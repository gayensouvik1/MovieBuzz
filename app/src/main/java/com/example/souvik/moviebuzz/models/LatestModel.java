package com.example.souvik.moviebuzz.models;

import static android.R.attr.rating;

/**
 * Created by souvik on 4/1/17.
 */

public class LatestModel {

    private String imageURL;
    private String name;
    private double rating;


    public String getName(){
        return name;
    }

    public void setName(String s){
        name = s;
    }

    public String getImageURL(){
        return imageURL;
    }

    public void setImageURL(String s){
        imageURL = s;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
