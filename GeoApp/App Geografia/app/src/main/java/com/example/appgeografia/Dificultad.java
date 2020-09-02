package com.example.appgeografia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Dificultad extends AppCompatActivity {

    private Button btnFacil;
    private Button btnNormal;
    private Button btnDificil;

    String string_mapa_pasajero;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

        // deshabilita la barra de notificacions
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        final Bundle extras = getIntent().getExtras();
        string_mapa_pasajero = extras.getString("mapa");

        btnFacil = findViewById(R.id.btnFacil);
        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNivel(1);
            }
        });

        btnNormal = findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNivel(2);
            }
        });

        btnDificil = findViewById(R.id.btnDificil);
        btnDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNivel(3);
            }
        });
    }

    public void setNivel(int nivel) {
        if (nivel == 1){
            Intent intentFacil = new Intent(this, Facil.class);
            intentFacil.putExtra("mapa", string_mapa_pasajero);
            startActivity(intentFacil);
        }
        else if(nivel == 2) {
            Intent intentNormal = new Intent(this, Normal.class);
            intentNormal.putExtra("mapa", string_mapa_pasajero);
            startActivity(intentNormal);
        }
        else if(nivel == 3) {
            Intent intentDificil = new Intent(this, Dificil.class);
            intentDificil.putExtra("mapa", string_mapa_pasajero);
            startActivity(intentDificil);
        }
    }
}