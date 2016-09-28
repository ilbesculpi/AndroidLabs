package com.ilbesculpi.labs.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "Main";

    private TextView display;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        display = (TextView) findViewById(R.id.label_display);
    }

    public void doSomething(View v) {
        Log.i(TAG, "button clicked");
        count++;
        display.setText("" + count);
    }

    public void launch(View v) {
        Log.i(TAG, "launch new activity");
        Intent intent = new Intent();
        intent.setClass(this, TickActivity.class);
        startActivity(intent);
    }

}
