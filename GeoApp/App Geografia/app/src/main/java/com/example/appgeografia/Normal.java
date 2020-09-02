package com.example.appgeografia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class Normal extends AppCompatActivity {

    private cLocalizacion localizacion_normal = null;
    private ArrayList<cLocalizacion> localizacions_normal = new ArrayList<>();
    private Random myRandom = new Random();
    private ArrayList<cLocalizacion> comprovacion_juego_normal = new ArrayList<>();

    String string_mapa_normal;

    EditText respuesta_usuario;
    ImageView imagen_procedencia;

    private int puntuacio = 0;
    private TextView tvPuntuacioInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Bundle extras_normal = getIntent().getExtras();
        string_mapa_normal = extras_normal.getString("mapa");
        respuesta_usuario = findViewById(R.id.edUsuariResposta);
        imagen_procedencia = findViewById(R.id.imRespuestaNormal);
        tvPuntuacioInt = findViewById(R.id.tvPuntuacioInt);


        if (string_mapa_normal.equals("catalunya")){
            localizacions_normal = Mapas.lista_catalunya;
        }
        else if (string_mapa_normal.equals("espanya")){
            localizacions_normal = Mapas.lista_españa;
        }
        else if (string_mapa_normal.equals("europa")){
            localizacions_normal = Mapas.lista_europa;
        }
        else if (string_mapa_normal.equals("mundial")){
            localizacions_normal = Mapas.lista_mundial;
        }

        for (int a = 0; a < localizacions_normal.size(); a++){
            localizacions_normal.get(a).setMostrada(false);
        }

        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("Nivel Normal!");
        ad.setMessage("En este nivel aparecerán imágenes en la que se mostraran comarcas, ciudades o países y" +
                " se tendrá que introducir el nombre de cada uno! \n" +
                "\nLos acentos no son importantes, y las mayúsculas o minúsculas son irrelevantes \n" +
                "Las comunidades autonomas, ciudades o países se tendrán que escribir en Español");

        ad.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        ad.show();

        comprovacion_juego_normal.clear();

        randomizarJuego();

        Button btnComprovarNormal = findViewById(R.id.btnComprovarNormal);
        btnComprovarNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juego();
            }
        });

        Button btnTerminarNormal = findViewById(R.id.btnTerminarNormal);
        btnTerminarNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void randomizarJuego(){

        boolean sortida = false;

        while (sortida == false){

            int posArray = myRandom.nextInt(localizacions_normal.size());
            localizacion_normal = localizacions_normal.get(posArray);
            if (localizacion_normal.getMostrada() == false){
                imagen_procedencia.setImageResource(getResources().getIdentifier(localizacion_normal.getLink(), "drawable", getOpPackageName()));
                comprovacion_juego_normal.add(localizacion_normal);
                sortida = true;
            }
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("ALERTA!!");
        ad.setMessage("¿ Seguro que quieres salir ? Se perderá todo profreso realizado!");

        ad.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                finish();
            }
        });

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // no fem res.
            }
        });
        ad.show();
    }


    public void juego(){

        String respuesta = respuesta_usuario.getText().toString().toLowerCase();
        String lugar = localizacion_normal.getNombre().toLowerCase();

        if (localizacions_normal.size() == comprovacion_juego_normal.size()){

            if (string_mapa_normal.equals("catalunya")){
                if (Mapas.bloqueado_mapa_esp = true) {
                    Mapas.bloqueado_mapa_esp = false;
                    Toast.makeText(getApplicationContext(), "Has desbloqueado el mapa de España!!", Toast.LENGTH_LONG).show();
                }
                else if (Mapas.bloqueado_mapa_esp = false){
                    Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();
                }
            }
            else if (string_mapa_normal.equals("espanya")){

                if (Mapas.bloqueado_mapa_ue = true) {
                    Mapas.bloqueado_mapa_ue = false;
                    Toast.makeText(getApplicationContext(), "Has desbloqueado el mapa de la Unión Europea!", Toast.LENGTH_LONG).show();
                }
                else if (Mapas.bloqueado_mapa_ue = false) {
                    Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
            else if (string_mapa_normal.equals("europa")){
                if(Mapas.bloqueado_mapa_mundial = true){
                    Mapas.bloqueado_mapa_mundial = false;
                    Toast.makeText(getApplicationContext(), "Has desbloqueado el mapa Mundial!", Toast.LENGTH_LONG).show();
                }
                else if (Mapas.bloqueado_mapa_mundial = false) {
                    Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();
                }
                if (puntuacio > MainActivity.user1.getPuntuacio_max_normal()){
                    MainActivity.user1.setPuntuacio_max_normal(puntuacio);

                }
            }
            finish();
        }

        else if (respuesta.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Introduce una respuesta porfavor", Toast.LENGTH_LONG).show();
        }

        else if (respuesta.equals(lugar)){
            Toast.makeText(getApplicationContext(), "Has acertado!", Toast.LENGTH_LONG).show();
            localizacion_normal.setMostrada(true);
            respuesta_usuario.setText("");
            randomizarJuego();
            puntuacio = puntuacio + 10;
            tvPuntuacioInt.setText(String.valueOf(puntuacio));
        }

        else  {
            Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT).show();
            respuesta_usuario.setText("");
            puntuacio = puntuacio - 5;
            tvPuntuacioInt.setText(String.valueOf(puntuacio));
        }
    }
}
