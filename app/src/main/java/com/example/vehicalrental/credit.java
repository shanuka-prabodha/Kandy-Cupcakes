package com.example.vehicalrental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class credit extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private static final Pattern credi_number = Pattern.compile("^[0-9]{6}");
    private static final Pattern cvv_number = Pattern.compile("^[0-9]{4}");

    long maxid =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        Intent i = getIntent();
        final String Nic =i.getStringExtra("NIC");
        final String date =i.getStringExtra("date");
        final String amout = i.getStringExtra("amount");
        final String vehicle = i.getStringExtra("vehicle");

        TextView nic =  findViewById(R.id.txtNIC);
        TextView day =findViewById(R.id.txtdate);
        TextView tot = findViewById(R.id.txtTotalamount);
        TextView vehi = findViewById(R.id.Vehicleid);


        nic.setText(Nic);
        day.setText(date);
        tot.setText(amout);
        vehi.setText(vehicle);

        final int a = Integer.parseInt(amout);


        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("Payment");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid =(long)dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

        Button pay = findViewById(R.id.btnpay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final   EditText credinum = findViewById(R.id.editcredinum);
                final String cre =  credinum.getText().toString();

                final EditText Cvv = findViewById(R.id.Evcc);
                final String cvv =  Cvv.getText().toString();

                if(TextUtils.isEmpty(cre)){
                    credinum.setError("Credit card number is  Required");
                    return;
                } else if (!credi_number.matcher(cre).matches()){
                    credinum.setError("credit card number should be 6 digits number ");
                    return;
                }

                if(TextUtils.isEmpty(cvv)){
                   Cvv.setError("CVV number is Required");
                    return;
                } else if (!cvv_number.matcher(cvv).matches()){
                    Cvv.setError("CVV number should be 4 digits number ");
                    return;
                }






                paymentHelper helper = new paymentHelper(String.valueOf(maxid+1),Nic,date,a,"Paid","Card Payment");

                reference.child(String.valueOf(maxid+1)).setValue(helper);

                Toast.makeText(credit.this,"Payment added succesfully",Toast.LENGTH_LONG).show();

                Intent i =new Intent(credit.this,MainActivity.class);
                startActivity(i);

            }
        });


    }
}