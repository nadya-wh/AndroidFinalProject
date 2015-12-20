package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

/**
 * Created by User on 19.12.2015.
 */
public enum FoodType {
    DRINK("drink", "drinks"),
    SOUP("soup", "soups"),
    SALAD("salad", "salads"),
    SUSHI("sushi", "sushi");


    private String singleFormValue;
    private String multipleFormValue;

    FoodType(String singleFormValue, String mutipleFormValue) {
        this.singleFormValue = singleFormValue;
        this.multipleFormValue = mutipleFormValue;
    }

    public String getSingleFormValue() {
        return singleFormValue;
    }

    public String getMultipleFormValue() {
        return multipleFormValue;
    }
}
