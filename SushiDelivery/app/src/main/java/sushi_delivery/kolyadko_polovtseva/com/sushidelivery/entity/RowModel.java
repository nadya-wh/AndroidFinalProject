package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

/**
 * Created by User on 20.12.2015.
 */
public class RowModel {
    private String name;
    private int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */

    public RowModel(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
