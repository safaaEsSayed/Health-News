package com.example.engsafapc.health_data.Data;

import java.util.ArrayList;

public class Result {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<article> articles) {
        this.articles = articles;
    }

    String status;
    String totalResults;
    ArrayList<article> articles ;
}
