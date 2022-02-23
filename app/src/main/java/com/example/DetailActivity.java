package com.example;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
        ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Order Detail");

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

         binding =ActivityDetailBinding.inflate(getLayoutInflater());


            setContentView(binding.getRoot());

              final int image = getIntent().getIntExtra("image", 0);
              final int pr = Integer.parseInt(getIntent().getStringExtra("price"));
              final String name = getIntent().getStringExtra("name");
              final String description = getIntent().getStringExtra("description");

                binding.detailimagee.setImageResource(image);
                binding.pricedet.setText(String.format("%d", pr));
                binding.namelbl.setText(name);
                binding.descriptilbl.setText(description);

                DBHelper helper = new DBHelper(this);
                binding.orderButton.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        if(binding.NameBox.length()==0) {
                            Toast.makeText(getApplicationContext(), "Please Fill Values", Toast.LENGTH_SHORT).show();
                        }


                        else {
                            //Make Validation
                            boolean isInserted = helper.insertOrder(binding.NameBox.getText().toString(),
                                    binding.phoneBox.getText().toString(),
                                    pr,
                                    image,
                                    name,
                                    description,
                                    Integer.parseInt(binding.quantity.getText().toString())

                            );

                            if (isInserted)
                                Toast.makeText(DetailActivity.this, "Order Success", Toast.LENGTH_SHORT).show();
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