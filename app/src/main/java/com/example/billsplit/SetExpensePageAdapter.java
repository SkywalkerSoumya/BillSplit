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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SetExpensePageAdapter extends ArrayAdapter<Bills> {

    // -------------------------------------------------------------------------------------------------------
    // START CHANGES RELATED TO PR#8 => ADDING LISTVIEW IN THE EXPENSES FRAGMENT
    // -------------------------------------------------------------------------------------------------------

    private final Activity context;
    private final ArrayList<Bills> members;
    public String memName = new String();
    public String memValue = new String();

    public SetExpensePageAdapter(Activity context, ArrayList<Bills> members){
        super(context, R.layout.add_mem_list, members);
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.add_expense_list, null,true);

        TextView name = rowView.findViewById(R.id.billName);
        TextView value = rowView.findViewById(R.id.billValue);

        name.setText(members.get(position).getbName());
        value.setText(new String(String.valueOf(members.get(position).getbAmount())));

        return rowView;
    }

    // -------------------------------------------------------------------------------------------------------
    // END CHANGES RELATED TO PR#8 => ADDING LISTVIEW IN THE EXPENSES FRAGMENT
    // -------------------------------------------------------------------------------------------------------

}

















