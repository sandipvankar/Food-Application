package com.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
        ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    try{
        int image = getIntent().getIntExtra("image", 0);
        int pr = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");

        binding.detailimagee.setImageResource(image);
        binding.pricedet.setText(String.format("%d", pr));
        binding.namelbl.setText(name);
        binding.descriptilbl.setText(description);

         }
    catch(Exception e)
        {
        }


    }
}