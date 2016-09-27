package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

import android.graphics.Bitmap;

/**
 * Created by User on 19.12.2015.
 */
public class Food {
    private FoodType type;
    private String foodName;
    private Double price;
    private String imageUrl;
    private Bitmap picture;

    public Food(FoodType type, String foodName, Double price) {
        this.type = type;
        this.foodName = foodName;
        this.price = price;
    }

    public Food(FoodType type, String foodName, Double price, String imageUrl, Bitmap picture) {
        this.type = type;
        this.foodName = foodName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.picture = picture;
    }

    public Food(FoodType type, String foodName, Double price, String imageUrl) {
        this.type = type;
        this.foodName = foodName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public FoodType getType() {
        return type;
    }

    public String getFoodName() {
        return foodName;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (type != food.type) return false;
        if (foodName != null ? !foodName.equals(food.foodName) : food.foodName != null)
            return false;
        if (price != null ? !price.equals(food.price) : food.price != null) return false;
        if (imageUrl != null ? !imageUrl.equals(food.imageUrl) : food.imageUrl != null)
            return false;
        return picture != null ? picture.equals(food.picture) : food.picture == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
