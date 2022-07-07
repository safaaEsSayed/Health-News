package com.example.engsafapc.health_data.WebAPI;

import com.example.engsafapc.health_data.Data.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIService {


    @GET("top-headlines")
    Call<Result> Resoures(@Query("category") String category,@Query("country") String Country, @Query("apiKey") String apiKey);
}

