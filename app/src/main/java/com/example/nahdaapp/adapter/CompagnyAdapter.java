package com.example.nahdaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nahdaapp.R;
import com.example.nahdaapp.models.Compagny;

import java.util.List;

public class CompagnyAdapter extends BaseAdapter {

    private Context context;
    private List<Compagny> compagnyList;
    private LayoutInflater inflater;


    public CompagnyAdapter(Context context, List<Compagny> compagnyList) {
        this.context = context;
        this.compagnyList = compagnyList;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return compagnyList.size();
    }

    @Override
    public Compagny getItem(int position) {
        return compagnyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =inflater.inflate(R.layout.adapter_compagny,null);

        // get informations about item
        Compagny currentCompagny = getItem (position);
        String compagnyName = currentCompagny.getName ();

        // get item icon view
        ImageView itemIconView = convertView.findViewById(R.id.compagny_icon);
        int resId = context.getResources().getIdentifier(compagnyName,"drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        // get item name view
        TextView compagnyNameView = convertView.findViewById (R.id.compagny_name);
        compagnyNameView.setText(compagnyName);


        return convertView;
    }


}
