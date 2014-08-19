package com.selftracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewRating extends Activity{
		
		TextView t1,t2,t3,t4,t5;
		Button back;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.rating_foodcourt);
			RatingFoodcourt p = new RatingFoodcourt(ViewRating.this);
			int rate[] = p.getrating();
			t1 =(TextView)findViewById(R.id.textView1);
			t2 =(TextView)findViewById(R.id.textView2);
			t3 =(TextView)findViewById(R.id.textView3);
			t4 =(TextView)findViewById(R.id.textView4);
			t5 =(TextView)findViewById(R.id.textView5);
			t1.setText("POOR     : "+ rate[0] + " Visits");
			t2.setText("NOT BAD  : "+ rate[1] + " Visits");
			t3.setText("DECENT   : "+ rate[2] + " Visits");
			t4.setText("GOOD     : "+ rate[3] + " Visits");
			t5.setText("EXCELLENT: "+ rate[4] + " Visits");
			back = (Button)findViewById(R.id.button1);
	        back.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
		}
}
