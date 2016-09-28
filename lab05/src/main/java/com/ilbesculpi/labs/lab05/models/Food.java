package com.ilbesculpi.labs.lab05.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

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

    public Food(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.picture = parcel.readString();
        this.type = FoodType.fromString(parcel.readString());
        this.price = parcel.readFloat();
        this.featured = parcel.readInt() == 0 ? false : true;
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

    //
    // Parcelable
    //

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>() {

        @Override
        public Food createFromParcel(Parcel parcel) {
            return new Food(parcel);
        }

        @Override
        public Food[] newArray(int i) {
            return new Food[i];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getPicture());
        parcel.writeString(getType().getValue());
        parcel.writeFloat(getPrice());
        parcel.writeInt(isFeatured() ? 1 : 0);
    }
}
