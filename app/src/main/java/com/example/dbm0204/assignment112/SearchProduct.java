package com.example.dbm0204.assignment112;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class SearchProduct extends Activity {
    AutoCompleteTextView actProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayProduct();
    }

    private void displayProduct() {
        try {
            actProduct = (AutoCompleteTextView) findViewById(R.id.actProductList);
            ArrayList<String> arrayList=new ArrayList<String>();
            DBHelper db = new DBHelper(this);
            Cursor c = db.getProduct();
            while (c.moveToNext()) {

                arrayList.add(c.getString(c.getColumnIndex("pname")));//add cursor value to array list
            }

            ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

            actProduct.setAdapter(adapter);

            actProduct.setThreshold(1);

        }
        catch (Exception ex){}
    }
}
