package com.ecloga.sortbook;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.Utils;

public class Help extends Activity {

    ExpandableLayout el1, el2;
    RelativeLayout rl1, rl2;
    TextView tvTitle1, tvDescription1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setTypeface(typeFace);

        tvDescription1 = (TextView) findViewById(R.id.tvDescription1);
        tvDescription1.setTypeface(typeFace);

        rl1 = (RelativeLayout) findViewById(R.id.rl1);
        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                el1.toggle();
            }
        });

        el1 = (ExpandableLayout) findViewById(R.id.el1);
        el1.setInterpolator(Utils.createInterpolator(Utils.FAST_OUT_SLOW_IN_INTERPOLATOR));

        TextView tvTutorial = (TextView) findViewById(R.id.tvTutorial);
        tvTutorial.setTypeface(typeFace);

        ImageView ivTutorial = (ImageView) findViewById(R.id.ivTutorial);
        ivTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                /*
                Do the tutorial stuff
                 */
            }
        });

        TextView tvFeedback = (TextView) findViewById(R.id.tvFeedback);
        tvFeedback.setTypeface(typeFace);

        ImageView ivFeedback = (ImageView) findViewById(R.id.ivFeedback);
        ivFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                /*
                Do the feedback stuff
                 */
            }
        });
    }
}
