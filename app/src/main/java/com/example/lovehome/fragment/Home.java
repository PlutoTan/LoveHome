package com.example.lovehome.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;

import com.example.homepage.fragemtpackage.Home_lunbo_Fragemt;
import com.example.library.entitypackage.City_name;
import com.example.library.entitypackage.Entity;
import com.example.library.httppackage.Item_http_library;
import com.example.library.jsonpackage.Json;
import com.example.lovehome.R;
import com.example.lovehome.adapterpackage.Home_Product_adapter;
import com.example.lovehome.application.List_itemclick;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by tanyang on 2016/8/9.
 */
public class Home extends Fragment {
    private PopupWindow popupWindow;
    private FragmentManager fa;
    ListView listView,listView1;
    ImageView af;
    public static ViewPager viewPager, viewPager1;
    public static ArrayList<Fragment> a = new ArrayList();
    ImageView dian_3, dian_4;
    private ArrayList<Entity> home_Product_array = new ArrayList<>();
    ArrayList<City_name> home_cityname_array=new ArrayList<>();
    LinearLayout home_pop_layout;
    TextView  home_pop_text,home_pop_city_adapter_text;

    Home_Product_adapter home_product_adapter;

    //控件实现
    public void view() {

        fa = getChildFragmentManager();
        FragmentTransaction ft = fa.beginTransaction();
        Home_lunbo_Fragemt home_lunbo_fragemt = new Home_lunbo_Fragemt();
        ft.add(R.id.home_Fragment_lunbo_layout_1, home_lunbo_fragemt);
        ft.commit();
    }

    /**
     * 重新计算ListView的高度，解决ScrollView和ListView两个View都有滚动的效果，在嵌套使用时起冲突的问题
     *
     * @param listView
     */
    public void setListViewHeight(ListView listView) {

        // 获取ListView对应的Adapter

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
    BaseAdapter baseAdapter=new BaseAdapter() {

        @Override
        public int getCount() {
            if (home_cityname_array==null){
                Log.e("fffff","空的"+home_cityname_array);
                return 1;
            }else {
            return home_cityname_array.size();}
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (home_cityname_array!=null){
                view=LayoutInflater.from(getActivity()).inflate(R.layout.adapter_xml,null);
                home_pop_city_adapter_text=(TextView) view.findViewById(R.id.pop_cityname_adapter_text);
                home_pop_city_adapter_text.setText(home_cityname_array.get(i).getCity_name().toString());
            }
            return view;
        }
    };
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getActivity().findViewById(R.id.home_choose_listview);

        view();
        Log.e("Tag", "大小xiaoxiaoi");
        citynamearray();
        Product();
        home_product_adapter = new Home_Product_adapter(getActivity(), home_Product_array);
        listView.setAdapter(home_product_adapter);
        List_itemclick list_itemclick = new List_itemclick();
        list_itemclick.home_list_click(getActivity(), listView);
        //   listView.setOnItemClickListener( List_itemclick().home_list_click(getActivity(),listView));
        home_pop_text = (TextView) getActivity().findViewById(R.id.home_pop_text_1);
        home_pop_layout = (LinearLayout) getActivity().findViewById(R.id.home_pop_layout);
        home_pop_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.home_popo_layout, null);
                popupWindow = new PopupWindow(view1,100, WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(view1);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(home_pop_layout, 0, 0);
                listView1=(ListView)view1.findViewById(R.id.POP_cityname);
                listView1.setAdapter(baseAdapter);
                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        home_pop_text.setText(home_cityname_array.get(i).getCity_name().toString());
                        popupWindow.dismiss();
                    }
                });
            }
        });
        a.add(new Home_ClassifyFragemt());
        a.add(new Home_ClassifyFragemt_1());
        dian_3 = (ImageView) getActivity().findViewById(R.id.dian_3);
        dian_4 = (ImageView) getActivity().findViewById(R.id.dian_4);
        viewPager1 = (ViewPager) getActivity().findViewById(R.id.home_viewpage_2);
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
                switch (position) {
                    case 0: {
                        dian_3.setImageResource(R.drawable.green_point);
                        dian_4.setImageResource(R.drawable.hen_point);
                        break;
                    }
                    case 1: {
                        dian_3.setImageResource(R.drawable.hen_point);
                        dian_4.setImageResource(R.drawable.green_point);
                        break;
                    }
                }
            }
        });
        dian_3.setTag("0");
        dian_4.setTag("1");
    }
    //城市名
    public  void  citynamearray(){
        Item_http_library b=new Item_http_library();
        Log.e("kkkkk","来了来了");
        b.http_cityname(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.e("gg",statusCode+"ggggggggg");
                if(statusCode==200){
                    ArrayList<City_name> AS = Json.city_names(response);
                    Log.e("gg",AS.get(0).getCity_name().toString());
                    home_cityname_array.clear();
                    home_cityname_array.addAll(AS);
                  //  setListViewHeight(listView1);
                    baseAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.e("gg","shibaillllll");
            }
        });

    }
    //
    public void Product() {
        Log.e("Tag", "大小");
        Item_http_library a = new Item_http_library();
        a.http_item_home(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.e("Tag", "sshhshshshshs");
                if (statusCode == 200) {
                    ArrayList<Entity> product = Json.home_listview_json(response);
                    Log.e("Tag", product.size() + "大小");
                    home_Product_array.clear();
                    home_Product_array.addAll(product);
                    //   Log.e("tag","有没有"+home_Product_array.get(1).getImgUrlList().get(0).getImg_url().toString());
                    //  Log.e("yyyy","donxi"+home_Product_array.toString());
                    setListViewHeight(listView);
                    //Log.e("tag","有youyouy没有"+home_Product_array.get(1).getImgUrlList().get(0).getImg_url().toString());
                    home_product_adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
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
