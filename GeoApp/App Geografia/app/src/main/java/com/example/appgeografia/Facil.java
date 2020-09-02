package com.example.appgeografia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Facil extends AppCompatActivity {

    private cLocalizacion localizacion_facil_unica = null;
    private ArrayList<cLocalizacion> comprovacion_juego_facil = new ArrayList<>();
    private ArrayList<cLocalizacion> localizacions_facil = new ArrayList<>();
    private ArrayList<String> array_opcions_falses = new ArrayList<>();
    private ArrayList<String> array_opcions_falses_cat = new ArrayList<>();
    private ArrayList<String> array_opcions_falses_esp = new ArrayList<>();
    private ArrayList<String> array_opcions_falses_ue = new ArrayList<>();
    private ArrayList<String> array_opcions_falses_mundial = new ArrayList<>();
    private Random myRandom = new Random();

    private ImageView imagen_procedencia;
    private Button opcion1;
    private Button opcion2;
    private Button opcion3;
    private Button opcion4;
    private String opcioFalse1;
    private String opcioFalse2;
    private String opcioFalse3;
    private String opcioFalse4;
    private String string_mapa_normal;

    private int puntuacio;
    private TextView puntuacio_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Bundle extras_normal = getIntent().getExtras();
        string_mapa_normal = extras_normal.getString("mapa");
        imagen_procedencia = findViewById(R.id.imRespuestaFacil);
        puntuacio_tv = findViewById(R.id.tvPuntosNumero);


        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("Nivel Facil!");
        ad.setMessage("En este nivel aparecerá una imagen en la que se mostrara una comarca, ciudad o país y cuatro opciones posibles. Solo una es la correcta! \n" +
                "Las comunidades autonomas, ciudades o países se tendrán que escribir en Español");

        ad.setButton(AlertDialog.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        ad.show();

        // Asignar el array al mapa selecionado
        if (string_mapa_normal.equals("catalunya")) {
            localizacions_facil = Mapas.lista_catalunya;
            array_opcions_falses = array_opcions_falses_cat;
        } else if (string_mapa_normal.equals("espanya")) {
            localizacions_facil = Mapas.lista_españa;
            array_opcions_falses = array_opcions_falses_esp;
        } else if (string_mapa_normal.equals("europa")) {
            localizacions_facil = Mapas.lista_europa;
            array_opcions_falses = array_opcions_falses_ue;
        } else if (string_mapa_normal.equals("mundial")) {
            localizacions_facil = Mapas.lista_mundial;
            array_opcions_falses = array_opcions_falses_mundial;
        }


        for (int a = 0; a < localizacions_facil.size(); a++) {
            localizacions_facil.get(a).setMostrada(false);
        }


        array_opcions_falses_cat.add("Moyanes");
        array_opcions_falses_cat.add("Noguera");
        array_opcions_falses_cat.add("Pallars Jussa");
        array_opcions_falses_cat.add("Valle de Aran");
        array_opcions_falses_cat.add("Alta Ribagorza");
        array_opcions_falses_cat.add("Pallars Sobira");
        array_opcions_falses_cat.add("Barcelones");
        array_opcions_falses_cat.add("Bajo Llobregat");
        array_opcions_falses_cat.add("Garraf");
        array_opcions_falses_cat.add("Bajo Penedes");
        array_opcions_falses_cat.add("Tarragones");
        array_opcions_falses_cat.add("Bajo Campo");
        array_opcions_falses_cat.add("Bajo Ebro");
        array_opcions_falses_cat.add("Montsia");
        array_opcions_falses_cat.add("Tierra Alta");
        array_opcions_falses_cat.add("Ribera de Ebro");
        array_opcions_falses_cat.add("Segria");
        array_opcions_falses_cat.add("Alto Penedes");
        array_opcions_falses_cat.add("Alto Camp");
        array_opcions_falses_cat.add("Conca de Barbera");
        array_opcions_falses_cat.add("Priorato");
        array_opcions_falses_cat.add("Les Garrigues");
        array_opcions_falses_cat.add("Alto Urgel");
        array_opcions_falses_cat.add("Selva");
        array_opcions_falses_cat.add("Maresme");
        array_opcions_falses_cat.add("Solsones");
        array_opcions_falses_cat.add("Alto Ampurdan");
        array_opcions_falses_cat.add("Bajo Ampurdan");
        array_opcions_falses_cat.add("Pla de l'Estany");
        array_opcions_falses_cat.add("Girones");
        array_opcions_falses_cat.add("Alto Urgel");
        array_opcions_falses_cat.add("Ripolles");
        array_opcions_falses_cat.add("Garrocha");
        array_opcions_falses_cat.add("Bergueda");
        array_opcions_falses_cat.add("Osona");
        array_opcions_falses_cat.add("Valles Oriental");
        array_opcions_falses_cat.add("Valles Occidental");
        array_opcions_falses_cat.add("Bages");
        array_opcions_falses_cat.add("Segarra");
        array_opcions_falses_cat.add("Anoia");

        array_opcions_falses_esp.add("Galicia");
        array_opcions_falses_esp.add("Asturias");
        array_opcions_falses_esp.add("Cantabria");
        array_opcions_falses_esp.add("Pais Vasco");
        array_opcions_falses_esp.add("Navarra");
        array_opcions_falses_esp.add("Aragon");
        array_opcions_falses_esp.add("Cataluña");
        array_opcions_falses_esp.add("Castilla y Leon");
        array_opcions_falses_esp.add("La Rioja");
        array_opcions_falses_esp.add("Comunidad de Madrid");
        array_opcions_falses_esp.add("Extremadura");
        array_opcions_falses_esp.add("Castilla la Mancha");
        array_opcions_falses_esp.add("Comunidad Valenciana");
        array_opcions_falses_esp.add("Islas Baleares");
        array_opcions_falses_esp.add("Andalucia");
        array_opcions_falses_esp.add("Region de Murcia");
        array_opcions_falses_esp.add("Islas Canarias");


        opcion1 = findViewById(R.id.btnRespuesta1);
        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovar(1);
            }
        });

        opcion2 = findViewById(R.id.btnRespuesta2);
        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovar(2);
            }
        });

        opcion3 = findViewById(R.id.btnRespuesta3);
        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovar(3);
            }
        });

        opcion4 = findViewById(R.id.btnRespuesta4);
        opcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovar(4);
            }
        });


        Button btnTerminar = findViewById(R.id.btnTerminarFacil);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        comprovacion_juego_facil.clear();

        randomizarJuego();
    }

    public void randomizarJuego() {

        boolean sortida = false;

        while (sortida == false) {

            int posArray = myRandom.nextInt(localizacions_facil.size());
            localizacion_facil_unica = localizacions_facil.get(posArray);
            if (localizacion_facil_unica.getMostrada() == false) {
                imagen_procedencia.setImageResource(getResources().getIdentifier(localizacion_facil_unica.getLink(), "drawable", getOpPackageName()));
                randomizarRespuestas();
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

        ad.setButton(AlertDialog.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
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

    public void randomizarRespuestas() {

        Collections.shuffle(array_opcions_falses);

        opcioFalse1 = array_opcions_falses.get(0);
        opcioFalse2 = array_opcions_falses.get(1);
        opcioFalse3 = array_opcions_falses.get(2);
        opcioFalse4 = array_opcions_falses.get(3);

        int randomResposta = myRandom.nextInt(4);

        if (randomResposta == 0) {
            opcion1.setText(localizacion_facil_unica.getNombre());
        } else if (randomResposta == 1) {
            opcion2.setText(localizacion_facil_unica.getNombre());
        } else if (randomResposta == 2) {
            opcion3.setText(localizacion_facil_unica.getNombre());
        } else if (randomResposta == 3) {
            opcion4.setText(localizacion_facil_unica.getNombre());
        }

        for (int i = 0; i < 4; i++) {

            if (i != randomResposta) {

                switch (i) {
                    case 0:

                        if (opcioFalse1.equals(localizacion_facil_unica.getNombre()) || opcioFalse1.equals(opcioFalse2) || opcioFalse1.equals(opcioFalse3) || opcioFalse1.equals(opcioFalse4)) {
                            randomizarRespuestas();
                        } else {
                            opcion1.setText(opcioFalse1);
                        }

                        break;

                    case 1:
                        if (opcioFalse2.equals(localizacion_facil_unica.getNombre()) || opcioFalse2.equals(opcioFalse1) || opcioFalse2.equals(opcioFalse3) || opcioFalse2.equals(opcioFalse4)) {
                            randomizarRespuestas();
                        } else {
                            opcion2.setText(opcioFalse2);
                        }
                        break;

                    case 2:
                        if (opcioFalse3.equals(localizacion_facil_unica.getNombre()) || opcioFalse3.equals(opcioFalse1) || opcioFalse3.equals(opcioFalse2) || opcioFalse3.equals(opcioFalse4)) {
                            randomizarRespuestas();
                        } else {
                            opcion3.setText(opcioFalse3);
                        }
                        break;

                    case 3:
                        if (opcioFalse4.equals(localizacion_facil_unica.getNombre()) || opcioFalse4.equals(opcioFalse1) || opcioFalse4.equals(opcioFalse2) || opcioFalse4.equals(opcioFalse3)) {
                            randomizarRespuestas();
                        } else {
                            opcion4.setText(opcioFalse4);
                        }
                        break;
                }
            }

        }

    }

    public void comprovar(int numeroBoton) {
        String boton_solucion = "";

        if (numeroBoton == 1) {
            boton_solucion = opcion1.getText().toString().toLowerCase();
        } else if (numeroBoton == 2) {
            boton_solucion = opcion2.getText().toString().toLowerCase();
        } else if (numeroBoton == 3) {
            boton_solucion = opcion3.getText().toString().toLowerCase();
        } else if (numeroBoton == 4) {
            boton_solucion = opcion4.getText().toString().toLowerCase();
        }

        String solucion = localizacion_facil_unica.getNombre().toLowerCase();

        if (boton_solucion.equals(solucion)) {

            Toast.makeText(getApplicationContext(), "Has acertado!", Toast.LENGTH_SHORT).show();

            puntuacio = puntuacio + 10;
            puntuacio_tv.setText(String.valueOf(puntuacio));

            comprovacion_juego_facil.add(localizacion_facil_unica);
            localizacion_facil_unica.setMostrada(true);


            if (comprovacion_juego_facil.size() == localizacions_facil.size()) {

                Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG).show();

                if (puntuacio > MainActivity.user1.getPuntuacio_max_facil()) {
                    MainActivity.user1.setPuntuacio_max_facil(puntuacio);
                }

                finish();
            } else {
                randomizarJuego();
            }
        } else if (boton_solucion != solucion) {
            Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT).show();

            if (puntuacio == 0) {

            } else {
                puntuacio = puntuacio - 5;
            }
            puntuacio_tv.setText(String.valueOf(puntuacio));
        }
    }
}
