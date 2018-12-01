package com.bwie.administrator.weekone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.administrator.weekone.dao.MyDao;
import com.bwie.administrator.weekone.myview.MyView;
import com.bwie.administrator.weekone.myview.MyXHView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] data = {"性感", "美女", "丰满", "御姐", "萝莉", "艾滋病", "梅毒", "性感", "美女", "丰满", "御姐", "萝莉", "艾滋病", "梅毒", "性感", "美女", "丰满", "御姐", "萝莉", "艾滋病", "梅毒"};
    private MyXHView My_Header;
    private MyView My_History;
    private MyView My_Hot;
    private MyDao myDao;
    private ArrayList<String> datas = new ArrayList<>();
    private ArrayList<String> mhistoryjihe = new ArrayList<>();
    private TextView My_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDao = new MyDao(this);
        mhistoryjihe = myDao.show();
        //初始化数据
        initData();
        initView();
        //进行一个判断
        if (!mhistoryjihe.isEmpty()) {
                //将默认数据直接从数据库添加到集合中
                My_History.setData(mhistoryjihe);
        }
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < data.length; i++) {
            datas.add(data[i]);
        }
    }

    //初始化控件
    private void initView() {
        My_Header = (MyXHView) findViewById(R.id.My_Header);
        My_Header.getAdd().setOnClickListener(this);
        My_History = (MyView) findViewById(R.id.My_History);
        My_Hot = (MyView) findViewById(R.id.My_Hot);
        My_Hot.setData(datas);
        My_del = (TextView) findViewById(R.id.My_del);
        My_del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.My_Add:
                String name = My_Header.getSearch().trim();
                //进行一个费控判断
                if (name != null && name.equals("")) {
                    Toast.makeText(this, "输入为空", Toast.LENGTH_SHORT).show();
                } else {
                    myDao.insertall(My_Header.getSearch().trim());
                    //自己封装一个删除子控件
                    My_History.removeChildView();
                    //将数据添加到集合中
                    mhistoryjihe.add(name);
                    My_History.setData(mhistoryjihe);
                    //添加完毕后进行一个输入框赋空
                    My_Header.getEdit().setText("");
                }
                break;
            case R.id.My_del:
                //删除数据库
                myDao.delete();
                //删除输入历史
                My_History.removeChildView();
                //对数据集合进行清空
                mhistoryjihe.clear();
                break;
        }

    }
}
