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
    final  static int v=11;

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null,v );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "create table  orders" +
                                "(id integer primary key autoincrement," +
                                "name text,"+
                                  "phone text,"+
                                "price int,"+
                                "image int,"+
                                "quantity int,"+
                                "foodname text,"+
                                "description text)"
                                );
        sqLiteDatabase.execSQL ( " create table users(username Text primary key ,mobileNo Text ,email Text,password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists orders");
        sqLiteDatabase.execSQL("Drop table if exists users");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name,String phone,int price, int image, String desc, String foodname, int quantity){
        SQLiteDatabase database= getReadableDatabase();
        ContentValues values= new ContentValues();

            values.put("name",name);
            values.put("phone",phone);
            values.put("price",price);
            values.put("image",image);
            values.put("foodname",foodname);
            values.put("description",desc);
            values.put("quantity", quantity);

        long id=database.insert("orders","null", values);
        if(id <= 0){
            return false;
        }
        else {
            return true;
        }

    }
    public boolean insertUserData(String username, String mobile, String email, String password){
        SQLiteDatabase database= this.getReadableDatabase();
        ContentValues values= new ContentValues();

        values.put("username", username);
        values.put("mobileNo", mobile);
        values.put("email", email);
        values.put("password",password);

        long id=database.insert("users","null", values);
        if (id==-1)
            return  false;
        else
            return true;

    }
    //CheckUsername function
    public Boolean checkusername(String username) {
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor= database.rawQuery("select * from users where username=? ", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
    //CheckUsername&Password function
    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor= database.rawQuery("select * from users where username=? and password=?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public ArrayList<OrderModel> getOrder() {
        ArrayList<OrderModel> orders=new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,description,image,price,name,phone from orders ", null);
        if(cursor.moveToFirst()) {
            do {
                OrderModel model= new OrderModel();
                model.setOrderNumber(cursor.getInt(0) +"");
                model.setItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) +"");

                model.setName(cursor.getString(4));
                model.setNumber(cursor.getString(5));
                orders.add(model);
            }while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return orders;
    }

    public int deleteOrder(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id="+id , null);
    }
         
}
