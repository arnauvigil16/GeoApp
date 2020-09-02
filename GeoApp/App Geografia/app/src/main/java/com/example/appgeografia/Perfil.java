package com.example.appgeografia;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Perfil extends AppCompatActivity {


    private TextView tvNombreUsuario2;
    public static  final int PICK_IMAGE = 100;
    public static Uri imageUri;
    private Button btnNomUsuari;
    private Button btnImagenUsuario;
    private Button btnPuntuacio;
    private ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // deshabilita la barra de notificacions
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        tvNombreUsuario2 = findViewById(R.id.tvNombreUsuario);
        foto = findViewById(R.id.imUsuario);
        btnNomUsuari = findViewById(R.id.btnNomUsuari);
        btnImagenUsuario = findViewById(R.id.btnImagenUsuario);
        btnPuntuacio = findViewById(R.id.btnPuntuacio);

        cargar_preferencias();

        btnPuntuacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDificultad = new Intent(Perfil.this, puntuacions.class);
                startActivity(intentDificultad);
            }
        });

        btnImagenUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarFoto();
            }
        });

        btnNomUsuari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarNombre();
            }
        });
    }

    private void modificarFoto(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }

    private void modificarNombre() {
        AlertDialog ad;

        ad = new AlertDialog.Builder(this).create();
        ad.setMessage("Introduzca su nombre de usuario:");

        // Ahora forzamos que aparezca el editText
        final EditText edtValor = new EditText(this);
        ad.setView(edtValor);

        ad.setButton(AlertDialog.BUTTON_POSITIVE,"Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                MainActivity.user1.setNom_usuari(edtValor.getText().toString());
                tvNombreUsuario2.setText(MainActivity.user1.getNom_usuari());
                guardarPreferencias();
            }
        });

        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // no fem res.
            }
        });
        ad.show();

        // el Show es asíncrono.
    }

    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("info_user", Context.MODE_PRIVATE);

        String usuario = MainActivity.user1.getNom_usuari();
        int puntuacion_maxima_facil = MainActivity.user1.getPuntuacio_max_facil();
        int puntuacion_maxima_normal = MainActivity.user1.getPuntuacio_max_normal();
        int puntuacion_maxima_dificil = MainActivity.user1.getPuntuacio_max_dificil();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("nom_user", usuario);
        editor.putInt("maxima_facil", puntuacion_maxima_facil);
        editor.putInt("maxima_normal", puntuacion_maxima_normal);
        editor.putInt("maxima_dificil", puntuacion_maxima_dificil);

        editor.commit();
    }

    private void cargar_preferencias() {
        SharedPreferences preferences = getSharedPreferences("info_user", Context.MODE_PRIVATE);

        MainActivity.user1.setNom_usuari(preferences.getString("nom_user","Usuario"));

        tvNombreUsuario2.setText(MainActivity.user1.getNom_usuari());
    }
}
