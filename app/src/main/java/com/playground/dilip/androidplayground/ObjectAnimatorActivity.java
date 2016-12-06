package com.playground.dilip.androidplayground;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        ivTest = (ImageView) findViewById(R.id.image_test);

        Button buttonRotate = (Button) findViewById(R.id.button_rotate);
        buttonRotate.setOnClickListener(this);

        Button buttonRotateY = (Button) findViewById(R.id.button_rotate_y);
        buttonRotateY.setOnClickListener(this);

        Button buttonRotateX = (Button) findViewById(R.id.button_rotate_x);
        buttonRotateX.setOnClickListener(this);

        Button buttonRotationXY = (Button) findViewById(R.id.button_rotation_xy);
        buttonRotationXY.setOnClickListener(this);

        Button buttonGrow = (Button) findViewById(R.id.button_grow);
        buttonGrow.setOnClickListener(this);

        Button buttonShrink = (Button) findViewById(R.id.button_shrink);
        buttonShrink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_rotate:
                ObjectAnimator rotate = ObjectAnimator.ofFloat(ivTest, "rotation", 360);
                rotate.setDuration(2000);
                rotate.start();
                break;
            case R.id.button_rotate_x:
                ObjectAnimator rotatex = ObjectAnimator.ofFloat(ivTest, "rotationX", 0.0f, 360);
                rotatex.setDuration(2000);
                rotatex.start();
                break;
            case R.id.button_rotate_y:
                ObjectAnimator rotatey = ObjectAnimator.ofFloat(ivTest, "rotationY", 0.0f, 360);
                rotatey.setDuration(2000);
                rotatey.start();
                break;
            case R.id.button_rotation_xy:
                ObjectAnimator rotateX1 = ObjectAnimator.ofFloat(ivTest, "rotationX", 0.0f, 360);
                ObjectAnimator rotateY1 = ObjectAnimator.ofFloat(ivTest, "rotationY", 0.0f, 360);
                AnimatorSet rotationXY = new AnimatorSet();
                rotationXY.playTogether(rotateX1, rotateY1);
                rotationXY.setDuration(2000);
                rotationXY.start();
                break;
            case R.id.button_grow:
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(ivTest, "scaleX", 2.0f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(ivTest, "scaleY", 2.0f);
                AnimatorSet scaleXY = new AnimatorSet();
                scaleXY.playTogether(scaleX, scaleY);
                scaleXY.setDuration(2000);
                scaleXY.start();
                break;
            case R.id.button_shrink:
                ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(ivTest, "scaleX", 1.0f);
                ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(ivTest, "scaleY", 1.0f);
                AnimatorSet scaleXY1 = new AnimatorSet();
                scaleXY1.playTogether(scaleX1, scaleY1);
                scaleXY1.setDuration(2000);
                scaleXY1.start();
                break;
        }
    }
}
