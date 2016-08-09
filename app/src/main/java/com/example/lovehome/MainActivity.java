package com.example.lovehome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.homepage.HomepageActivity;
import com.example.mine.Mine;
import com.example.release.Release;

public class MainActivity extends Activity {
    LinearLayout linearLayout_1;
    LinearLayout linearLayout_2;
    LinearLayout linearLayout_3;
    public void view(){
        linearLayout_1 =(LinearLayout)findViewById(R.id.util_layoutbutton_1);
        linearLayout_2 =(LinearLayout)findViewById(R.id.util_layoutbutton_2);
        linearLayout_3 =(LinearLayout)findViewById(R.id.util_layoutbutton_3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view();
        Intent one = new Intent(this, HomepageActivity.class);
        startActivity(one);
        linearLayout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this , HomepageActivity.class);
                startActivity(a);
            }
        });
        linearLayout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this, Release.class);
                startActivity(a);
            }
        });
        linearLayout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this, Mine.class);
                startActivity(a);
            }
        });
    }
}
