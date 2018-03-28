package com.ecloga.randompath;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private ImageView ivObject;
    private float currentX, currentY, previousX, previousY;
    private int nextX, nextY;
    Paint paint = new Paint();
    private TextView tvCoords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCoords = (TextView) findViewById(R.id.tvCoords);

        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);

        final SurfaceView surface = (SurfaceView) findViewById(R.id.surface);

        surface.getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(final SurfaceHolder holder) {
                Display display = getWindowManager().getDefaultDisplay();
                final Point size = new Point();
                display.getSize(size);

                previousX = 0;
                previousY = 0;

                ivObject = (ImageView) findViewById(R.id.ivObject);

                Random random = new Random();
                int x = random.nextInt(size.x - ivObject.getWidth());
                int y = random.nextInt(size.y - ivObject.getHeight());

                ivObject.setX(x);
                ivObject.setY(y);

                new CountDownTimer(5000, 1) {
                    @Override
                    public void onFinish() {
                        start();
                    }

                    @Override
                    public void onTick(long l) {
                        currentX = ivObject.getX();
                        currentY = ivObject.getY();

                        if (currentX > size.x - ivObject.getWidth() - 1) {
                            previousX = currentX + 1;
                        } else if (currentX < 1) {
                            previousX = currentX - 1;
                        }

                        if (currentX < previousX) {
                            nextX = (int) currentX - 5;
                        } else if (currentX > previousX) {
                            nextX = (int) currentX + 5;
                        }

                        if (currentY > size.y - ivObject.getHeight() - 1) {
                            previousY = currentY + 1;
                        } else if (currentY < 1) {
                            previousY = currentY - 1;
                        }

                        if (currentY < previousY) {
                            nextY = (int) currentY - 5;
                        } else if (currentY > previousY) {
                            nextY = (int) currentY + 5;
                        }

                        previousX = currentX;
                        previousY = currentY;

                        ivObject.setX(nextX);
                        ivObject.setY(nextY);

                        tvCoords.setText("X: " + currentX + "\nY: " + currentY);

                        Canvas canvas = holder.lockCanvas();
                        canvas.drawLine(previousX, previousY, nextX, nextY, paint);
                        holder.unlockCanvasAndPost(canvas);
                    }
                }.start();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }
        });

    }
}
