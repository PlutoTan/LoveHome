package com.example.lovehome;


import android.graphics.Color;
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

import com.example.lovehome.fragment.Home;

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
                ImageView_2.setImageResource(R.drawable.publish);
                ImageView_3.setImageResource(R.drawable.wode);
                ImageView_1.setImageResource(R.drawable.home_press);
                textView_1.setTextColor(Color.parseColor("#53c67a"));
                textView_2.setTextColor(Color.parseColor("#e8e8e8"));
                textView_3.setTextColor(Color.parseColor("#e8e8e8"));
                ft.replace(R.id.Fragment_layout, ff);
                ft.commit();
            }
        });
        linearLayout_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FragmentTransaction ft = fa.beginTransaction();
                com.example.lovehome.fragment.Release ff = new com.example.lovehome.fragment.Release();
                ImageView_1.setImageResource(R.drawable.home);
                ImageView_2.setImageResource(R.drawable.publish_press);
                ImageView_3.setImageResource(R.drawable.wode);
                textView_1.setTextColor(Color.parseColor("#e8e8e8"));
                textView_2.setTextColor(Color.parseColor("#53c67a"));
                textView_3.setTextColor(Color.parseColor("#e8e8e8"));
                ft.replace(R.id.Fragment_layout, ff);
                ft.commit();

            }
        });
        linearLayout_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                FragmentTransaction ft = fa.beginTransaction();
                com.example.lovehome.fragment.Mine ff = new com.example.lovehome.fragment.Mine();
                ImageView_1.setImageResource(R.drawable.home);
                ImageView_2.setImageResource(R.drawable.publish);
                ImageView_3.setImageResource(R.drawable.wode_press);
                textView_1.setTextColor(Color.parseColor("#e8e8e8"));
                textView_2.setTextColor(Color.parseColor("#e8e8e8"));
                textView_3.setTextColor(Color.parseColor("#53c67a"));
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


