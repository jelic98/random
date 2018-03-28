package ecloga.com.bmicalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener{

    EditText etHeight, etWeight;
    Button bCalculate;
    RadioGroup rgSelect;
    RadioButton rbMetric, rbStandard;
    double dHeight, dWeight, dResult;
    Intent info, second;
    String sResult, sHeight, sWeight;
    boolean metricChecked;
    ImageView ivInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        bCalculate = (Button) findViewById(R.id.bCalculate);
        rgSelect = (RadioGroup) findViewById(R.id.rgSelect);
        rbMetric = (RadioButton) findViewById(R.id.rbMetric);
        rbStandard = (RadioButton) findViewById(R.id.rbStandard);
        ivInfo = (ImageView) findViewById(R.id.ivInfo);

        rgSelect.setOnCheckedChangeListener(this);

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    sHeight = etHeight.getText().toString();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                try{
                    sWeight = etWeight.getText().toString();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                if (sHeight.matches("") && sWeight.matches("")) {
                    Toast.makeText(MainActivity.this, "You have to enter your HEIGHT and WEIGHT", Toast.LENGTH_LONG).show();
                    return;
                }else{
                    if (sHeight.matches("")) {
                        Toast.makeText(MainActivity.this, "You have to enter your HEIGHT", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (sWeight.matches("")) {
                        Toast.makeText(MainActivity.this, "You have to enter your WEIGHT", Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                if (rgSelect.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "You have to select system of measurement", Toast.LENGTH_LONG).show();
                    return;
                }

                dHeight = Double.parseDouble(sHeight);

                dWeight = Double.parseDouble(sWeight);

                    if (!metricChecked) {
                        dResult = 703 * (dWeight / (144 * dHeight * dHeight));
                    } else {
                        dResult = dWeight / (dHeight * dHeight);
                    }

                    second = new Intent(MainActivity.this, SecondActivity.class);
                    second.putExtra("key_result", dResult);
                    startActivity(second);
            }
        });

        ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                info = new Intent(MainActivity.this, InfoActivity.class);

                startActivity(info);

                finish();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch(checkedId){

            case(R.id.rbMetric):

                metricChecked = true;

                break;

            case(R.id.rbStandard):

                metricChecked = false;

                break;
        }
    }
}