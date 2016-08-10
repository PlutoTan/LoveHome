package com.example.lovehome.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.library.entitypackage.Entity;
import com.example.library.httppackage.Http;
import com.example.library.httppackage.Item_http_library;
import com.example.library.jsonpackage.Json;
import com.example.lovehome.R;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by tanyang on 2016/8/9.
 */
public class Home extends Fragment{
    private PopupWindow popupWindow;
    private FragmentManager fa;

    ImageView af;
    public static ViewPager viewPager, viewPager1;
    public static   ArrayList<Fragment> a=new ArrayList();
    ImageView dian_3,dian_4;
    private ArrayList<Entity> home_Product_array =new ArrayList<>();
    LinearLayout home_pop_layout;
   //控件实现
    public void view(){
         fa=getChildFragmentManager();
        FragmentTransaction ft=fa.beginTransaction();
        HomepageFragment homepageFragment=new HomepageFragment();
        ft.add(R.id.Fragment_layout_1,homepageFragment);
        ft.commit();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view();
        home_pop_layout=(LinearLayout)getActivity().findViewById(R.id.home_pop_layout);
        home_pop_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1=LayoutInflater.from(getActivity()).inflate(R.layout.home_popo_layout,null);
                popupWindow=new PopupWindow(view1,270, WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(view1);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(home_pop_layout,10,0);
            }
        });
        a.add(new Home_ClassifyFragemt());
        a.add(new Home_ClassifyFragemt_1());
        dian_3=(ImageView)getActivity().findViewById(R.id.dian_3);
        dian_4=(ImageView) getActivity().findViewById(R.id.dian_4);
        viewPager1=(ViewPager)getActivity().findViewById(R.id.home_viewpage_2);
        viewPager1.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return a.get(position);
            }

            @Override
            public int getCount() {
                return a.size();
            }
        });
        viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 0:{dian_3.setImageResource(R.drawable.green_point);
                           dian_4.setImageResource(R.drawable.hen_point);
                        break;}
                    case 1:{dian_3.setImageResource(R.drawable.hen_point);
                           dian_4.setImageResource(R.drawable.green_point);
                        break;}
                }
            }
        });
        dian_3.setTag("0");
        dian_4.setTag("1");
    }
    public void Product(){
        Item_http_library a=new Item_http_library();
        a.http_item_home(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
              if (statusCode==200){
                  ArrayList<Entity> product= Json.home_listview_json(response);
                  home_Product_array.clear();
                  home_Product_array.addAll(product);

              }
            }
        });


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment, container, false);
        return view;
    }
}
