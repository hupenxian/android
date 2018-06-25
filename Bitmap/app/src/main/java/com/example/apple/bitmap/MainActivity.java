package com.example.apple.bitmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

import java.text.DecimalFormat;

/**
 * Created by Jay on 2015/10/15 0015.
 */

public class MainActivity extends Activity {


    //Digit classifier model (protobuff file)
    private static final String MODEL_FILE = "file:///android_asset/mnistNN.pb";
    private static final String TAG = "MainActivity";


    private static final String INPUT_NODE = "input/x-input";
    private static final String OUTPUT_NODE = "Output";
    private static final float[] DROPOUT = {1};
    private static final long[] INPUT_SIZE = {1,28*28};


    //Load tensorflow library
    static {System.loadLibrary("tensorflow_inference");}
    private TensorFlowInferenceInterface inferenceEngine;

    //Temp variable for confidence values of digit.
    private float[] outputs = new float[10];

    private Button bt_clear;
    private Button bt_save;
    private Button bt_predict;
    private TextView tv_result;

    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_clear = (Button)findViewById(R.id.bt_clear);
        bt_save = (Button)findViewById(R.id.bt_save);
        bt_predict = (Button)findViewById(R.id.bt_predict);
        tv_result = (TextView)findViewById(R.id.tv_result);
        tv_result.setText("请输入");


        inferenceEngine = new TensorFlowInferenceInterface(getAssets(), MODEL_FILE);


        myView = (MyView) findViewById(R.id.myview);


        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.reset();
                tv_result.setText("请输入");
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.save();
            }
        });


        bt_predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                inferenceEngine.feed(INPUT_NODE, myView.getPixelData(), INPUT_SIZE);
                inferenceEngine.feed("FC_Layer_1/Dropout/Placeholder", DROPOUT);

                String[] outputNodeArray = {OUTPUT_NODE};
                inferenceEngine.run(outputNodeArray);

                inferenceEngine.fetch(OUTPUT_NODE, outputs);
                updateReadings(outputs);


            }
        });

    }


    public void updateReadings(float[] outputs) {
        if(outputs.length < 10)
            return;
        int maxindex=-1;
        float tmp=-1;

        for(int i = 0; i < 10; i++) {
            if (outputs[i]>tmp){
                tmp = outputs[i];
                maxindex = i;
            }
        }

        tv_result.setText("预测结果是： "+maxindex);

    }
}