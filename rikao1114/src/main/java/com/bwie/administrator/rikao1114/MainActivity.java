package com.bwie.administrator.rikao1114;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bwie.administrator.rikao1114.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button m_Btn;

    @Override   //引入视图
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override   //初始化数据
    protected void initData() {

    }

    @Override  //查找控件
    protected void findViewById() {
        m_Btn = findViewById(R.id.My_Btn);

    }

    @Override
    protected void getNextData() {

    }

    @Override
    protected void setListener() {
        m_Btn.setOnClickListener(this);
    }

    @Override
    protected void progressLogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.My_Btn:
                Toast.makeText(MainActivity.this,"唉",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
