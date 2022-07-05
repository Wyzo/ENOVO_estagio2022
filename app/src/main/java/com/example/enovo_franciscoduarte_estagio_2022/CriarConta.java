package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CriarConta extends AppCompatActivity {

    Button btnLogin;

    Intent pagLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        btnLogin = findViewById(R.id.btnIrLogin);

        btnLogin.setOnClickListener(v -> {
            pagLogin = new Intent(this, MainActivity.class);
            startActivity(pagLogin);
        });
    }
}