package com.selftracker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	Button settings,map,visitEditing,heartBeat,pulseRate,monetaryExpenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        monetaryExpenses = (Button)findViewById(R.id.button5);
        monetaryExpenses.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set2 = new Intent("com.selftracker.UnderConstruction");
				startActivity(set2);
					
			}
		});
        visitEditing = (Button)findViewById(R.id.button6);
        visitEditing.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent set6 = new Intent("com.selftracker.SQLite");
				startActivity(set6);
			}
		});
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}


	
    
}
