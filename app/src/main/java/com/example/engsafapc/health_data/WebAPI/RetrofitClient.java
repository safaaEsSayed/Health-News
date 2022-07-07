package com.example.engsafapc.health_data.WebAPI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static String ApiUrl ="";


    public static APIService retrofitRequest() {

        Retrofit.Builder rBuilder = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/");
        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(2500, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(2500, TimeUnit.SECONDS);

        rBuilder.client(okHttpClientBuilder.build());
        Retrofit retrofit = rBuilder.addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        return apiService;

    }
}


