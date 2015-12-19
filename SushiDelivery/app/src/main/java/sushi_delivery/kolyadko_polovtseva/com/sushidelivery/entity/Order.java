package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

import java.util.ArrayList;

/**
 * Created by User on 19.12.2015.
 */
public class Order {
    private ArrayList<Food> food;

    public Order() {
        food = new ArrayList<>();
    }

    public Order(ArrayList<Food> food) {
        this.food = food;
    }

    public void addFoodItem(Food foodItem) {
        food.add(foodItem);
    }

    public void removeFoodItem(Food foodItem) {
        food.remove(foodItem);
    }

    public int countOrderSize() {
        return food.size();
    }

    public Food getFoodItem(int index) {
        return food.get(index);
    }
}
