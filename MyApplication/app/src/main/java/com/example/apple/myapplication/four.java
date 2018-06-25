package com.example.apple.myapplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;



public class four extends Activity {

    List<thing> thingList;
    MyOpenHelper mOpenHelper;
    SQLiteDatabase db;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ListView lv = (ListView) findViewById(R.id.listView);
        thingList = new ArrayList<thing>();
        // 创建MyOpenHelper实例
        mOpenHelper = new MyOpenHelper(this);

        // 得到数据库
        db = mOpenHelper.getWritableDatabase();
        // 查询数据
        Query();
        // 创建MyAdapter实例
        myAdapter = new MyAdapter(this);
        // 向listview中添加Adapter
        lv.setAdapter(myAdapter);
//        mOpenHelper.onCreate(db);


        Button bt_add = (Button)findViewById(R.id.button_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText et = (EditText)findViewById(R.id.edittext_desc);
                String desc = et.getText().toString();

                ContentValues values = new ContentValues();
                values.put("desc",desc);
                values.put("finish",1);

                db.insert("todolist",null,values);
                et.setText("");
                values.clear();


            }
        });

        Button bt_update = (Button)findViewById(R.id.button_update);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });


    }

    private void refresh() {
        finish();
        Intent intent = new Intent(four.this, four.class);
        startActivity(intent);
    }

    // 创建MyAdapter继承BaseAdapter
    class MyAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return thingList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 从personList取出Person
            thing p = thingList.get(position);
            final int f;
            final String s;
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.todolist_item, null);
                viewHolder.txt_desc = (TextView) convertView
                        .findViewById(R.id.desc);
                viewHolder.txt = (TextView)convertView.findViewById(R.id.finish);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            final int id = p.getId();
            s = p.getDesc();
            f = p.getFinish();
            viewHolder.txt_desc.setText(p.getDesc());
            viewHolder.txt.setText(f+"");

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(four.this,todolistdetail.class);
                    intent.putExtra("id",id+"");
                    intent.putExtra("desc",s);
                    intent.putExtra("finish",f+"");
                    startActivity(intent);
                }
            });


            return convertView;
        }
    }

    class ViewHolder {
        private TextView txt_desc;
        private TextView txt;
    }


    // 查询数据
    public void Query() {
        Cursor cursor = db.query("todolist", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String _id = cursor.getString(0);
            String desc = cursor.getString(1);
            int finish;
            if (Integer.parseInt(cursor.getString(2))==2){
                continue;
            }
            finish=1;
            thing onething = new thing(Integer.parseInt(_id), desc, finish);
            thingList.add(onething);
        }
    }

}
