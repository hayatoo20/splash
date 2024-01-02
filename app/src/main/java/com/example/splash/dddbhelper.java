package com.example.splash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dddbhelper extends SQLiteOpenHelper {

    private static final String Database__Name = "order.db";
    private static final int Database_Version = 1;

    private static final String TABLE_USER_DETAILS = "UserDetails";
    private static final String COL1_USERNAME = "UserName";
    private static final String COL2_PASSWORD = "Password";

    public static final String TABLE_ORDER_DETAILS = "OrderDetails";
    public static final String ColUm_1 = "Contact_Number";
    public static final String ColUm_2 = "Customer__Name";
    public static final String ColUm_3 = "Number_Of_Order_Type1";
    public static final String ColUm_4 = "Number_Of_Order_Type2";
    public static final String ColUm_5 = "Total_Price_Of_Order";

    public dddbhelper(Context context) {
        super(context, Database__Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTableQuery = "CREATE TABLE " + TABLE_USER_DETAILS + " (" +
                COL1_USERNAME + " TEXT PRIMARY KEY, " +
                COL2_PASSWORD + " TEXT)";
        db.execSQL(createUserTableQuery);

        String createOrderTableQuery = "CREATE TABLE " + TABLE_ORDER_DETAILS +
                " (" + ColUm_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ColUm_2 + " TEXT, " +
                ColUm_3 + " INTEGER, " +
                ColUm_4 + " INTEGER, " +
                ColUm_5 + " INTEGER)";
        db.execSQL(createOrderTableQuery);
      
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER_DETAILS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DETAILS);
        onCreate(db);
    }

    public boolean insertUserData(String userName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL1_USERNAME, userName);
        values.put(COL2_PASSWORD, password);

        long result = db.insert(TABLE_USER_DETAILS, null, values);
        return result != -1;
    }

    public boolean validateUser(String userName, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER_DETAILS + " WHERE " + COL1_USERNAME + "=? AND " + COL2_PASSWORD + "=?", new String[]{userName, password});
        return cursor.getCount() > 0;
    }

    public boolean To_check_username_andpassword(String userName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT*FROM UserDetails WHERE UserName=?", new String[]{userName});
        return cursor.getCount() > 0;
    }

    public boolean updateOrderDetails(int contact, String name, int order1, int order2, int total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ColUm_2, name);
        values.put(ColUm_3, order1);
        values.put(ColUm_4, order2);
        values.put(ColUm_5, total);

        int result = db.update(TABLE_ORDER_DETAILS, values, ColUm_1 + "=?", new String[]{String.valueOf(contact)});
        return result > 0;
    }


    public boolean deleteOrderDetails(int contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_ORDER_DETAILS, ColUm_1 + "=?", new String[]{String.valueOf(contact)});
        return result > 0;
    }

    public Cursor getAllOrderDetails() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ORDER_DETAILS, null);
    }

    public boolean insertOrderData(String nama, int contact, int order1, int order2, int total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ColUm_2, nama);
        values.put(ColUm_1, contact);
        values.put(ColUm_3, order1);
        values.put(ColUm_4, order2);
        values.put(ColUm_5, total);

        long result = db.insert(TABLE_ORDER_DETAILS, null, values);
        return result != -1;
    }
    }