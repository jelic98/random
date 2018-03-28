package example.lazar.com.lazar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class OpenedClass extends Activity implements RadioGroup.OnCheckedChangeListener{

    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread, setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvAnswer);
        returnData = (Button) findViewById(R.id.bReturn);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswers);

        returnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent person = new Intent();
                Bundle backpack = new Bundle();
                backpack.putString("answer", setData);
                person.putExtras(backpack);
                setResult(RESULT_OK, person);
                finish();
            }
        });
        selectionList.setOnCheckedChangeListener(this);
        //Bundle gotBasket = getIntent().getExtras();
        //gotBread = gotBasket.getString("key");
        //question.setText(gotBread);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.rbCrazy:
                    setData = "Probably right!";
                    break;

                case R.id.rbSexy:
                    setData = "Definitely right!";
                    break;

                case R.id.rbBoth:
                    setData = "Spot On!";
                    break;
            }
            test.setText(setData);
    }
}
