package com.example.foodapp;


import android.content.Intent;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityFoodMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger, "Burger", "75", "Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "135", "Just Cheese and tomato"));
        list.add(new MainModel(R.drawable.sandwich, "Sandwich", "72", "Delicious sandwiches made with mix vegetables"));
        list.add(new MainModel(R.drawable.fries, "Fries", "89", "Masala French and Spicy Fries"));
        list.add(new MainModel(R.drawable.vadapav, "Vadapav", "45", "tomato,capsicum,onion with cheese "));
        list.add(new MainModel(R.drawable.pasta, "Pasta", "160", "Semolina pasta with which is rich in protein"));
        list.add(new MainModel(R.drawable.paneer, "Paneer", "150", "Paneer tikka masala with butter"));
        list.add(new MainModel(R.drawable.samosa, "Samosa", "25", "Aloo mutter Samosa with Ragda "));

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
                startActivity(new Intent(activity_food_menu.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

