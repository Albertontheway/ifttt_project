package com.albert.ifttt.broadcast;

import com.albert.ifttt.contentprovider.MyUsers;
import com.albert.ifttt.contentprovider.database_utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class mainbroadcastReceiver extends BroadcastReceiver {

	// action 名称
	String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	String USER_PRESENT = "android.intent.action.USER_PRESENT";
	database_utils data_util;
	
	public void onReceive(Context context, Intent intent) {
		
		if (intent.getAction().equals(SMS_RECEIVED)) {
			// 相关处理 : 地域变换、电量不足、来电来信；
		}
		if (intent.getAction().equals(USER_PRESENT)) {
			Log.e("mainbroadcast", " USER_PRESENT  ");
		}
		if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
			Log.e("mainbroadcast", " ACTION_SCREEN_ON  ");
//			Cursor cur =   context.managedQuery(myUri, columns, null, null, null);
			
			
		} else if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
			Log.e("mainbroadcast", " ACTION_SCREEN_OFF  ");
		} else if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
			Log.e("mainbroadcast", " ACTION_USER_PRESENT  ");
		}

	}

}
