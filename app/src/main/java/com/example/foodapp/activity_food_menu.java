package com.example.foodapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.OrderActivity;
import com.example.activity_food_menu.Adapters.MainAdapter;
import com.example.foodapp.Models.MainModel;
import com.example.foodapp.databinding.ActivityFoodMenuBinding;

import java.util.ArrayList;

public class activity_food_menu extends AppCompatActivity {


        ActivityFoodMenuBinding binding;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Menu");


            Intent intent = getIntent();

            String str=intent.getStringExtra("uid");
           // Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();


            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("userid", str);
            myEdit.commit();
        binding = ActivityFoodMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger, "11","Burger", "75", "Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "12","Pizza", "135", "Just Cheese and tomato"));
        list.add(new MainModel(R.drawable.sandwich, "13","Sandwich", "72", "Delicious sandwiches made with mix vegetables"));
        list.add(new MainModel(R.drawable.friess,"14", "Fries", "89", "Masala French and Spicy Fries"));
        list.add(new MainModel(R.drawable.vadapav,"15", "Vadapav", "45", "tomato,capsicum,onion with cheese "));
        list.add(new MainModel(R.drawable.pasta, "16","Pasta", "160", "Semolina pasta with which is rich in protein"));
        list.add(new MainModel(R.drawable.paneer,"17", "Paneer", "150", "Paneer tikka masala with butter"));
        list.add(new MainModel(R.drawable.samosa, "18","Samosa", "25", "Aloo mutter Samosa with Ragda "));
        list.add(new MainModel(R.drawable.alooprt, "19","Aloopuri", "70", "Whole wheat flour, garam masala powder, ginger, diced"));
        list.add(new MainModel(R.drawable.bhelpuri, "20","Bhelpuri", "60", "Puffed rice, fennel, green chutney, tamarind paste, jaggery"));
        list.add(new MainModel(R.drawable.chines, "21","Chines", "120", "Hakka noodles are wheat noodles "));
        list.add(new MainModel(R.drawable.dosa, "22","Masala Dosa", "145", " Cripsy Masala Dosa with Chatni"));
        list.add(new MainModel(R.drawable.frankie, "23","Masala Frankie", "110", " Veg rolls made with whole wheat flour and mixed veggies"));
        list.add(new MainModel(R.drawable.gujratit, "24","Gujarati Thali", "170", " consists of rotli, dal or kadhi, rice, and shaak"));
        list.add(new MainModel(R.drawable.indisambhar, "25","Idli Sambar", "125", "  fluffy soft idli is served with hot sambar (spicy vegetable lentil stew)"));
        list.add(new MainModel(R.drawable.pavbhaji, "26","PavBhaji", "90", "spiced mixture of mashed vegetables in a thick gravy served with bread"));
        list.add(new MainModel(R.drawable.pjbthali, "27","Punjabi Thali", "190", "buttery and paneer based dishes with gluten free makki di roti and Jeera rice"));
        list.add(new MainModel(R.drawable.dabeli, "28","Dabeli", "30", " spicy, tangy and sweet potato filling inside a bun"));
        list.add(new MainModel(R.drawable.cholebhature, "29","Chole Bhature", "100", "chole - a spicy chickpea curry, aiiiiiii/ul,kkkkkkk`

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.myorders:
                Intent intent;
                startActivity(new Intent(activity_food_menu.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

