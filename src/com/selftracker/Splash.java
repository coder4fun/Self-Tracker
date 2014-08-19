package com.selftracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle selftracker) {
		// TODO Auto-generated method stub
		super.onCreate(selftracker);
		setContentView(R.layout.activity_splash);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.selftracker.SignInPage");
					startActivity(openMainActivity);
				}
				
			}
		};
		timer.start();
	}

}
