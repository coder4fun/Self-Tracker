package com.selftracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity{
	
	Button signup;
	EditText userId, password,checkPassword,secureCode;
	@Override
	protected void onCreate(Bundle signUp) {
		// TODO Auto-generated method stub
		super.onCreate(signUp);
		setContentView(R.layout.sign_up);
		
		userId = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		checkPassword = (EditText) findViewById(R.id.editText3);
		secureCode = (EditText) findViewById(R.id.editText4);
		
		signup = (Button)findViewById(R.id.button1);
        signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(userId.length() == 0){
					Context context = getApplicationContext();
					CharSequence text = "Please enter User Id";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
				else if(secureCode.length() == 0){
					Context context = getApplicationContext();
					CharSequence text = "Please Enter Secure Code";
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
				else if(checkPassword.length() == 0){
					Context context = getApplicationContext();
					CharSequence text = "Please Re-enter Password for verification";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
				else if(!((password.getText().toString()).equals(checkPassword.getText().toString()))){
					Context context = getApplicationContext();
					CharSequence text = "Password Mismatch... Please verify";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
				else{
					String name = userId.getText().toString();
					String passkey = password.getText().toString();
					AuthenticationDb entry = new AuthenticationDb(SignUp.this);
					entry.open();
					entry.createEntry(name,passkey);
					entry.close();
					
					Context context = getApplicationContext();
					CharSequence text = "Thankyou for Signing up...";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
					Intent set2 = new Intent("com.selftracker.SignInPage");
					startActivity(set2);
				}	
			}
		});
	}
}
