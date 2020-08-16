package com.cupcakes.viewlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[] , s2[],s3[],s4[];
    int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.f};
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        b1= findViewById(R.id.btnadd);

    s1 = getResources().getStringArray(R.array.BrandNames);
    s2 = getResources().getStringArray(R.array.Passengers);
    s3 = getResources().getStringArray(R.array.Transmission);
    s4 = getResources().getStringArray(R.array.price);



    MyAdapter myAdapter = new MyAdapter(this,s1,s2,s3,s4,images);
    recyclerView.setAdapter(myAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in= new Intent(MainActivity.this,AddVehical.class);
            startActivity(in);
        }
    });

    }
}