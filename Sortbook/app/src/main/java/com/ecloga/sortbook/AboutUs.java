package com.ecloga.sortbook;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;

public class AboutUs extends Activity {

    ExpandableLayout el1, el2;
    RelativeLayout rl1, rl2;
    TextView tvTitle1, tvDescription1, tvTitle2, tvDescription2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setTypeface(typeFace);

        tvDescription1 = (TextView) findViewById(R.id.tvDescription1);
        tvDescription1.setTypeface(typeFace);

        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        tvTitle2.setTypeface(typeFace);

        tvDescription2 = (TextView) findViewById(R.id.tvDescription2);
        tvDescription2.setTypeface(typeFace);

        rl1 = (RelativeLayout) findViewById(R.id.rl1);
        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                el1.toggle();
            }
        });

        rl2 = (RelativeLayout) findViewById(R.id.rl2);
        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                el2.toggle();
            }
        });

        el1 = (ExpandableLayout) findViewById(R.id.el1);
        el1.setInterpolator(Utils.createInterpolator(Utils.FAST_OUT_SLOW_IN_INTERPOLATOR));

        el2 = (ExpandableLayout) findViewById(R.id.el2);
        el2.setInterpolator(Utils.createInterpolator(Utils.FAST_OUT_SLOW_IN_INTERPOLATOR));
    }
}
