package java_20190731;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = Calendar.YEAR;
		int month = Calendar.MONTH;
		int date = Calendar.DATE;
		
		int hour = Calendar.HOUR;
		int minute = Calendar.MINUTE;
		int second = Calendar.SECOND;
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초\n", year, month, date, hour, minute, second);
		
		c.set(2019, 6, 1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		Calendar2 c2 = new Calendar2();
		c2.print(2019, 7, 31);
		c2.print(2019,7);
		c2.print(2019);
		
	}
	

}
