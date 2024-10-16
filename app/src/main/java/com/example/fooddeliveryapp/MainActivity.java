package com.example.fooddeliveryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button clientSignInButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("SignInPref", MODE_PRIVATE);

        if (isUserSignedIn()) {
            navigateToHomePage();
            return;
        }
        setContentView(R.layout.activity_main);

        clientSignInButton = findViewById(R.id.ClientSignIn);
        clientSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClientSignInActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean isUserSignedIn() {
        return sharedPreferences.getBoolean("IS_SIGNED_IN", false);
    }
    private void navigateToHomePage() {
        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }
}
