package com.albert.ifttt.jni;

public class mainjni {
	
	{
		System.loadLibrary("ifttt");

	}

	public native int forkthread(String serviceName, int sdkVersion);
}
