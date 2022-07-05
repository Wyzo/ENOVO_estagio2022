package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

public class ChatPrivadoActivity extends AppCompatActivity {

    Button btnVoltar, btnEnviarMsg, abrirGaleria, btnIrMsgRecente;
    TextView msg, mensagem, mensagem_outrolado, hora_e_data, hora_e_data2;
    LinearLayout mensagens;
    ImageView img, img2;
    EditText tbMensagem;
    Uri selected_image;
    ScrollView mensagens_scroll;

    int alturaLayout, alturaScroll;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_privado);

        Bundle extras = this.getIntent().getExtras();
        int id_mensagemPrivada = extras.getInt("id");

        msg = findViewById(R.id.idMsg);
        btnVoltar = findViewById(R.id.btnVoltar_);
        btnEnviarMsg = findViewById(R.id.btnEnviarMsg);

        btnVoltar.setOnClickListener(voltarPagina());
        btnEnviarMsg.setOnClickListener(enviarMsg_());

        msg.setText("Id da mensagem: " + id_mensagemPrivada);

        abrirGaleria = findViewById(R.id.btnGaleria);

        btnIrMsgRecente = findViewById(R.id.btnIrMsgRecente);

        mensagens_scroll = findViewById(R.id.ScrollViewMessages);
        mensagens = findViewById(R.id.layoutMensagens_teste);

        alturaLayout = mensagens.getHeight();
        alturaScroll = mensagens_scroll.getHeight();


        if (alturaLayout > alturaScroll)
        {
            btnIrMsgRecente.setVisibility(View.VISIBLE);
        }
        else
        {
            btnIrMsgRecente.setVisibility(View.INVISIBLE);
        }


        btnIrMsgRecente.setOnClickListener(v -> {
            mensagens_scroll.scrollTo(mensagens.getBottom(), mensagens.getBottom());

            System.out.println(mensagens.getBottom());
            System.out.println(mensagens_scroll.getBottom());
        });

        abrirGaleria.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 3);
        });
    }

    @SuppressLint({"NewApi", "ResourceType"})
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){

            mensagens = findViewById(R.id.layoutMensagens_teste);
            selected_image = data.getData();

            int value = 250;
            int dpValue = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    value,
                    this.getResources().getDisplayMetrics());

            int value2 = 16;
            int dpValue2 = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    value2,
                    this.getResources().getDisplayMetrics());

            img = new ImageView(this);
            img.setImageURI(selected_image);

            img2 = new ImageView(this);
            img2.setImageURI(selected_image);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,10,10,10);
            params.gravity = Gravity.END;
            img.setId(0b1);
            img.setLayoutParams(params);
            img.setMaxWidth(dpValue);
            img.setPadding(dpValue2, dpValue2, dpValue2, dpValue2);
            img.setAdjustViewBounds(true);
            img.setClickable(true);
            img.setOnClickListener(v -> {
                Intent fullScreenActivity = new Intent(ChatPrivadoActivity.this, FullScreenActivity.class);
                fullScreenActivity.putExtra("uri2", selected_image);
                startActivity(fullScreenActivity);
            });

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params2.setMargins(10,10,10,10);
            params2.gravity = Gravity.START;
            img2.setId(0b10);
            img2.setLayoutParams(params2);
            img2.setMaxWidth(dpValue);
            img2.setPadding(dpValue2, dpValue2, dpValue2, dpValue2);
            img2.setAdjustViewBounds(true);
            img2.setOnClickListener(v -> {
                Intent fullScreenActivity = new Intent(ChatPrivadoActivity.this, FullScreenActivity.class);
                fullScreenActivity.putExtra("uri2", selected_image);
                startActivity(fullScreenActivity);
            });

            mensagens.addView(img);
            mensagens.addView(img2);

            btnIrMsgRecente = findViewById(R.id.btnIrMsgRecente);

            mensagens_scroll = findViewById(R.id.ScrollViewMessages);

            alturaLayout = mensagens.getHeight();
            alturaScroll = mensagens_scroll.getHeight();


            if (alturaLayout > alturaScroll)
            {
                btnIrMsgRecente.setVisibility(View.VISIBLE);
            }
            else
            {
                btnIrMsgRecente.setVisibility(View.INVISIBLE);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceAsColor", "SetTextI18n"})
    private View.OnClickListener enviarMsg_() {
        return v -> {
            ScrollView view = findViewById(R.id.ScrollViewMessages);
            view.fullScroll(ScrollView.FOCUS_DOWN);

            tbMensagem = findViewById(R.id.txtMensagem);
            String msg = tbMensagem.getText().toString();
            mensagens = findViewById(R.id.layoutMensagens_teste);
            mensagem = new TextView(this);
            mensagem_outrolado = new TextView(this);
            hora_e_data = new TextView(this);
            hora_e_data2 = new TextView(this);

            if (!msg.equals("")) {
                Instant instant = Instant.now() ;

                int day = instant.atZone(ZoneOffset.UTC).getDayOfMonth();
                int month = instant.atZone(ZoneOffset.UTC).getMonthValue();
                int year = instant.atZone(ZoneOffset.UTC).getYear();

                @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dateformatted = dateFormat.format(date);

                int value = 250;
                int dpValue = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value,
                        this.getResources().getDisplayMetrics());

                int value2 = 16;
                int dpValue2 = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        value2,
                        this.getResources().getDisplayMetrics());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                params.gravity = Gravity.END;
                mensagem.setLayoutParams(params);
                mensagem.setBackground(getResources().getDrawable(R.drawable.msg_background));
                mensagem.setMaxWidth(dpValue);
                mensagem.setPadding(dpValue2, dpValue2, dpValue2, dpValue2);
                mensagem.setText(msg);

                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params2.setMargins(10,10,10,10);
                params2.gravity = Gravity.START;
                mensagem_outrolado.setLayoutParams(params2);
                mensagem_outrolado.setBackground(getResources().getDrawable(R.drawable.msg_background_recetor));
                mensagem_outrolado.setMaxWidth(dpValue);
                mensagem_outrolado.setPadding(dpValue2, dpValue2, dpValue2, dpValue2);
                mensagem_outrolado.setText(msg);

                mensagem.setTextColor(Color.parseColor("#FFFFFF"));

                hora_e_data.setTextColor(R.color.ENOVO_cinza);
                hora_e_data.setTextSize(12);
                hora_e_data.setLayoutParams(params);
                hora_e_data.setText(day + "/" + month + "/" + year + " " + dateformatted);

                hora_e_data2.setTextColor(R.color.ENOVO_cinza);
                hora_e_data2.setTextSize(12);
                hora_e_data2.setLayoutParams(params2);
                hora_e_data2.setText(day + "/" + month + "/" + year + " " + dateformatted);

                mensagens.addView(mensagem);
                mensagens.addView(hora_e_data);
                mensagens.addView(mensagem_outrolado);
                mensagens.addView(hora_e_data2);

                mensagem.setOnClickListener(v1 -> Toast.makeText(this, "teste", Toast.LENGTH_LONG).show());

                tbMensagem.setText(null);

                btnIrMsgRecente = findViewById(R.id.btnIrMsgRecente);

                alturaLayout = mensagens.getHeight();
                alturaScroll = view.getHeight();


                if (alturaLayout > alturaScroll)
                {
                    btnIrMsgRecente.setVisibility(View.VISIBLE);
                }
                else
                {
                    btnIrMsgRecente.setVisibility(View.INVISIBLE);
                }
            }
        };
    }

    private View.OnClickListener voltarPagina() {
        return v -> {
            Intent voltar = new Intent(this, MensagensActivity.class);
            startActivity(voltar);
        };
    }
}