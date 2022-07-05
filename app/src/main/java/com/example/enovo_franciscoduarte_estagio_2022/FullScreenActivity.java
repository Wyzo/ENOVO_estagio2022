package com.example.enovo_franciscoduarte_estagio_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity extends AppCompatActivity {

    ImageView img;
    Bundle extras;
    Uri img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        img = findViewById(R.id.fullScreenImage);
        extras = getIntent().getExtras();

        img2 = (Uri) extras.get("uri2");
        img.setImageURI(img2);
    }
}