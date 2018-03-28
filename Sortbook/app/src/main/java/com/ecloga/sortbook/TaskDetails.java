package com.ecloga.sortbook;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;

public class TaskDetails extends Activity {

    String title, date, group, favourite, time, sDate, reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_details);

        overridePendingTransition(R.anim.popup_open, R.anim.popup_close);

        Typeface typeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/josefin_slab_regular.ttf");

        setWindowSize();

        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setTypeface(typeFace);

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setTypeface(typeFace);

        TextView tvGroup = (TextView) findViewById(R.id.tvGroup);
        tvGroup.setTypeface(typeFace);

        TextView tvFavourite = (TextView) findViewById(R.id.tvFavourite);
        tvFavourite.setTypeface(typeFace);

        TextView tvTime = (TextView) findViewById(R.id.tvTime);
        tvTime.setTypeface(typeFace);

        TextView tvReminder = (TextView) findViewById(R.id.tvReminder);
        tvReminder.setTypeface(typeFace);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            title = extras.getString("title");
            sDate = extras.getString("date");
            group = extras.getString("group");
            favourite = extras.getString("favourite");
            reminder = extras.getString("reminder");
        }

        TextView tvNameText = (TextView) findViewById(R.id.tvNameText);
        tvNameText.setTypeface(typeFace);
        tvNameText.setText(title);

        TextView tvDateText = (TextView) findViewById(R.id.tvDateText);
        tvDateText.setTypeface(typeFace);

        date = sDate.substring(0, sDate.indexOf("@"));

        tvDateText.setText(date);

        TextView tvGroupText = (TextView) findViewById(R.id.tvGroupText);
        tvGroupText.setTypeface(typeFace);
        tvGroupText.setText(group);

        TextView tvFavouriteText = (TextView) findViewById(R.id.tvFavouriteText);
        tvFavouriteText.setTypeface(typeFace);
        tvFavouriteText.setText(favourite);

        TextView tvTimeText = (TextView) findViewById(R.id.tvTimeText);
        tvTimeText.setTypeface(typeFace);

        time = sDate.substring(sDate.indexOf("@") + 2);

        tvTimeText.setText(time);

        TextView tvReminderText = (TextView) findViewById(R.id.tvReminderText);
        tvReminderText.setTypeface(typeFace);
        tvReminderText.setText(reminder);

        ButtonFlat btnSave = (ButtonFlat) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDetails.this.finish();
            }
        });
    }

    private void setWindowSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
