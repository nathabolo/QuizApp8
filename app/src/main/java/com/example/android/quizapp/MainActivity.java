package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tools.RobotsBackground;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = new WebView(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        final Activity activity = this;
        mWebView.setWebViewClient(new WebViewClient(){

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }

        });
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

    TextView textView;
    int screenWidth, currentMsg;
    String[] msgArray = new String[] {"A robot is a machine one can manupulate to perform a variety of tasks!!!"};
    Animation.AnimationListener myAnimationListener;

    @Override
    protected void onStart() {
        super.onStart();

        textView = (TextView) findViewById(R.id.animation);

        // Get the screen width
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        screenWidth = size.x;

        // Set the first message
        textView.setText(msgArray[0]);
        // Measure the size of textView
        textView.measure(0,0);
        // Get textView width
        int textWidth = textView.getMeasuredWidth();
        // Create the animation
        Animation animation = new TranslateAnimation(-textWidth, screenWidth, 0, 0);
        animation.setDuration(8000);
        animation.setRepeatMode(Animation.ZORDER_TOP);
        animation.setRepeatCount(Animation.INFINITE);

        // Create the animation listener
        myAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // If out of messages loop from start
                if (++currentMsg >= msgArray.length)
                    currentMsg = 0;
                // Set the next msg
                textView.setText(msgArray[currentMsg]);
                // Measure the size of textView // this is important
                textView.measure(0, 0);
                // Get textView width
                int textWidth = textView.getMeasuredWidth();
                // Create the animation
                animation = new TranslateAnimation(-textWidth, screenWidth, 0, 0);

                animation.setDuration(8000);
                animation.setRepeatMode(Animation.ZORDER_TOP);
                animation.setRepeatCount(Animation.INFINITE);
                animation.setAnimationListener(myAnimationListener);
                textView.setAnimation(animation);
            }
        };
        animation.setAnimationListener(myAnimationListener);

        textView.setAnimation(animation);
    }

    //Get action bar into an activity

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_refresh){
           mWebView.reload();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



