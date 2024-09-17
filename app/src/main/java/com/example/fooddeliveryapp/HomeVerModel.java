package com.example.fooddeliveryapp;

public class HomeVerModel {
    int image;
    String name;
    String timing;
    String rating;
    String prices;

    public HomeVerModel(int image, String name, String timing, String prices, String rating) {
        this.image = image;
        this.name = name;
        this.timing = timing;
        this.prices = prices;
        this.rating = rating;
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

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}
