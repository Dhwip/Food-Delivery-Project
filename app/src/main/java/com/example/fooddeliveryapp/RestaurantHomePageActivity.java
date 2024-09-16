package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RestaurantHomePageActivity extends AppCompatActivity {

    public Button btnAddMenu, btnViewMenu,logout,pendingOrders;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_home_page);

        btnAddMenu = findViewById(R.id.btnAddMenu);
        btnViewMenu = findViewById(R.id.btnViewMenu);
        logout = findViewById(R.id.logout);
        pendingOrders = findViewById(R.id.Orders);

        btnAddMenu.setOnClickListener(v -> {
            Intent intent = new Intent(RestaurantHomePageActivity.this, AddMenuActivity.class);
            startActivity(intent);
        });

        btnViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantHomePageActivity.this, MenuListActivity.class);
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
        pendingOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RestaurantHomePageActivity.this,"Clicked Pending Orders",Toast.LENGTH_SHORT).show();
            }
        });
    }
}