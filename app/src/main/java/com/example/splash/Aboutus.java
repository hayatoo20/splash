///package Name..
package com.example.splash;
///....
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;////..
/////Name of class about us
public class Aboutus extends AppCompatActivity {
Button hayattt;////Variable Name
@Override///...
///
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);///...
setContentView(R.layout.activity_aboutus);
//set of button
hayattt=(Button) findViewById(R.id.about_us);///..
hayattt.setOnClickListener(new View.OnClickListener() {
@Override///....
public void onClick(View v) {
////Name of object is hayat... this code is to go back to home after
/// show this current page
Intent hayat=new Intent(getApplication(),HomeActivity.class);///...
startActivity(hayat);////...//
}///..//
});///...//
}///...//
}///...//

