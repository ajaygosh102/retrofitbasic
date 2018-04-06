package com.example.nano.retrofitbasic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nano on 3/23/2018.
 */

public interface Api {

    String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("marvel")

    Call<List<Hero>> getHeroes();
}
