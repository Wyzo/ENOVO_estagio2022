package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        SharedPreferences pref = getSharedPreferences("user_details",MODE_PRIVATE);
         Button btnIrContactos = findViewById(R.id.btnIrContactos);
         btnIrContactos.setOnClickListener(irContactos());

         Button btnIrMensagens = findViewById(R.id.btnIrMensagens);
         btnIrMensagens.setOnClickListener(irMensagens());

        String email = pref.getString("email", null);
        gerarContactos(email);
    }

    public void gerarContactos(String email){
        switch (email)
        {
            case "1@gmail.com":
                for (int i = 13; i > 0; i--) {
                    int id;
                    id = i;
                    LinearLayout contactos = findViewById(R.id.lyContactos);
                    LinearLayout contacto = new LinearLayout(this);
                    ImageView imagem = new ImageView(this);
                    TextView nome = new TextView(this);

                    imagem.setBackgroundResource(R.drawable.ic_person);

                    nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    nome.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                    //nome.setText(Html.fromHtml("Nome<br>" + id));
                    nome.setText("Nome do contacto " + id);
                    nome.setTextSize(23);
                    nome.setId(id);

                    contacto.addView(imagem);
                    contacto.addView(nome);

                    contactos.addView(contacto);

                }
                break;
            default:
                LinearLayout contactos = findViewById(R.id.lyContactos);
                TextView nome = new TextView(this);

                nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                nome.setPadding(4, 0, 4, 0);    //left,top,right,bottom
                //nome.setText(Html.fromHtml("Nome<br>" + id));
                nome.setText("Ainda sem contactos");
                nome.setTextSize(23);

                contactos.addView(nome);
                break;
        }
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
}