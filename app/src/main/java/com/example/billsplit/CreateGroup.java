package com.example.billsplit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class CreateGroup extends AppCompatActivity {

    ListView listView;

    ArrayList<String> members = new ArrayList<String>();

    EditText member_name;
    Button add_mem_btn;
    ImageButton del_mem_btn,save_btn;
    EditText grp_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        member_name = findViewById(R.id.input_member_name);
        add_mem_btn = findViewById(R.id.add_new_mem_btn);
        del_mem_btn = findViewById(R.id.mem_del_btn);
        save_btn = findViewById(R.id.right_icon_save);
        grp_name = findViewById(R.id.input_grp_name);

        listView = findViewById(R.id.add_member_list);

        AddMemberAdapter adapter = new AddMemberAdapter(this, members);

        listView.setAdapter(adapter);

        add_mem_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String temp_name = member_name.getText().toString();
                if(temp_name.length() == 0){
                    Toast.makeText(getApplicationContext(), "Need to enter member's name", Toast.LENGTH_SHORT).show();
                }else{
                    members.add(temp_name);
                    member_name.setText("");
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "New Member Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uri = "https://billsplit-backend.herokuapp.com/";

                try {
                    URL url = new URL(uri);
                    HttpURLConnection client = (HttpURLConnection) url.openConnection();

                    client.setRequestMethod("POST");
                    client.setRequestProperty("grp_name",grp_name.getText().toString());
                    client.setRequestProperty("members_list", listView.toString());
                    client.setDoOutput(true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}