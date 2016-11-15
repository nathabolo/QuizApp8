package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tools.RobotsBackground;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get values from the text views

        final TextView startTest = (TextView) findViewById(R.id.robotics_background);

        //Set the values to OnclickListener

        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create a new intent (@Link startTest activity)

                Intent roboticBacgroundIntent = new Intent(MainActivity.this,

                        RobotsBackground.class);
                //Start a new activity

                startActivity(roboticBacgroundIntent);

            }
        });
    }

    //Get action bar into an activity

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

}


