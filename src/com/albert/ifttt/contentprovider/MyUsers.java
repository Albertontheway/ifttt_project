package com.albert.ifttt.contentprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public class MyUsers {
	public static final String AUTHORITY = "com.albert.ifttt.contentprovider.MainContentProvider";

	// BaseColumn�����Ѿ������� _id�ֶ�
	public static final class User implements BaseColumns {
		public static final Uri CONTENT_URI = Uri
				.parse("content://com.albert.ifttt.contentprovider.MainContentProvider");
		// ��������
		public static final String USER_NAME = "USER_NAME";
		public static final String USER_STATE = "USER_STATE";
		public static final String USER_TIME = "USER_TIME";
	}
}
