package com.selftracker;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.os.Bundle;

public class Map extends MapActivity{
	private MapView mapView;
	private MyLocationOverlay myLocationOverlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    // main.xml contains a MapView
	
	    setContentView(R.layout.map_view);
		 
	   // extract MapView from layout
	
	    mapView = (MapView) findViewById(R.id.mapview);
	
	    mapView.setBuiltInZoomControls(true);
	
	
	   // create an overlay that shows our current location
	
	    myLocationOverlay = new MyLocationOverlay(this, mapView);
	
	 
	
	    // add this overlay to the MapView and refresh it
		    mapView.getOverlays().add(myLocationOverlay);
	
	    mapView.postInvalidate();
	
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
