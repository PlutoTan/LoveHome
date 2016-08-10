package com.example.lovehome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.homepage.Homepage;
import com.example.lovehome.R;
import com.example.lovehome.adapterpackage.Home_Classify_Adapter;

/**
 * Created by tanyang on 2016/8/10.
 */
public class Home_ClassifyFragemt extends Fragment{
    static int home_gridview_imgid[]={R.drawable.meishi,R.drawable.yule, R.drawable.fangchan,R.drawable.che,
                               R.drawable.hunqing, R.drawable.zhuangxiu,R.drawable.jiaoyu,R.drawable.gongzuo};
     static String home_gridview_text[]={"美食","娱乐","房产","车","婚庆","装修","教育","工作"};
    GridView gridView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView=(GridView) getActivity().findViewById(R.id.home_classify_gridview_1);
        gridView.setAdapter(new Home_Classify_Adapter(home_gridview_imgid,home_gridview_text,getActivity()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   switch (home_gridview_text[i].toString()){
                       case  "美食":
                           Intent a=new Intent(getActivity(),Homepage.class);
                           startActivity(a);
                           break;
                       case  "娱乐":
                           Intent b=new Intent(getActivity(),Homepage.class);
                           startActivity(b);
                           break;
                       case  "房产":
                           Intent c=new Intent(getActivity(),Homepage.class);
                           startActivity(c);
                           break;
                       case  "车":
                           Intent d=new Intent(getActivity(),Homepage.class);
                           startActivity(d);
                           break;
                       case  "婚庆":
                           Intent e=new Intent(getActivity(),Homepage.class);
                           startActivity(e);
                           break;
                       case  "装修":
                           Intent f=new Intent(getActivity(),Homepage.class);
                           startActivity(f);
                           break;
                       case  "教育":
                           Intent g=new Intent(getActivity(),Homepage.class);
                           startActivity(g);
                           break;
                       case  "工作":
                           Intent h=new Intent(getActivity(),Homepage.class);
                           startActivity(h);
                           break;
                   }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_classify_fragment,null);
    }
}

