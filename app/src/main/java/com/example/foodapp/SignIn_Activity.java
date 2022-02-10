package com.example.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn_Activity extends AppCompatActivity {
        TextView textView,fb,google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        getSupportActionBar().setTitle("Sign In");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = (TextView) findViewById(R.id.textViewlogin);
        fb= (TextView) findViewById(R.id.tvfb);
        google = (TextView) findViewById(R.id.tvgoogle);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Create Account", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),SignUp_Activity.class);
                startActivity(i);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://m.facebook.com/home.php?_rdr"));
                startActivity(i);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://myaccount.google.com/?utm_source=sign_in_no_continue&pli=1&nlr=1"));
                startActivity(i);
            }
        });
    }
}