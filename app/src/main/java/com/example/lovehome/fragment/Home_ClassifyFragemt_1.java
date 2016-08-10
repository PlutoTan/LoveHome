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
public class Home_ClassifyFragemt_1 extends Fragment{
    static  int home_gridview2_imgid[]={ R.drawable.baihuo,R.drawable.tiaozhao,R.drawable.shangwu,R.drawable.bianmin,
                R.drawable.laoxianghui,R.drawable.qita};
    static  String home_gridview2_text[]={"百货","跳蚤","商务","便民","老乡会","其他"};
    GridView gridView2;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView2=(GridView)getActivity().findViewById(R.id.home_classify_gridview_2);
        gridView2.setAdapter(new Home_Classify_Adapter(home_gridview2_imgid,home_gridview2_text,getActivity()));
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (home_gridview2_text[i].toString()){
                    case  "百货":
                        Intent a=new Intent(getActivity(),Homepage.class);
                        startActivity(a);
                        break;
                    case  "跳蚤":
                        Intent b=new Intent(getActivity(),Homepage.class);
                        startActivity(b);
                        break;
                    case  "商务":
                        Intent c=new Intent(getActivity(),Homepage.class);
                        startActivity(c);
                        break;
                    case  "便民":
                        Intent d=new Intent(getActivity(),Homepage.class);
                        startActivity(d);
                        break;
                    case  "老乡会":
                        Intent e=new Intent(getActivity(),Homepage.class);
                        startActivity(e);
                        break;
                    case  "其他":
                        Intent f=new Intent(getActivity(),Homepage.class);
                        startActivity(f);
                        break;
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_classify_fragment_1,null);

    }
}
