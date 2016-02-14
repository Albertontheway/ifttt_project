package com.albert.ifttt;

import com.albert.ifttt.R;
import com.albert.ifttt.R.id;
import com.albert.ifttt.R.layout;
import com.albert.ifttt.R.menu;
import com.albert.ifttt.contentprovider.MyUsers;
import com.albert.ifttt.service.MainService;

import android.app.Activity;
import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	private Intent intent = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(MainActivity.this, MainService.class);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment(intent))
					.commit();
		}
		insertRecord("MyUser");
		displayRecords();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void insertRecord(String userName) {
		ContentValues values = new ContentValues();
		values.put(MyUsers.User.USER_NAME, userName);
		getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
	}

	private void displayRecords() {
		String columns[] = new String[] { MyUsers.User._ID,
				MyUsers.User.USER_NAME };
		Uri myUri = MyUsers.User.CONTENT_URI;
		Cursor cur = managedQuery(myUri, columns, null, null, null);
		if (cur.moveToFirst()) {
			String id = null;
			String userName = null;
			do {
				id = cur.getString(cur.getColumnIndex(MyUsers.User._ID));
				userName = cur.getString(cur
						.getColumnIndex(MyUsers.User.USER_NAME));
				Toast.makeText(this, id + " " + userName, Toast.LENGTH_LONG)
						.show();
			} while (cur.moveToNext());
		}
	}
}
