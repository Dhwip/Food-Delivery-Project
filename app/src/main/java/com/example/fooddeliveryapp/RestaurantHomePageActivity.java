package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RestaurantHomePageActivity extends AppCompatActivity {

    private Button btnAddMenu, btnViewMenu,logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_home_page);

        btnAddMenu = findViewById(R.id.btnAddMenu);
        btnViewMenu = findViewById(R.id.btnViewMenu);
        logout = findViewById(R.id.logout);

        btnAddMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantHomePageActivity.this, AddMenuActivity.class);

                startActivity(intent);
            }
        });

        btnViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantHomePageActivity.this, MenuListActivity.class);
//                intent.putExtra("restaurantName", "Vedant");
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantHomePageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}