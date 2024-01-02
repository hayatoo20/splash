package com.example.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class orderone extends AppCompatActivity {

    Button hayattttt;////Variable Name
    @Override///...
///
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);///...
        setContentView(R.layout.activity_aboutus);
//set of button
        hayattttt=(Button) findViewById(R.id.about_us);///..
        hayattttt.setOnClickListener(new View.OnClickListener() {
            @Override///....
            public void onClick(View v) {
////Name of object is hayat... this code is to go back to home after
/// show this current page
                Intent hayat=new Intent(getApplication(),orderpage.class);///...
                startActivity(hayat);////...//
            }///..//
        });///...//
    }///...//
}///...//

