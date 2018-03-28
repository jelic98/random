package example.lazar.com.lazar;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Lazar on 02.01.2015.
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
                    sleep(5000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } finally{
                    Intent openMainActivity = new Intent("example.lazar.com.lazar.MENU");
                    startActivity(openMainActivity);
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
