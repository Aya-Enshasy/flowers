package com.example.fragmentactivity;

import java.util.ArrayList;

public class Cart {
  String id;
    ArrayList<CartModel> cartModels;

    public Cart() {
    }

    public Cart(String id, ArrayList<CartModel> cartModels) {
        this.id = id;
        this.cartModels = cartModels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<CartModel> getCartModels() {
        return cartModels;
    }

    public void setCartModels(ArrayList<CartModel> cartModels) {
        this.cartModels = cartModels;
    }
}
