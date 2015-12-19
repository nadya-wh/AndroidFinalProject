package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity;

/**
 * Created by User on 19.12.2015.
 */
public class User {
    private String login;
    private String name;
    private String password;
    private String address;
    private String phoneNumber;

    public User(String login, String name, String address, String phoneNumber) {
        this.login = login;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User(String login, String name, String password, String address, String phoneNumber) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
