package com.example.library.jsonpackage;

import com.example.library.entitypackage.Entity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by tanyang on 2016/8/10.
 */
public class Json {
    //首页的数据填充
    public  static ArrayList<Entity> home_listview_json (JSONObject jsonObject) {
       ArrayList<Entity> home_listview_arraylist=null;
         try{
             String status=jsonObject.getString("msg");
             if(status.equals("success")){
                 JSONArray r=jsonObject.getJSONArray("list");
                // for (int i=0;i<r.length();i++) {
                     JSONObject jo = r.getJSONObject(0);
                     String a=jo.getString("0");
                     Gson gson=new Gson();
                     home_listview_arraylist=gson.fromJson(a,new TypeToken<ArrayList<Entity>>(){}.getType());
                 }
            // }
         }catch (Exception e){e.printStackTrace();}
        return home_listview_arraylist;
    }

}
