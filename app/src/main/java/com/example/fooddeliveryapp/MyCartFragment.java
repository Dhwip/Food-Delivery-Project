package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyCartFragment extends Fragment implements AddToCartListener {

    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    TextView total;
    Button placeOrder;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_cart,container,false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = CartManager.getInstance().getCartItems();
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
        total = view.findViewById(R.id.total);
        placeOrder = view.findViewById(R.id.button);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.isEmpty()) {
                    Toast.makeText(getContext(), "Cart is empty", Toast.LENGTH_SHORT).show();
                } else {
                    double totalPrice = 0;
                    for (CartModel cartItem : list) {
                        try {
                            String priceString = cartItem.getPrice().replaceAll("[^\\d.]", "");
                            totalPrice += Double.parseDouble(priceString);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    if (totalPrice == 0) {
                        Toast.makeText(getContext(), "Cart is empty", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(getContext(), BillActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        updateTotalPrice();

        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void onAddToCart(HomeVerModel item) {
        CartModel cartItem = new CartModel(item.getImage(), item.getName(), item.getPrices(), item.getRating());
        list.add(cartItem);
        cartAdapter.notifyDataSetChanged();
        updateTotalPrice();
    }
    @Override
    public void onResume() {
        super.onResume();
        list = CartManager.getInstance().getCartItems();
        cartAdapter.notifyDataSetChanged();
        updateTotalPrice();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
