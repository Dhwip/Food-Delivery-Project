package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddMenuActivity extends AppCompatActivity {
    private EditText etFoodName, etFoodPrice;
    private Button btnSave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        etFoodName = findViewById(R.id.etFoodName);
        etFoodPrice = findViewById(R.id.etFoodPrice);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = etFoodName.getText().toString().trim();
                String foodPrice = etFoodPrice.getText().toString().trim();

                if (!foodName.isEmpty() && !foodPrice.isEmpty()) {
                    Toast.makeText(AddMenuActivity.this, "Menu item saved!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddMenuActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}