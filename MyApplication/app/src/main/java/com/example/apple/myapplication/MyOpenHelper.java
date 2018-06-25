package com.example.apple.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        //创建数据库
        super(context, "todolist.db", null, 2);
        // TODO Auto-generated constructor stub
        System.out.println("MyOpenHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //创建表
        db.execSQL("create table todolist(id integer primary key autoincrement,desc text,finish integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("drop table if exists list");

    }

}
