package com.example.billsplit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class overviewFragment extends Fragment {

    View view;
    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_overview, container, false);
        return view;
//        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listview = view.findViewById(R.id.overview_listview);

        PersonAmount pa1 = new PersonAmount("Soumya", 900);
        PersonAmount pa2 = new PersonAmount("mava", 1450);
        PersonAmount pa3 = new PersonAmount("potol", 870);

        //Adding person in a Arraylist
        ArrayList<PersonAmount> pAmountList = new ArrayList<>();
        pAmountList.add(pa1);
        pAmountList.add(pa2);
        pAmountList.add(pa3);


        SetOverviewPageAdapter adapter = new SetOverviewPageAdapter(this, R.layout.add_overview_list, pAmountList);
        listview.setAdapter(adapter);
    }
}