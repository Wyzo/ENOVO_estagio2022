package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtEmail = findViewById(R.id.emailTextBox);
        EditText txtPassword = findViewById(R.id.textPassword);
        Button loginBt = findViewById(R.id.btnLogin);

        SharedPreferences pref = getSharedPreferences("user_details",MODE_PRIVATE);

        Intent mensagens = new Intent(MainActivity.this, MensagensActivity.class);

        loginBt.setOnClickListener(v -> {
            String email = txtEmail.getText().toString();
            String password = txtPassword.getText().toString();

            if (email.equals("1@gmail.com") && password.equals("teste123")){
                SharedPreferences.Editor editor = pref.edit();

                String[] For_split_email = email.split("[@._]");
                String teste = For_split_email[0];

                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("id", teste);
                editor.apply();

                startActivity(mensagens);
            }
            else if (email.equals("2@gmail.com") && password.equals("teste123")){
                SharedPreferences.Editor editor = pref.edit();

                String[] For_split_email = email.split("[@._]");
                String teste = For_split_email[0];

                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("id", teste);
                editor.apply();

                startActivity(mensagens);
            }
            else if (email.equals("3@gmail.com") && password.equals("teste123")){
                SharedPreferences.Editor editor = pref.edit();

                String[] For_split_email = email.split("[@._]");
                String teste = For_split_email[0];

                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("id", teste);
                editor.apply();

                startActivity(mensagens);
            }
            else{
                alertView();
            }
        });
    }

    private void alertView() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle( "Erro!" ).setIcon(R.drawable.ic_baseline_error_outline_24).setMessage("Conta não encontrada!").setPositiveButton("Ok", (dialoginterface, i) -> {}).show();
    }
}