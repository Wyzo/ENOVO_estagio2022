package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    Button btnVoltar;
    String email, password, nome;
    EditText emailTXT, passwordTXT, nomeTXT;
    ImageView imagem;
    TextView sair;
    Intent intent, paginaLogin, mensagens;
    Uri selected_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        SharedPreferences pref = getSharedPreferences("user_details",MODE_PRIVATE);

        btnVoltar = findViewById(R.id.btnVoltar_);
        btnVoltar.setOnClickListener(irMsgs());

        email = pref.getString("email", null);
        password = pref.getString("password", null);
        nome = pref.getString("id", null);

        emailTXT = findViewById(R.id.emailTextBox);
        passwordTXT = findViewById(R.id.passwordTextBox);
        nomeTXT = findViewById(R.id.nomeText);

        emailTXT.setText(email);
        passwordTXT.setText(password);
        nomeTXT.setText(nome);

        imagem = findViewById(R.id.imgPerfil);
        imagem.setOnClickListener(v -> {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 3);
        });

        sair = findViewById(R.id.btnSair);

        sair.setOnClickListener(v -> {
            paginaLogin = new Intent(this, MainActivity.class);
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = pref.edit();

            editor.remove("email");
            editor.remove("password");
            editor.remove("id");
            editor.clear();
            editor.apply();

            startActivity(paginaLogin);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null){
            selected_image = data.getData();

            int value2 = 164;
            int valorDP = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    value2,
                    this.getResources().getDisplayMetrics());

            imagem = findViewById(R.id.imgPerfil);

            imagem.getLayoutParams().width = valorDP;
            imagem.getLayoutParams().height = valorDP;
            imagem.setImageURI(selected_image);
        }
    }

    public View.OnClickListener irMsgs(){
        return v -> {
            mensagens = new Intent(this, MensagensActivity.class);
            startActivity(mensagens);
        };
    }
}