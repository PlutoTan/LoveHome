package com.example.lovehome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lovehome.R;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by 123 on 2016/8/9.
 */
public class HomepageFragment extends Fragment {
    ArrayList<Fragment> lunbo=new ArrayList<>();
    ImageView dian_1,dian_2;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lunbo.add(new ReleaseFragment());
        lunbo.add(new PersonalFragment());
        dian_1=(ImageView) getActivity().findViewById(R.id.dian_1);
        dian_2=(ImageView) getActivity().findViewById(R.id.dian_2);
        AutoScrollViewPager scrollViewPager=  (AutoScrollViewPager)getActivity().findViewById(R.id.lunbo);
        scrollViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return lunbo.get(position);
            }

            @Override
            public int getCount() {
                return lunbo.size();
            }
        });

        scrollViewPager.setInterval(4000); //设置自动滚动的间隔时间，单位为毫秒
        scrollViewPager.setDirection(0) ;//设置自动滚动的方向，默认向右
        scrollViewPager.setCycle(true); //是否自动循环轮播，默认为true
        //scrollViewPager.setScrollDurationFactor(double) 设置ViewPager滑动动画间隔时间的倍率，达到减慢动画或改变动画速度的效果
        scrollViewPager.setStopScrollWhenTouch(true); //当手指碰到ViewPager时是否停止自动滚动，默认为true
        scrollViewPager.setSlideBorderMode(2); //滑动到第一个或最后一个Item的处理方式，支持没有任何操作、轮播以及传递到父View三种模式
        scrollViewPager.setBorderAnimation(false); //设置循环滚动时滑动到从边缘滚动到下一个是否需要动画，默认为true
        scrollViewPager.startAutoScroll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
       View view=  inflater.inflate(R.layout.fragmenthomepage,null);





        return view;
    }
}
