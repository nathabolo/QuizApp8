package com.android.tools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.quizapp.R;

public class RobotsBackground extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //A code for back button

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_robots_background);

        //Get values from the text views

        final TextView robotsHistory = (TextView) findViewById(R.id.history);

        //Set the values to OnclickListener

        robotsHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create a new intent (@Link startTest activity)

                Intent historyIntent = new Intent(RobotsBackground.this,

                        RobotsHistory.class);

                //Start a new activity

                startActivity(historyIntent);

                //Get values from the text views

                final TextView mathsRobotics = (TextView) findViewById(R.id.maths_robots);

                //Set the values to OnclickListener

                mathsRobotics.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Create a new intent (@Link startTest activity)

                        Intent mathsIntent = new Intent(RobotsBackground.this,

                                RobotsAndmaths.class);
                        //Start a new activity

                        startActivity(mathsIntent);


                        //Get values from the text views

                        final TextView techRobotics = (TextView) findViewById(R.id.robots_tech);

                        //Set the values to OnclickListener

                        techRobotics.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                //Create a new intent (@Link startTest activity)

                                Intent techIntent = new Intent(RobotsBackground.this,

                                        RobotsAndTech.class);
                                //Start a new activity

                                startActivity(techIntent);


                                //Get values from the text views

                                final TextView robotsSociety = (TextView) findViewById(R.id.robots_society);

                                //Set the values to OnclickListener

                                robotsSociety.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        //Create a new intent (@Link startTest activity)

                                        Intent societyIntent = new Intent(RobotsBackground.this,

                                                RobotsAndSociety.class);
                                        //Start a new activity

                                        startActivity(societyIntent);

                                    }

                                });


                            }

                        });


                    }

                });


            }

        });

    }

    //Get action bar into an activity

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
