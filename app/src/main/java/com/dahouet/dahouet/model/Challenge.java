package com.dahouet.dahouet.model;

/**
 * Created by mcueff on 09/11/17.
 */

public class Challenge {

    private String date_debut;
    private String date_fin;
    private String libelle;
    private int id;

    public Challenge(String date_debut, String date_fin, String libelle, int id) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.libelle = libelle;
        this.id = id;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
