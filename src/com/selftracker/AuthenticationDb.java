package com.selftracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AuthenticationDb {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "user_name";
	public static final String KEY_PASSWORD = "password";
	
	private static final String DATABASE_NAME = "LoginDatabase";
	private static final String DATABASE_TABLE = "AutenticationTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper loginHelper;
	private final Context loginContext;
	private SQLiteDatabase loginDatabase;
	
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
					KEY_PASSWORD + " TEXT NOT NULL);" 
			);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXITS" + DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	
	public AuthenticationDb(Context c ){
		loginContext =c;
	}
	
	public AuthenticationDb open() throws SQLException{
		loginHelper = new DbHelper(loginContext);
		loginDatabase = loginHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		loginHelper.close();
	}

	public long createEntry(String name, String passkey) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_PASSWORD, passkey);
		return loginDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public String getUserId(int i) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_PASSWORD};
		Cursor c = loginDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iName = c.getColumnIndex(KEY_NAME);
		int j =1;		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			if(j == i)
				result = c.getString(iName);
			else 
				j++;
		}
		return result;
	}

	public String getPassword(int i) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_PASSWORD};
		Cursor c = loginDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iPassword = c.getColumnIndex(KEY_PASSWORD);
		int j =1;		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			if(j == i)
				result = c.getString(iPassword);
			else 
				j++;
		}
		return result;
	}

	public int getNumber() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_PASSWORD};
		Cursor c = loginDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		int result = 1;
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			result++;
		}
		return result;
	}

	public Object replaceEntry(String user, String string) {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_PASSWORD};
		Cursor c = loginDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
				
		int iName = c.getColumnIndex(KEY_NAME);
		int iRow = c.getColumnIndex(KEY_ROWID);	
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			if(user.equals(c.getString(iName))){
				ContentValues values = new ContentValues();
				values.put(KEY_ROWID, iRow);
				values.put(KEY_NAME, user);
				values.put(KEY_PASSWORD, string);
				loginDatabase.replace(DATABASE_TABLE, null, values);
			}
		}
		createEntry(user, string);
		return null;
		
	}

	public void eraseLoginDetails() {
		// TODO Auto-generated method stub
		loginDatabase.delete(DATABASE_TABLE, null, null);
	}
}
