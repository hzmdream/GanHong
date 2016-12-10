package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * 日期格式转换类
 * "2016-11-30T20:35:00.000+08:00"---转换为2016-11-30 20:35:00
 * @author usky
 *
 */
public class MyDateFormat {

	public static void main(String[] args) throws ParseException {
		String oldDateStr = "2016-11-30T20:35:00.000+08:00";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");  //yyyy-MM-dd'T'HH:mm:ss.SSSZ
		  Date  date = df.parse(oldDateStr);
		  SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		  Date date1 =  df1.parse(date.toString());
		  DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//  Date date3 =  df2.parse(date1.toString());
		  String format = df2.format(date1);
		  System.out.println(format);
		  System.out.println(format.substring(format.indexOf(" ")+1, format.lastIndexOf(":")));
	}
}
