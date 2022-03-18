package com.example;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
        ActivityDetailBinding binding;
        ImageView plus,minus;
        int total,price;
        int count=1;


    public  void increment(View v) {
        count++;
        binding.quantity.setText("" + count);

        int pr = Integer.parseInt(getIntent().getStringExtra("price"));
        total = pr;
        price = pr;
        total = pr * count;
        binding.pricedet.setText(String.format("%d", total));
    }
    public  void descrement (View v){
        if (count <=1) {
            count =1;

        }
        else {
            count--;
            binding.quantity.setText("" + count);


            int pr = Integer.parseInt(getIntent().getStringExtra("price"));
             price = pr;
             total=pr;
            total = pr - price;
            binding.pricedet.setText(String.format("%d", total));
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Order Detail");

        plus = (ImageView) findViewById(R.id.add);
        minus = (ImageView) findViewById(R.id.minus);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);






        @SuppressLint("WrongConstant") SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);
        final String str = sh.getString("userid", "");
     //   Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

         binding =ActivityDetailBinding.inflate(getLayoutInflater());


            setContentView(binding.getRoot());

              final int image = getIntent().getIntExtra("image", 0);
               int pr = Integer.parseInt(getIntent().getStringExtra("price"));
              final String name = getIntent().getStringExtra("name");
              final String description = getIntent().getStringExtra("description");
              final  String proid = getIntent().getStringExtra("pid");




                binding.detailimagee.setImageResource(image);
                binding.pricedet.setText(String.format("%d", pr));
                binding.namelbl.setText(name);
                binding.descriptilbl.setText(description);
                binding.proId.setText(proid);




                DBHelper helper = new DBHelper(this);
                binding.orderButton.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        if(binding.NameBox.length()==0) {
                            Toast.makeText(getApplicationContext(), "Please Fill Values", Toast.LENGTH_SHORT).show();
                        }
                        else if (!binding.phoneBox.getText().toString().matches("[0-9]{10}")) {
                            binding.phoneBox.setError("Enter Only 10 Digit Mobile Number");
                        }
                        else if(!binding.NameBox.getText().toString().matches("[a-z,A-Z]*")) {
                            binding.NameBox.setError("Enter Only Character");
                        }
                        else {
                            //Make Validation
                            boolean isInserted = helper.insertOrder(binding.NameBox.getText().toString(),
                                    Integer.parseInt(proid),str,
                                    binding.phoneBox.getText().toString(),
                                    Integer.parseInt(binding.pricedet.getText().toString()),
                                    image,
                                    name,
                                    description,
                                    Integer.parseInt(binding.quantity.getText().toString())

                            );

                            if (isInserted) {
                                Toast.makeText(DetailActivity.this, "Order Success", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(getIntent());
                            }
                            else
                                Toast.makeText(DetailActivity.this, "Sorry Order Incorrect", Toast.LENGTH_SHORT).show();
                        }

                     }
                });

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}