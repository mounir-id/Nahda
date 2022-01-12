package com.example.nahdaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.nahdaapp.models.Compagny;
import com.example.nahdaapp.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        tableLayout=(TableLayout)findViewById(R.id.product_list);
        List<Product> products= new ArrayList<>();
        Compagny compagny = new Compagny("atlas");
        products.add(new Product("magestic1",150,100,"marron", compagny));
        products.add(new Product("magestic2",200,50,"beige", compagny));


        for (Product p:products
             ) {
            View tableRow = LayoutInflater.from(this).inflate(R.layout.adapter_product,null,false);
            TextView ProductNameView = tableRow.findViewById (R.id.product_name);
            ProductNameView.setText(p.getName());

            TextView ProductQuantityView = tableRow.findViewById (R.id.product_quantity);
            ProductQuantityView.setText(Integer.toString(p.getQuantity()));

            TextView ProductColorsView = tableRow.findViewById (R.id.product_color);
            ProductColorsView.setText(p.getColors());

            tableLayout.addView(tableRow);

            addButton = findViewById(R.id.add_product);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),AddProduct.class);
                    startActivity(intent);
                }
            });
        }

    }
}