package com.selftracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql_view);
		TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
		Visits info = new Visits(this);
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
		
	}
}
