package com.example.engsafapc.health_data.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.engsafapc.health_data.Data.article;
import com.example.engsafapc.health_data.R;
import com.example.engsafapc.health_data.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResourceAdapter  extends RecyclerView.Adapter<ResourceAdapter.ViewHolder> {

    private Context context;
    private List<article> articles;
    private boolean isMore = true;



    public ResourceAdapter(Context context, List<article> articleList) {
        this.context = context;
        this.articles = articleList;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_resources, parent, false);

        return new ViewHolder(itemView);
    }



    @Override
    public int getItemCount() {

        return articles.size();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.TitlelVlu.setText(articles.get(position).getTitle());
        holder.DescriptionVal.setText(articles.get(position).getDescription());
        Glide.with(holder.itemView).load(articles.get(position).getUrlToImage()).into(holder.image);


        holder.morelessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMore = !isMore;
                if (isMore) {


                    holder.morelessButton.setText("More Description");

                    holder.DescriptionVal.setVisibility(View.GONE);
                    holder.TitlelVlu.setVisibility(View.VISIBLE);
                    holder.image.setVisibility(View.VISIBLE);

                }
                else {
                    holder. morelessButton.setText("Less");
                    holder.DescriptionVal.setVisibility(View.VISIBLE);
                    holder.TitlelVlu.setVisibility(View.GONE);
                }
            }
        });

    }




    public  class ViewHolder extends  RecyclerView.ViewHolder{
        @Nullable

        @BindView(R.id.TitlelVlu)
        TextView TitlelVlu;
        @BindView(R.id.moreless_button)
        Button morelessButton;
        @BindView(R.id.DescriptionVal)
        TextView DescriptionVal;
        @BindView(R.id.image)
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }





}



