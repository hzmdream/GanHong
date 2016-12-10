package com.ganhong.test.utctolocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UTCToLocalDate {

	public static void main(String[] args) {
		System.out.println(dealDateFormat("2016-12-10T20:35:00.000+08:00"));
	}
	public static String dealDateFormat(String oldDateStr){
		// 此格式只有 jdk 1.7才支持 yyyy-MM-dd'T'HH:mm:ss.SSSXXX
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); // yyyy-MM-dd'T'HH:mm:ss.SSSZ
		Date date;
		try {
			date = df.parse(oldDateStr);
			SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			Date date1 = df1.parse(date.toString());
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// Date date3 = df2.parse(date1.toString());
			return df2.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
