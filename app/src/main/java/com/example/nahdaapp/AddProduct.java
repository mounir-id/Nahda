package com.example.nahdaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    EditText productName, productColor,productQuantity;
    Button btSubmit;
    Spinner compagny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productName = findViewById(R.id.product_name);
        productColor = findViewById(R.id.product_color);
        productQuantity = findViewById(R.id.product_quantity);
        compagny = findViewById(R.id.compagnies);
        btSubmit = findViewById(R.id.submit_product);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbHelper myDB = new DbHelper( AddProduct.this);
                myDB.addProduct (productName.getText ().toString ().trim (),
                        productColor.getText ().toString ().trim (),
                        Integer.valueOf(productQuantity.getText ().toString().trim()),
                        compagny.getSelectedItem().toString().trim());
                Intent intent = new Intent(AddProduct.this,ProductActivity.class);
                startActivity(intent);
            }
        });


    }
}