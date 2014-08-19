package com.selftracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TimeForVisit extends Activity{

	Button thirty, fortyfive,onehour;
	Preferences p = new Preferences(TimeForVisit.this);
	@Override
	protected void onCreate(Bundle timeForVisit) {
		// TODO Auto-generated method stub
		super.onCreate(timeForVisit);
		setContentView(R.layout.time_for_visit);
		thirty = (Button)findViewById(R.id.button1);
        thirty.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 p.setcounter(30);
				TimeForVisit.this.finish();				
			}
		});
        fortyfive = (Button)findViewById(R.id.button2);
        fortyfive.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				p.setcounter(45);
				TimeForVisit.this.finish();
			}
		});
        onehour = (Button)findViewById(R.id.button3);
        onehour.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				p.setcounter(60);
				TimeForVisit.this.finish();	
			}
		});
	}
}
