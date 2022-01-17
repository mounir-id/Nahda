package com.example.nahdaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.nahdaapp.models.Compagny;

import java.util.ArrayList;
import java.util.List;

public class CompagnyActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compagny);

        List<Compagny> compagnies= new ArrayList<>();
        for (int i = 0; i < getResources().getStringArray(R.array.compagnies).length; i++) {
            compagnies.add(new Compagny(getResources().getStringArray(R.array.compagnies)[i]));
        }

        listView = (ListView) findViewById (R. id. listView);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(CompagnyActivity.this,
                android.R.layout.simple_list_item_1,
                getResources ().getStringArray (R.array.compagnies));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CompagnyActivity.this, ProductActivity.class);
                intent.putExtra("CompagnyName", listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
            });
        listView.setAdapter(mAdapter);
        }

}