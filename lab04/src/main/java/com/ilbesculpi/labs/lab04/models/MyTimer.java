package com.ilbesculpi.labs.lab04.models;


import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

    private int elapsedTime;
    private Timer timer;
    private int timeInterval = 1000;
    private TimerTask task;
    private Handler handler;
    private boolean isRunning = false;

    public MyTimer(Handler handler) {
        this(0, handler);
    }

    public MyTimer(int startTime, Handler handler) {
        elapsedTime = startTime;
        this.handler = handler;
    }

    public void start() {

        task = new TimerTask() {
            @Override
            public void run() {
                elapsedTime += 1;
                handler.obtainMessage(1)
                        .sendToTarget();
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, timeInterval);
        isRunning = true;
    }

    public void pause() {
        if( timer != null ) {
            timer.cancel();
            timer.purge();
        }
        isRunning = false;
    }

    public void resume() {
        if( !isRunning) {
            start();
        }
    }

    public void stop() {
        pause();
        elapsedTime = 0;
    }

    public void reset() {
        stop();
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public String getTime() {
        if( elapsedTime < 10 ) {
            return "0" + elapsedTime;
        }
        return "" + elapsedTime;
    }

}
