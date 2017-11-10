package com.dahouet.dahouet.service;

import com.dahouet.dahouet.model.Regate;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by mcueff on 09/11/17.
 */

public interface RegateService {

    public static final String ENDPOINT = "http://10.105.49.86:8080";
    @GET("/challenge{challenge_id}/regates/")
    List<Regate> regates(@Path("challenge_id") int challenge_id);
}
