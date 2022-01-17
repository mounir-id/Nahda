package com.example.nahdaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "NahdaInventory.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "nahda";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "product_name";
    private static final String COLUMN_COLOR = "product_color";
    private static final String COLUMN_QUANTITY = "product_quantity";
    private static final String COLUMN_COMPAGNY = "product_compagny";


    public DbHelper (@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

            String query =  "CREATE TABLE "+ TABLE_NAME+
                    " ("+COLUMN_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, "+
                            COLUMN_NAME+ "TEXT, "+
                            COLUMN_COLOR + "TEXT, "+
                            COLUMN_QUANTITY + "INTEGER, "+
                            COLUMN_COMPAGNY + "TEXT); ";
            db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL ("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    void addProduct (String name, String color, int quantity, String compagny) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_COLOR, color);
        cv.put(COLUMN_QUANTITY, quantity);
        cv.put(COLUMN_COMPAGNY, compagny);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
            Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Ajouté!", Toast.LENGTH_SHORT).show();
    }
}
