package com.example.billsplit;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SetExpensePageAdapter extends ArrayAdapter<Bills> {

    private Context mContext;
    private ArrayList<Bills> list;
    private int mResource;
    public SetExpensePageAdapter(@NonNull expensesFragment context, int resource, @NonNull ArrayList<Bills> objects) {
        super(context.getContext(), resource, objects);
        this.mContext = context.getContext();
        this.list = objects;
        this.mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//       String billname = getItem(position).getbName();
        String billname = list.get(position).getbName();
       int billamount = getItem(position).getbAmount();:

       Bills bills = new Bills(billname,billamount);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView bName = (TextView) convertView.findViewById(R.id.billName);
        TextView bValue = (TextView) convertView.findViewById(R.id.billValue);

        bName.setText(billname);
        bValue.setText(billamount);

        return convertView;

    }
}















