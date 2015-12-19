package sushi_delivery.kolyadko_polovtseva.com.sushidelivery.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.dao.IUserDAO;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.dao.DatabaseValues;
import sushi_delivery.kolyadko_polovtseva.com.sushidelivery.entity.User;

/**
 * Created by User on 19.12.2015.
 */
public class UserDAOImpl extends SQLiteOpenHelper implements IUserDAO {

    private static final String DB_NAME = "sushi_delivery";
    private static final String USER_TABLE_NAME = "user";
    private final Context context;


    public UserDAOImpl(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }


    @Override
    public boolean checkUserExist(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + USER_TABLE_NAME +
                        " where " + DatabaseValues.LOGIN.getValue() + "= '" + login +
                        "' and " + DatabaseValues.PASSWORD.getValue() + " = '" + password + "';",
                null);
        if (res.getCount() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseValues.NAME.getValue(), user.getName());
        contentValues.put(DatabaseValues.LOGIN.getValue(), user.getLogin());
        contentValues.put(DatabaseValues.PASSWORD.getValue(), user.getPassword());
        contentValues.put(DatabaseValues.ADDRESS.getValue(), user.getAddress());
        contentValues.put(DatabaseValues.PHONE_NUMBER.getValue(), user.getPhoneNumber());
        if (db.insert(USER_TABLE_NAME, null, contentValues) == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User getUser(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + USER_TABLE_NAME +
                        " where " + DatabaseValues.LOGIN.getValue() + "= '" + login +
                        "' and " + DatabaseValues.PASSWORD.getValue() + " = '" + password + "';",
                null);
        if (res.getCount() == 1) {
            res.moveToFirst();
            String name = res.getString(res.getColumnIndex(DatabaseValues.NAME.getValue()));
            String email = res.getString(res.getColumnIndex(DatabaseValues.LOGIN.getValue()));
            String address = res.getString(res.getColumnIndex(DatabaseValues.ADDRESS.getValue()));
            String phoneNumber = res.getString(res.getColumnIndex(DatabaseValues.PHONE_NUMBER.getValue()));
            return new User(email, name, address, phoneNumber);
        } else {
            return null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (login text primary key, name text, password text, address text, phone_number text);");
        db.execSQL("insert into user values ('admin@admin.com', 'admin', 'admin', 'admin', '000-00-00')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
