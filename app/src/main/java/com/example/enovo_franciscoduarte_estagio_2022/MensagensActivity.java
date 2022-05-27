package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.URI;


public class MensagensActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);

        SharedPreferences pref = getSharedPreferences("user_details",MODE_PRIVATE);

        TextView nome = findViewById(R.id.textNome);
        String email = pref.getString("email", null);
        String id = pref.getString("id", null);

        nome.setText("Olá, " + id);

        Button btnIrMensagens = findViewById(R.id.btnIrMensagens);
        btnIrMensagens.setOnClickListener(irMensagens());

        Button btnIrContactos = findViewById(R.id.btnIrContactos);
        btnIrContactos.setOnClickListener(irContactos());

        Button btnIrAddContactos = findViewById(R.id.btnAdd);
        btnIrAddContactos.setOnClickListener(irAddContactos());

        nome.setOnClickListener(irPerfil());

        gerarMensagens(email);
    }
    
    @SuppressLint({"SetTextI18n", "ResourceType"})
    void gerarMensagens(String email){

        /*
        ImageView linha_separadora = new ImageView(this);
        linha_separadora.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        //linha_separadora.getLayoutParams().width = 413;
        linha_separadora.getLayoutParams().height = 1;
        linha_separadora.setBackgroundColor(Color.parseColor("#0a3354"));
        linha_separadora.setId(1);*/
                /*

            <ImageView
        android:id="@+id/retanguloFundo2"
        android:layout_width="413dp"
        android:layout_height="1dp"
        android:background="@color/ENOVO_azul"
        android:contentDescription="@string/todo"
        tools:ignore="ExtraText,ImageContrastCheck,MissingConstraints" />

        <View
    android:layout_width="match_parent"
    android:layout_height="2dp"
    android:background="#c0c0c0"/>
         */
        /*

        View linha = new View(this);
        /*
        linha.getLayoutParams().height = 2;
        linha.setBackgroundColor(Color.parseColor("#0a3354"));*/
/*
        linha.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                5
        ));
        linha.setBackgroundColor(Color.parseColor("#B3B3B3"));*/

        switch (email) {
            case "1@gmail.com":
                for (int i = 13; i > 0; i--) {
                    int id;
                    id = i;
                    LinearLayout mensagens = findViewById(R.id.llMensagens);

                    View linha = new View(this);
        /*
        linha.getLayoutParams().height = 2;
        linha.setBackgroundColor(Color.parseColor("#0a3354"));*/

                    linha.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            5
                    ));
                    linha.setBackgroundColor(Color.parseColor("#B3B3B3"));

                    LinearLayout msgOrganizada = new LinearLayout(this);
                    LinearLayout msgNomeEMsg = new LinearLayout(this);
                    ImageView imagemPerfil = new ImageView(this);


                    /*LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) msgOrganizada.getLayoutParams();
                    params.setMargins(0, 50, 0, 0);
                    //msgOrganizada.setLayoutParams(params);*/

                    msgNomeEMsg.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    msgNomeEMsg.setOrientation(LinearLayout.VERTICAL);

                    //ScrollView scroll = findViewById(R.id.svMensagens);
                    TextView quote = new TextView(this);
                    TextView nome = new TextView(this);

                    imagemPerfil.setBackgroundResource(R.drawable.ic_person);
                    msgOrganizada.addView(imagemPerfil);

                    nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    nome.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    //nome.setText(Html.fromHtml("Nome<br>" + id));
                    nome.setText("Nome " + id);
                    nome.setTextSize(23);
                    nome.setId(id);

                    quote.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    quote.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    quote.setText("Mensagem " + id);
                    //quote.setText(Html.fromHtml("<br>Mensagem" + id));
                    quote.setTextSize(15);
                    quote.setId(id);

                    msgNomeEMsg.addView(nome);
                    msgNomeEMsg.addView(quote);
                    msgNomeEMsg.setClickable(true);
                    msgNomeEMsg.setId(id);
                    msgNomeEMsg.setOnClickListener(carregarPrivado(msgNomeEMsg.getId()));

                    msgOrganizada.addView(msgNomeEMsg);

                    mensagens.addView(msgOrganizada);
                    mensagens.addView(linha);
                }
                break;
            case "2@gmail.com":
                for (int i = 8; i > 0; i--) {
                    int id;
                    id = i;
                    LinearLayout mensagens = findViewById(R.id.llMensagens);

                    LinearLayout msgOrganizada = new LinearLayout(this);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)msgOrganizada.getLayoutParams();

                    params.topMargin = 200;

                    msgOrganizada.setLayoutParams(params);


                    LinearLayout msgNomeEMsg = new LinearLayout(this);
                    ImageView imagemPerfil = new ImageView(this);

                    msgNomeEMsg.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    msgNomeEMsg.setOrientation(LinearLayout.VERTICAL);

                    //ScrollView scroll = findViewById(R.id.svMensagens);
                    TextView quote = new TextView(this);
                    TextView nome = new TextView(this);

                    imagemPerfil.setBackgroundResource(R.drawable.ic_person);
                    msgOrganizada.addView(imagemPerfil);

                    nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    nome.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    //nome.setText(Html.fromHtml("Nome<br>" + id));
                    nome.setText("Nome " + id);
                    nome.setTextSize(23);
                    nome.setId(id);

                    quote.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    quote.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    quote.setText("Mensagem " + id);
                    //quote.setText(Html.fromHtml("<br>Mensagem" + id));
                    quote.setTextSize(15);
                    quote.setId(id);

                    msgNomeEMsg.addView(nome);
                    msgNomeEMsg.addView(quote);
                    msgNomeEMsg.setClickable(true);
                    msgNomeEMsg.setId(id);
                    msgNomeEMsg.setOnClickListener(carregarPrivado(msgNomeEMsg.getId()));

                    msgOrganizada.addView(msgNomeEMsg);

                    mensagens.addView(msgOrganizada);
                }
                break;
            case "3@gmail.com":
                for (int i = 3; i > 0; i--) {
                    int id;
                    id = i;
                    LinearLayout mensagens = findViewById(R.id.llMensagens);

                    LinearLayout msgOrganizada = new LinearLayout(this);
                    LinearLayout msgNomeEMsg = new LinearLayout(this);
                    ImageView imagemPerfil = new ImageView(this);

                    msgNomeEMsg.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    msgNomeEMsg.setOrientation(LinearLayout.VERTICAL);

                    //ScrollView scroll = findViewById(R.id.svMensagens);
                    TextView quote = new TextView(this);
                    TextView nome = new TextView(this);

                    imagemPerfil.setBackgroundResource(R.drawable.ic_person);
                    msgOrganizada.addView(imagemPerfil);

                    nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    nome.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    //nome.setText(Html.fromHtml("Nome<br>" + id));
                    nome.setText("Nome " + id);
                    nome.setTextSize(23);
                    nome.setId(id);

                    quote.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    quote.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    quote.setText("Mensagem " + id);
                    //quote.setText(Html.fromHtml("<br>Mensagem" + id));
                    quote.setTextSize(15);
                    quote.setId(id);

                    msgNomeEMsg.addView(nome);
                    msgNomeEMsg.addView(quote);
                    msgNomeEMsg.setClickable(true);
                    msgNomeEMsg.setId(id);
                    msgNomeEMsg.setOnClickListener(carregarPrivado(msgNomeEMsg.getId()));

                    msgOrganizada.addView(msgNomeEMsg);

                    mensagens.addView(msgOrganizada);
                }
                break;
        }
    }

    private View.OnClickListener carregarPrivado(int id) {
        return v -> {
            Bundle bundle = new Bundle();
            Intent chatPrivado = new Intent(this, ChatPrivadoActivity.class);
            bundle.putInt("id", id);
            chatPrivado.putExtras(bundle);
            startActivity(chatPrivado);
        };
    }

    public View.OnClickListener irMensagens() {
        return v -> {
            Intent mensagens = new Intent(this, MensagensActivity.class);
            startActivity(mensagens);
        };
    }

    public View.OnClickListener irContactos() {
        return v -> {
            Intent contactos = new Intent(this, ContactosActivity.class);
            startActivity(contactos);
        };
    }

    public View.OnClickListener irAddContactos(){
        return v -> {
          Intent addContactos = new Intent(this, AdicionarActivity.class);
          startActivity(addContactos);
        };
    }

    public View.OnClickListener irPerfil(){
        return v -> {
            Intent perfil = new Intent(this, PerfilActivity.class);
            startActivity(perfil);
        };
    }
}