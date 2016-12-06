package com.playground.dilip.androidplayground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView ivInterpolatoreImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        ivInterpolatoreImage = (ImageView) findViewById(R.id.image_interpolator);

        Button button_bounce = (Button) findViewById(R.id.button_bounce);
        button_bounce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_bounce:
                Animation animation = AnimationUtils.loadAnimation(this,R.anim.interpolator_bounce);
                ivInterpolatoreImage.startAnimation(animation);
                break;
        }
    }
}
