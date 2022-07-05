package com.example.enovo_franciscoduarte_estagio_2022;

import static com.example.enovo_franciscoduarte_estagio_2022.R.drawable.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;

public class MensagensActivity extends AppCompatActivity {

    TextView nome, quote, notificacoes;
    SharedPreferences pref;
    String id;
    Button btnIrMensagens, btnIrContactos, btnIrAddContactos;
    LinearLayout msgOrganizada, msgOrganizada2, msgNomeEMsg;
    ShapeableImageView imagemPerfil;
    Intent chatPrivado, mensagens, contactos, addContactos, perfil;
    Bundle bundle;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);

        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        nome = findViewById(R.id.textNome);

        id = pref.getString("id", null);

        nome.setText("Olá, " + id);

        btnIrMensagens = findViewById(R.id.btnIrMensagens);
        btnIrMensagens.setOnClickListener(irMensagens());

        btnIrContactos = findViewById(R.id.btnIrContactos);
        btnIrContactos.setOnClickListener(irContactos());

        btnIrAddContactos = findViewById(R.id.btnAdd);
        btnIrAddContactos.setOnClickListener(irAddContactos());

        nome.setOnClickListener(irPerfil());

        gerarMensagens();
    }
    
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint({"SetTextI18n", "ResourceType", "UseCompatLoadingForDrawables"})
    void gerarMensagens(){
        for (int i = 1; i < 13; i++) {
            int id;
            id = i;
            LinearLayout mensagens = findViewById(R.id.layoutMensagens);

            View linha = new View(this);

            linha.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    3
            ));
            linha.setBackgroundColor(Color.parseColor("#B3B3B3"));

            msgOrganizada = new LinearLayout(this);
            msgOrganizada2 = new LinearLayout(this);
            msgNomeEMsg = new LinearLayout(this);
            imagemPerfil = new ShapeableImageView(this);

            msgNomeEMsg.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            msgNomeEMsg.setOrientation(LinearLayout.VERTICAL);

            msgOrganizada2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            msgOrganizada2.setOrientation(LinearLayout.HORIZONTAL);

            quote = new TextView(this);
            nome = new TextView(this);

            imagemPerfil.setBackgroundResource(pfp);

            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            parms.width = 200;
            parms.height = 200;
            imagemPerfil.setLayoutParams(parms);
            imagemPerfil.setShapeAppearanceModel(imagemPerfil.getShapeAppearanceModel()
                    .toBuilder()
                    .setAllCorners(CornerFamily.ROUNDED, 100)
                    .build());

            msgOrganizada.addView(imagemPerfil);
            nome.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            nome.setPadding(60, 0, 20, 0);
            nome.setText("Nome " + id);
            nome.setTextColor(getResources().getColor(R.color.black));
            nome.setTextSize(23);
            nome.setId(id);

            quote.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            quote.setPadding(60, 0, 20, 0);
            quote.setText("Lorem ipsum dolor sit amet, consectetur.");
            quote.setTextSize(15);
            quote.setTextColor(getResources().getColor(R.color.black));
            quote.setId(id);
            msgOrganizada2.addView(nome);

            notificacoes = new TextView(this);
            notificacoes.setBackground(getResources().getDrawable(R.drawable.notificacoes));
            notificacoes.setTextColor(getResources().getColor(R.color.white));
            notificacoes.setTextSize(16);

            switch (i){
                case 1:
                    notificacoes.setText("8");

                    msgOrganizada2.addView(notificacoes);
                    quote.setTypeface(null, Typeface.BOLD);
                    break;
                case 2:
                    notificacoes.setText("27");
                    msgOrganizada2.addView(notificacoes);
                    quote.setTypeface(null, Typeface.BOLD);
                    break;
                default:
                    break;
            }

            msgNomeEMsg.addView(msgOrganizada2);
            msgNomeEMsg.addView(quote);
            msgNomeEMsg.addView(linha);
            msgNomeEMsg.setClickable(true);
            msgNomeEMsg.setId(id);
            msgNomeEMsg.setOnClickListener(carregarPrivado(msgNomeEMsg.getId()));

            msgOrganizada.addView(msgNomeEMsg);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(0, 60, 0, 0);

            msgOrganizada.setLayoutParams(layoutParams);

            mensagens.addView(msgOrganizada);
        }
    }

    private View.OnClickListener carregarPrivado(int id) {
        return v -> {
            bundle = new Bundle();
            chatPrivado = new Intent(this, ChatPrivadoActivity.class);
            bundle.putInt("id", id);
            chatPrivado.putExtras(bundle);
            startActivity(chatPrivado);
        };
    }

    public View.OnClickListener irMensagens() {
        return v -> {
            mensagens = new Intent(this, MensagensActivity.class);
            startActivity(mensagens);
        };
    }

    public View.OnClickListener irContactos() {
        return v -> {
            contactos = new Intent(this, ContactosActivity.class);
            startActivity(contactos);
        };
    }

    public View.OnClickListener irAddContactos(){
        return v -> {
            addContactos = new Intent(this, AdicionarActivity.class);
            startActivity(addContactos);
        };
    }

    public View.OnClickListener irPerfil(){
        return v -> {
            perfil = new Intent(this, PerfilActivity.class);
            startActivity(perfil);
        };
    }
}