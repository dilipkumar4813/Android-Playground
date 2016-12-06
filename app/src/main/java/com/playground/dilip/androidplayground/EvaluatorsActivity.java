package com.playground.dilip.androidplayground;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.RectEvaluator;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class EvaluatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluators);

        ImageView ivArgbEvaluators = (ImageView) findViewById(R.id.image_argb_evaluator);

        //Implementing ARGB Evaluator in android using the ofObject method in ObjectAnimator Class
        ObjectAnimator argbEvaluator = ObjectAnimator.ofObject(ivArgbEvaluators, "backgroundColor", new ArgbEvaluator(), Color.CYAN, Color.MAGENTA);
        argbEvaluator.setDuration(5000);
        argbEvaluator.start();

        //Implementing RECT Evaluator in android
        ImageView ivRectEvaluators = (ImageView) findViewById(R.id.image_rect_evaluator);

        Rect local = new Rect();
        ivRectEvaluators.getLocalVisibleRect(local);

        Rect from = new Rect(local);
        Rect to = new Rect(local);

        from.right = from.left + local.width() / 4;
        from.bottom = from.top + local.height() / 2;

        to.left = to.right - local.width() / 2;
        to.top = to.bottom - local.height() / 4;

        ObjectAnimator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            anim = ObjectAnimator.ofObject(ivRectEvaluators,
                    "clipBounds",
                    new RectEvaluator(),
                    from, to);
        }

        if (anim != null) {
            anim.setDuration(2000);
            anim.start();
        }
    }
}
