////
///
package com.example.splash;
///

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class orderpage extends AppCompatActivity {
    EditText nam_ha, contact_ha, order_type1, order_Type2;
    TextView price_of_order;
    Button add_ha, update_ha, delete_ha, CLEAR_, BACK_TO;
    ///////
    dddbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderpage);
        nam_ha = (EditText) findViewById(R.id.name_);
        contact_ha = (EditText) findViewById(R.id.contact_);
        order_type1 = (EditText) findViewById(R.id.order1);
        order_Type2 = (EditText) findViewById(R.id.order2);
        price_of_order = (TextView) findViewById(R.id.Total);
        add_ha = (Button) findViewById(R.id.add_order);
        update_ha = (Button) findViewById(R.id.update_order);
        delete_ha = (Button) findViewById(R.id.delete_order);
        CLEAR_ = (Button) findViewById(R.id.clear_r);
        BACK_TO = (Button) findViewById(R.id.Back);
////
        db = new dddbhelper(this);
/////Add total price
        add_ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = nam_ha.getText().toString();
                int contact = Integer.parseInt(contact_ha.getText().toString());
                int order_1 = Integer.parseInt(order_type1.getText().toString());
                int order_2 = Integer.parseInt(order_Type2.getText().toString());
                int totalOrder1 = order_1 * 1;
                int totalOrder2 = order_2 * 15;
                int totalPrice = totalOrder1 + totalOrder2;

                boolean success = db.insertOrderData(nama, contact, order_1, order_2, totalPrice);
                if (success) {
                    price_of_order.setText(String.valueOf(totalPrice)); // Update TextView with the calculated value
                    Toast.makeText(orderpage.this, "Data is Successfully Added ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(orderpage.this, "Data is Not Successfully Added", Toast.LENGTH_LONG).show();
                }
            }
        });
        delete_ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dddbhelper dbHelper = new dddbhelper(orderpage.this); // Instantiate your helper
                boolean isDeleted = dbHelper.deleteOrderDetails(Integer.parseInt(contact_ha.getText().toString()));

                if (isDeleted) {
                    Toast.makeText(orderpage.this, "Data is Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(orderpage.this, "Data is not Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });

        update_ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nam_ha.getText().toString();
                int contact = Integer.parseInt(contact_ha.getText().toString());
                int order_1 = Integer.parseInt(order_type1.getText().toString());
                int order_2 = Integer.parseInt(order_Type2.getText().toString());

                int total = order_1 * 1 + order_2 * 15; // Calculate total based on your logic

                dddbhelper dbHelper = new dddbhelper(orderpage.this); // Instantiate your helper
                boolean isUpdated = dbHelper.updateOrderDetails(contact, name, order_1, order_2, total);

                if (isUpdated) {
                    Toast.makeText(orderpage.this, "Data is Successfully Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(orderpage.this, "Data is Not Unsuccessfully Updated", Toast.LENGTH_LONG).show();
                }
            }
        });
        CLEAR_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllFields();
            }

            private void clearAllFields() {
                nam_ha.getText().clear();
                contact_ha.getText().clear();
                order_type1.getText().clear();
                order_Type2.getText().clear();

            }
        });

        BACK_TO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hayat = new Intent(getApplication(), HomeActivity.class);
                startActivity(hayat);
            }
        });
    }
}

