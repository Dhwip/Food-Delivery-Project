package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminSignInActivity extends AppCompatActivity {

    private EditText email, password;
    private Button signInButton;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);

        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        signUpTextView = findViewById(R.id.signUpTextView);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();

                // TODO: Authenticate the admin sign-in
                Toast.makeText(AdminSignInActivity.this, "Admin Signed In", Toast.LENGTH_SHORT).show();
            }
        });
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminSignInActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminSignInActivity.this, "Sign Up clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
