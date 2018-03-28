package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ActionFailed extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_failed);

        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionFailed.this, ActionFailed.class));
                ActionFailed.this.finish();
            }
        });
    }
}
