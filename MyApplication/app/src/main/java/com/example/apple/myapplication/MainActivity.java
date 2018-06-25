package com.example.apple.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_one = (Button)findViewById(R.id.button_one);
        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,one.class);
                startActivity(intent);

            }
        });


        Button bt_two = (Button)findViewById(R.id.button_two);
        bt_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,two.class);
                startActivity(intent);
            }
        });

        Button bt_three = (Button)findViewById(R.id.button_three);
        bt_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,three.class);
                startActivity(intent);

            }
        });


        Button bt_four = (Button)findViewById(R.id.button_four);
        bt_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,four.class);
                startActivity(intent);
            }
        });



        Button bt_five = (Button)findViewById(R.id.button_five);
        bt_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,five.class);
                startActivity(intent);

            }
        });
    }
}
