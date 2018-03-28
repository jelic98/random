package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;

public class ChangeGroup extends Activity implements View.OnClickListener {

    String activator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_group);

        overridePendingTransition(R.anim.popup_open, R.anim.popup_close);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            activator = extras.getString("activator");
        }

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        setWindowSize();

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setTypeface(typeFace);

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setTypeface(typeFace);

        TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setTypeface(typeFace);

        TextView tv5 = (TextView) findViewById(R.id.tv5);
        tv5.setTypeface(typeFace);

        TextView tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setTypeface(typeFace);

        TextView tv6 = (TextView) findViewById(R.id.tv6);
        tv6.setTypeface(typeFace);

        LinearLayout group_1 = (LinearLayout) findViewById(R.id.group_1);
        group_1.setOnClickListener(this);

        LinearLayout group_2 = (LinearLayout) findViewById(R.id.group_2);
        group_2.setOnClickListener(this);

        LinearLayout group_3 = (LinearLayout) findViewById(R.id.group_3);
        group_3.setOnClickListener(this);

        LinearLayout group_4 = (LinearLayout) findViewById(R.id.group_4);
        group_4.setOnClickListener(this);

        LinearLayout group_5 = (LinearLayout) findViewById(R.id.group_5);
        group_5.setOnClickListener(this);

        LinearLayout group_6 = (LinearLayout) findViewById(R.id.group_6);
        group_6.setOnClickListener(this);

        ButtonFlat btnCancel = (ButtonFlat) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RecyclerItemClickAnimation(getApplicationContext(), v);
                ChangeGroup.this.finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(activator.equals("edit")) {
            Intent intent = new Intent();

            if(v.getId() == R.id.group_1) {
                intent.putExtra("group", "1");
            }else if(v.getId() == R.id.group_2) {
                intent.putExtra("group", "2");
            }else if(v.getId() == R.id.group_3) {
                intent.putExtra("group", "3");
            }else if(v.getId() == R.id.group_4) {
                intent.putExtra("group", "4");
            }else if(v.getId() == R.id.group_5) {
                intent.putExtra("group", "5");
            }else if(v.getId() == R.id.group_6) {
                intent.putExtra("group", "6");
            }

            setResult(RESULT_OK, intent);
        }else if(activator.equals("menu")) {
            if(v.getId() == R.id.group_1) {

            }else if(v.getId() == R.id.group_2) {

            }else if(v.getId() == R.id.group_3) {

            }else if(v.getId() == R.id.group_4) {

            }else if(v.getId() == R.id.group_5) {

            }else if(v.getId() == R.id.group_6) {

            }
        }

        ChangeGroup.this.finish();
    }

    private void setWindowSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
