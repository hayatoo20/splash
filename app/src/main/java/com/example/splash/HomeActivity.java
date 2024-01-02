package com.example.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    ImageView about_,orde__,contact__us;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
about_=(ImageView) findViewById(R.id.button1);
orde__=(ImageView) findViewById(R.id.button2);
 contact__us=(ImageView) findViewById(R.id.button3);

 about_.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent=new Intent(HomeActivity.this,Aboutus.class);
         startActivity(intent);
     }
 });
 orde__.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent=new Intent(HomeActivity.this,orderpage.class);
         startActivity(intent);
     }
 });
 contact__us.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent=new Intent(HomeActivity.this,contactus.class);
         startActivity(intent);
     }
 });


        }
    }