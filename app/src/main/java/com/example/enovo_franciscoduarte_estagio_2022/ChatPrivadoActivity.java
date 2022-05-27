package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.time.Instant;
import java.time.ZoneOffset;

public class ChatPrivadoActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_privado);

        Bundle extras = this.getIntent().getExtras();
        int id_mensagemPrivada = extras.getInt("id");

        TextView msg = findViewById(R.id.idMsg);
        Button btnVoltar = findViewById(R.id.btnVoltar_);
        Button btnEnviarMsg = findViewById(R.id.btnEnviarMsg);

        btnVoltar.setOnClickListener(voltarPagina());
        btnEnviarMsg.setOnClickListener(enviarMsg_());

        msg.setText("Id da mensagem: " + id_mensagemPrivada);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceAsColor", "SetTextI18n"})
    private View.OnClickListener enviarMsg_() {
        return v -> {
            ScrollView view = findViewById(R.id.ScrollViewMessages);
            view.fullScroll(ScrollView.FOCUS_DOWN);

            EditText tbMensagem = findViewById(R.id.txtMensagem);
            String msg = tbMensagem.getText().toString();
            LinearLayout mensagens = findViewById(R.id.layoutMensagens_teste);
            TextView mensagem = new TextView(this);
            TextView hora_e_data = new TextView(this);

            if (!msg.equals("")) {
                Instant instant = Instant.now() ;
                int hour = instant.atZone(ZoneOffset.UTC).getHour() + 1;
                int minute = instant.atZone(ZoneOffset.UTC).getMinute();
                int day = instant.atZone(ZoneOffset.UTC).getDayOfMonth();
                int month = instant.atZone(ZoneOffset.UTC).getMonthValue();
                int year = instant.atZone(ZoneOffset.UTC).getYear();

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

                mensagem.setTextColor(Color.parseColor("#FFFFFF"));

                hora_e_data.setTextColor(R.color.ENOVO_cinza);
                hora_e_data.setTextSize(12);
                hora_e_data.setLayoutParams(params);
                hora_e_data.setText(day + "/" + month + "/" + year + " " + hour + ":" + minute);
                mensagens.addView(mensagem);
                mensagens.addView(hora_e_data);

                tbMensagem.setText(null);
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