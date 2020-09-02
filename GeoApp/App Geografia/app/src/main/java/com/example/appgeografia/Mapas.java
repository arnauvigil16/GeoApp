package com.example.appgeografia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class Mapas extends AppCompatActivity {

    public static  ArrayList<cLocalizacion> lista_catalunya = new ArrayList<cLocalizacion>();
    public static  ArrayList<cLocalizacion> lista_españa = new ArrayList<cLocalizacion>();
    public static  ArrayList<cLocalizacion> lista_europa = new ArrayList<cLocalizacion>();
    public static  ArrayList<cLocalizacion> lista_mundial = new ArrayList<cLocalizacion>();

    public static Boolean bloqueado_mapa_esp = true;
    public static Boolean bloqueado_mapa_ue = true;
    public static Boolean bloqueado_mapa_mundial = true;

    Button btnCat;
    Button btnESP;
    Button btnEU;
    Button btnMundial;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 11111 && resultCode == RESULT_OK) {
            finish();
            startActivity(getIntent());
        }
        if (requestCode == 22222 && resultCode == RESULT_OK) {
            finish();
            startActivity(getIntent());
        }
        if (requestCode == 33333 && resultCode == RESULT_OK) {
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);

        lista_españa.add(new cLocalizacion(0, "Galicia", "Santiago de compostela","@drawable/galicia"));
        lista_españa.add(new cLocalizacion(1, "Asturias", "Oviedo","@drawable/asturias"));
        lista_españa.add(new cLocalizacion(2, "Cantabria", "Santander","@drawable/cantabria"));
        lista_españa.add(new cLocalizacion(3, "Pais Vasco", "Vitoria","@drawable/pais_vasco"));
        lista_españa.add(new cLocalizacion(4, "Navarra", "Pamplona","@drawable/navarra"));
        lista_españa.add(new cLocalizacion(5, "Aragon", "Zaragoza","@drawable/aragon"));
        lista_españa.add(new cLocalizacion(7, "Cataluña", "Barcelona","@drawable/catalunya"));
        lista_españa.add(new cLocalizacion(8, "Castilla y Leon", "Valladolid","@drawable/castilla_leon"));
        lista_españa.add(new cLocalizacion(9, "La Rioja", "Logroño","@drawable/rioja"));
        lista_españa.add(new cLocalizacion(10, "Comunidad de Madrid", "Madrid","@drawable/madrid"));
        lista_españa.add(new cLocalizacion(11, "Extremadura", "Merida","@drawable/extremadura"));
        lista_españa.add(new cLocalizacion(12, "Castilla la Mancha", "Toledo","@drawable/castilla_la_mancha"));
        lista_españa.add(new cLocalizacion(13, "Comunidad Valenciana", "Valencia","@drawable/valencia"));
        lista_españa.add(new cLocalizacion(14, "Islas Baleares", "Palma de Mallorca","@drawable/baleares"));
        lista_españa.add(new cLocalizacion(15, "Andalucia", "Sevilla","andalucia"));
        lista_españa.add(new cLocalizacion(15, "Region de Murcia", "Murcia","@drawable/murcia"));
        lista_españa.add(new cLocalizacion(16, "Islas Canarias", "Gran Canaria","@drawable/canarias"));

        lista_catalunya.add(new cLocalizacion(1, "Noguera", "Balaguer","@drawable/noguera"));
        lista_catalunya.add(new cLocalizacion(2, "Pallars Jussa", "Tremp","@drawable/pallars_jusa"));
        lista_catalunya.add(new cLocalizacion(3, "Valle de Aran", "Viella Mitg Aran","@drawable/vall_aran"));
        lista_catalunya.add(new cLocalizacion(4, "Alta Ribagorza", "Pont de suert","@drawable/alta_ribagorza"));
        lista_catalunya.add(new cLocalizacion(5, "Pallars Sobira", "Sort","@drawable/pallars_sobira"));
        lista_catalunya.add(new cLocalizacion(6, "Barcelones", "Barcelona","@drawable/barcelones"));
        lista_catalunya.add(new cLocalizacion(7, "Bajo Llobregat", "San Feliu de Llobregat","@drawable/baix_llobregat"));
        lista_catalunya.add(new cLocalizacion(8, "Garraf", "Villanueva i la Geltru","@drawable/garraf"));
        lista_catalunya.add(new cLocalizacion(9, "Bajo Penedes", "Vendrell","@drawable/baix_penedes"));
        lista_catalunya.add(new cLocalizacion(10, "Tarragones", "Tarragona","@drawable/tarragones"));
        lista_catalunya.add(new cLocalizacion(11, "Bajo Campo", "Reus","@drawable/baix_camp"));
        lista_catalunya.add(new cLocalizacion(12, "Bajo Ebro", "Tortosa","@drawable/baix_ebre"));
        lista_catalunya.add(new cLocalizacion(13, "Montsia", "Amposta","@drawable/montsia"));
        lista_catalunya.add(new cLocalizacion(14, "Tierra Alta", "Gandesa","@drawable/terra_alta"));
        lista_catalunya.add(new cLocalizacion(15, "Ribera de Ebro", "Mora de Ebro","@drawable/ribera_ebre"));
        lista_catalunya.add(new cLocalizacion(16, "Segria", "Lerida","@drawable/segria"));
        lista_catalunya.add(new cLocalizacion(17, "Alto Penedes", "Vilafranca del Penedes","@drawable/alt_penedes"));
        lista_catalunya.add(new cLocalizacion(18, "Alto Campo", "Valls","@drawable/alt_camp"));
        lista_catalunya.add(new cLocalizacion(19, "Conca de Barbera", "Montblanch","@drawable/conca_barbera"));
        lista_catalunya.add(new cLocalizacion(20, "Priorato", "Falset","@drawable/priorat"));
        lista_catalunya.add(new cLocalizacion(21, "Les Garrigues", "Les Borges Blanques","@drawable/garrigues"));
        lista_catalunya.add(new cLocalizacion(22, "Alto Urgel", "Seo de urgel","@drawable/alt_urgell"));
        lista_catalunya.add(new cLocalizacion(23, "Selva", "Santa Coloma de Faranes","@drawable/selva"));
        lista_catalunya.add(new cLocalizacion(24, "Maresme", "Mataro","@drawable/maresme"));
        lista_catalunya.add(new cLocalizacion(25, "Solsones", "Solsona","@drawable/solsones"));
        lista_catalunya.add(new cLocalizacion(26, "Alto Ampurdan", "Figueras","@drawable/solsones"));
        lista_catalunya.add(new cLocalizacion(27, "Bajo Ampurdan", "La Bisbal del Ampurdan","@drawable/baix_emporda"));
        lista_catalunya.add(new cLocalizacion(28, "Pla de l'Estany", "Bañoles","@drawable/pla_estany"));
        lista_catalunya.add(new cLocalizacion(29, "Girones", "Gerona","@drawable/girones"));
        lista_catalunya.add(new cLocalizacion(30, "Plana de Urgel", "Mollerusa","@drawable/pla_urgell"));
        lista_catalunya.add(new cLocalizacion(31, "Ripolles", "Ripoll","@drawable/ripolles"));
        lista_catalunya.add(new cLocalizacion(32, "Garrocha", "Olot","@drawable/garrotxa"));
        lista_catalunya.add(new cLocalizacion(33, "Bergueda", "Berga","@drawable/bergueda"));
        lista_catalunya.add(new cLocalizacion(34, "Osona", "Vich","@drawable/osona"));
        lista_catalunya.add(new cLocalizacion(35, "Valles Oriental", "Granollers","@drawable/valles_oriental"));
        lista_catalunya.add(new cLocalizacion(36, "Valles Occidental", "Tarrasa","@drawable/valles_oriental"));
        lista_catalunya.add(new cLocalizacion(37, "Bages", "Manresa","@drawable/bages"));
        lista_catalunya.add(new cLocalizacion(38, "Segarra", "Cervera","@drawable/segarra"));
        lista_catalunya.add(new cLocalizacion(39, "Anoia", "Igualada","@drawable/anoia"));


        // deshabilita la barra de notificacions
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        btnCat = findViewById(R.id.btnCat);
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa("catalunya");
            }
        });

        btnESP = findViewById(R.id.btnESP);
        btnESP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bloqueado_mapa_esp == true) {
                    Toast.makeText(getApplicationContext(), "No puedes acceder aun a este mapa!", Toast.LENGTH_LONG).show();
                }
                else if (bloqueado_mapa_esp == false) {
                    mapa("españa");
                }
            }
        });


        btnEU = findViewById(R.id.btnEU);
        btnEU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bloqueado_mapa_ue == true) {
                    Toast.makeText(getApplicationContext(), "No puedes acceder aun a este mapa!", Toast.LENGTH_LONG).show();
                }
                else if (bloqueado_mapa_ue == false) {
                    mapa("europa");
                }
            }
        });

        btnMundial = findViewById(R.id.btnMundial);
        btnMundial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bloqueado_mapa_mundial == true) {
                    Toast.makeText(getApplicationContext(), "No puedes acceder aun a este mapa!", Toast.LENGTH_LONG).show();
                }
                else if (bloqueado_mapa_mundial == false) {
                    mapa("mundial");
                }
            }
        });

        if (bloqueado_mapa_esp == false){
            btnESP.setBackgroundResource(R.drawable.icono_espanya);
        }
        if (bloqueado_mapa_ue == false){
            btnEU.setBackgroundResource(R.drawable.icono_europa);
        }
        if (bloqueado_mapa_mundial == false){
            btnMundial.setBackgroundResource(R.drawable.icono_mundo);
        }
    }


    public void mapa(String mapa) {
        Intent intentDificultad = new Intent(this, Dificultad.class);

       if (mapa == "catalunya"){
            intentDificultad.putExtra("mapa","catalunya");
            startActivityForResult(intentDificultad, 11111);
       }
       else if(mapa == "españa") {
            intentDificultad.putExtra("mapa", "espanya");
            startActivityForResult(intentDificultad, 22222);
       }
       else if(mapa == "europa") {
           intentDificultad.putExtra("mapa", "europa");
           startActivityForResult(intentDificultad, 33333);
       }
       else if(mapa == "mundial") {
           intentDificultad.putExtra("mapa", "mundial");
           startActivity(intentDificultad);
       }
    }
}
