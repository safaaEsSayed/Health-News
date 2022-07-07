package com.example.engsafapc.health_data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.engsafapc.health_data.Adapters.ResourceAdapter;
import com.example.engsafapc.health_data.Data.Result;
import com.example.engsafapc.health_data.Data.article;
import com.example.engsafapc.health_data.WebAPI.APIService;
import com.example.engsafapc.health_data.WebAPI.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends AppCompatActivity {
    private String Lang = "en" ;
    private String Coun = "us";

    ArrayList <article> articles = new ArrayList<>();
    RecyclerView recycler;
    FloatingActionButton fab;
    private ResourceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recycler=(RecyclerView)findViewById(R.id.recycler) ;
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this , ChangingLang.class));
            }
        });
        recycler.setLayoutManager(new LinearLayoutManager (this));
        getDataFromIntent();
        Resources();


    }

    private void getDataFromIntent() {
        Intent intent = getIntent() ;
        if(intent!=null){
        Lang = intent.getStringExtra("Lang");
        Coun = intent.getStringExtra("Coun");

        }
    }

    public  void Resources( ) {



        try {
            APIService apiService = RetrofitClient.retrofitRequest();
            Call <Result> call = apiService.Resoures("health",Coun,"1b58766a79234156a93711ed508c3184");
            call.enqueue(new Callback <Result> () {
                @Override
                public void onResponse(Call<Result> call, Response <Result> response) {
                    try {
                        if ((response.isSuccessful())) {

                            articles =response.body().getArticles();
                            adapter = new ResourceAdapter(home.this,articles);
                            recycler.setAdapter(adapter);
                        }

                    } catch (Exception ex) {

                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Toast.makeText(home.this,"f",Toast.LENGTH_LONG).show();
                }
            });

        } catch (Exception ex) {
        }
    }


}