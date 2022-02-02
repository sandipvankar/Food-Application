package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        DBHelper helper = new DBHelper(this);

        binding.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean isInserted  =  helper.insertOrder(binding.namelbl.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        pr,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())

                );
              if(isInserted)
                  Toast.makeText(DetailActivity.this, "Order Success", Toast.LENGTH_SHORT).show();
              else
                  Toast.makeText(DetailActivity.this, "Sorry Order Incorrect", Toast.LENGTH_SHORT).show();
            }
        });
         }
    catch(Exception e)
        {
        }


    }
}