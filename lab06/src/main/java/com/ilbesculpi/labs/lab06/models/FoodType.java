package com.ilbesculpi.labs.lab06.models;

import java.io.Serializable;

public class FoodType implements Serializable {

    private String name;
    private String color;

    public FoodType() {

    }

    public FoodType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackground() {
        return color;
    }
}
