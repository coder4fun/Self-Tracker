package com.selftracker;

import android.content.Context;


public class Preferences {
	public static boolean Mode = true;
	public static int Time_For_Visit = 0;
	public static String Remainder_time = "";
	public String modeString ="";
	private final Context preferencesContext ;
	
	public Preferences(Context c ){
		preferencesContext =c;
	}
	
	public void changemode() {
		// TODO Auto-generated method stub
		Mode = false;
	}
	public void setcounter(int i) {
		// TODO Auto-generated method stub
		Time_For_Visit = i;
	}
	{	
	
	if(!Mode)
		modeString = "Doctor Mode";
	else
		modeString = "UserMode";
	}
	public void remainderString(String returnString) {
		// TODO Auto-generated method stub
		Remainder_time.equals(returnString);
	}
	CharSequence text = "The present settings are : \nMODE: "+ modeString + "\nTime for visit: " + Time_For_Visit + "minutes\nRemainder: " + Remainder_time;
	public CharSequence getPreferences()
	{
		return text;
	}
}



