package com.albert.ifttt.contentprovider;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class database_utils {
	Activity a = null;
	Service s = null;

	public database_utils(Activity a) {
		this.a = a;
	}

	public database_utils(Service s) {
		this.s = s;
	}

	public void insertRecord(String userName) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy年MM月dd日   HH:mm:ss     ");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String str_curDate = formatter.format(curDate);

		ContentValues values = new ContentValues();
		values.put(MyUsers.User.USER_NAME, userName);
		values.put(MyUsers.User.USER_STATE, userName);
		values.put(MyUsers.User.USER_TIME, str_curDate);
		if (a != null) {
			a.getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
		} else {
			s.getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
		}

	}

	public void displayRecords() {
		String columns[] = new String[] { MyUsers.User._ID,
				MyUsers.User.USER_NAME, MyUsers.User.USER_STATE,
				MyUsers.User.USER_TIME };
		Uri myUri = MyUsers.User.CONTENT_URI;
		Cursor cur1;
		if (a != null) {
			cur1 = a.managedQuery(myUri, columns, null, null, null);
		} else {
			cur1 = s.getContentResolver().query(myUri, columns, null, null,
					null);
		}

		if (cur1.moveToFirst()) {
			String id = null;
			String userName = null;
			String userState = null;
			String userTime = null;
			do {
				id = cur1.getString(cur1.getColumnIndex(MyUsers.User._ID));
				userName = cur1.getString(cur1
						.getColumnIndex(MyUsers.User.USER_NAME));
				userState = cur1.getString(cur1
						.getColumnIndex(MyUsers.User.USER_STATE));
				userTime = cur1.getString(cur1
						.getColumnIndex(MyUsers.User.USER_TIME));
				// Toast.makeText(this,
				// id + " " + userName + " " + userState + " " + userTime,
				// Toast.LENGTH_LONG).show();
				Log.e("displayRecords", id + " " + userName + " " + userState
						+ " " + userTime);
			} while (cur1.moveToNext());
		}
	}
}
