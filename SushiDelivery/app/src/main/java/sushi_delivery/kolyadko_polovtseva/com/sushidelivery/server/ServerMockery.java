package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Order;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.User;

/**
 * Created by User on 19.12.2015.
 */
public class ServerMockery {
    private static User currentUser = null;
    private static Order currentOrder = null;

    public static void setCurrentUser(User currentUser) {
        ServerMockery.currentUser = currentUser;
    }

    public static void setCurrentOrder(Order currentOrder) {
        ServerMockery.currentOrder = currentOrder;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Order getCurrentOrder() {
        return currentOrder;
    }
}
