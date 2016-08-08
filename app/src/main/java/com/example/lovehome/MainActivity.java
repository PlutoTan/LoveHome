package com.example.lovehome;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lovehome.fragment.Home;
import com.example.lovehome.fragment.Mine;
import com.example.lovehome.fragment.Release;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    public  static FragmentManager fa;
    ArrayList<Fragment> fragments =new ArrayList<>();
    LinearLayout linearLayout_1;
    LinearLayout linearLayout_2;
    LinearLayout linearLayout_3;
    TextView textView_1;
    TextView textView_2;
    TextView textView_3;
    public void  view(){

        fragments.add(new Home());
        fragments.add(new Mine());
        fragments.add(new Release());
        linearLayout_1=(LinearLayout)findViewById(R.id.layoutbutton_1);
        linearLayout_2=(LinearLayout)findViewById(R.id.layoutbutton_2);
        linearLayout_3=(LinearLayout)findViewById(R.id.layoutbutton_3);
        linearLayout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=fa.beginTransaction();
                Home home=new Home();
                ft.replace(R.id.framelayput,home);
                ft.commit();
            }
        });
        linearLayout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=fa.beginTransaction();
                Release home=new Release();
                ft.replace(R.id.framelayput,home);
                ft.commit();
            }
        });
        linearLayout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft=fa.beginTransaction();
                Mine home=new Mine();
                ft.replace(R.id.framelayput,home);
                ft.commit();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view();
           fa=getSupportFragmentManager();
                 FragmentTransaction ft=fa.beginTransaction();
                 Home home=new Home();
                ft.add(R.id.framelayput,home);
                ft.commit();
    }
}
