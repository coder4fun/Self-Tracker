package com.selftracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Remainder extends Activity {
	TimePicker remind;
	Button back,set;
	public String timeSet ="";
	Preferences p = new Preferences(Remainder.this);
	public int hour,minutes;
	@Override
	protected void onCreate(Bundle remainder) {
		// TODO Auto-generated method stub
		super.onCreate(remainder);
		setContentView(R.layout.remainder);
		
		back = (Button)findViewById(R.id.button1);
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Remainder.this.finish();
			}
		});
        
		remind = (TimePicker)findViewById(R.id.timePicker1);
		set = (Button)findViewById(R.id.button2);
        set.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hour = remind.getCurrentHour();
				minutes = remind.getCurrentMinute();
				
				String returnString = hour + " hours" + minutes + "minutes";
				p.remainderString(returnString);
				finish();
			}
		});
	    
	}
		
}
