package com.example.billsplit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AddMemberAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> members;
    public String memName = new String();

    public AddMemberAdapter(Activity context, ArrayList<String> members){
        super(context, R.layout.add_mem_list, members);

        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.add_mem_list, null,true);

        TextView name = rowView.findViewById(R.id.Name);
        ImageButton delete_mem_btn;

        name.setText(members.get(position));
        delete_mem_btn = rowView.findViewById(R.id.mem_del_btn);
        memName = members.get(position);

        delete_mem_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, members.get(position) + " removed", Toast.LENGTH_SHORT).show();
                members.remove(members.get(position));
                notifyDataSetChanged();
            }
        });

        return rowView;
    }
}
