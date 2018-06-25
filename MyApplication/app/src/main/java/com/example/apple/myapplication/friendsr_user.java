package com.example.apple.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/5/16.
 */

public class friendsr_user {
    private String name;
    private int imageid;
    private int age;
    private String desc;

    public friendsr_user(String name, int imageid, int age, String desc){
        this.name = name;
        this.imageid = imageid;
        this.age = age;
        this.desc = desc;
    }

    public static List<friendsr_user> getAllUsers(){
        List<friendsr_user> users = new ArrayList<friendsr_user>();
        users.add(new friendsr_user("张三",R.drawable.zhangsan,22,"高富帅"));
        users.add(new friendsr_user("李四",R.drawable.lisi,23,"CEO，霸道总裁"));
        users.add(new friendsr_user("王五",R.drawable.wangwu,24,"黄金单身汉"));
        users.add(new friendsr_user("赵六",R.drawable.zhaoliu,23,"潜力股"));

        return users;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setImageid(int imageid){
        this.imageid = imageid;
    }
    public int getImageid(){
        return imageid;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return desc;
    }

}
