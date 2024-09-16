package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MenuListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> menuItems;
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        // Initialize the ListView and menuItems
        menuItems = new ArrayList<>();

        String restaurantName = getIntent().getStringExtra("restaurantName");

        dbHelper = new DatabaseHelper(this);

        Cursor cursor = dbHelper.getMenuItemsByRestaurant(restaurantName);

        if (cursor.moveToFirst()) {
            do {
                String foodName = cursor.getString(cursor.getColumnIndexOrThrow("FoodName"));
                double foodPrice = cursor.getDouble(cursor.getColumnIndexOrThrow("FoodPrice"));
                menuItems.add(foodName + " - Rs" + foodPrice);
            } while (cursor.moveToNext());
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
    }
}
