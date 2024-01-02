///Name of package is splash
package com.example.splash;/////
///....
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
///Name of the_Activity is Registeration
public class Registeration extends AppCompatActivity {
 ///Variables for_EditText
 EditText userName, password, confirmPassword;///...
 ///Variables for_Button...
 Button submitDetails, backToLogin;///...
 dddbhelper db;///Name of the database to connect or store user details
 ///...
 @SuppressLint("MissingInflatedId")///....
/////...
 @Override///...
////to declare variables or attributes
 protected void onCreate(Bundle savedInstanceState) {
///...
  super.onCreate(savedInstanceState);///...
///
  setContentView(R.layout.activity_registeration);///...
///first value...1
  userName = findViewById(R.id.e1);//use_r..._name
///second_ value...2
  password = findViewById(R.id.e2);//pass..._word..
///third value...3
  confirmPassword = findViewById(R.id.e3);//con...firm.P.
///fourth value...4_
  submitDetails = findViewById(R.id.b_1);//SUB...UserD..
///fifth value...5_
  backToLogin = findViewById(R.id.b_2);//BACK...LOG..
  db = new dddbhelper(this);///Call DB_Hel_per
  submitDetails.setOnClickListener(v -> {
///Code to set on registeration user Details..
   String username = userName.getText().toString();///g_t_user__name
///...
   String pass = password.getText().toString();///g_t_pass__w
///...
   String confirm = confirmPassword.getText().toString();///con_pass__w
////if condition (to check and fill fieald rows user details)...
   if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm)) {
////,...Masseage if the one or all of rows are empty...
Toast.makeText(Registeration.this,
"Please Fill all Details", Toast.LENGTH_SHORT).show();///...
} else {
if (pass.equals(confirm)) {
///Codes to check if user name is not found in database before for new user
boolean userExists = db.To_check_username_andpassword(username, pass);///to check
/// if it not found before and ok
if (!userExists) {
///user N_m and password will be inserted in database
boolean regResult = db.insertUserData(username, pass);///...
///the result will show with below message...
if (regResult) {
Toast.makeText(Registeration.this,
 "Registration is Successful", Toast.LENGTH_SHORT).show();///No Error in data and
///stored in databas
} else {
Toast.makeText(Registeration.this,
"Registration is not Successful", Toast.LENGTH_SHORT).show();///there
// is un error
}///...
} else {
///the user detailes is stored before in database
Toast.makeText(Registeration.this, //...
"This User Already Exists, Go to Sign In",
Toast.LENGTH_SHORT).show();///to show message
}////...
 } else {
///IF user name not match to password
Toast.makeText(Registeration.this,
"Passwords do not match", Toast.LENGTH_SHORT).show();///show this message
}///...
}///....
});/////
//Codes to set on back to_login page
backToLogin.setOnClickListener(v -> {
///after register page it will allow user to go baack to login page
Intent hayat=new Intent(getApplication(),login.class);///name of the object (hayat)
startActivity(hayat);///to start with current page
});///...
}///...
}///...


