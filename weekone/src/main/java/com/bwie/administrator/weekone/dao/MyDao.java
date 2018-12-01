package com.bwie.administrator.weekone.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.bwie.administrator.weekone.sqlhelper.MyHelper;

import java.util.ArrayList;

public class MyDao {

    private MyHelper helper;
    private SQLiteDatabase database;
    private Context mcontext;

    public MyDao(Context context) {
        mcontext = context;
        helper = new MyHelper(context);
        database = helper.getWritableDatabase();
    }

    //查询的方法
    public ArrayList<String> show() {
        ArrayList<String> datas = new ArrayList<>();
        Cursor cursor = database.query("flow", null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            datas.add(name);
        }
        return datas;
    }

    //添加数据的方法
    public void insertall(String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        database.insert("flow", null, values);
        Toast.makeText(mcontext, "添加成功", Toast.LENGTH_SHORT).show();
    }

    //删除数据的方法
    public void delete() {
        database.execSQL("delete from flow");
    }


}
