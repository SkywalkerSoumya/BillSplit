package com.example.billsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONObject;


public class CreateGroup extends AppCompatActivity {

    ArrayList<String> members = new ArrayList<String>();

    //Declaring UI elements
    ListView listView;
    EditText member_name, grp_name, loc;
    Button add_mem_btn;
    ImageButton del_mem_btn, save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        // Defining the UI elements
        member_name = findViewById(R.id.input_member_name);
        add_mem_btn = findViewById(R.id.add_new_mem_btn);
        del_mem_btn = findViewById(R.id.mem_del_btn);
        save_btn = findViewById(R.id.right_icon_save);
        loc = findViewById(R.id.input_location);
        listView = findViewById(R.id.add_member_list);
        grp_name = findViewById(R.id.input_grp_name);

        // Connecting listview with the adapter
        AddMemberAdapter adapter = new AddMemberAdapter(this, members);
        listView.setAdapter(adapter);

        // Onclick Event for the add_mem_btn
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
                    Toast.makeText(getApplicationContext(), "New Member", Toast.LENGTH_LONG).show();
                }
            }
        });

        // OnClick event for the save_btn.
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Using a new thread for the background api call.
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            URL url = new URL("https://billsplit-backend.herokuapp.com/test");

                            // Declaring the structure for the api call.
                            HttpURLConnection client = (HttpURLConnection) url.openConnection();
                            client.setRequestMethod("POST");
                            client.setRequestProperty("Content-type", "application/json; utf-8");
                            client.setRequestProperty("Accept", "application/json");

                            // Creating the body for the request
                            JSONObject body = new JSONObject();
                            body.put("id", grp_name.getText().toString());
                            body.put("name", loc.getText().toString());
                            String jsonInputString = body.toString();

                            // Connecting the body with the request.
                            client.setDoOutput(true);
                            OutputStream os = client.getOutputStream();
                            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                            os.write(input, 0, input.length);

                            System.out.println(client.getResponseMessage());

                        }catch( Exception e){
                            System.out.println(e);
                        }
                    }
                }).start();
            }
        });

    }

}