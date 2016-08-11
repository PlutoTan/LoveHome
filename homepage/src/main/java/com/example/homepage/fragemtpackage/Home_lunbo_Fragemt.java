package com.example.homepage.fragemtpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.homepage.R;

import java.util.ArrayList;

/**
 * Created by tanyang on 2016/8/11.
 */
public class Home_lunbo_Fragemt extends Fragment{
    ViewPager viewPager;
    private int pageNumber;
    int [] home_lunbo_image_droweba={ R.drawable.lunbo_1,R.drawable.lunbo_2,R.drawable.lunbo_1,R.drawable.lunbo_2};
    ArrayList<View> home_lunbo_image_array=new ArrayList<>();
    ArrayList<ImageView> home_lunbo_diandian_array=new ArrayList<>();
    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0) {
                pageNumber++;
                viewPager.setCurrentItem(pageNumber);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_lunbo_fargent_layout,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager=(ViewPager) getActivity().findViewById(R.id.home_lunbo_fargent_viewpage);
        for (int i=0;i<home_lunbo_image_droweba.length;i++){
            ImageView view=new ImageView(getActivity());
            view.setImageResource(home_lunbo_image_droweba[i]);
            home_lunbo_image_array.add(view);
        }
     //   home_lunbo_image_array.add(R.drawable.lunbo_1);
      //  home_lunbo_image_array.add(R.drawable.lunbo_2);


        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                pageNumber=position;
                for (int i=0;i<home_lunbo_diandian_array.size();i++){
                    if(i==position%home_lunbo_image_array.size()){
                        home_lunbo_diandian_array.get(i).setImageResource(R.drawable.green_point);
                    }else {
                        home_lunbo_diandian_array.get(i).setImageResource(R.drawable.hen_point);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(20,20);
       LinearLayout diandian=(LinearLayout)getActivity().findViewById(R.id.home_lunbo_fargent_diandian_layout);
        for(int i=0;i<=home_lunbo_image_array.size();i++){
            ImageView dian=new ImageView(getActivity());
            lp.leftMargin=10;
            dian.setLayoutParams(lp);
         //   dian.set
          //  dian.setScrollX(50);
          //  dian.setScrollY(50);

            dian.setImageResource(R.drawable.hen_point);
            home_lunbo_diandian_array.add(dian);
            diandian.addView(home_lunbo_diandian_array.get(i));
        }
        pageNumber=(10000/2)-(10000/2)%home_lunbo_image_array.size();
        viewPager.setCurrentItem(pageNumber);
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try{
                        sleep(3000);
                        handler.sendEmptyMessage(0);
                    }catch (Exception e){e.printStackTrace();}

                }
            }
        }.start();
    }

    PagerAdapter pagerAdapter=new  PagerAdapter() {
        @Override
        public int getCount() {
            return 10000;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;

        }

        @Override//杀掉
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = home_lunbo_image_array.get(position % home_lunbo_image_array.size());
            container.removeView(v);

        }

        @Override//创建
        public Object instantiateItem(ViewGroup container, int position) {
            View v = home_lunbo_image_array.get(position % home_lunbo_image_array.size());
            container.addView(v);
            return v;

        }
    };
}
