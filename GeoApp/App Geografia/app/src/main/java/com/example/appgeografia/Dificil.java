package com.example.appgeografia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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

public class Dificil extends AppCompatActivity {

    private EditText respuesta_usuario = null;
    private cLocalizacion localizacion_dificil = null;
    private TextView tvNombre;
    private TextView tvPuntuacioInt;
    private Random myRandom = new Random();
    private ArrayList<cLocalizacion> localizacions_dificil = new ArrayList<>();
    private ArrayList<cLocalizacion> comprovacion_juego_dificil = new ArrayList<>();
    private String string_mapa_dificil;
    private int puntuacio = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Bundle extras_dificil = getIntent().getExtras();
        string_mapa_dificil = extras_dificil.getString("mapa");
        tvNombre = findViewById(R.id.tvNomPais);
        respuesta_usuario = findViewById(R.id.ed_Respuesta_Usuari);
        tvPuntuacioInt = findViewById(R.id.puntuacionTvInt);

        if (string_mapa_dificil.equals("catalunya")){
            localizacions_dificil = Mapas.lista_catalunya;
        }
        else if (string_mapa_dificil.equals("espanya")){
            localizacions_dificil = Mapas.lista_españa;
        }
        else if (string_mapa_dificil.equals("europa")){
            localizacions_dificil = Mapas.lista_europa;
        }
        else if (string_mapa_dificil.equals("mundial")){
            localizacions_dificil = Mapas.lista_mundial;
        }

        for (int a = 0; a < localizacions_dificil.size(); a++){
            localizacions_dificil.get(a).setMostrada(false);
        }

        comprovacion_juego_dificil.clear();

        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("Nivel Dificil!");
        ad.setMessage("En este nivel aparecerán el nombre de las comarcas, ciudades o países y se tendrá que introducir la capital de cada una! \n" +
                "\nLos acentos no son importantes y las mayúsculas o minúsculas son irrelevantes \n" +
                "Las comunidades autonomas, ciudades o países se tendrán que escribir en Español");

        ad.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        ad.show();

        randomizarJuego();

        Button btnComprovar = findViewById(R.id.btnComprovarDificil);
        btnComprovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juego();
            }
        });

        Button btnTerminar = findViewById(R.id.btnTerminarDificil);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }




    public void randomizarJuego(){
        boolean sortida = false;

        while (sortida == false){
            int posArray = myRandom.nextInt(localizacions_dificil.size());
            localizacion_dificil = localizacions_dificil.get(posArray);
            if (localizacion_dificil.getMostrada() == false){
                tvNombre.setText(localizacion_dificil.getNombre());
                comprovacion_juego_dificil.add(localizacion_dificil);
                sortida = true;
            }
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("ALERTA!!");
        ad.setMessage("¿ Seguro que quieres salir ? Se perderá todo progreso realizado!");

        ad.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                finish();
            }
        });

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        ad.show();
    }

    public void juego(){
        String respuesta = respuesta_usuario.getText().toString().toLowerCase();
        String capital = localizacion_dificil.getCapital().toLowerCase();

            if (localizacions_dificil.size() == comprovacion_juego_dificil.size()){
                if (string_mapa_dificil.equals("catalunya")){
                    if (Mapas.bloqueado_mapa_esp = true) {
                        Mapas.bloqueado_mapa_esp = false;
                        Toast.makeText(getApplicationContext(), "Has desbloqueado el mapa de España!!", Toast.LENGTH_LONG).show();
                    }
                    else if (Mapas.bloqueado_mapa_esp = false){
                        Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();
                    }
                }
                else if (string_mapa_dificil.equals("espanya")){

                    if (Mapas.bloqueado_mapa_ue = true) {
                        Mapas.bloqueado_mapa_ue = false;
                        Toast.makeText(getApplicationContext(), "Has desbloqueado el mapa de la Unión Europea!", Toast.LENGTH_LONG).show();
                    }
                    else if (Mapas.bloqueado_mapa_ue = false) {
                        Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();
                    }

                }
                else if (string_mapa_dificil.equals("europa")){
                    if(Mapas.bloqueado_mapa_mundial = true){
                        Mapas.bloqueado_mapa_mundial = false;
                        Toast.makeText(getApplicationContext(), "Has desbloqueado el mapa Mundial!", Toast.LENGTH_LONG).show();
                    }
                    else if (Mapas.bloqueado_mapa_mundial = false) {
                        Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();
                        if (puntuacio > MainActivity.user1.getPuntuacio_max_dificil()){
                            MainActivity.user1.setPuntuacio_max_dificil(puntuacio);

                        }
                        finish();
                    }
                }

                finish();

            }

           else if (respuesta.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Introduce una respuesta porfavor", Toast.LENGTH_LONG).show();
            }

            else if (respuesta.equals(capital)){
                 Toast.makeText(getApplicationContext(), "Has acertado!", Toast.LENGTH_LONG).show();
                 localizacion_dificil.setMostrada(true);
                 respuesta_usuario.setText("");
                 randomizarJuego();



                puntuacio = puntuacio + 10;
                tvPuntuacioInt.setText(String.valueOf(puntuacio));
            }

            else  {
                Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT).show();
                respuesta_usuario.setText("");


                if (puntuacio == 0){

                }
                else{
                    puntuacio = puntuacio - 5;
                }

                tvPuntuacioInt.setText(String.valueOf(puntuacio));
            }
    }


}