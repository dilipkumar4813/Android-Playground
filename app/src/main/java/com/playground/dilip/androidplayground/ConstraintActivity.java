package com.playground.dilip.androidplayground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ConstraintActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        ImageView ivInterpolatorActivity = (ImageView) findViewById(R.id.image_interpolator_activity);
        ivInterpolatorActivity.setOnClickListener(this);

        ImageView ivObjectAnimator = (ImageView) findViewById(R.id.image_object_animator);
        ivObjectAnimator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_interpolator_activity:
                Intent interpolatorIntent = new Intent(this, InterpolatorActivity.class);
                startActivity(interpolatorIntent);
                break;
            case R.id.image_object_animator:
                Intent intentObjectAnimatorActivity = new Intent(this, ObjectAnimatorActivity.class);
                startActivity(intentObjectAnimatorActivity);
                break;
        }
    }
}
