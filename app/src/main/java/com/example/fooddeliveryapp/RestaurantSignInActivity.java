package com.example.fooddeliveryapp;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_sign_in);

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
                Toast.makeText(RestaurantSignInActivity.this, "Restaurant Signed In", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(RestaurantSignInActivity.this, "Sign Up clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
