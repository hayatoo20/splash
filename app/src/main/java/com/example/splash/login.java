
/// after splash activity this login activity will be display....
package com.example.splash;
///.....

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

///...
public class login extends AppCompatActivity {
///...
EditText mobileoremai, pass___word;
///...
Button loggginn, submituserdetails;
private dddbhelper db;///...
///....
@Override
///....
protected void onCreate(Bundle savedInstanceState) {
///...
    super.onCreate(savedInstanceState);///...
////...
    setContentView(R.layout.activity_login);///...

    db = new dddbhelper(this);
///....find the view for ech view
//1..

    mobileoremai = (EditText) findViewById(R.id.e1);
///2
    pass___word = (EditText) findViewById(R.id.e2);

    loggginn = (Button) findViewById(R.id.u1);
////4
    submituserdetails = (Button) findViewById(R.id.u2);////4

///create login action code.eee..
///...
///..
///...
    loggginn.setOnClickListener(v -> {
        String gssemail = mobileoremai.getText().toString();
        String pass_w = pass___word.getText().toString();
        String Hayat=mobileoremai.getText().toString();

        if (gssemail.isEmpty() || pass_w.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Fill all Details ", Toast.LENGTH_LONG).show();
        } else if (db.validateUser(gssemail, pass_w)) {
            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
            Intent hayat = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(hayat);

        } else {

            Toast.makeText(getApplicationContext(), "Incorrect username or Password", Toast.LENGTH_LONG).show();
        }

    });
    submituserdetails.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent hayat=new Intent(login.this,Registeration.class);
            startActivity(hayat);
        }
    });

}}