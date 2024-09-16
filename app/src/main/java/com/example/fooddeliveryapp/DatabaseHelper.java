package com.example.fooddeliveryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FoodDelivery.db";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_RESTAURANT = "Restaurant";
    private static final String TABLE_RIDER = "Rider";
    private static final String TABLE_CLIENT = "Client";
    private static final String TABLE_ADMIN = "Admin";
    private static final String TABLE_MENU = "Menu";
    private static final String TABLE_ORDERS = "Orders";

    private static final String COL_MENU_ID = "MenuID";
    private static final String COL_RESTAURANT_NAME = "RestaurantName";
    private static final String COL_FOOD_NAME = "FoodName";
    private static final String COL_FOOD_PRICE = "FoodPrice";

    private static final String COL_ORDER_ID = "OrderID";
    private static final String COL_ORDER_DETAILS = "OrderDetails";
    private static final String COL_CLIENT_ID = "ClientID";
    private static final String COL_RIDER_ID = "RiderID";

    private static final String COL_ID = "ID";
    private static final String COL_NAME = "Name";
    private static final String COL_EMAIL = "Email";
    private static final String COL_PASSWORD = "Password";

    private static final String COL_VEHICLE = "Vehicle";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_RESTAURANT = "CREATE TABLE " + TABLE_RESTAURANT + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_PASSWORD + " TEXT)";

        String CREATE_TABLE_RIDER = "CREATE TABLE " + TABLE_RIDER + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_PASSWORD + " TEXT, "
                + COL_VEHICLE + " TEXT)";

        String CREATE_TABLE_CLIENT = "CREATE TABLE " + TABLE_CLIENT + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_PASSWORD + " TEXT)";

//        // Create Admin table
//        String CREATE_TABLE_ADMIN = "CREATE TABLE " + TABLE_ADMIN + " ("
//                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + COL_EMAIL + " TEXT, "
//                + COL_PASSWORD + " TEXT)";

        String CREATE_TABLE_MENU = "CREATE TABLE " + TABLE_MENU + " ("
                + COL_MENU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_RESTAURANT_NAME + " TEXT, "  // Store restaurant name
                + COL_FOOD_NAME + " TEXT, "
                + COL_FOOD_PRICE + " REAL)";

        String CREATE_TABLE_ORDERS = "CREATE TABLE " + TABLE_ORDERS + " ("
                + COL_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_ORDER_DETAILS + " TEXT, "
                + COL_CLIENT_ID + " INTEGER, "
                + COL_RIDER_ID + " INTEGER, "  // Initially NULL when the order is not assigned
                + "FOREIGN KEY (" + COL_CLIENT_ID + ") REFERENCES " + TABLE_CLIENT + "(" + COL_ID + "), "
                + "FOREIGN KEY (" + COL_RIDER_ID + ") REFERENCES " + TABLE_RIDER + "(" + COL_ID + "))";

        db.execSQL(CREATE_TABLE_RESTAURANT);
        db.execSQL(CREATE_TABLE_RIDER);
        db.execSQL(CREATE_TABLE_CLIENT);
//        db.execSQL(CREATE_TABLE_ADMIN);
        db.execSQL(CREATE_TABLE_MENU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop existing tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RIDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        onCreate(db);
    }

    public boolean insertRestaurant(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_RESTAURANT, null, values);
        return result != -1;
    }

//    public boolean insertMenuItem(String restaurantName, String foodName, double foodPrice) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_RESTAURANT_NAME, restaurantName);
//        values.put(COL_FOOD_NAME, foodName);
//        values.put(COL_FOOD_PRICE, foodPrice);
//        long result = db.insert(TABLE_MENU, null, values);
//        return result != -1; // Return true if insertion was successful
//    }

    public boolean insertRider(String name, String email, String password, String vehicle) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);
        values.put(COL_VEHICLE, vehicle);
        long result = db.insert(TABLE_RIDER, null, values);
        return result != -1;
    }

    public boolean insertClient(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_CLIENT, null, values);
        return result != -1;
    }

//
//    public boolean insertAdmin(String email, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_EMAIL, email);
//        values.put(COL_PASSWORD, password);
//        long result = db.insert(TABLE_ADMIN, null, values);
//        return result != -1; // Return true if insertion was successful
//    }

    public boolean authenticateUser(String tableName, String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName + " WHERE " + COL_EMAIL + "=? AND " + COL_PASSWORD + "=?",
                new String[]{email, password});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

//    // Fetch all restaurants
//    public Cursor getAllRestaurants() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT * FROM " + TABLE_RESTAURANT, null);
//    }
    public Cursor getMenuItemsByRestaurant(String restaurantName) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_MENU + " WHERE " + COL_RESTAURANT_NAME + " = ?",
                new String[]{restaurantName});
    }

//    // Fetch all riders
//    public Cursor getAllRiders() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT * FROM " + TABLE_RIDER, null);
//    }
//
//    public Cursor getAvailableOrders() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT * FROM Orders WHERE RiderID IS NULL";  // Assuming RiderID is NULL when the order is not accepted
//        return db.rawQuery(query, null);
//    }
//
//    public boolean acceptOrder(int orderId, int riderId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_RIDER_ID, riderId);  // Assign the rider's ID to this order
//
//        int result = db.update(TABLE_ORDERS, values, COL_ORDER_ID + " = ?", new String[]{String.valueOf(orderId)});
//        return result > 0;  // Return true if the update was successful
//    }

}
