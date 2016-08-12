package com.example.library.httppackage;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * Created by tanyang on 2016/8/10.
 */
public class Item_http_library {
    private  static String result="";
    private AsyncHttpClient client;
    private AsyncHttpClient client2,client3;
    public Item_http_library() {
       client=new AsyncHttpClient();
        client2=new AsyncHttpClient();
        client3=new AsyncHttpClient();
    }
    public  void  http_item_home (JsonHttpResponseHandler handler){
        try {
            String  url= Http.Product;
            client.get(url,handler);
        }catch (Exception e){e.printStackTrace();}
    }
    public  void http_cityname(JsonHttpResponseHandler handler){
        try{
            Log.e("tag","shuju545555555afafaf");
            String url=Http.city_interface;
            client2.get(url,handler);
            Log.e("tag","数据545555555afafaf"+url);
        }catch (Exception e){e.printStackTrace();}
    }
    public  void http_classify(JsonHttpResponseHandler handler){
        try{
            String a=Http.superclass_interface;
            client3.get(a,handler);
        }catch (Exception e){e.printStackTrace();}
    }
}
