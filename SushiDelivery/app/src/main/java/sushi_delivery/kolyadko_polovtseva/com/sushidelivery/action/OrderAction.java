package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.action;

import java.util.ArrayList;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Food;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Order;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server.ServerMockery;

/**
 * Created by User on 19.12.2015.
 */
public class OrderAction {
    public static ArrayList<String> getFoodNames(Order order) {
        ArrayList<String> list = new ArrayList<>(order.countOrderSize());
        for (int i = 0; i < order.countOrderSize(); i++) {
            list.add(order.getFoodItem(i).getFoodName());
        }
        return list;
    }
}
