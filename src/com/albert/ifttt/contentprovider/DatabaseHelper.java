package com.albert.ifttt.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
	DatabaseHelper(Context context) {
		super(context, MainContentProvider.DATABASE_NAME, null,
				MainContentProvider.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 创建用于存储数据的表
		 
 		
		db.execSQL("create table "
				+ MainContentProvider.TABLE_NAME
				+ "( _id INTEGER PRIMARY KEY AUTOINCREMENT, USER_NAME TEXT, USER_STATE TEXT , USER_TIME TEXT);");
//	db.execSQL("ALTER SESSION SET TIME_ZONE='UTC';");
	}

	// , TIME DATETIME DEFAULT CURRENT_TIMESTAMP
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + MainContentProvider.TABLE_NAME);
		onCreate(db);
	}
}