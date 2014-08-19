package com.selftracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorActivity extends Activity{
	
	Button settings,map,heartBeat,pulseRate,foodCourtVisits;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_doctor);
		 settings = (Button)findViewById(R.id.button1);
	        settings.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent set1 = new Intent("com.selftracker.Settings");
					startActivity(set1);
						
					
				}
			});
	        map = (Button)findViewById(R.id.button2);
	        map.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent set2 = new Intent("com.selftracker.MyMapLocationActivity");
					startActivity(set2);
						
				}
			});
	        heartBeat = (Button)findViewById(R.id.button3);
	        heartBeat.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent set2 = new Intent("com.selftracker.UnderConstruction");
					startActivity(set2);
						
				}
			});
	        pulseRate = (Button)findViewById(R.id.button4);
	        pulseRate.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent set2 = new Intent("com.selftracker.UnderConstruction");
					startActivity(set2);
						
				}
			});
	        foodCourtVisits = (Button)findViewById(R.id.button5);
	        foodCourtVisits.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent set3 = new Intent("com.selftracker.ViewRating");
					startActivity(set3);
						
				}
			});
	}
}
