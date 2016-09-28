package com.ilbesculpi.labs.lab04;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ilbesculpi.labs.lab04.models.MyTimer;

public class TimerActivity extends AppCompatActivity {

    public static final String TAG = "TIMER";

    private TextView labelTimer;
    private MyTimer timer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timer);

        Log.d(TAG, "onCreate()");

        labelTimer = (TextView) findViewById(R.id.label_timer);

        handler = new Handler() {
            public void handleMessage(Message msg) {
                displayTime(timer.getTime());
            }
        };

        timer = new MyTimer(handler);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        Log.d(TAG, "onSaveInstanceState()");
        state.putInt("elapsedTime", timer.getElapsedTime());
        state.putBoolean("isRunning", timer.isRunning());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState()");
        displayTime(timer.getTime());

        int elapsedTime = savedInstanceState.getInt("elapsedTime");
        timer = new MyTimer(elapsedTime, handler);
        displayTime(timer.getTime());

        boolean isTimerRunning = savedInstanceState.getBoolean("isRunning");
        if( isTimerRunning ) {
            timer.start();
        }
    }

    public void toggleTimer(View view) {
        if( timer.isRunning() ) {
            timer.pause();
        }
        else {
            timer.resume();
        }
    }

    public void startTimer() {
        timer.start();
    }

    public void pauseTimer() {
        timer.pause();
    }

    public void resetTimer(View view) {
        timer.reset();
        displayTime("00");
    }

    public void displayTime(String time) {
        labelTimer.setText(time);
    }

}
