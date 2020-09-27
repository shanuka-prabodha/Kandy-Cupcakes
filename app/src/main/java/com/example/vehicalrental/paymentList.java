package com.example.vehicalrental;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class paymentList extends ArrayAdapter<paymentHelper> {

    private Activity  context;
    private List<paymentHelper> paymentHelperList;

    public paymentList(Activity context,List<paymentHelper>paymentHelperList){

        super(context,R.layout.list_payment,paymentHelperList);
        this.context = context;
        this.paymentHelperList = paymentHelperList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,ViewGroup parent) {
      LayoutInflater inflater = context.getLayoutInflater();
      View listviewpayment = inflater.inflate(R.layout.list_payment,null,true);
        TextView nic = (TextView)listviewpayment.findViewById(R.id.txtNic);
        TextView date = (TextView)listviewpayment.findViewById(R.id.txtdate);
        TextView amount = (TextView)listviewpayment.findViewById(R.id.txtamount);
        TextView state = (TextView)listviewpayment.findViewById(R.id.txtpaysate);
        TextView method = (TextView)listviewpayment.findViewById(R.id.txtpaymethod);

        paymentHelper pay = paymentHelperList.get(position);
        int p =pay.getTotalamount();
        String am =String.valueOf(p);


        nic.setText(pay.getNIC());
        date.setText(pay.getDate());
        amount.setText(am);
        state.setText(pay.getPaiedState());
        method.setText(pay.getPaymenttype());

        return listviewpayment;
    }
}
