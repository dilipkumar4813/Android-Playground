package com.playground.dilip.androidplayground.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.playground.dilip.androidplayground.R;

/**
 * Created by Dilip on 12/8/2016.
 */

public class RssFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rss, container, false);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
