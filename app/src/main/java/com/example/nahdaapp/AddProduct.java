package com.example.nahdaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddProduct extends AppCompatActivity {

    EditText productName, productColor,productQuantity;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productName = findViewById(R.id.product_name);
        productColor = findViewById(R.id.product_color);
        productQuantity = findViewById(R.id.product_quantity);
        btSubmit = findViewById(R.id.submit_product);


    }
}