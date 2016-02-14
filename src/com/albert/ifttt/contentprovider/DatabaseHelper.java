package com.albert.ifttt.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper(Context context) {
        super(context, MainContentProvider.DATABASE_NAME, null, MainContentProvider.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //�������ڴ洢���ݵı�
    db.execSQL("Create table " + MainContentProvider.TABLE_NAME + "( _id INTEGER PRIMARY KEY AUTOINCREMENT, USER_NAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MainContentProvider.TABLE_NAME);
        onCreate(db);
    }
}