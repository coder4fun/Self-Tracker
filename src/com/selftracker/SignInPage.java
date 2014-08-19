package com.selftracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInPage extends Activity{
	
	Button login,cancel,signup;
	EditText userId,password;
	@Override
	protected void onCreate(Bundle signInPage) {
		// TODO Auto-generated method stub
		super.onCreate(signInPage);
		setContentView(R.layout.login_page);
				
		userId = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);		
		
		 login = (Button)findViewById(R.id.button1);
	     login.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/*
					Intent intent = getIntent();
					final String id = intent.getStringExtra("userId");
					Intent intent2 = getIntent();
					final String passkey = intent2.getStringExtra("password");
					*/
					if(userId.length() == 0){
						Context context = getApplicationContext();
						CharSequence text = "Please enter User Id";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
					else if(password.length() == 0){
						Context context = getApplicationContext();
						CharSequence text = "Please Enter Password";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
					else{
						String user = userId.getText().toString();
						String passkey = password.getText().toString();
						AuthenticationDb info = new AuthenticationDb(SignInPage.this);
						info.open();
						int entriesNumber = info.getNumber();
						int i;
						boolean valid = false;
						for(i = 1; i<=entriesNumber;i++){
							String dataUser = info.getUserId(i);
							String dataPassword = info.getPassword(i);
							if(user.equals(dataUser) && passkey.equals(dataPassword)){
								valid = true;
							}
						}
						info.close();
						
						if(valid){						
						Intent set1 = new Intent("com.selftracker.MainActivity");
						startActivity(set1);
						}
						else{
							Context context = getApplicationContext();
							CharSequence text = "User Name and Password mismatch.... If you don't have an id please create one";
							int duration = Toast.LENGTH_SHORT;

							Toast toast = Toast.makeText(context, text, duration);
							toast.show();
						}
					}
				}	
			});
	     
	     cancel = (Button)findViewById(R.id.button2);
	     cancel.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
	     signup = (Button)findViewById(R.id.button3);
	     signup.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent set2 = new Intent("com.selftracker.SignUp");
					startActivity(set2);
				}
			});
		
	}

}
