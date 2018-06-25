package com.example.apple.myapplication;

import android.app.Activity;


/**
 * Created by apple on 2018/5/16.
 */

public class thing extends Activity{
    private int id;
    private String desc;
    private int finish;


    public thing(){}

    public thing(int id, String desc,int finish){
        super();
        this.id = id;
        this.desc = desc;
        this.finish = finish;
    }


    public void setId(int id){
        this.id = id;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public int getId(){
        return id;
    }
    public String getDesc(){
        return desc;
    }

    public void setFinish(int finish){
        this.finish = finish;
    }
    public int getFinish(){
        return finish;
    }


}
