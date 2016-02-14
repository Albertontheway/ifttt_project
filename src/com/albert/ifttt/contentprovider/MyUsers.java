package com.albert.ifttt.contentprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public class MyUsers {
	public static final String AUTHORITY = "com.albert.ifttt.contentprovider.MainContentProvider";

	// BaseColumn类中已经包含了 _id字段
	public static final class User implements BaseColumns {
		public static final Uri CONTENT_URI = Uri
				.parse("content://com.albert.ifttt.contentprovider.MainContentProvider");
		// 表数据列
		public static final String USER_NAME = "USER_NAME";
		public static final String USER_STATE = "USER_STATE";
		public static final String USER_TIME = "USER_TIME";
	}
}
