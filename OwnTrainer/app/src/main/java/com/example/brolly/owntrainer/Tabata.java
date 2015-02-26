package com.example.brolly.owntrainer;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class Tabata extends Activity {


    Button bStart,bPause;
    Chronometer stoper;
    TextView textView,textViewReady;
    long time=0;
    int count =1;
    boolean workout =false;


    final CounterClass timer20 = new CounterClass(20400,1000);
    final CounterClass timer10 = new CounterClass(10400,1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabata);


        if (Build.VERSION.SDK_INT >= 11)
        {
            ActionBar bar = getActionBar();
            bar.hide();
        }

        textViewReady = (TextView)findViewById(R.id.textView);
        textView = (TextView)findViewById(R.id.textView2);
        bStart =(Button)findViewById(R.id.bStart);
        bPause = (Button)findViewById(R.id.bPasuse);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tabata, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    void tabataStart1()
    {

            textViewReady.setText("Prepare Yourself");
            timer10.start();

            Thread thread = new Thread() {

                public void run() {
                    try {

                        sleep(10300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        timer10.cancel();
                        tabataStart2();

                    }
                }
            };
            thread.start();

    }


    void tabataStart2()
    {

        textViewReady.setText("GO!");
        timer20.start();

        Thread thread = new Thread() {

            public void run() {
                try {

                    sleep(20300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    timer20.cancel();
                    tabataStart1();

                }
            }
        };
        thread.start();

    }

    void tabata()
    {
        tabataStart1();
        Thread thread = new Thread(){

            public void run()
            {
                try {

                    sleep(30300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    tabataStart1();

                }
            }

        };

        thread.start();
    }



    public void startStoper(View view)
    {
        //tabataStart1();
            tabata();
    }



    public void pauseStoper(View view) {
        timer20.cancel();
        timer10.cancel();
    }



    public class CounterClass extends CountDownTimer
    {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onTick(long milisUtilFinished)
        {
            long milis = milisUtilFinished;
            String hms = String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(milis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis)));
            textView.setText(hms);
        }
        public void onFinish()
        {

                textViewReady.setText("Done!");


        }
    }




}


