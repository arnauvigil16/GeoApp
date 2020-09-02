package com.example.appgeografia;

public class cLocalizacion {

    private int id;
    private String nombre_localizacion;
    private String capital;
    private String link_img;
    private boolean mostrada = false;


    public cLocalizacion(int iID, String sNombre, String sCapital, String sLink){
        id = iID;
        nombre_localizacion = sNombre;
        capital = sCapital;
        link_img = sLink;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre_localizacion;
    }

    public String getCapital(){
        return capital;
    }

    public String getLink(){
        return link_img;
    }

    public boolean getMostrada() {
        return mostrada;
    }

    public void setMostrada(boolean bMostrada) {
        mostrada = bMostrada;
    }
}
