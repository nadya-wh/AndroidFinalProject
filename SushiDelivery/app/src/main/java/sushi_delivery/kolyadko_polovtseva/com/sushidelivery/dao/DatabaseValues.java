package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.dao;

/**
 * Created by User on 18.12.2015.
 */
public enum DatabaseValues {

    NAME("name"),
    LOGIN("login"),
    PASSWORD("password"),
    PHONE_NUMBER("phone_number"),
    ADDRESS("address");

    private String value;

    DatabaseValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
