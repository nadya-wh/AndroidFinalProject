package sushi_delivery.kolyadko_polovtseva.com.sushidelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 18.12.2015.
 */
public class DatabaseManager extends SQLiteOpenHelper {

//    private static final String DB_PATH = "/data/data/com/kolyadko_polovtseva/sushi_delivery/databases/";
    private static final String DB_NAME = "sushi_delivery";
    private static final String USER_TABLE_NAME = "user";
    private final Context context;
    private SQLiteDatabase database;


    public DatabaseManager(Context context)
    {
        super(context, DB_NAME , null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (login text primary key, name text, password text);");
        db.execSQL("insert into user values ('admin@admin.com', 'admin', 'admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUser(String name, String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseValues.NAME.getValue(), name);
        contentValues.put(DatabaseValues.LOGIN.getValue(), login);
        contentValues.put(DatabaseValues.PASSWORD.getValue(), password);
        if (db.insert(USER_TABLE_NAME, null, contentValues) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUserExist(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + USER_TABLE_NAME +
                " where " + DatabaseValues.LOGIN.getValue() + "= '" + login +
                "' and " + DatabaseValues.PASSWORD.getValue() + " = '" + password + "';",
                null );
        if (res.getCount() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
