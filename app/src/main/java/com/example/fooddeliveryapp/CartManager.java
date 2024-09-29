package com.example.fooddeliveryapp;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static CartManager instance;
    private final List<CartModel> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItem(CartModel item) {
        cartItems.add(item);
    }

    public List<CartModel> getCartItems() {
        return new ArrayList<>(cartItems);  // Return a copy to avoid modifications outside
    }

    public void clearCart() {
        cartItems.clear();
    }

    public int getCartSize() {
        return cartItems.size();
    }
}

