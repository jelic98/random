package example.lazar.com.lazar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import example.lazar.com.lazar.R;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lazar on 10.01.2015.
 */

public class Camera extends Activity implements View.OnClickListener{

    ImageView iv;
    Button b;
    ImageButton ib;
    Intent i;
    final static int cameraData = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        iv = (ImageView) findViewById(R.id.ivReturnedPic);
        b = (Button) findViewById(R.id.bSetWallpaper);
        ib = (ImageButton) findViewById(R.id.ibTakePic);
        InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
        bmp = BitmapFactory.decodeStream(is);

        b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSetWallpaper:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ibTakePic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
        }
    }
}
