package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.dao;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.User;

/**
 * Created by User on 19.12.2015.
 */
public interface IUserDAO {
    boolean checkUserExist(String login, String password);
    boolean addUser (User user);


}
