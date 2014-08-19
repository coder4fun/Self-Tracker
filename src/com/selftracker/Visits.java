package com.selftracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Visits {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "place_name";
	public static final String KEY_FOODCOURT = "Foodcourt_or_not";
	
	private static final String DATABASE_NAME = "VisitsDB";
	private static final String DATABASE_TABLE = "PlacesTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					KEY_NAME +" TEXT NOT NULL, " +
					KEY_FOODCOURT + " TEXT NOT NULL);" 
			);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXITS" + DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	
	public Visits(Context c ){
		ourContext =c;
	}
	
	public Visits open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}

	public long createEntry(String name, String foodcourt) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_FOODCOURT, foodcourt);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_FOODCOURT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iFoodcourt = c.getColumnIndex(KEY_FOODCOURT);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iFoodcourt) + "\n";
		}
		return result;
	}

	public void deleteDbEntry() {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, null, null);
	}

}

