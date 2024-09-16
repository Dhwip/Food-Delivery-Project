package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RestaurantSignInActivity extends AppCompatActivity {

    private EditText email, password;
    private Button signInButton;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_sign_in);

        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        signUpTextView = findViewById(R.id.signUpTextView);
        databaseHelper = new DatabaseHelper(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(RestaurantSignInActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isValidUser = databaseHelper.authenticateUser("Restaurant",emailInput, passwordInput);
                    if (isValidUser) {
                        Intent intent = new Intent(RestaurantSignInActivity.this,RestaurantHomePageActivity.class);
                        startActivity(intent);
                        Toast.makeText(RestaurantSignInActivity.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RestaurantSignInActivity.this, "Sign In Failed: Invalid Email or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RestaurantSignInActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantSignInActivity.this, RestaurantSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
