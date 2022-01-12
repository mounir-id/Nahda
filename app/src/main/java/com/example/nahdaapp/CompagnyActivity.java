package com.example.nahdaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.nahdaapp.adapter.CompagnyAdapter;
import com.example.nahdaapp.models.Compagny;

import java.util.ArrayList;
import java.util.List;

public class CompagnyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compagny);


        List<Compagny> compagnies= new ArrayList<>();
        compagnies.add(new Compagny("atlas"));
        compagnies.add(new Compagny("ilham"));

        GridView compagnyGridView = findViewById(R.id.compagny_List_View);
        compagnyGridView.setAdapter(new CompagnyAdapter(this,compagnies));


        compagnyGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ProductActivity.class);
                startActivity(intent);
            }
        });

    }


}