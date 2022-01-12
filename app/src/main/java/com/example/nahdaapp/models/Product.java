package com.example.nahdaapp.models;

import com.example.nahdaapp.CompagnyActivity;

import java.util.List;

public class Product {


    private String name;
    private int price;
    private int quantity;
    private String color;
    private Compagny compagny;

    public Product(String name, int price, int quantity, String color, Compagny compagny) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.compagny = compagny;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColors() {
        return color;
    }

    public Compagny getCompagny() {
        return compagny;
    }
}
