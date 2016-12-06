package com.playground.dilip.androidplayground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivInterpolatorImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        ivInterpolatorImage = (ImageView) findViewById(R.id.image_interpolator);

        Button buttonBounce = (Button) findViewById(R.id.button_bounce);
        buttonBounce.setOnClickListener(this);

        Button buttonAccelerate = (Button) findViewById(R.id.button_accelerate);
        buttonAccelerate.setOnClickListener(this);

        Button buttonDecelerate = (Button) findViewById(R.id.button_decelerate);
        buttonDecelerate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_bounce:
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.interpolator_bounce);
                ivInterpolatorImage.startAnimation(animation);
                break;
            case R.id.button_accelerate:
                Animation animationAccelerate = AnimationUtils.loadAnimation(this, R.anim.interpolator_accelerate);
                ivInterpolatorImage.startAnimation(animationAccelerate);
                break;
            case R.id.button_decelerate:
                Animation animationDecelerate = AnimationUtils.loadAnimation(this, R.anim.interpolator_accelerate);
                ivInterpolatorImage.startAnimation(animationDecelerate);
                break;
        }
    }
}
