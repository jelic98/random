package example.lazar.com.lazar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.ImageView;
import android.widget.Button;
import android.view.Gravity;


/**
 * Created by Lazar on 03.01.2015.
 */
public class Vragolan extends Activity {

    ImageView grki;
    TextView score, tajmer;
    Button start;
    int counter;
    Display display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        counter = 0;

        Display display = getWindowManager().getDefaultDisplay();

        grki = (ImageView) findViewById(R.id.ivGrki);
        score = (TextView) findViewById(R.id.tvScore);
        start = (Button) findViewById(R.id.bStart);
        tajmer = (TextView) findViewById(R.id.tvTimer);

        grki.setVisibility(View.INVISIBLE);

        final int width = display.getWidth();
        final int height = display.getHeight();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start.setVisibility(View.INVISIBLE);

                grki.setVisibility(View.VISIBLE);

                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {

                        tajmer.setText(millisUntilFinished / 1000 + " sec");

                    }

                    public void onFinish() {

                        tajmer.setText("Time's Up!");
                        tajmer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                        grki.setVisibility(View.INVISIBLE);

                        score.setText("TOTAL: " + counter);
                        score.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

                        score.setTextSize(50);
                        tajmer.setTextSize(35);

                        start.setText("AGAIN");
                        start.setVisibility(View.VISIBLE);

                        start.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent again = getIntent();
                                startActivity(again);

                            }
                        });
                    }
                }.start();
            }
        });

        grki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                score.setText("Score: " + counter);

                Random pos = new Random();

                int x, y;

                x = width - 120;
                y = height - 150;

                grki.setX(pos.nextInt(x));
                grki.setY(pos.nextInt(y));

            }
        });
    }
}
