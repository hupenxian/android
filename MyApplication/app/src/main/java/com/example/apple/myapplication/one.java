package com.example.apple.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        final int tmp = (int)(Math.random()*1000);
        Log.i("tag","-----one----");

        Button bt_guess = (Button)findViewById(R.id.button_guess);
        bt_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.text_guess);
                int c = Integer.parseInt(editText.getText().toString());

                TextView tv = (TextView)findViewById(R.id.test);

                if (c==tmp){
                    tv.setText("bingo");
                }else if (c<tmp){
                    tv.setText("too small");
                }else
                    tv.setText("too big");


            }
        });


    }
}
