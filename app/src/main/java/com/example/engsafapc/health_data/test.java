package com.example.engsafapc.health_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.engsafapc.health_data.Adapters.ResourceAdapter;
import com.example.engsafapc.health_data.Data.Result;
import com.example.engsafapc.health_data.Data.article;
import com.example.engsafapc.health_data.WebAPI.APIService;
import com.example.engsafapc.health_data.WebAPI.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class test extends AppCompatActivity {
    ArrayList<article> articles = new ArrayList<>();
    RecyclerView recycler;
    private ResourceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        recycler=(RecyclerView)findViewById(R.id.recycler) ;
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Resources();


    }

    public  void Resources( ) {



       /* try {
            APIService apiService = RetrofitClient.retrofitRequest();
            Call<Result> call = apiService.Resoures("health",C,"1b58766a79234156a93711ed508c3184");
            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    try {
                        if ((response.isSuccessful())) {
                           Toast.makeText(test.this,response.body().getTotalResults(),Toast.LENGTH_LONG).show();
                            articles =response.body().getArticles();
                            adapter = new ResourceAdapter(test.this,articles);
                            recycler.setAdapter(adapter);
                        }

                    } catch (Exception ex) {

                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Toast.makeText(test.this,"f",Toast.LENGTH_LONG).show();
                }
            });

        } catch (Exception ex) {
        }*/
    }


}