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

public class SetOverviewPageAdapter extends ArrayAdapter<PersonAmount> {

    private final Context mContext;
    private final ArrayList<PersonAmount> personAmount;
    private int mResource;
    //public String memName = new String();

    public SetOverviewPageAdapter(overviewFragment overviewFragment, int add_overview_list, ArrayList<PersonAmount> pAmountList) {
        super(overviewFragment.getContext(), add_overview_list, pAmountList);
        mContext = overviewFragment.getContext();
        mResource = add_overview_list;
        this.personAmount = pAmountList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String personName = personAmount.get(position).getpName();
        int amount = personAmount.get(position).getpAmount();
        PersonAmount p = new PersonAmount(personName,amount);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.add_overview_list,null);

        TextView pName = convertView.findViewById(R.id.PersonName);
        TextView pAmount = convertView.findViewById(R.id.PersonAmount);

        pName.setText(personName);
        pAmount.setText(new String(String.valueOf(amount)));

        return convertView;
    }
}