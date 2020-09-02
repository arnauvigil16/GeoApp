package com.example.appgeografia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tutorial extends AppCompatActivity {

    TextView texto;
    ImageView imagen_tutorial;
    TextView titulo;
    Button btnSiguiente;
    Button btnAnterior;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        imagen_tutorial = findViewById(R.id.im_Tutorial);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnAnterior = findViewById(R.id.btnAnterior);
        titulo = findViewById(R.id.tvTitulo);

        orden_tutorial();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador > 4){}
                else{
                    contador++;
                    orden_tutorial();
                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador < 0){}
                else{
                    contador--;
                    orden_tutorial();
                }
            }
        });
    }

    private void orden_tutorial(){
        switch (contador){
            case 0:
                titulo.setText("Inicio");
                imagen_tutorial.setImageResource(getResources().getIdentifier("@drawable/tutorial_inicio", "drawable", getOpPackageName()));
                break;
            case 1:
                titulo.setText("Mapas");
                imagen_tutorial.setImageResource(getResources().getIdentifier("@drawable/tutorial_mapas", "drawable", getOpPackageName()));
                break;
            case 2:
                titulo.setText("Dificultad");
                imagen_tutorial.setImageResource(getResources().getIdentifier("@drawable/tutorial_dificultad", "drawable", getOpPackageName()));
                break;
            case 3:
                titulo.setText("Usuario");
                imagen_tutorial.setImageResource(getResources().getIdentifier("@drawable/tutorial_usuario", "drawable", getOpPackageName()));
                break;
            case 4:
                titulo.setText("Puntos");
                imagen_tutorial.setImageResource(getResources().getIdentifier("@drawable/tutorial_puntos", "drawable", getOpPackageName()));
                break;
            default:
                Toast.makeText(getApplicationContext(), "No hay mas información que mostrar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
