package com.example.lovehome.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.lovehome.R;

import java.util.ArrayList;

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
    int pageNumber =0;
    LinearLayout home_pop_layout;
    Handler handler =new Handler() {
        @Override
        public void handleMessage(Message msg) {
            viewPager.setCurrentItem(msg.arg1);
        }
    };
    ArrayList<View> image_list=new ArrayList<View>();
    ArrayList<ImageView> dian_list=new ArrayList<>();
   //控件实现
    public void view(){
        home_pop_layout=(LinearLayout)getActivity().findViewById(R.id.home_pop_layout);
        home_pop_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1=LayoutInflater.from(getActivity()).inflate(R.layout.home_popowindow,null);
                popupWindow=new PopupWindow(view1,270, WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(view1);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(home_pop_layout,10,0);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homefragment,container,false);
        view();
        viewPager=(ViewPager)view.findViewById(R.id.home_viewpage_1);
        String rootpath= Environment.getExternalStorageDirectory().getAbsolutePath();
        inflater=LayoutInflater.from(getActivity());
        View v1=inflater.inflate(R.layout.image_item_layout,null);
        ((ImageView)v1.findViewById(R.id.image)).setImageResource(R.drawable.lunbo_1);
        View v2=inflater.inflate(R.layout.image_item_layout,null);
        ((ImageView)v2.findViewById(R.id.image)).setImageResource(R.drawable.lunbo_2);
        image_list.add(v1);
        image_list.add(v2);
        LinearLayout dian_layout=(LinearLayout)getActivity().findViewById(R.id.dots_layout);

        dian_list.add((ImageView)getActivity().findViewById(R.id.dian_1));
        dian_list.add((ImageView)getActivity().findViewById(R.id.dian_2));

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View v=image_list.get(position%image_list.size());
                container.removeView(v);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v=image_list.get(position%image_list.size());
                container.addView(v);
                return v;
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                pageNumber=arg0;
                for(int i=0;i<dian_list.size();i++){
                    if(i==arg0%image_list.size()){
                        dian_list.get(i).setImageResource(R.drawable.green_point);
                    }else{
                        dian_list.get(i).setImageResource(R.drawable.hen_point);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        new Thread(){
            @Override
            public void run() {
                while(true){
                    try{
                        sleep(3000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    //继续下一张
                    pageNumber++;
                    //通知handle
                    Message message= handler.obtainMessage();
                    message.arg1=pageNumber;
                    handler.sendMessage(message);
                }
            }
        }.start();
        return view;



    }


}
