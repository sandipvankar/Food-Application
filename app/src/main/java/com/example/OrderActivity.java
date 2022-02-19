package com.example;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodapp.Adapters.OrdersAdapter;
import com.example.foodapp.Models.OrderModel;
import com.example.foodapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
        ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Orders List");

        // calling the action bar
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper=new DBHelper(this);
        ArrayList<OrderModel> list= helper.getOrder();


        OrdersAdapter adapter= new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
    // this event will enable the back
        public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
        }
}