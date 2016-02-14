package com.albert.ifttt.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class mainbroadcastReceiver extends BroadcastReceiver {

	// action ����
	String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	String USER_PRESENT = "android.intent.action.USER_PRESENT";

	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals(SMS_RECEIVED)) {
			// ��ش��� : ����任���������㡢�������ţ�
		}
		if (intent.getAction().equals(USER_PRESENT)) {
			Log.e("mainbroadcast", " USER_PRESENT  ");
		}
		if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
			Log.e("mainbroadcast", " ACTION_SCREEN_ON  ");
		} else if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
			Log.e("mainbroadcast", " ACTION_SCREEN_OFF  ");
		} else if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
			Log.e("mainbroadcast", " ACTION_USER_PRESENT  ");
		}

	}

}