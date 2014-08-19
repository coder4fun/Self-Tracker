package com.selftracker;

import android.app.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;


public class SQLite extends Activity implements OnClickListener,OnCheckedChangeListener{

	Button updateDB, viewDB,deleteDB;
	EditText placeName,foodcourtOrNot;
	RadioGroup rating;
	RatingFoodcourt r = new RatingFoodcourt(SQLite.this);
	//RadioButton a,b,c,d,e;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_editing);
				
		updateDB = (Button)findViewById(R.id.button3);
		deleteDB = (Button)findViewById(R.id.button1);
		viewDB= (Button)findViewById(R.id.button4);
		placeName = (EditText) findViewById(R.id.editText1);
		foodcourtOrNot = (EditText) findViewById(R.id.editText2);
	
		rating = (RadioGroup)findViewById(R.id.radioGroup1);
		
		rating.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				
			switch(checkedId){
				
				case R.id.radio0:
					//count = 1;
					r.setRating(1);
					break;
				case R.id.radio1:
					//count = 2;
					r.setRating(2);
					break;
				case R.id.radio2:
					//count = 3;
					r.setRating(3);
					break;
				case R.id.radio3:
					//count = 4;
					r.setRating(4);
					break;
				case R.id.radio4:
					//count = 5;
					r.setRating(5);
					break;	
				}	
			}
		});
		
		updateDB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				//boolean didItWork = true;
				//try{
					
				String name = placeName.getText().toString();
				String foodcourt = foodcourtOrNot.getText().toString();
				Visits entry = new Visits(SQLite.this);
				entry.open();
				entry.createEntry(name,foodcourt);
				entry.close();
				
				Context context = getApplicationContext();
				CharSequence text = "Data successfully added!!!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				rating.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						
					switch(checkedId){
						
						case R.id.radio0:
							//count = 1;
							r.setRating(1);
							break;
						case R.id.radio1:
							//count = 2;
							r.setRating(2);
							break;
						case R.id.radio2:
							//count = 3;
							r.setRating(3);
							break;
						case R.id.radio3:
							//count = 4;
							r.setRating(4);
							break;
						case R.id.radio4:
							//count = 5;
							r.setRating(5);
							break;	
						}	
					}
				});
			}
		});
		viewDB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.selftracker.SQLView");
				startActivity(i);
			}
		});
		deleteDB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				//boolean didItWork = true;
				//try{
					
				Visits delete = new Visits(SQLite.this);
				delete.open();
				delete.deleteDbEntry();
				delete.close();
				
				Context context = getApplicationContext();
				CharSequence text = "Data successfully Deleted!!!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
			}
		});
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
						
	}

}
