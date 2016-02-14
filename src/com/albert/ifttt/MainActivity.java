package com.albert.ifttt;

import com.albert.ifttt.R;
import com.albert.ifttt.contentprovider.MyUsers;
import com.albert.ifttt.service.MainService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.albert.ifttt.broadcast.mainbroadcastReceiver;

public class MainActivity extends Activity {
	private Intent intent = null;
	private BroadcastReceiver mainbroadcastReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent = new Intent(MainActivity.this, MainService.class);
		mainbroadcastReceiver = new mainbroadcastReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_USER_PRESENT);
		registerReceiver(mainbroadcastReceiver, filter);

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
		values.put(MyUsers.User.USER_STATE, userName);
		getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
	}

	private void displayRecords() {
		String columns[] = new String[] { MyUsers.User._ID,
				MyUsers.User.USER_NAME,MyUsers.User.USER_STATE,MyUsers.User.USER_TIME};
		Uri myUri = MyUsers.User.CONTENT_URI;
		Cursor cur = managedQuery(myUri, columns, null, null, null);
		if (cur.moveToFirst()) {
			String id = null;
			String userName = null;
			String userState = null;
			String userTime = null;
			do {
				id = cur.getString(cur.getColumnIndex(MyUsers.User._ID));
				userName = cur.getString(cur
						.getColumnIndex(MyUsers.User.USER_NAME));
				userState = cur.getString(cur
						.getColumnIndex(MyUsers.User.USER_STATE));
				userTime = cur.getString(cur
						.getColumnIndex(MyUsers.User.USER_TIME));
				Toast.makeText(this, id + " " + userName+" "+userState+" "+userTime, Toast.LENGTH_LONG)
						.show();
			} while (cur.moveToNext());
		}
	}
}
