package com.selftracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity{

	Button chPass,deldata;
	EditText userId, oldPassword, newPassword, reEnter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_password);
		
		userId = (EditText) findViewById(R.id.editText1);
		oldPassword = (EditText) findViewById(R.id.editText2);
		newPassword = (EditText) findViewById(R.id.editText3);
		reEnter = (EditText) findViewById(R.id.editText4);
		
		chPass = (Button)findViewById(R.id.button1);
	    chPass.setOnClickListener(new View.OnClickListener() {
				
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
					else if(oldPassword.length() == 0){
						Context context = getApplicationContext();
						CharSequence text = "Please Enter old Password";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
					else if(newPassword.length() == 0){
						Context context = getApplicationContext();
						CharSequence text = "Please Enter new Password";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
					else if(reEnter.length() == 0){
						Context context = getApplicationContext();
						CharSequence text = "Please Re-Enter new Password";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
					else{
						String user = userId.getText().toString();
						String passkey = oldPassword.getText().toString();
						AuthenticationDb info = new AuthenticationDb(ChangePassword.this);
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
							/*AuthenticationDb replace = new AuthenticationDb(ChangePassword.this);
							replace.open();
							replace.replaceEntry(user,newPassword.getText().toString());
							replace.close();
							*/
							Context context = getApplicationContext();
							CharSequence text = "Password Changed Successfully";
							int duration = Toast.LENGTH_SHORT;

							Toast toast = Toast.makeText(context, text, duration);
							toast.show();
							finish();
						}
						
					}
				}	
			});
	    deldata = (Button)findViewById(R.id.button2);
	    deldata.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				
							AuthenticationDb delete = new AuthenticationDb(ChangePassword.this);
							delete.open();
							delete.eraseLoginDetails();
							delete.close();
							
							Context context = getApplicationContext();
							CharSequence text = "All Login Database Deleted... \nPlease Sign-up and Sign-in to continue...";
							int duration = Toast.LENGTH_SHORT;

							Toast toast = Toast.makeText(context, text, duration);
							toast.show();
							Intent set3 = new Intent("com.selftracker.SignUp");
							startActivity(set3);
						
				}	
			});
	    

	}
}
