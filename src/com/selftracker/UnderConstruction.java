package com.selftracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class UnderConstruction extends Activity {

	@Override
	protected void onCreate(Bundle underConstruction) {
		// TODO Auto-generated method stub
		super.onCreate(underConstruction);
		setContentView(R.layout.under_construction);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.selftracker.MainActivity");
					startActivity(openMainActivity);
				}
				
			}
		};
		timer.start();
	}
}
