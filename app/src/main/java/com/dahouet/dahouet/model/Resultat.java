package com.dahouet.dahouet.model;

/**
 * Created by mcueff on 09/11/17.
 */

public class Resultat {

    private int classement;
    private int num_voile;

    public Resultat(int classement, int num_voile) {
        this.classement = classement;
        this.num_voile = num_voile;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public int getNum_voile() {
        return num_voile;
    }

    public void setNum_voile(int num_voile) {
        this.num_voile = num_voile;
    }
}
