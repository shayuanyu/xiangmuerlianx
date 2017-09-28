package com.bawei.day3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.bawei.day3.R.id.btn;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView textView;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonListener b = new ButtonListener();
        mButton = (Button)findViewById(btn);
        textView = (TextView) findViewById(R.id.textview);
        mButton.setOnClickListener(b);
        mButton.setOnTouchListener(b);
        mButton.setBackgroundResource(R.color.zise);
       mButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            int num = (int) (Math.random()*10+20);
               textView.setText(String.valueOf(num));
           }
       });
    }

    class ButtonListener implements View.OnClickListener, View.OnTouchListener {

        public void onClick(View v) {
            if(v.getId() == btn){
            }
        }

        public boolean onTouch(View v, MotionEvent event) {
            if(v.getId() == btn){
                if(event.getAction() == MotionEvent.ACTION_UP){
                    mButton.setBackgroundResource(R.color.green);
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mButton.setBackgroundResource(R.color.yellow);
                }
            }
            return false;
        }

    }


}
