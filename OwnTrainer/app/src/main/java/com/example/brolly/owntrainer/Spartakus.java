package com.example.brolly.owntrainer;

import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class Spartakus extends Activity {


    Button bStart,bPause;
    TextView vScore,textView;
    ImageView imageView;

    final CounterClass timer60 = new CounterClass(60000,1000);
    final CounterClass timer15 = new CounterClass(15000,1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spartakus);

       if( Build.VERSION.SDK_INT >= 11)
       {
           ActionBar bar = getActionBar();
           bar.hide();

       }




        bStart = (Button)findViewById(R.id.button);
        bPause = (Button)findViewById(R.id.button2);
        vScore = (TextView)findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView2);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spartakus, menu);
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

    public void pause(View view) {
        timer15.cancel();
        timer60.cancel();

    }

    public void start(View view) {
        int count =1;

        vScore.setText("Ready?");
        timer15.start();

        if(textView.getText().toString().equalsIgnoreCase("00"))
        {
            
            vScore.setText("Seria "+count);
            timer60.start();
        }

        if(vScore.getText().toString().startsWith("Break"))
        {
            vScore.setText("Break "+count);
            timer15.start();
        }
        count++;



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
            textView.setText("00");
        }


    }
}
