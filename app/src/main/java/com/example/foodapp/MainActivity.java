package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button login, signup;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        
        login = (Button) findViewById(R.id.btnlogin);
        signup= (Button) findViewById(R.id.btn2signup);

        
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(MainActivity.this, "Login has been Clicked", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this ,SignIn_Activity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this ,SignUp_Activity.class);
                startActivity(intent);
            }
        });


    }
}