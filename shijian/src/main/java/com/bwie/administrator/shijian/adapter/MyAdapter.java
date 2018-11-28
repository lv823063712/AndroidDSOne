package com.bwie.administrator.shijian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.administrator.shijian.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> datas;

    public MyAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //声明一个holder类
        ViewHolder holder = null;
        //进行判断
        if (convertView == null){
            convertView = View.inflate(context,R.layout.listview_item,null);
            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.listview_Name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(datas.get(position));

        return convertView;
    }

    //holder类
    class ViewHolder{
        TextView tv;
    }

}
