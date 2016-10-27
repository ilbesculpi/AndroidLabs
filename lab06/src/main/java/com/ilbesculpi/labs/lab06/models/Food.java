package com.ilbesculpi.labs.lab06.models;

import java.io.Serializable;

public class Food implements Serializable {

    private int id;
    private String name;
    private String picture;
    private float price;
    private FoodType type;
    private boolean featured;

    public Food() {

    }

    public Food(int id, String name, String picture, FoodType type, float price, boolean featured) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.type = type;
        this.price = price;
        this.featured = featured;
    }


    //
    // Properties
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    @Override
    public String toString() {
        return getName();
    }

}
