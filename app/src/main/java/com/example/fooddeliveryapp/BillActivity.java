package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BillActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView total;
    Button goToHomeButton;
    CartAdapter cartAdapter;
    List<CartModel> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        recyclerView = findViewById(R.id.bill_recycler);
        total = findViewById(R.id.bill_total);
        goToHomeButton = findViewById(R.id.go_to_home_button);

        list = CartManager.getInstance().getCartItems();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);

        updateTotalPrice();

        CartManager.getInstance().clearCart();

        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartManager.getInstance().clearCart();

                list.clear();
                cartAdapter.notifyDataSetChanged();

                Intent intent = new Intent(BillActivity.this, HomePageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("go_to_home", true);
                startActivity(intent);
                finish();
            }
        });

    }

    private void updateTotalPrice() {
        double totalPrice = 0;

        for (CartModel cartItem : list) {
            try {
                String priceString = cartItem.getPrice().replaceAll("[^\\d.]", "");
                totalPrice += Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        total.setText("Total: ₹ " + String.format("%.2f", totalPrice));
    }
}
