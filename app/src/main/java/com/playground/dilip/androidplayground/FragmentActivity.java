package com.playground.dilip.androidplayground;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playground.dilip.androidplayground.fragments.FirstFragment;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if(savedInstanceState==null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container,new FirstFragment());
            fragmentTransaction.commit();
        }else{
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        }
    }
}
