package com.bawei.day2;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView dianji;
    private TextView xianshi;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dianji.setText("http://www.baidu八维考试.com");
        //下划线
        dianji.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG );

        dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    webview.loadUrl("http://www.baidu.com");
            }
        });
    }

    private void initView() {
        dianji = (TextView) findViewById(R.id.dianji);
        xianshi = (TextView) findViewById(R.id.xianshi);
        webview = (WebView) findViewById(R.id.webview);
    }
}
