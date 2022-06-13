package com.example.billsplit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class expensesFragment extends Fragment {

    View view;
    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_expenses, container, false);
        return view;
        //return inflater.inflate(R.layout.fragment_expenses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listview = view.findViewById(R.id.expenses_listview);

        //Creating Bills objects --- Temporary
        Bills b1 = new Bills("Kashmir", 5000);
        Bills b2 = new Bills("Gangtok", 7000);
        Bills b3 = new Bills("Ladakh", 3450);
        Bills b4 = new Bills("Sandakphu", 3995);
        Bills b5 = new Bills("Manali", 6580);

        //Adding bills in a Arraylist
        ArrayList<Bills> billsList = new ArrayList<>();
        billsList.add(b1);
        billsList.add(b2);
        billsList.add(b3);
        billsList.add(b4);
        billsList.add(b5);

//        System.out.println("6546546464646464646464\n");
//        Log.e("abcde464654",billsList.toString());
//        System.out.println("6546546464646464646464");

        SetExpensePageAdapter adapter = new SetExpensePageAdapter(this, R.layout.add_expense_list, billsList);
        listview.setAdapter(adapter);
    }
}