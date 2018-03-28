package example.lazar.com.lazar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import example.lazar.com.lazar.R;

public class Data extends Activity implements View.OnClickListener {

    Button start, startFor;
    EditText sendEt;
    TextView gotAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialize();
    }

    public void initialize() {
        start = (Button) findViewById(R.id.bSA);
        startFor = (Button) findViewById(R.id.bSAFR);
        sendEt = (EditText) findViewById(R.id.etSend);
        gotAnswer = (TextView) findViewById(R.id.tvGot);

        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle basket = data.getExtras();
            String s = basket.getString("answer");
            gotAnswer.setText(s);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bSA:
                String bread = sendEt.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key", bread);
                Intent a = new Intent(Data.this, OpenedClass.class);
                a.putExtras(basket);
                startActivity(a);
                break;

            case R.id.bSAFR:
                Intent i = new Intent(Data.this, OpenedClass.class);
                startActivityForResult(i, 0);
                break;
        }
    }
}
