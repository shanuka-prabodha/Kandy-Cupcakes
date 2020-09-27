package com.example.vehicalrental;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.cash);
        Button bt2 = findViewById(R.id.button2);
        Button bt3 = findViewById(R.id.pay);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nic = findViewById(R.id.txtNIC);
                EditText date = findViewById(R.id.txtdate);
                EditText tot = findViewById(R.id.txtTotalamount);
                EditText vehi =findViewById(R.id.Vehicleid);


                String Nic = nic.getText().toString();
                String da = date.getText().toString();
                String amount = tot.getText().toString();
                String vehicle = vehi.getText().toString();

                Intent i = new Intent(MainActivity.this,cash.class) ;

                i.putExtra("NIC",Nic);
                i.putExtra("date",da);
                i.putExtra("amount",amount);
                i.putExtra("vehicle",vehicle);
                startActivity(i);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nic = findViewById(R.id.txtNIC);
                EditText date = findViewById(R.id.txtdate);
                EditText tot = findViewById(R.id.txtTotalamount);
                EditText vehi =findViewById(R.id.Vehicleid);


                String Nic = nic.getText().toString();
                String da = date.getText().toString();
                String amount = tot.getText().toString();
                String vehicle = vehi.getText().toString();

                Intent i = new Intent(MainActivity.this,credit.class) ;
                i.putExtra("NIC",Nic);
                i.putExtra("date",da);
                i.putExtra("amount",amount);
                i.putExtra("vehicle",vehicle);
                startActivity(i);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,allpayment.class) ;

                startActivity(i);
            }
        });

    }
}