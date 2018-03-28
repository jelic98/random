package ecloga.com.bottlegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import java.util.Random;


public class MainActivity extends Activity {

    ImageView spin, bottle, info;
    private boolean isClick;
    int begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = (ImageView) findViewById(R.id.ivSpin);
        bottle = (ImageView) findViewById(R.id.ivBottle);
        info = (ImageView) findViewById(R.id.ivInfo);

        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int angle = new Random().nextInt(3600 - 360) + 360;
                float pivot_x, pivot_y;

                bottle.setPivotX(bottle.getWidth() / 2);
                bottle.setPivotY(bottle.getHeight() / 2);

                pivot_x = bottle.getPivotX();
                pivot_y = bottle.getPivotY();

                final Animation animRotate = new RotateAnimation(begin, angle, pivot_x, pivot_y);
                animRotate.setDuration(2500);
                animRotate.setRepeatCount(0);
                animRotate.setStartOffset(361);
                animRotate.setRepeatMode(Animation.REVERSE);
                animRotate.setFillEnabled(true);
                animRotate.setFillAfter(true);

                bottle.startAnimation(animRotate);

                isClick=true;

                if(isClick) {
                    begin = angle;
                }else{
                    begin = 361;
                }

            }

        });

        info.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, InfoActivity.class);

                startActivity(intent);

                }
            }
        );
    }
}
