package com.example.fooddeliveryapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button clientSignInButton;
    private Button restaurantSignInButton;
    private Button riderSignInButton;
    private Button adminSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientSignInButton = findViewById(R.id.ClientSignIn);
        restaurantSignInButton = findViewById(R.id.RestSignIn);
        riderSignInButton = findViewById(R.id.RiderSignIn);
        adminSignInButton = findViewById(R.id.AdminSignIn);

        clientSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Clicked Client",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ClientSignInActivity.class);
                startActivity(intent);
            }
        });

        restaurantSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Clicked Restaurant",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, RestaurantSignInActivity.class);
                startActivity(intent);
            }
        });

        riderSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Clicked Rider",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, RiderSignInActivity.class);
                startActivity(intent);
            }
        });

        adminSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Clicked Admin",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AdminSignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
