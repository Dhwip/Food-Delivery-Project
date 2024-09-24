package com.example.fooddeliveryapp;

public class FeaturedModel {
    int image;
    String name;
    String desc;

    public FeaturedModel(int image, String desc, String name) {
        this.image = image;
        this.desc = desc;
        this.name = name;
    }

    public int getImage() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
