package com.example.homepage;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homepage.adapterpackage.Home_POP_adapter;
import com.example.library.entitypackage.ClassifyONE;
import com.example.library.entitypackage.ClassifyTWO;
import com.example.library.httppackage.Http;
import com.example.library.httppackage.Item_http_library;
import com.example.library.jsonpackage.Json;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Homepage extends Activity {
    ListView listView_1, listView_2;
    TextView textView_1, textView_2 ,basatapterText;
    LinearLayout layout_1, layout_2;
    ImageView ImageView1, imageView2;
    PopupWindow popupWindow_1, popupWindow_2;
    Home_POP_adapter home_pop_adapter;
    public static   ArrayList<ClassifyONE> classifyONEs=new ArrayList<>();
    public static   ArrayList<ClassifyTWO> classifyTWOs=new ArrayList<>();
    String[] date1 = {"美食", "娱乐", "房产", "车", "婚庆", "装修", "教育", "工作", "百货", "跳蚤", "商务"
            , "便民", "老乡会", "其他"};
    String[] date2 = {"aa", "bb", "cc", "dd", "ee"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ImageView1 = (ImageView) findViewById(R.id.classif1);
        ImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Homepage.this.finish();
            }
        });
        layout_1 = (LinearLayout) findViewById(R.id.home_classify_layoutbutton_1);
        layout_2 = (LinearLayout) findViewById(R.id.home_classify_layoutbutton_2);
        imageView2 = (ImageView) findViewById(R.id.kkkkkkk);
        classify_one();
        home_pop_adapter=new Home_POP_adapter(Homepage.this,classifyONEs);
        layout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(Homepage.this).inflate(R.layout.listview_layout_1, null);
                popupWindow_1 = new PopupWindow(view1,800, WindowManager.LayoutParams.WRAP_CONTENT);
                Log.e("ooooo","changjian");
                popupWindow_1.setContentView(view1);
                Toast.makeText(Homepage.this, "被带你点了", Toast.LENGTH_SHORT).show();
                popupWindow_1.setBackgroundDrawable(new BitmapDrawable());
                popupWindow_1.setFocusable(true);
                popupWindow_1.showAsDropDown(layout_1, 0, 0);
                listView_1=(ListView) view1.findViewById(R.id.classify_pop_listview_1);
                listView_2=(ListView) view1.findViewById(R.id.classify_pop_listview_2);
                listView_1.setAdapter(home_pop_adapter);
                listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                         switch (date1[i].toString()){
                             case "美食":{
                                 listView_2.setAdapter(baseAdapter2);
                             }
                         }
                    }
                });
            }
        });
    }
    public void classify_one(){
        Item_http_library a=new Item_http_library();
        a.http_classify(new JsonHttpResponseHandler(){
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                if(statusCode==200){
                    ArrayList<ClassifyONE> ASS= Json.classifyONEs(response);
                    classifyONEs.clear();
                    Log.e("jjjj", "zaizai"+ASS.get(1).toString());
                    classifyONEs.addAll(ASS);
              //      for (){}
                    home_pop_adapter.notifyDataSetChanged();
                }
            }
        });
    }
    BaseAdapter baseAdapter2=new BaseAdapter() {
        @Override
        public int getCount() {
            return date2.length;
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
            if(view==null) {
                view = LayoutInflater.from(Homepage.this).inflate(R.layout.baseadapter_layout, null);
                basatapterText=(TextView) view.findViewById(R.id.baseadapter_text);
                basatapterText.setText(date2[i].toString());
            }
            return view;
        }
    };
    BaseAdapter baseAdapter1=new BaseAdapter() {
        @Override
        public int getCount() {
            return date1.length;
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
            if(view==null) {
                view = LayoutInflater.from(Homepage.this).inflate(R.layout.baseadapter_layout, null);
                basatapterText=(TextView) view.findViewById(R.id.baseadapter_text);
                basatapterText.setText(date1[i].toString());
            }
            return view;
        }
    };

}


