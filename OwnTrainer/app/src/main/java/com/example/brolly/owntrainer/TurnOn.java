package com.example.brolly.owntrainer;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;


public class TurnOn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_on);

        if(Build.VERSION.SDK_INT >= 11)
        {
            ActionBar bar = getActionBar();
            bar.hide();
        }

        // tworze nowy watek
        Thread thread = new Thread()
        {
            public void run()
            {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(".MyMenu");
                    startActivity(intent);

                }
            }
        };


        thread.start();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();  // zawsze wywołuje superklasę

        // zatrzymuje metodę śledzącą aktywność uruchomioną poprzez metodę onCreate()
        android.os.Debug.stopMethodTracing();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.turn_on, menu);
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
}
