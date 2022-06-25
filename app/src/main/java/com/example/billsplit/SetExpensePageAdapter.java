package com.example.billsplit;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SetExpensePageAdapter extends ArrayAdapter<Bills> {

    private final Context mContext;
    private final ArrayList<Bills> bills;
    private int mResource;
    //public String memName = new String();

    public SetExpensePageAdapter(expensesFragment expensesFragment, int add_expense_list, ArrayList<Bills> billsList) {
        super(expensesFragment.getContext(), add_expense_list, billsList);
        mContext = expensesFragment.getContext();
        mResource = add_expense_list;
        this.bills = billsList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = bills.get(position).getbName();
        int amount = bills.get(position).getbAmount();
        Bills b = new Bills(name,amount);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.add_expense_list,null);

        TextView bName = convertView.findViewById(R.id.billName);
        TextView bAmount = convertView.findViewById(R.id.billValue);

        bName.setText(name);
        bAmount.setText(new String(String.valueOf(amount)));

        return convertView;
    }
}

















