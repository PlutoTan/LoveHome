package com.example.lovehome.adapterpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.library.entitypackage.Entity;
import com.example.lovehome.MainActivity;
import com.example.lovehome.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tanyang on 2016/8/10.
 */
public class Home_Product_adapter extends BaseAdapter{
    private Context context;
    private ArrayList<Entity> life;
    View views;
    public Home_Product_adapter(Context context, ArrayList<Entity> life) {
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
                convertView = LayoutInflater.from(context).inflate(R.layout.home_product_adapter_xml, null);
                holder = new ViewHolder();
             //   Log.e("TAG", "空的集合" + life);
                holder.product_imag = (ImageView) convertView.findViewById(R.id.adapter_imageview);
                holder.product_text_mincheng = (TextView) convertView.findViewById(R.id.adapter_titlename);
                holder.product_text_jiage = (TextView) convertView.findViewById(R.id.adapter_jiage);
                holder.product_text_didian = (TextView) convertView.findViewById(R.id.adapter_didian);
                holder.product_text_shijian = (TextView) convertView.findViewById(R.id.adapter_shijina);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Entity a = life.get(position);
            Picasso.with(context).load(a.getImgUrlList().get(0).getImg_url().toString()).into(holder.product_imag);
            holder.product_text_mincheng.setText(a.getMerchant_name());
            holder.product_text_jiage.setText(a.getPer_capita_consumption()+"/人");
            holder.product_text_didian.setText(a.getBusiness_location());
            holder.product_text_shijian.setText(a.getOpening_time() + "-" + a.getClosing_time());

        }
        return convertView;
    }
  static class ViewHolder{
      ImageView product_imag;
      TextView product_text_mincheng;
      TextView product_text_jiage;
      TextView product_text_didian;
      TextView product_text_shijian;
  }

}


