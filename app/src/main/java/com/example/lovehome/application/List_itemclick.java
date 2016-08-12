package com.example.lovehome.application;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import com.example.homepage.Homepage;
import com.example.library.entitypackage.Entity;
import com.example.lovehome.fragment.Home;

import java.util.ArrayList;

/**
 * Created by tanyang on 2016/8/11.
 */
public class List_itemclick {
    public void home_list_click(final Context context, ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String a=arrayList.get(i).toString();
                Intent b=new Intent(context, Homepage.class);
                b.putExtra("itemid",i);
                context.startActivity(b);
            }
        });
    }
}
