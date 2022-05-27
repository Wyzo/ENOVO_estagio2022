package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdicionarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        Button btnVoltarMensagens = findViewById(R.id.btnVoltar_);
        btnVoltarMensagens.setOnClickListener(voltarMensagens());
    }

    public View.OnClickListener voltarMensagens() {
        return v -> {
            Intent mensagens = new Intent(this, MensagensActivity.class);
            startActivity(mensagens);
        };
    }
}