package com.albert.ifttt.broadcast;

import com.albert.ifttt.MainActivity;
import com.albert.ifttt.contentprovider.MyUsers;
import com.albert.ifttt.contentprovider.database_utils;
import com.albert.ifttt.service.MainService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class mainbroadcastReceiver extends BroadcastReceiver {

	// action Ãû³Æ
	String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	String USER_PRESENT = "android.intent.action.USER_PRESENT";
	private database_utils data_util = null;

	public mainbroadcastReceiver(database_utils data_util) {
		this.data_util = data_util;
		

	}
	public mainbroadcastReceiver() {
		
		
		

	}
	public void onReceive(Context context, Intent intent) {
	
		if (intent.getAction().equals(SMS_RECEIVED)) {
			if (data_util == null) {
				Intent startServiceIntent = new Intent(context, MainService.class);
				startServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startService(startServiceIntent);
				
			} else {
				data_util.insertRecord("SMS_RECEIVED");
				data_util.displayRecords();
			}

		}

		if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {

			data_util.insertRecord("ACTION_SCREEN_ON");
			data_util.displayRecords();

		} else if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
			data_util.insertRecord("ACTION_SCREEN_OFF");
			data_util.displayRecords();

		} else if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
			if (data_util == null) {
				Intent startServiceIntent = new Intent(context, MainService.class);
				startServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startService(startServiceIntent);
				
			}else{
				data_util.insertRecord("ACTION_USER_PRESENT");
				data_util.displayRecords();
			}
		
		}

	}

}
