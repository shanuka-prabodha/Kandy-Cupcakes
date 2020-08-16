package com.cupcakes.viewlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateVehical extends AppCompatActivity {

    ImageView mainimageview;
    TextView title,description;
    EditText edt1,edt2,edt3,edt4;

    String data1,data2,data3,data4;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vehical);

        mainimageview = findViewById(R.id.mainimageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        edt1=findViewById(R.id.et1);
        edt2=findViewById(R.id.et2);
        edt3=findViewById(R.id.et3);
        edt4=findViewById(R.id.et4);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2")  && getIntent().hasExtra("data3")&& getIntent().hasExtra("data4") ){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");
            myImage = getIntent().getIntExtra("myImage",1);

        }
        else
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
    }

    private void setData(){

        //title.setText(data1);
       // description.setText(data2);
        mainimageview.setImageResource(myImage);

        edt1.setText(data1);
        edt2.setText(data2);
        edt3.setText(data3);
        edt4.setText(data4);

    }
}