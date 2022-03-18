package com.example.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DBHelper;

public class SignIn_Activity extends AppCompatActivity {
        TextView textView,fb,google,username,password,us;
        Button login;
        DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



        getSupportActionBar().setTitle("Sign In");

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.textView7);
        fb= (TextView) findViewById(R.id.tvfb);
        google = (TextView) findViewById(R.id.tvgoogle);
        username = (TextView) findViewById(R.id.username2);
        password = (TextView) findViewById(R.id.Password2);
        login = (Button) findViewById(R.id.btnlogin1);

        DB= new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "All Field Required!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean  checkuserpass = DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                    //      Toast.makeText(getApplicationContext(), "Username=" + user, Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent(getApplicationContext(), activity_food_menu.class);
                           //pass username

                             intent.putExtra("uid", user);
                             startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
             }
        });
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}