package com.example.apple.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class userdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);


        int imageId = getIntent().getIntExtra("user_image",0);
        String desc = getIntent().getStringExtra("user_desc");

        ImageView imageView = (ImageView)findViewById(R.id.user_large_image);
        TextView textView = (TextView)findViewById(R.id.user_desc_text);

        imageView.setImageResource(imageId);
        textView.setText(desc);


    }
}
