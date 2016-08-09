package com.example.homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mine.Mine;
import com.example.release.Release;

public class Homepage extends AppCompatActivity {
    LinearLayout linearLayout_1;
    LinearLayout linearLayout_2;
    LinearLayout linearLayout_3;
    public void view(){
        linearLayout_1 =(LinearLayout)findViewById(R.id.util_layoutbutton_1);
        linearLayout_2 =(LinearLayout)findViewById(R.id.util_layoutbutton_2);
        linearLayout_3 =(LinearLayout)findViewById(R.id.util_layoutbutton_3);
        linearLayout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        linearLayout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Homepage.this, Release.class);
                startActivity(a);
            }
        });
        linearLayout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Homepage.this, Mine.class);
                startActivity(a);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        view();
    }
}
