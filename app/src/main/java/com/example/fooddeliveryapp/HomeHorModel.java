package com.example.fooddeliveryapp;

public class HomeHorModel {
    int image;
    String name;

    public HomeHorModel(int image,String n){
        this.image = image;
        this.name = n;
    }

    public int getImg() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
