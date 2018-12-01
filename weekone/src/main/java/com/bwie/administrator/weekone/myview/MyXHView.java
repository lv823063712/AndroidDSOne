package com.bwie.administrator.weekone.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.administrator.weekone.R;

public class MyXHView extends LinearLayout {

    private EditText My_Search;
    private TextView My_Add;

    public MyXHView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //引入头部布局
        LayoutInflater.from(context).inflate(R.layout.my_hander, this);
        //查找控件
        My_Search = findViewById(R.id.My_Search);
        My_Add = findViewById(R.id.My_Add);
    }

    //获取输入框中的值
    public String getSearch() {
        return My_Search.getText().toString().trim();
    }

    //按钮点击后返回的值
    public TextView getAdd() {
        return My_Add;
    }

    //对editText进行操作
    public EditText getEdit() {
        return My_Search;
    }
}
