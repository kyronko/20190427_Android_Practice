package com.tjedit.a20190427_android_practice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tjedit.a20190427_android_practice.R;
import com.tjedit.a20190427_android_practice.datas.PizzaStore;

import java.util.List;

public class PizzaStoreAdapter extends ArrayAdapter<PizzaStore> {
    Context mContext;
    List<PizzaStore> mList;
    LayoutInflater inf;

    public  PizzaStoreAdapter (Context context, List<PizzaStore> list){
        super(context, R.layout.pizza_spinner_list_item,list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
         View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.pizza_spinner_list_item, null);

        }
        return  row;
    }
}
