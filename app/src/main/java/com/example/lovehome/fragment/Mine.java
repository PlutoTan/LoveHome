package com.example.lovehome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.User_MINfragment;
import com.example.lovehome.R;

/**
 * Created by tanyang on 2016/8/9.
 */

public class Mine extends Fragment{
  FragmentManager fa;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fa=getChildFragmentManager();
        FragmentTransaction ft=fa.beginTransaction();
        User_MINfragment f1=new User_MINfragment();
        ft.add(R.id.mine_managemen,f1);
        ft.commit();
        return inflater.inflate(R.layout.minefragment,null);
    }
}
