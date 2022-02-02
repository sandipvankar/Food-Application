package com.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
   final static String DBName="FoodDatabase.db";
   final  static int v=3;

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null,v );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "create table orders " +
                                "(id integer primary key autoincrement," +
                                "name text,"+
                                "phone text,"+
                                "price int,"+
                                "image int,"+
                                "quantity int,"+
                                "description text,"+
                                "foodname text)"
                                );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name,String phone,int price, int image, String desc, String foodname, int quantity){
        SQLiteDatabase database= getReadableDatabase();
        ContentValues values= new ContentValues();

            values.put("name",name);
            values.put("phone",phone);
            values.put("price",price);
            values.put("image",image);
            values.put("description",desc);
            values.put("foodname",foodname);
            values.put("quantity", quantity);

        long id=database.insert("orders","null", values);
        if(id <= 0){
            return false;
        }
        else {
            return true;
        }

    }

    public ArrayList<OrderModel> getOrder() {
        ArrayList<OrderModel> orders=new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders ", null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrderModel model= new OrderModel();
                model.setOrderNumber(cursor.getInt(0) +"");
                model.setItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) +"");

                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
}
