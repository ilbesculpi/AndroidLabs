package com.ilbesculpi.labs.lab04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TickActivity extends AppCompatActivity {

    public static final String TAG = "TICK";

    private boolean stopped = false;

    TextView display;

    int ticks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick);
        display = (TextView) findViewById(R.id.label_display);
        startTick();
    }

    private void startTick() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if( stopped ) {
                    Log.wtf(TAG, "tick: " + ticks);
                }
                else {
                    Log.d(TAG, "tick: " + ticks);
                }

                TickActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        display.setText("tick: " + ticks + " ticks");
                    }
                });
                ticks++;
            }
        }, 0, 1000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stopped = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopped = true;
    }
}
