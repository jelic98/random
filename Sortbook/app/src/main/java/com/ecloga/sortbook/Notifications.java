package com.ecloga.sortbook;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Notifications extends Activity {

    int counter0, counter1, counter2, counter3, counter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        TextView tv0 = (TextView) findViewById(R.id.tv0);
        tv0.setTypeface(typeFace);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setTypeface(typeFace);

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setTypeface(typeFace);

        TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setTypeface(typeFace);

        TextView tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setTypeface(typeFace);

        RelativeLayout rl0 = (RelativeLayout) findViewById(R.id.rl0);
        rl0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter0++;

                RelativeLayout rl0 = (RelativeLayout) findViewById(R.id.rl0);
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                RelativeLayout rl2 = (RelativeLayout) findViewById(R.id.rl2);
                RelativeLayout rl3 = (RelativeLayout) findViewById(R.id.rl3);

                ImageView indicator0 = (ImageView) findViewById(R.id.indicator0);
                ImageView indicator1 = (ImageView) findViewById(R.id.indicator1);
                ImageView indicator2 = (ImageView) findViewById(R.id.indicator2);
                ImageView indicator3 = (ImageView) findViewById(R.id.indicator3);

                if(counter0 % 2 == 0) {
                    Preferences.setDefaults("notifications", "true", getApplicationContext());
                    Preferences.setDefaults("sound", "true", getApplicationContext());
                    Preferences.setDefaults("vibration", "true", getApplicationContext());
                    Preferences.setDefaults("light", "true", getApplicationContext());

                    rl0.setBackgroundColor(getResources().getColor(R.color.primary));
                    indicator0.setImageResource(R.drawable.done_menu);

                    rl1.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                    indicator1.setImageResource(R.drawable.done_menu);

                    rl2.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                    indicator2.setImageResource(R.drawable.done_menu);

                    rl3.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                    indicator3.setImageResource(R.drawable.done_menu);
                }else {
                    Preferences.setDefaults("notifications", "false", getApplicationContext());
                    Preferences.setDefaults("sound", "false", getApplicationContext());
                    Preferences.setDefaults("vibration", "false", getApplicationContext());
                    Preferences.setDefaults("light", "false", getApplicationContext());

                    rl0.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator0.setImageResource(R.drawable.menu_delete);

                    rl1.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator1.setImageResource(R.drawable.menu_delete);

                    rl2.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator2.setImageResource(R.drawable.menu_delete);

                    rl3.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator3.setImageResource(R.drawable.menu_delete);
                }
            }
        });

        RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;

                ImageView indicator1 = (ImageView) findViewById(R.id.indicator1);

                if(counter1 % 2 == 0) {
                    Preferences.setDefaults("sound", "true", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                    indicator1.setImageResource(R.drawable.done_menu);
                }else {
                    Preferences.setDefaults("sound", "false", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator1.setImageResource(R.drawable.menu_delete);
                }
            }
        });

        RelativeLayout rl2 = (RelativeLayout) findViewById(R.id.rl2);
        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;

                ImageView indicator2 = (ImageView) findViewById(R.id.indicator2);

                if(counter2 % 2 == 0) {
                    Preferences.setDefaults("vibration", "true", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                    indicator2.setImageResource(R.drawable.done_menu);
                }else {
                    Preferences.setDefaults("vibration", "false", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator2.setImageResource(R.drawable.menu_delete);
                }
            }
        });

        RelativeLayout rl3 = (RelativeLayout) findViewById(R.id.rl3);
        rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;

                ImageView indicator3 = (ImageView) findViewById(R.id.indicator3);

                if(counter3 % 2 == 0) {
                    Preferences.setDefaults("light", "true", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                    indicator3.setImageResource(R.drawable.done_menu);
                }else {
                    Preferences.setDefaults("light", "false", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator3.setImageResource(R.drawable.menu_delete);
                }
            }
        });

        RelativeLayout rl4 = (RelativeLayout) findViewById(R.id.rl4);
        rl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter4++;

                ImageView indicator4 = (ImageView) findViewById(R.id.indicator4);

                if(counter4 % 2 == 0) {
                    Preferences.setDefaults("alarms", "true", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.primary));
                    indicator4.setImageResource(R.drawable.done_menu);
                }else {
                    Preferences.setDefaults("alarms", "false", getApplicationContext());

                    v.setBackgroundColor(getResources().getColor(R.color.accent));
                    indicator4.setImageResource(R.drawable.menu_delete);
                }
            }
        });
    }
}
