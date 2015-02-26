package com.example.brolly.owntrainer;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyMenu extends Activity {


    Button bTabata,bMuscle,bSpartacus,bCardio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(Build.VERSION.SDK_INT >= 11)
        {
            ActionBar bar = getActionBar();
            bar.hide();
        }

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

    public void tabata(View view) {

        Intent intent = new Intent(this,Tabata.class);
        startActivity(intent);
    }

    public void muscleMass(View view) {
        Intent intent = new Intent(this,MuscleMass.class);
                startActivity(intent);
    }

    public void cardio(View view) {
    }

    public void spartakus(View view) {
        Intent intent = new Intent(this,Spartakus.class);
        startActivity(intent);
    }
}
