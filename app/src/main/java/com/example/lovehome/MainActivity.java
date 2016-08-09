package com.example.lovehome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homepage.Homepage;
import com.example.homepage.HomepageActivity;
import com.example.lovehome.fragment.Home;
import com.example.mine.Mine;
import com.example.release.Release;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    public static FragmentManager fa;
    ArrayList<Fragment> fragments=new ArrayList();

    ImageView ImageView_1;
    ImageView ImageView_2;
    ImageView ImageView_3;
    LinearLayout linearLayout_1;
    LinearLayout linearLayout_2;
    LinearLayout linearLayout_3;
    TextView textView_1;
    TextView textView_2;
    TextView textView_3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fragments.add(new Home());
        fragments.add(new com.example.lovehome.fragment.Release());
        fragments.add(new com.example.lovehome.fragment.Mine());
        ImageView_1=(ImageView)findViewById(R.id.util_imageview_1);
        ImageView_2=(ImageView)findViewById(R.id.util_imageview_2);
        ImageView_3=(ImageView)findViewById(R.id.util_imageview_3);
        textView_1=(TextView) findViewById(R.id.util_textview_1);
        textView_2=(TextView) findViewById(R.id.util_textview_2);
        textView_3=(TextView) findViewById(R.id.util_textview_3);
        linearLayout_1=(LinearLayout)findViewById(R.id.util_layoutbutton_1);
        linearLayout_2=(LinearLayout)findViewById(R.id.util_layoutbutton_2);
        linearLayout_3=(LinearLayout)findViewById(R.id.util_layoutbutton_3);
        linearLayout_1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                FragmentTransaction ft = fa.beginTransaction();
                Home ff = new Home();

                ft.replace(R.id.Fragment_layout, ff);
                ft.commit();
            }
        });
        linearLayout_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FragmentTransaction ft = fa.beginTransaction();
                com.example.lovehome.fragment.Release ff = new com.example.lovehome.fragment.Release();
                ft.replace(R.id.Fragment_layout, ff);
                ft.commit();

            }
        });
        linearLayout_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FragmentTransaction ft = fa.beginTransaction();
                com.example.lovehome.fragment.Mine ff = new com.example.lovehome.fragment.Mine();
                ft.replace(R.id.Fragment_layout, ff);
                ft.commit();

            }
        });

        fa=getSupportFragmentManager();
        FragmentTransaction ft = fa.beginTransaction();
        Home f1 = new Home();
        ft.add(R.id.Fragment_layout, f1);
        ft.commit();
    }


}


