package com.example.apple.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class todolistdetail extends AppCompatActivity {

    MyOpenHelper mOpenHelper;
    SQLiteDatabase db;

    private GestureDetector mDetector;
    private final static int MIN_MOVE = 200;   //最小距离
    private MyGestureListener mgListener;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolistdetail);

        // 创建MyOpenHelper实例
        mOpenHelper = new MyOpenHelper(this);

        // 得到数据库
        db = mOpenHelper.getWritableDatabase();

        String desc = getIntent().getStringExtra("desc");
        String finish = getIntent().getStringExtra("finish");
        String _id = getIntent().getStringExtra("id");
        this.id = Integer.parseInt(_id);


        TextView tv = (TextView)findViewById(R.id.todolistdetail);
        TextView tv_f = (TextView)findViewById(R.id.todolistdetail_finish);

        int f = Integer.parseInt(finish);


        if (f==1){
            tv_f.setText("这项还没完成呢，要加快了");
        }else
            tv_f.setText("这项已经完成了");

        tv.setText(desc);

        //实例化SimpleOnGestureListener与GestureDetector对象
        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    //自定义一个GestureListener,这个是View类下的，别写错哦！！！
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {

            if(e1.getY() - e2.getY()  < MIN_MOVE){
                //向下滑
                reject();
                finish();
                Toast.makeText(todolistdetail.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }


    public void reject(){
        db.execSQL("update todolist  set finish = 2 where id="+id);
    }
}
