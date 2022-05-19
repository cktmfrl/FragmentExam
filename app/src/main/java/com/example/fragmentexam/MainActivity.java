package com.example.fragmentexam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fragmentexam.fragment.ColorFragment;
import com.example.fragmentexam.fragment.ColorListFragment;

public class MainActivity extends AppCompatActivity {// implements ColorListFragment.OnColorSeletedListener {

    //private ColorFragment mColorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mColorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);

        ColorListFragment colorListFragment = (ColorListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color_list);
        colorListFragment.setOnColorSelectedListener(new ColorListFragment.OnColorSeletedListener() {
            @Override
            public void onColorSeleted(int color) {
                ColorFragment colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);
                colorFragment.setColor(color);
            }
        });
    }

//    @Override
//    public void onColorSeleted(int color) {
//        mColorFragment.setColor(color);
//    }
}