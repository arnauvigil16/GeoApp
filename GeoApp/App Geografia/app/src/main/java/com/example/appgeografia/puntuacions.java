package com.example.appgeografia;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class puntuacions extends AppCompatActivity {

    TextView tvPuntuacionFacil;
    TextView tvPuntuacionNormal;
    TextView tvPuntuacionDificil;
    ImageView ivFacil;
    ImageView ivNormal;
    ImageView ivDificil;

    private int puntuacionFacil;
    private int puntuacionNormal;
    private int puntuacionDificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacions);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        puntuacionFacil = MainActivity.user1.getPuntuacio_max_facil();
        puntuacionNormal = MainActivity.user1.getPuntuacio_max_normal();
        puntuacionDificil = MainActivity.user1.getPuntuacio_max_dificil();

        tvPuntuacionFacil = findViewById(R.id.tvPuntuacionFacil);
        tvPuntuacionNormal = findViewById(R.id.tvPuntuacionNormal);
        tvPuntuacionDificil = findViewById(R.id.tvPuntuacionDificil);

        ivFacil = findViewById(R.id.ivFacil);
        ivNormal = findViewById(R.id.ivNormal);
        ivDificil = findViewById(R.id.ivDificil);

        tvPuntuacionFacil.setText(String.valueOf(puntuacionFacil));
        tvPuntuacionNormal.setText(String.valueOf(puntuacionNormal));
        tvPuntuacionDificil.setText(String.valueOf(puntuacionDificil));

        puntuacions(puntuacionFacil,ivFacil);
        puntuacions(puntuacionNormal,ivNormal);
        puntuacions(puntuacionDificil,ivDificil);
    }

    private void puntuacions(int puntuacion, ImageView imagen) {
        if (puntuacion <= 50) {
            imagen.setBackgroundResource(R.drawable.bronze);
        }
        else if (puntuacion > 50 && puntuacion <= 100){
            imagen.setBackgroundResource(R.drawable.silver);
        }
        else if (puntuacion >= 100){
            imagen.setBackgroundResource(R.drawable.gold);
        }
    }
}
