package com.selftracker;

import android.content.Context;

public class RatingFoodcourt {

	public static int rate[];
	
	private final Context context ;
	
	public RatingFoodcourt(Context c ){
		context =c;
	}

	public void setRating(int count) {
		// TODO Auto-generated method stub
		switch(count){
		case 1:
			rate[0]++;
			break;
		case 2:
			rate[1]++;
			break;
		case 3:
			rate[2]++;
			break;
		case 4:
			rate[3]++;
			break;
		case 5:
			rate[4]++;
			break;	
		}
	}
	
	
	public int[] getrating() {
		// TODO Auto-generated method stub
		return rate;
	}
	
}
