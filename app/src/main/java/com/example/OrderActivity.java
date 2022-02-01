package com.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodapp.Adapters.OrdersAdapter;
import com.example.foodapp.Models.OrderModel;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
        ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrderModel> list=new ArrayList<>();
        list.add(new OrderModel(R.drawable.burger,"Burger", "75", "15534"));
        list.add(new OrderModel(R.drawable.pizza,"Pizza", "135", "3541"));
        list.add(new OrderModel(R.drawable.paneer,"Paneer", "150", "55234"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa", "25", "34626"));

        OrdersAdapter adapter= new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
}