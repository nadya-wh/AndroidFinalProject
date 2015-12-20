package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

/**
 * Created by User on 20.12.2015.
 */
public enum FoodParameters {
    PRICE("price"),
    NAME("name"),
    IMAGE_URL("imgUrl");


    private String value;

    FoodParameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
