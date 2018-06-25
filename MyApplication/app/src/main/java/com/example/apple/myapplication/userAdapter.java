package com.example.apple.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apple on 2018/5/16.
 */

public class userAdapter extends ArrayAdapter<friendsr_user> {

    public userAdapter(Context context, int source, List<friendsr_user> objects){
        super(context,source,objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        // 获取用户的数据
        final friendsr_user user = getItem(position);

        // 创建布局
        View oneUserView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);

        // 获取ImageView和TextView
        ImageView imageView = (ImageView) oneUserView.findViewById(R.id.user_small_image);
        TextView textView = (TextView) oneUserView.findViewById(R.id.user_samll_text);

        // 根据用户数据设置ImageView和TextView的展现
        imageView.setImageResource(user.getImageid());
        textView.setText(user.getName());


        oneUserView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  初始化一个准备跳转到userdetail的Intent
                Intent intent = new Intent(getContext(), userdetail.class);

                intent.putExtra("user_image",user.getImageid());;
                intent.putExtra("user_desc",user.getDesc());

                // 准备跳转
                getContext().startActivity(intent);
            }
        });


        return oneUserView;


    }

}
