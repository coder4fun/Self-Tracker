package com.selftracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeOfAppUse extends Activity{

	Preferences p = new Preferences(ModeOfAppUse.this);
	
	Button user,doctor;
	@Override
	protected void onCreate(Bundle modeOfAppUse) {
		// TODO Auto-generated method stub
		super.onCreate(modeOfAppUse);
		setContentView(R.layout.mode_of_app_use);
		

		user = (Button)findViewById(R.id.button1);
        user.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				finish();
				finish();
				Intent set1 = new Intent("com.selftracker.MainActivity");
				startActivity(set1);
			}
		});
        
        doctor = (Button)findViewById(R.id.button2);
        doctor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				p.changemode();
				finish();
				finish();
				finish();
				Intent set1 = new Intent("com.selftracker.DoctorActivity");
				startActivity(set1);
			}
		});
	}

}
