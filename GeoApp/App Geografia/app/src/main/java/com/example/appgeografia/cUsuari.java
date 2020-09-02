package com.example.appgeografia;

import android.net.Uri;

public class cUsuari {

    private String nom_usuari = "Usuario";
    private int puntuacio_max_facil;
    private int puntuacio_max_normal;
    private int puntuacio_max_dificil;
    private Uri foto;


    public String getNom_usuari() {
        return nom_usuari;
    }

    public void setNom_usuari(String nom_usuari) {
        this.nom_usuari = nom_usuari;
    }


    public int getPuntuacio_max_facil() {
        return puntuacio_max_facil;
    }

    public void setPuntuacio_max_facil(int puntuacio_max_facil) {
        this.puntuacio_max_facil = puntuacio_max_facil;
    }

    public int getPuntuacio_max_normal() {
        return puntuacio_max_normal;
    }

    public void setPuntuacio_max_normal(int puntuacio_max_normal) {
        this.puntuacio_max_normal = puntuacio_max_normal;
    }

    public int getPuntuacio_max_dificil() {
        return puntuacio_max_dificil;
    }

    public void setPuntuacio_max_dificil(int puntuacio_max_dificil) {
        this.puntuacio_max_dificil = puntuacio_max_dificil;
    }
}
