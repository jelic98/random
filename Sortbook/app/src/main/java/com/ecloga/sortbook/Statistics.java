package com.ecloga.sortbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Statistics extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        int undone = Integer.parseInt(String.valueOf(Parameters.taskUndone));
        int done = Integer.parseInt(String.valueOf(Parameters.taskDone));
        int total = undone + done;
        double complete;

        if(total != 0) {
            complete = Double.valueOf((done * 100) / total);
        }else {
            complete = 0;
        }

        TextView tvTotal = (TextView) findViewById(R.id.tvTotal);
        TextView tvDone = (TextView) findViewById(R.id.tvDone);
        TextView tvComplete = (TextView) findViewById(R.id.tvComplete);

        tvTotal.setText(String.valueOf(total));
        tvDone.setText(String.valueOf(done));
        tvComplete.setText(String.valueOf(complete) + "%");
    }
}
