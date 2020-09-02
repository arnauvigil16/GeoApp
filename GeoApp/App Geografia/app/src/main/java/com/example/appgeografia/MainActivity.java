package com.example.appgeografia;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static MediaPlayer musica;

    public static cUsuari user1 = new cUsuari();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        musica = MediaPlayer.create(this, R.raw.chill_music);

        musica.start();
        musica.setLooping(true);

        Button btnSilencio = findViewById(R.id.btnSilencio);
        btnSilencio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musica.pause();
            }
        });

        Button btnMusica = findViewById(R.id.btnSonido);
        btnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musica.start();
            }
        });

        Button btnJugar = findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNiveles = new Intent(MainActivity.this, Mapas.class);
                startActivity(intentNiveles);
            }
        });

        Button btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPerfil = new Intent(MainActivity.this, Perfil.class);
                startActivity(intentPerfil);
            }
        });

        Button btnTutorial = findViewById(R.id.btnTutorial);
        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTutorial = new Intent(MainActivity.this, tutorial.class);
                startActivity(intentTutorial);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        musica.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        musica.start();
    }
}
