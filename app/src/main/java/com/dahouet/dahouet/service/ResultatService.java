package com.dahouet.dahouet.service;

import com.dahouet.dahouet.model.Resultat;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by mcueff on 09/11/17.
 */

public interface ResultatService {

    public static final String ENDPOINT = "http://10.105.49.86:8080";
    @GET("/regate{id}/resultat/")
    List<Resultat> resultats(@Path("id") int id);
}
