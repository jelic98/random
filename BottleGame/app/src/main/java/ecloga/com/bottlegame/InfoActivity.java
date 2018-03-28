package ecloga.com.bottlegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lazar on 05.01.2015.
 */
public class InfoActivity extends Activity{

    ImageView back;
    TextView about, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        back = (ImageView) findViewById(R.id.ivBack);
        about = (TextView) findViewById(R.id.tvAbout);
        info = (TextView) findViewById(R.id.tvInfo);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(InfoActivity.this, MainActivity.class);

                startActivity(intent);

            }
        });

    }
}
