package com.albert.ifttt;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.albert.ifttt.R;
import com.albert.ifttt.contentprovider.MyUsers;
import com.albert.ifttt.contentprovider.database_utils;
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
	database_utils data_util;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		data_util = new database_utils(MainActivity.this);
		intent = new Intent(MainActivity.this, MainService.class);
//		mainbroadcastReceiver = new mainbroadcastReceiver(data_util);
//		IntentFilter filter = new IntentFilter();
//		filter.addAction(Intent.ACTION_SCREEN_ON);
//		filter.addAction(Intent.ACTION_SCREEN_OFF);
////		filter.addAction(Intent.ACTION_USER_PRESENT);
//		registerReceiver(mainbroadcastReceiver, filter);
		 
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.startService(intent);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment(intent))
					.commit();
		}
	

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

}
