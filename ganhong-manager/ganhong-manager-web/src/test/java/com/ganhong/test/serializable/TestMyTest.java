package com.ganhong.test.serializable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMyTest {

	public static void main(String[] args) {
		
		/*MyTest myTest = new MyTest();
		myTest.age = "12";*/
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		System.out.println(sdf.format(date));
		
		addMinu(date);
	}

	private static void addMinu(Date date) {
		  Calendar now=Calendar.getInstance();
		 
		  now.add(Calendar.MINUTE,15);
		 
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		  String dateStr=sdf.format(now.getTimeInMillis());
		 
		  System.out.println(dateStr);
		
	}
}
