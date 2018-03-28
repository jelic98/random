package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAccount extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        int undone = Integer.parseInt(String.valueOf(Parameters.taskUndone));
        int done = Integer.parseInt(String.valueOf(Parameters.taskDone));
        int total = undone + done;
        int complete;

        if(total != 0) {
            complete = (done * 100) / total;
        }else {
            complete = 0;
        }

        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setTypeface(typeFace);

        TextView tvTotalTitle = (TextView) findViewById(R.id.tvTotalTitle);
        TextView tvDoneTitle = (TextView) findViewById(R.id.tvDoneTitle);
        TextView tvCompleteTitle = (TextView) findViewById(R.id.tvCompleteTitle);

        tvTotalTitle.setTypeface(typeFace);
        tvDoneTitle.setTypeface(typeFace);
        tvCompleteTitle.setTypeface(typeFace);

        TextView tvTotal = (TextView) findViewById(R.id.tvTotal);
        TextView tvDone = (TextView) findViewById(R.id.tvDone);
        TextView tvComplete = (TextView) findViewById(R.id.tvComplete);

        tvTotal.setTypeface(typeFace);
        tvDone.setTypeface(typeFace);
        tvComplete.setTypeface(typeFace);

        tvTotal.setText(String.valueOf(total));
        tvDone.setText(String.valueOf(done));
        tvComplete.setText(String.valueOf(complete) + "%");

        CircleImageView civProfile = (CircleImageView) findViewById(R.id.civProfile);
        civProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                Vibrator vibe = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(50);
            }
        });

        TextView tvLogout = (TextView) findViewById(R.id.tvLogout);
        tvLogout.setTypeface(typeFace);

        ImageView ivLogout = (ImageView) findViewById(R.id.ivLogout);
        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                /*
                Do the log out stuff
                 */
            }
        });
    }
}
