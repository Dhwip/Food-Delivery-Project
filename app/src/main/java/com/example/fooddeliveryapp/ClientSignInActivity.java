package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ClientSignInActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_signin);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        signUpTextView = findViewById(R.id.signUpTextView);
        databaseHelper = new DatabaseHelper(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = emailEditText.getText().toString();
                String passwordInput = passwordEditText.getText().toString();

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(ClientSignInActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isValidUser = databaseHelper.authenticateUser("Client",emailInput, passwordInput);
                    if (isValidUser) {
                        Intent intent = new Intent(ClientSignInActivity.this,HomePageActivity.class);
                        startActivity(intent);
                        Toast.makeText(ClientSignInActivity.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ClientSignInActivity.this, "Sign In Failed: Invalid Email or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClientSignInActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientSignInActivity.this,ClientSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}

