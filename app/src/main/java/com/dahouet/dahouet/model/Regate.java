package com.dahouet.dahouet.model;

/**
 * Created by mcueff on 09/11/17.
 */

public class Regate {

    private int id;
    private String date;
    private String libelle;
    private int distance;


    private int challenge_id;


    public Regate(int id, String date, String libelle, int distance, int challenge_id, String date_debut, String date_fin) {
        this.id = id;
        this.date = date;
        this.libelle = libelle;
        this.distance = distance;
        this.challenge_id = challenge_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

}
