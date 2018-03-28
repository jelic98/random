package ecloga.com.bottlegame;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Lazar on 05.01.2015.
 */
public class SplashActivity extends Activity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(SplashActivity.this, R.raw.splashsound);
        ourSong.start();
        Thread timer = new Thread(){
            public void run() {
                try{
                    sleep(3500);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } finally{
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                    startActivity(intent);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();
    }
}
