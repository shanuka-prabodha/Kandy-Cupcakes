package com.example.vehicalrental;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class searchdetails extends ArrayAdapter<paymentHelper> {


    private Activity context;
    private List<paymentHelper> paymentHelperList;;


    public searchdetails(Activity context,List<paymentHelper>paymentHelperList){

        super(context,R.layout.search_list,paymentHelperList);
        this.context = context;
        this.paymentHelperList = paymentHelperList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewpayment = inflater.inflate(R.layout.search_list, null, true);
        TextView nic = (TextView) listviewpayment.findViewById(R.id.txtNic);
        TextView date = (TextView) listviewpayment.findViewById(R.id.txtdate);
        TextView amount = (TextView) listviewpayment.findViewById(R.id.txtamount);
        EditText state = (EditText) listviewpayment.findViewById(R.id.txtpaysate);




        paymentHelper pay = paymentHelperList.get(position);
        int p = pay.getTotalamount();
        String am = String.valueOf(p);


        nic.setText(pay.getNIC());
        date.setText(pay.getDate());
        amount.setText(am);
        state.setText(pay.getPaiedState());


        return listviewpayment;



    }

}
