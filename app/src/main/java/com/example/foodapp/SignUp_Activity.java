package com.example.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp_Activity extends AppCompatActivity {
    Button register;
    TextView textView,fb,google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Sign Up");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        register= (Button) findViewById(R.id.btnregister);
        textView= (TextView) findViewById(R.id.textViewlogin);
        fb = (TextView) findViewById(R.id.tvfb);
        google = (TextView) findViewById(R.id.tvgoogle);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignIn_Activity.class);
                startActivity(intent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignIn_Activity.class);
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