package com.android.tools;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.quizapp.R;

public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score
		bar.setRating(score);
		switch (score)
		{
		case 1:
		case 2: t.setText("Opps, try again and keep learning");
		break;
		case 3:t.setText("Sorry!!! Keep on trying to achieve better results");
		case 4:t.setText("It seems like you read a lot about robotics");
		break;
		case 5:t.setText("Correct!!! Congraculations you are a pro");
		break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch (menuItem.getItemId()) {
			case android.R.id.button1:
				onBackPressed();
				return true;
			default:
				return super.onOptionsItemSelected(menuItem);
		}
	}

}
