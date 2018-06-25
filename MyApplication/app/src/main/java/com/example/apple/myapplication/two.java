package com.example.apple.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class two extends AppCompatActivity {

    public int cnt=0;
    int[] a = new int[12];



    public void check(){

        TextView two_result = (TextView)findViewById(R.id.two_result);

        if ((a[1]+a[2]+a[3])==3||(a[4]+a[5]+a[6])==3||(a[7]+a[8]+a[9])==3||(a[1]+a[4]+a[7])==3||(a[2]+a[5]+a[8])==3||(a[3]+a[6]+a[9]==3)){
            two_result.setText("X WIN");
        }else if ((a[1]+a[5]+a[9])==3||(a[3]+a[5]+a[7])==3){
            two_result.setText("X WIN");
        }else if ((a[1]+a[2]+a[3])==30||(a[4]+a[5]+a[6])==30||(a[7]+a[8]+a[9])==30||(a[1]+a[4]+a[7])==30||(a[2]+a[5]+a[8])==30||(a[3]+a[6]+a[9]==30)){
            two_result.setText("O WIN");
        }else if ((a[1]+a[5]+a[9])==30||(a[3]+a[5]+a[7])==30){
            two_result.setText("O WIN");
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        final Button bt_two_1 = (Button)findViewById(R.id.two_1);
        final Button bt_two_2 = (Button)findViewById(R.id.two_2);
        final Button bt_two_3 = (Button)findViewById(R.id.two_3);
        final Button bt_two_4 = (Button)findViewById(R.id.two_4);
        final Button bt_two_5 = (Button)findViewById(R.id.two_5);
        final Button bt_two_6 = (Button)findViewById(R.id.two_6);
        final Button bt_two_7 = (Button)findViewById(R.id.two_7);
        final Button bt_two_8 = (Button)findViewById(R.id.two_8);
        final Button bt_two_9 = (Button)findViewById(R.id.two_9);
        final TextView tx = (TextView)findViewById(R.id.two_result) ;



        Button bt_two_reset = (Button)findViewById(R.id.button_two_reset);
        bt_two_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bt_two_1.setText("");
                bt_two_2.setText("");
                bt_two_3.setText("");
                bt_two_4.setText("");
                bt_two_5.setText("");
                bt_two_6.setText("");
                bt_two_7.setText("");
                bt_two_8.setText("");
                bt_two_9.setText("");
                cnt=0;
                tx.setText("");
                for (int i=1;i<10;i++)
                    a[i]=0;

            }
        });


        bt_two_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_1.setText("X");
                    a[1]=1;
                }else{
                    bt_two_1.setText("O");
                    a[1]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_2.setText("X");
                    a[2]=1;
                }else{
                    bt_two_2.setText("O");
                    a[2]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_3.setText("X");
                    a[3]=1;
                }else{
                    bt_two_3.setText("O");
                    a[3]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_4.setText("X");
                    a[4]=1;
                }else{
                    bt_two_4.setText("O");
                    a[4]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_5.setText("X");
                    a[5]=1;
                }else{
                    bt_two_5.setText("O");
                    a[5]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_6.setText("X");
                    a[6]=1;
                }else{
                    bt_two_6.setText("O");
                    a[6]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_7.setText("X");
                    a[7]=1;
                }else{
                    bt_two_7.setText("O");
                    a[7]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_8.setText("X");
                    a[8]=1;
                }else{
                    bt_two_8.setText("O");
                    a[8]=10;
                }
                check();
                cnt = cnt+1;

            }
        });
        bt_two_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt%2==0){
                    bt_two_9.setText("X");
                    a[9]=1;
                }else{
                    bt_two_9.setText("O");
                    a[9]=10;
                }
                check();
                cnt = cnt+1;

            }
        });




    }
}
