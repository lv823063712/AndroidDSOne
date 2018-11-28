package com.bwie.administrator.rikao1114.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    //加载资源布局
    protected abstract int getLayoutId();

    //初始化数据
    protected abstract void initData();

    //初始化组件
    protected abstract void findViewById();

    //获取上一个页面传过来的参数
    protected abstract void getNextData();

    //注册监听
    protected abstract void setListener();

    //页面代码逻辑
    protected abstract void progressLogic();

    //同步和异步的区别    同步按顺序执行
    void init() {
        if (getLayoutId() != 0) {
            //使用 setContentView 方法和布局资源定义用户界面。
            setContentView(getLayoutId());
            initData();
            findViewById();
            getNextData();
            setListener();
            progressLogic();
        }
    }

}
