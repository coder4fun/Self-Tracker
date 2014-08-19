package com.selftracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings  extends Activity {

	Button back,mode,time,reminder,monetary,password,presentSettings;
	@Override
	protected void onCreate(Bundle settings) {
		// TODO Auto-generated method stub
		super.onCreate(settings);
		setContentView(R.layout.settings);
		back = (Button)findViewById(R.id.button1);
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Settings.this.finish();
			}
		});
        
        presentSettings = (Button)findViewById(R.id.button8);
        presentSettings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Preferences p = new Preferences(Settings.this);
				CharSequence text = p.getPreferences();
				Context context = getApplicationContext();
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
			}
		});
        mode = (Button)findViewById(R.id.button3);
        mode.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set3 = new Intent("com.selftracker.ModeOfAppUse");
				startActivity(set3);
			}
		});
        
        time = (Button)findViewById(R.id.button4);
        time.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set4 = new Intent("com.selftracker.TimeForVisit");
				startActivity(set4);
			}
		});
        reminder = (Button)findViewById(R.id.button5);
        reminder.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set5 = new Intent("com.selftracker.Remainder");
				startActivity(set5);
			}
		});
        monetary = (Button)findViewById(R.id.button6);
        monetary.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set6 = new Intent("com.selftracker.UnderConstruction");
				startActivity(set6);
			}
		});
        password = (Button)findViewById(R.id.button7);
        password.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set7 = new Intent("com.selftracker.ChangePassword");
				startActivity(set7);
			}
		});
        	
	}
}
	
