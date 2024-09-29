package com.example.fooddeliveryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button clientSignInButton;
    private Button restaurantSignInButton;
    private Button riderSignInButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("SignInPref", MODE_PRIVATE);
        checkForSignedInUser();

        clientSignInButton = findViewById(R.id.ClientSignIn);
        restaurantSignInButton = findViewById(R.id.RestSignIn);
        riderSignInButton = findViewById(R.id.RiderSignIn);

        clientSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClientSignInActivity.class);
                startActivity(intent);
            }
        });

        restaurantSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RestaurantSignInActivity.class);
                startActivity(intent);
            }
        });

        riderSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RiderSignInActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkForSignedInUser() {
        boolean isSignedIn = sharedPreferences.getBoolean("IS_SIGNED_IN", false);
        String userType = sharedPreferences.getString("UserType", "");

        if (isSignedIn) {
            switch (userType) {
                case "Client":
                    Intent clientIntent = new Intent(MainActivity.this, HomePageActivity.class);
                    startActivity(clientIntent);
                    finish();
                    break;
                case "Restaurant":
                    Intent restaurantIntent = new Intent(MainActivity.this, RestaurantHomePageActivity.class);
                    startActivity(restaurantIntent);
                    finish();
                    break;
                case "Rider":
                    Intent riderIntent = new Intent(MainActivity.this, RiderHomePageActivity.class);
                    startActivity(riderIntent);
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}
