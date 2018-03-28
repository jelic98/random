package com.ecloga.sortbook;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Report extends Activity {

    MaterialEditText etTitle, etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        TextView tvHelp = (TextView) findViewById(R.id.tvHelp);
        tvHelp.setTypeface(typeFace);

        etTitle = (MaterialEditText) findViewById(R.id.etTtitle);
        etDescription = (MaterialEditText) findViewById(R.id.etDescription);

        etTitle.setTypeface(typeFace);
        etDescription.setTypeface(typeFace);

        TextView tvSend = (TextView) findViewById(R.id.tvSend);
        tvSend.setTypeface(typeFace);

        ImageView ivSend = (ImageView) findViewById(R.id.ivSend);
        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                String title = String.valueOf(etTitle.getText());

                if(title == null || title.isEmpty()) {
                    etTitle.setError("This field is required");

                    /*
                    Check MAX_CHARS(100) in etDescription
                     */
                }else {
                     /*
                    Do the send report stuff
                        +++ Popup window - "Thanks for helping!"
                    */

                    Report.this.finish();
                }
            }
        });
    }
}
