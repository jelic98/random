package ecloga.com.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lazar on 24.01.2015.
 */

public class InfoActivity extends Activity {

    TextView tvAbout, tvInfo;
    ImageView ivBack, ivLogo;
    Intent first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvAbout = (TextView) findViewById(R.id.tvAbout);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first = new Intent(InfoActivity.this, MainActivity.class);

                startActivity(first);

                finish();
            }
        });
    }
}
