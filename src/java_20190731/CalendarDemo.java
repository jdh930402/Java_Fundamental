package java_20190731;

import java.util.Calendar;

import util.Utility;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		String date = Utility.getDate(calendar, "yyyyMMdd");
		System.out.println(date);
		
	}
	

}
