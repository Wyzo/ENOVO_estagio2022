package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdicionarActivity extends AppCompatActivity {

    Button btnVoltarMensagens;
    Intent mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        btnVoltarMensagens = findViewById(R.id.btnVoltar_);
        btnVoltarMensagens.setOnClickListener(voltarMensagens());
    }

    public View.OnClickListener voltarMensagens() {
        return v -> {
            mensagens = new Intent(this, MensagensActivity.class);
            startActivity(mensagens);
        };
    }
}