package com.example.library.httppackage;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * Created by tanyang on 2016/8/10.
 */
public class Item_http_library {
    private  static String result="";
    private AsyncHttpClient client;

    public Item_http_library() {
       client=new AsyncHttpClient();
    }
    public  void  http_item_home (JsonHttpResponseHandler handler){
        try {
            String  url= Http.Product;
            client.get(url,handler);
        }catch (Exception e){e.printStackTrace();}

    }
}
