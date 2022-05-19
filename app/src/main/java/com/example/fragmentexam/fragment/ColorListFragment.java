package com.example.fragmentexam.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {

    private OnColorSeletedListener mListener;

    public void setOnColorSelectedListener(OnColorSeletedListener listener) {
        mListener = listener;
    }

    public interface OnColorSeletedListener {
        void onColorSeleted(int color);
    }

    public ColorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context); // 호스트 액티비티의 인스턴스
//        try {
//            mListener = (OnColorSeletedListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(((Activity) context).getLocalClassName() + " 는 OnColorSeletedListener를 구현해야 합니다.");
//        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("red", "green", "blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch (colorString) {
            case "red":
                color = Color.RED;
                break;
            case "green":
                color = Color.GREEN;
                break;
            case "blue":
                color = Color.BLUE;
                break;
        }

        if (mListener != null) {
            mListener.onColorSeleted(color);
        }
    }
}