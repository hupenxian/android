package com.example.apple.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        userAdapter userAdapter = new userAdapter(this, R.layout.user_item, friendsr_user.getAllUsers());
        ListView listView = (ListView) findViewById(R.id.user_listView);

        listView.setAdapter(userAdapter);


        
    }
}
