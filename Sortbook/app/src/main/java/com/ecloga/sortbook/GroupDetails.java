package com.ecloga.sortbook;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class GroupDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_details);

        overridePendingTransition(R.anim.popup_open, R.anim.popup_close);

        setWindowSize();
    }

    private void setWindowSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
