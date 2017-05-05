package com.wangly.defineview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wangly.defineview.view.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.defineView);
        circleProgressView.start();

    }

    public void branch(){
        Log.i("TAG","---创建分支---");
        Log.i("TAG","---创建分支---");
        Log.i("TAG","---创建分支---");
        Log.i("TAG","---创建分支---");
        Log.i("TAG","---创建分支---");

    }
}
