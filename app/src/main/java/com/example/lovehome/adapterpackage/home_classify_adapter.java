package com.example.lovehome.adapterpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lovehome.R;

/**
 *
 */
public class Home_Classify_Adapter extends BaseAdapter{
    private Context context;
    private int a[];
    private  String b[];

    public Home_Classify_Adapter(int[] a,String b[], Context context) {
        this.a = a;
        this.context = context;
        this.b=b;
    }

    @Override
    public int getCount() {
        return a.length;
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
        ViewHolder holder=null;
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.home_classify_gridview_layout,null);
            holder=new ViewHolder();
            holder.home_gradview_img=(ImageView)view.findViewById(R.id.home_classify_gridview_imageview);
            holder.home_gradview_text=(TextView)view.findViewById(R.id.home_classify_gridview_textview);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
                 holder.home_gradview_img.setImageResource(a[i]);
                 holder.home_gradview_text.setText(b[i]);
        return view;
    }
    static  class ViewHolder{
        ImageView home_gradview_img;
        TextView home_gradview_text;
    }
}
