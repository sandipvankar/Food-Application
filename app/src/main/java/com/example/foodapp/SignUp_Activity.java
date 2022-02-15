package com.example.foodapp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.DBHelper;

public class SignUp_Activity extends AppCompatActivity {
    Button register;
    TextView textView,fb,google ,name,mob,email,pass ;
    Image image;

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Sign Up");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        name= (TextView) findViewById(R.id.personName);
        mob= (TextView) findViewById(R.id.editTextPhone);
        email= (TextView) findViewById(R.id.username2);
        pass= (TextView) findViewById(R.id.Password2);

        register= (Button) findViewById(R.id.btnlogin1);
        textView= (TextView) findViewById(R.id.textView7);
        fb = (TextView) findViewById(R.id.tvfb);
        google = (TextView) findViewById(R.id.tvgoogle);
        DB= new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm= name.getText().toString();
                int mo=Integer.parseInt( mob.getText().toString());
                String em= email.getText().toString();
                String ps= pass.getText().toString();


                if(email.length()==0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    email.setError("Please Enter Valid E-Mail");
                }
                else if (!mob.getText().toString().matches("[0-9]{10}")) {
                    mob.setError("Enter Only 10 Digit Mobile Number");
                }
                else if(!name.getText().toString().matches("[a-z,A-Z]*")) {
                    name.setError("Enter Only Character");
                }
                 else if (pass.length()<6) {
                    pass.setError("Please Enter Password Minimum in 6 Character");
                }
                else {

                    Boolean checkuser = DB.checkusername(nm);
                    if(checkuser==false){
                        Boolean insert= DB.insertUserData(nm,mo,em,ps);

                        if(insert==true) {
                            Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),SignIn_Activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "User Already Exists!!", Toast.LENGTH_SHORT).show();
                    }

                }

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