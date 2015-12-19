package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

/**
 * Created by User on 19.12.2015.
 */
public class Food {
    private FoodType type;
    private String foodName;
    private Double price;

    public Food(FoodType type, String foodName, Double price) {
        this.type = type;
        this.foodName = foodName;
        this.price = price;
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
}
