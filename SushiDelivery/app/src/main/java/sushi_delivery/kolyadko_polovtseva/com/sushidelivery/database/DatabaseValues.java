package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.database;

/**
 * Created by User on 18.12.2015.
 */
public enum DatabaseValues {

    NAME("name"),
    LOGIN("login"),
    PASSWORD("password");

    private String value;

    DatabaseValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
