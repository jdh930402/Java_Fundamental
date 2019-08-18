package java_20190731;
// one line comment

import java.util.Calendar;

/*
 * multi line comment
 */

// 아래의 주석은 java docs comment
//
/**
 * Calendar클래스는 년도별, 월별, 요일을 구할 수 있는 클래스입니다.
 */
public class Calendar2 {

	public void print(int year) {
		// 2019 01 01의 총 날짜를 구한다.
		for (int i = 0; i < 12; i++) {
			print(year, i + 1);
			System.out.println();
		}
	}

	/*
	 * 매개변수에 년도와 월로 호출하면 해당 연도의 월 달력을 출력하는 기능입니다.
	 */
	public void print(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		// 들여쓰기 기능
		// 2019 07 01 의 총 날짜를 구한다.
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		for (int i = 0; i < dayOfWeek - 1; i++) {
			System.out.print("\t");
		}

		for (int i = 0; i < c.getActualMaximum(Calendar.DATE); i++) {
			System.out.print(i + 1 + "\t");
			if (dayOfWeek % 7 + 1 == Calendar.SUNDAY) {
				System.out.println();
			}
			dayOfWeek++;
			// 개행
		}
		System.out.println();
	}

	/**
	 * 매개변수에 년, 월, 일로 호출하면 해당 연도의 요일을 출력하는 기능입니다.
	 */
	public void print(int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String message = null;
		if (dayOfWeek == Calendar.MONDAY) {
			message = "월요일";
		} else if (dayOfWeek == Calendar.TUESDAY) {
			message = "화요일";
		} else if (dayOfWeek == Calendar.WEDNESDAY) {
			message = "수요일";
		} else if (dayOfWeek == Calendar.THURSDAY) {
			message = "목요일";
		} else if (dayOfWeek == Calendar.FRIDAY) {
			message = "금요일";
		} else if (dayOfWeek == Calendar.SATURDAY) {
			message = "토요일";
		} else if (dayOfWeek == Calendar.SUNDAY) {
			message = "일요일";
		}
		System.out.println(year + "년 " + month + "월 " + date + "일 " + message);
	}
}