package com.example.dbm0204.assignment112;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProductEntry extends Activity implements View.OnClickListener {
    EditText etProduct;
    TextView tvSave,tvClear,tvViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_entry);

        initializeView();
        eventHandling();
    }

    private void eventHandling() {

        tvSave.setOnClickListener(this);
        tvClear.setOnClickListener(this);
        tvViewProduct.setOnClickListener(this);
    }

    private void initializeView() {
        tvSave= (TextView) findViewById(R.id.tvSave);
        tvClear=(TextView) findViewById(R.id.tvClear);
        etProduct=(EditText) findViewById(R.id.etName);
        tvViewProduct=(TextView) findViewById(R.id.tvViewProduct);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.tvSave:
                if(etProduct.getText().toString().isEmpty())
                {
                    Toast.makeText(this,"Enter a product",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DBHelper db=new DBHelper(getApplicationContext());
                    long id =db.saveProduct(etProduct.getText().toString());
                    if(id==-1)
                    {
                        Toast.makeText(this,"Error occurred!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this,"Product added.",Toast.LENGTH_SHORT).show();

                        etProduct.getText().clear();

                    }
                }
                break;
            case R.id.tvClear:

                break;

            case  R.id.tvViewProduct:
                Intent i=new Intent(ProductEntry.this, SearchProduct.class);
                startActivity(i);

                break;

        }


    }
}