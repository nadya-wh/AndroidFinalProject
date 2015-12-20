package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.server;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.Order;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.User;

/**
 * Created by User on 19.12.2015.
 */
public class ServerMockery {
    private static User currentUser = null;
    private static Order currentOrder = null;
    private static String sushiKingPhoneNumber = "+375296667641";

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

    public static String getSushiKingPhoneNumber() {
        return sushiKingPhoneNumber;
    }

    public static void setSushiKingPhoneNumber(String sushiKingPhoneNumber) {
        ServerMockery.sushiKingPhoneNumber = sushiKingPhoneNumber;
    }

    public static void logOut(){
        setCurrentOrder(null);
        setCurrentOrder(null);
    }
}
