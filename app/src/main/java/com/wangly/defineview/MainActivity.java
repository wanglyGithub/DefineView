package com.wangly.defineview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wangly.defineview.view.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.defineView);
        circleProgressView.start();

    }
}
