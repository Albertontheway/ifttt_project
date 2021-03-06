package com.albert.ifttt.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) 
	{
		if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()))
		{
			Intent startServiceIntent = new Intent(context, MainService.class);
			startServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startService(startServiceIntent);
		}
	}
}
