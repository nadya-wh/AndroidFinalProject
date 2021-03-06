package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

import android.graphics.Bitmap;

/**
 * Created by User on 20.12.2015.
 */
public class RowModel {
    private String name;
    private boolean value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */
    private String imageUrl;
    private double price;
    private FoodType type;
    private Bitmap picture;


    public RowModel(String name, boolean value, String imageUrl, double price, FoodType type) {
        this.name = name;
        this.value = value;
        this.imageUrl = imageUrl;
        this.price = price;
        this.type = type;
    }


    public RowModel(String name, boolean value, String imageUrl, double price, FoodType type,
                    Bitmap picture) {
        this.name = name;
        this.value = value;
        this.imageUrl = imageUrl;
        this.price = price;
        this.type = type;
        this.picture = picture;
    }

    public FoodType getType() {
        return type;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValue() {
        return value;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
}
