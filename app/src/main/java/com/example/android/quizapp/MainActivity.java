package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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



