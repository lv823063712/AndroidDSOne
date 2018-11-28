package com.bwie.administrator.shijian.eliminate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * parent.requestDisallowInterceptTouchEvent(true);
 * 当我触摸到子控件的时候，父控件不会影响你
 */
public class MyViewPage extends ViewPager {
    private ViewGroup parent;

    public MyViewPage(@NonNull Context context) {
        super(context);
    }

    public MyViewPage(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public void setParent(ViewGroup parent) {
        this.parent = parent;
    }

    //


    @Override//事件分发
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //进行判断
        if (parent != null) {
            //请求不允许拦截触摸事件
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override//拦截事件
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //进行判断
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev);
    }
    @Override//消费 处理
    public boolean onTouchEvent(MotionEvent ev) {
        //进行判断
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(ev);
    }
}
