package com.sompod44soft.rentgiant.Database_Classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class DataBaseConnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RentGient";
    private static final String TABLE_NAME = "AppUsersData";
    private static final int VERSION = 44;
    private Context context;
    private static final String CREATE_TABLE = "CREATE TABLE appusers (\n" +
            " user_id integer PRIMARY KEY,\n" +
            " name text NOT NULL,\n" +
            " user_name text NOT NULL,\n" +
            " password text NOT NULL,\n" +
            " email text NOT NULL UNIQUE,\n" +
            " phone text NOT NULL UNIQUE\n" +
            ");";

    public DataBaseConnection(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "create table ", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        }catch(Exception e){
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
