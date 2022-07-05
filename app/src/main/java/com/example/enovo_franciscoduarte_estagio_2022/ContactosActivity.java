package com.example.enovo_franciscoduarte_estagio_2022;

import static com.example.enovo_franciscoduarte_estagio_2022.R.drawable.pfp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;

public class ContactosActivity extends AppCompatActivity {

    Button btnIrContactos, btnIrMensagens;
    SharedPreferences pref;
    LinearLayout contactos, contacto;
    ShapeableImageView imagemPerfil;
    TextView nome;
    View linha;

    Intent mensagens, contactos_intent;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        btnIrContactos = findViewById(R.id.btnIrContactos);
        btnIrContactos.setOnClickListener(irContactos());

        btnIrMensagens = findViewById(R.id.btnIrMensagens);
        btnIrMensagens.setOnClickListener(irMensagens());

        email = pref.getString("email", null);
        gerarContactos(email);
    }

    @SuppressLint("SetTextI18n")
    public void gerarContactos(String email){
        if ("1@gmail.com".equals(email)) {
            for (int i = 13; i > 0; i--) {
                int id;
                id = i;
                contactos = findViewById(R.id.lyContactos);
                contacto = new LinearLayout(this);

                imagemPerfil = new ShapeableImageView(this);
                nome = new TextView(this);

                linha = new View(this);

                linha.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        5
                ));
                linha.setBackgroundColor(Color.parseColor("#B3B3B3"));

                imagemPerfil.setBackgroundResource(pfp);
                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                parms.width = 200;
                parms.height = 200;
                imagemPerfil.setLayoutParams(parms);
                imagemPerfil.setShapeAppearanceModel(imagemPerfil.getShapeAppearanceModel()
                        .toBuilder()
                        .setAllCorners(CornerFamily.ROUNDED, 100)
                        .build());

                nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                nome.setPadding(60, 0, 4, 0);
                nome.setText("Nome do contacto " + id);
                nome.setTextSize(23);
                nome.setId(id);

                contacto.addView(imagemPerfil);
                contacto.addView(nome);
                contacto.setPadding(0, 30, 0, 30);

                contactos.addView(contacto);
                contactos.addView(linha);

            }
        } else {
            contactos = findViewById(R.id.lyContactos);
            nome = new TextView(this);

            nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            nome.setPadding(4, 0, 4, 0);
            nome.setText("Ainda sem contactos");
            nome.setTextSize(23);

            contactos.addView(nome);
        }
    }

    public View.OnClickListener irMensagens() {
        return v -> {
            mensagens = new Intent(this, MensagensActivity.class);
            startActivity(mensagens);
        };
    }

    public View.OnClickListener irContactos() {
        return v -> {
            contactos_intent = new Intent(this, ContactosActivity.class);
            startActivity(contactos_intent);
        };
    }
}