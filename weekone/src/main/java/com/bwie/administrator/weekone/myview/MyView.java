package com.bwie.administrator.weekone.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.administrator.weekone.R;

import java.util.ArrayList;

public class MyView extends LinearLayout {
    private int mwidthPixels;
    private String mcolor;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕的尺寸与密度
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        //像素宽度
        mwidthPixels = metrics.widthPixels;
        //设置这个布局垂直显示(此处注意需要继承的是线性布局,如果不是出不来)
        setOrientation(VERTICAL);
        //获得样式属性
        TypedArray myarray = context.obtainStyledAttributes(attrs, R.styleable.GroupDemo);
        //进行判断
        if (myarray != null) {
            //如果不为空就获得样式
            mcolor = (String) myarray.getText(R.styleable.GroupDemo_textColor);
            //将资源回收
            myarray.recycle();
        }
    }

    //删除的方法
    public void removeChildView() {
        //删除所有的子控件
        removeAllViews();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    //添加数据
    public void setData(ArrayList<String> datas) {
        //创建一个线性布局对象
        LinearLayout linearLayout = getLinear();
        //进行for循环
        for (int i = 0; i < datas.size(); i++) {
            //获取文字
            final String tmp = datas.get(i);
            //初始化宽度
            int numWidth = 0;
            //得到每一行的linearlayout到底有多少个子控件,需要计算总宽度
            int childCount = linearLayout.getChildCount();
            //进行for循环,计算一行的宽度
            for (int j = 0; j < childCount; j++) {
                //通过循环的到每一个子控件
                TextView tv_chang = (TextView) linearLayout.getChildAt(j);
                //layoutParams布局参数    获取布局参数
                LayoutParams layoutParams = (LayoutParams) tv_chang.getLayoutParams();
                //设定每一个控件的外边距
                int aleftMargin = layoutParams.leftMargin;
                //测量这个textview的宽度
                tv_chang.measure(getMeasuredWidth(), getMeasuredHeight());
                //将得到的宽度相加  字体本身的宽度+左外边距+左边的填充+右边的填充
                numWidth += tv_chang.getMeasuredWidth() + aleftMargin + tv_chang.getPaddingLeft() + tv_chang.getPaddingRight();
            }
            //获得text对象
            TextView text = getText();
            //设置一个点击事件,再点击条目的时候进行吐司展示
            text.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), tmp, Toast.LENGTH_SHORT).show();
                }
            });
            //设置属性
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            //给params设置具体的数值;
            params.leftMargin = 15;
            params.topMargin = 10;
            //设定文字的属性
            text.setLayoutParams(params);
            //将文字进行传入
            text.setText(tmp);
            //测量输入的值的高与宽
            text.measure(getMeasuredWidth(), getMeasuredHeight());
            //得到输入值总宽度
            int textNumWidth = text.getMeasuredWidth() + text.getPaddingLeft() + text.getPaddingRight();
            //设定 一个判断条件,如果某个字符串特别长超出了屏幕的总宽度
            if (textNumWidth > mwidthPixels) {
                //如果文字过长就进行一个截取字符串
                String s = tmp.substring(0, 6);
                text.setText(s + "...");
                text.measure(getMeasuredWidth(), getMeasuredHeight());//截取完毕后再重新测量宽高
                textNumWidth = text.getMeasuredWidth();//得到宽度
            }
            //进行判断
            if (mwidthPixels >= numWidth + textNumWidth) {
                linearLayout.addView(text);//添加新的控件
            } else {
                //此处给LinearLayout重新赋值,通过getLinear换行
                linearLayout = getLinear();
                linearLayout.addView(text);
            }
        }
    }

    //初始化子线性布局视图
    private LinearLayout getLinear() {
        //创建一个控件对象
        LinearLayout linearLayout = new LinearLayout(getContext());
        //使用LayoutParams  用来控制组件的大小
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);//将属性值添加到控件
        //this本类对象
        this.addView(linearLayout);//此处只要重新添加视图了就自动换行
        return linearLayout;//返回控件
    }

    //初始化文字
    private TextView getText() {
        //创建一个textview对象
        TextView textView = new TextView(getContext());
        //设定字体大小
        textView.setTextSize(20);
        //设定字体颜色
        textView.setTextColor(Color.parseColor(mcolor));
        //设定背景颜色
        textView.setBackgroundResource(R.drawable.text_view);
        //设定每个搜索的间隔
        textView.setPadding(10, 3, 10, 3);
        //返回文字
        return textView;
    }

}

