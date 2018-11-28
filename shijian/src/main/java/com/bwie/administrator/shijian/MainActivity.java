package com.bwie.administrator.shijian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.administrator.shijian.adapter.MyAdapter;
import com.bwie.administrator.shijian.adapter.MyPageAdapter;
import com.bwie.administrator.shijian.eliminate.MyViewPage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private MyAdapter adapter;
    private View myHeaderView;
    private MyViewPage myViewPage;
    private ArrayList<String> datas = new ArrayList<>();
    private ArrayList<View> mPageListList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        //初始化视图
        initHolderView();
        //查找控件
        initView();
        //设置适配器
        adapter = new MyAdapter(MainActivity.this, datas);
        listview.setAdapter(adapter);
    }

    private void initHolderView() {
        myHeaderView = getLayoutInflater().inflate(R.layout.holder_view, null);
        myViewPage = myHeaderView.findViewById(R.id.MyHe);
        //进行循环
        for (int i = 0; i < 10; i++) {
            View view = getLayoutInflater().inflate(R.layout.page_view, null);
            mPageListList.add(view);
        }
        myViewPage.setParent((ViewGroup) myViewPage.getParent());
        //设置适配器
        myViewPage.setAdapter(new MyPageAdapter(mPageListList));

    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 50; i++) {
            datas.add("BigFlyRed" + i);
        }
    }

    //查找控件
    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        listview.addHeaderView(myHeaderView);
    }
}
