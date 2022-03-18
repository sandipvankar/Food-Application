package com.example;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.foodapp.Adapters.OrdersAdapter;
import com.example.foodapp.Models.OrderModel;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
        ActivityOrderBinding binding;
        SQLiteDatabase db;
        DBHelper DB ;
        SwipeRefreshLayout refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Orders List");

        refresh = (SwipeRefreshLayout) findViewById(R.id.refreshlayout);


        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB = new DBHelper(this);
        @SuppressLint("WrongConstant") SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);
        final String str = sh.getString("userid", "");


        Boolean checkuser = DB.checkusername(str);
        if(checkuser == true)
        {

           // Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

            ArrayList<OrderModel> list= DB.getOrder(str);
            OrdersAdapter adapter= new OrdersAdapter(list,this);
            binding.orderRecyclerView.setAdapter(adapter);


            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            binding.orderRecyclerView.setLayoutManager(layoutManager);

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please First Login and after Show your Orders", Toast.LENGTH_SHORT).show();
        }

//    try {
//        //swipeRefresh
//        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//                refresh.setRefreshing(false);
//            }
//        });
//        refresh.setColorSchemeColors(Color.CYAN);
//    } catch (Exception e) {}

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
