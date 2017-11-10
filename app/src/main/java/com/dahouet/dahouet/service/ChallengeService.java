package com.dahouet.dahouet.service;

import com.dahouet.dahouet.model.Challenge;

import java.util.ArrayList;

import retrofit.http.GET;

/**
 * Created by mcueff on 09/11/17.
 */

public interface ChallengeService {

    public static final String ENDPOINT = "http://10.105.49.86:8080";
    @GET("/challenges/")
    ArrayList<Challenge> challenges();
}
