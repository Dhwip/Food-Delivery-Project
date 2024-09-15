package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ClientSignUpActivity extends AppCompatActivity {

    private EditText email, password, confirmPassword,name;
    private Button signUpButton;
    private DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_up);

        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        confirmPassword = findViewById(R.id.confirmPasswordEditText);
        signUpButton = findViewById(R.id.signUpButton);
        name = findViewById(R.id.nameEditText);

        databaseHelper = new DatabaseHelper(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = name.getText().toString();
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();
                String confirmPasswordInput = confirmPassword.getText().toString();

                if (emailInput.isEmpty() || passwordInput.isEmpty() || confirmPasswordInput.isEmpty()||nameInput.isEmpty()) {
                    Toast.makeText(ClientSignUpActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (!passwordInput.equals(confirmPasswordInput)) {
                    Toast.makeText(ClientSignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = databaseHelper.insertClient(nameInput,emailInput, passwordInput);
                    if (isInserted) {
                        Toast.makeText(ClientSignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ClientSignUpActivity.this, ClientSignInActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ClientSignUpActivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
