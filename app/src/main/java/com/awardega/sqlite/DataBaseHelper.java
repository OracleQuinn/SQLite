package com.awardega.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public boolean addOne(CustomerModel customerModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
        cv.put(COLUMN_CUSTOMER_SURNAME, customerModel.getSurname());
        cv.put(COLUMN_CUSTOMER_COUNTRY, customerModel.getCountry());
        cv.put(COLUMN_CUSTOMER_SEX, customerModel.getSex());
        cv.put(COLUMN_CUSTOMER_PHONENUMBER, customerModel.getPhoneNumber());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);

        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<CustomerModel> getEveryOne(){
        List<CustomerModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do{
                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                String customerSurname = cursor.getString(2);
                String customerCountry = cursor.getString(3);
                String customerSex = cursor.getString(4);
                int customerPhoneNumber = cursor.getInt(5);

                CustomerModel newCustomer = new CustomerModel(customerID, customerName, customerSurname, customerCountry, customerSex, customerPhoneNumber);
                returnList.add(newCustomer);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }
}
