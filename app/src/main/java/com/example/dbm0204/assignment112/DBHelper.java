package com.example.dbm0204.assignment112;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public DBHelper(Context context) {
        super(context,"ProductDB" , null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//create table
        String query="create table productName(_id integer primary key autoincrement,pname text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //insert product
    public long saveProduct(String name)
    {
        db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("pname",name);
        long id=db.insert("productName",null,contentValues);
        return id;
    }

    //fetch product-name
    public Cursor getProduct()
    {
        db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from productName",null);
        if(cursor!=null)
            return  cursor;
        else
            return null;
    }

    //fetch data using array list



}
