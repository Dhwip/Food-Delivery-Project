package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RiderSignUpActivity extends AppCompatActivity {
    private EditText email, password, confirmPassword,name,vehicle;
    private Button signUpButton;
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_sign_up);
        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        confirmPassword = findViewById(R.id.confirmPasswordEditText);
        signUpButton = findViewById(R.id.signUpButton);
        name = findViewById(R.id.nameEditText);
        vehicle = findViewById(R.id.vehicleEditText);

        databaseHelper = new DatabaseHelper(this);

        signUpButton.setOnClickListener(v -> {
            String nameInput = name.getText().toString();
            String emailInput = email.getText().toString();
            String passwordInput = password.getText().toString();
            String confirmPasswordInput = confirmPassword.getText().toString();
            String vehicleInput = vehicle.getText().toString();

            if (emailInput.isEmpty() || passwordInput.isEmpty() || confirmPasswordInput.isEmpty()||nameInput.isEmpty()) {
                Toast.makeText(RiderSignUpActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else if (!passwordInput.equals(confirmPasswordInput)) {
                Toast.makeText(RiderSignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                boolean isInserted = databaseHelper.insertRider(nameInput,emailInput, passwordInput,vehicleInput);
                if (isInserted) {
                    Toast.makeText(RiderSignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RiderSignUpActivity.this, RiderSignInActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RiderSignUpActivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}