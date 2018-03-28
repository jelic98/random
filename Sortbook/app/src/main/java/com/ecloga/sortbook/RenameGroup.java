package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.gc.materialdesign.views.ButtonFlat;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RenameGroup extends Activity implements View.OnClickListener {

    int groupId;
    MaterialEditText etGroupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rename_group);

        Intent intent = getIntent();
        groupId = intent.getIntExtra("groupId", 0);

        etGroupName = (MaterialEditText) findViewById(R.id.etGroupName);

        setWindowSize();

        String newName = "";

        if(groupId == R.id.group_1) {
            newName = String.valueOf(Preferences.getDefaults("group_1_name"
                    , getApplicationContext()));
        }else if(groupId == R.id.group_2) {
            newName = String.valueOf(Preferences.getDefaults("group_2_name"
                    , getApplicationContext()));
        }else if(groupId == R.id.group_3) {
            newName = String.valueOf(Preferences.getDefaults("group_3_name"
                    , getApplicationContext()));
        }else if(groupId == R.id.group_4) {
            newName = String.valueOf(Preferences.getDefaults("group_4_name"
                    , getApplicationContext()));
        }else if(groupId == R.id.group_5) {
            newName = String.valueOf(Preferences.getDefaults("group_5_name"
                    , getApplicationContext()));
        }else if(groupId == R.id.group_6) {
            newName = String.valueOf(Preferences.getDefaults("group_6_name"
                    , getApplicationContext()));
        }

        etGroupName.setText(newName);

        ButtonFlat btnSave = (ButtonFlat) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        ButtonFlat btnCancel = (ButtonFlat) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RenameGroup.this.finish();
            }
        });
    }

    private void setWindowSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSave:
                if(groupId == R.id.group_1) {
                    Preferences.setDefaults("group_1_name", String.valueOf(etGroupName.getText())
                            , getApplicationContext());
                }else if(groupId == R.id.group_2) {
                    Preferences.setDefaults("group_2_name", String.valueOf(etGroupName.getText())
                            , getApplicationContext());
                }else if(groupId == R.id.group_3) {
                    Preferences.setDefaults("group_3_name", String.valueOf(etGroupName.getText())
                            , getApplicationContext());
                }else if(groupId == R.id.group_4) {
                    Preferences.setDefaults("group_4_name", String.valueOf(etGroupName.getText())
                            , getApplicationContext());
                }else if(groupId == R.id.group_5) {
                    Preferences.setDefaults("group_5_name", String.valueOf(etGroupName.getText())
                            , getApplicationContext());
                }else if(groupId == R.id.group_6) {
                    Preferences.setDefaults("group_6_name", String.valueOf(etGroupName.getText())
                            , getApplicationContext());
                }

                RenameGroup.this.finish();

                break;
            case R.id.btnCancel:
                RenameGroup.this.finish();

                break;
        }
    }
}
