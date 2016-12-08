package com.playground.dilip.androidplayground.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.playground.dilip.androidplayground.R;

/**
 * Created by Dilip on 12/8/2016.
 */

public class FirstFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button buttonRssFeed = (Button) view.findViewById(R.id.button_rss);
        buttonRssFeed.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_rss:
                break;
        }
    }
}
