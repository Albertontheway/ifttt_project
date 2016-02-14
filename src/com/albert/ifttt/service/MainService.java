package com.albert.ifttt.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MainService extends Service {
	int mStartMode; // indicates how to behave if the service is killed
	IBinder mBinder; // interface for clients that bind
	boolean mAllowRebind; // indicates whether onRebind should be used

	@Override
	public void onCreate() {

		// The service is being created
		Log.e("MainService", " MainService onCreate");
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				int i;
//				for (i = 0; i <= 50; i++) {
//					Toast.makeText(getApplicationContext(), "i = " + i,
//							Toast.LENGTH_LONG).show();
//
//				}
//			}
//		}).start();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// The service is starting, due to a call to startService()
		Log.e("MainService", " MainService onStartCommand");
		return mStartMode;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// A client is binding to the service with bindService()
		Log.e("MainService", " MainService onBind");
		return mBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// All clients have unbound with unbindService()
		Log.e("MainService", " MainService onUnbind");
		return mAllowRebind;
	}

	@Override
	public void onRebind(Intent intent) {
		// A client is binding to the service with bindService(),
		// after onUnbind() has already been called
		Log.e("MainService", " MainService onRebind");
	}

	@Override
	public void onDestroy() {
		Log.e("MainService", " MainService onDestroy");
		// The service is no longer used and is being destroyed
	}

}
