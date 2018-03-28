package ecloga.com.bmicalculator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by Lazar on 24.01.2015.
 */

public class SecondActivity extends Activity {

    TextView tvResult;
    Button bAgain;
    ImageView ivInfo;
    Intent first;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = (TextView) findViewById(R.id.tvResult);
        bAgain = (Button) findViewById(R.id.bAgain);
        ivInfo = (ImageView) findViewById(R.id.ivInfo);

        double dResult = getIntent().getExtras().getDouble("key_result");

        if (dResult <= 17.5){
            tvResult.setTextColor(Color.RED);
        }

        if (dResult > 17.5 && dResult <= 18.5){
            tvResult.setTextColor(Color.YELLOW);
        }

        if (dResult > 18.5 && dResult <= 24.9){
            tvResult.setTextColor(Color.GREEN);
        }

        if (dResult > 24.9 && dResult <= 29.9){
            tvResult.setTextColor(Color.YELLOW);
        }

        if (dResult > 29.9 && dResult <= 34.9){
            tvResult.setTextColor(Color.rgb(255, 165, 0));
        }

        if (dResult > 34.9 && dResult<=39.9){
            tvResult.setTextColor(Color.RED);
        }

        if (dResult > 39.9){
            tvResult.setTextColor(Color.BLACK);
        }

        DecimalFormat precision = new DecimalFormat("##.#");
        String sResult = String.valueOf(precision.format(dResult));

        tvResult.setText("Your BMI is " + sResult);

        bAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(first);

            }
        });
    }
}
