package com.example.homepage.adapterpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.homepage.R;
import com.example.library.entitypackage.ClassifyONE;
import com.example.library.entitypackage.ClassifyTWO;

import java.util.ArrayList;

/**
 * Created by tanyang on 2016/8/12.
 */
public class Home_pop_adapter_2 extends BaseAdapter{
    private Context context;
    private ArrayList<ClassifyONE> life;
    private ArrayList<ClassifyTWO> twwo;
    View views;
    public Home_pop_adapter_2(Context context, ArrayList<ClassifyONE> life) {
        this.context=context;
        this.life=life;
        if (life==null){
            Log.e("TAG","空的集合");
            return;
        }
    }

    @Override
    public int getCount() {
        Log.v("TAG","空的");
        return life.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(life!=null) {
            //  Log.e("tag", "有没有");
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.baseadapter_layout, null);
                holder = new ViewHolder();
                //   Log.e("TAG", "空的集合" + life);
                holder.pop_text_da=(TextView) convertView.findViewById(R.id.classify_popu_class1_text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
           // twwo.addAll(life.get(position).getChildCategoryList())
            //holder.pop_text_da.setText(life.get(.toString());

        }
        return convertView;
    }
    static class ViewHolder{
        TextView pop_text_da;
    }

}
