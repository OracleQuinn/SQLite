package com.awardega.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_SURNAME = "CUSTOMER_SURNAME";
    public static final String COLUMN_CUSTOMER_COUNTRY = "CUSTOMER_COUNTRY";
    public static final String COLUMN_CUSTOMER_SEX = "CUSTOMER_SEX";
    public static final String COLUMN_CUSTOMER_PHONENUMBER = "CUSTOMER_PHONENUMBER";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CUSTOMER_NAME + " TEXT,"
                + COLUMN_CUSTOMER_SURNAME + " TEXT,"
                + COLUMN_CUSTOMER_COUNTRY + " TEXT,"
                + COLUMN_CUSTOMER_SEX + " TEXT,"
                + COLUMN_CUSTOMER_PHONENUMBER + " INT);";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
