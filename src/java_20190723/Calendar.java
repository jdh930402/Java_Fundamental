package java_20190723;
// one line comment

/*
 * multi line comment
 */

// 아래의 주석은 java docs comment
//
/**
 * Calendar클래스는 년도별, 월별, 요일을 구할 수 있는 클래스입니다.
 */
public class Calendar {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	/**
	 * 매개변수에 연도로 호출하면 해당 연도의 월별 달력을 출력하는 기능입니다.
	 */
	public void print(int year) {
		// 2019 01 01의 총 날짜를 구한다.
		for (int i = 0; i < 12; i++) {
			print(year, i + 1);
			System.out.println();
		}
	}

	/**
	 * 매개변수에 년도와 월로 호출하면 해당 연도의 월 달력을 출력하는 기능입니다.
	 */
	public void print(int year, int month) {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		// 들여쓰기 기능
		// 2019 07 01 의 총 날짜를 구한다.
		int totalCount = getCount(year, month, 1);
		int rest = totalCount % 7; // 2019 07 01 rest값은 1
		for (int i = 0; i < rest; i++) {
			System.out.print("\t");
		}

		for (int i = 0; i < this.getLastDay(year, month); i++) {
			System.out.print(i + 1 + "\t");
			if (rest % 7 == Calendar.SATURDAY) {
				System.out.println();
			}
			rest++;
			// 개행
		}
		System.out.println();
	}

	/**
	 * 매개변수에 년, 월, 일로 호출하면 해당 연도의 요일을 출력하는 기능입니다.
	 */
	public void print(int year, int month, int day) {
		int totalCount = getCount(year, month, day);

		int dayOfWeek = totalCount % 7;
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
		System.out.println(year + "년 " + month + "월 " + day + "일 " + message);
	}

	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean isLeafYear = isLeafYear(year);
		// 해당 년도가 윤년인지 판단한다.
		if (isLeafYear) {
			monthArray[1] = 29;
		}
		return monthArray[month - 1];
	}

	private boolean isLeafYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	private int getCount(int year, int month, int day) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int preYear = year - 1;
		// preMonth => 2019년 11월
		int preMonth = month - 1;
		int totalCount = 0;
		boolean isLeafYear = isLeafYear(year);
		// 해당 년도가 윤년인지 판단한다.
		if (isLeafYear) {
			monthArray[1] = 29;
		}

		// 2018년도 까지의 총합
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		// 2019년도 11월까지 합 구하기
		for (int i = 0; i < preMonth; i++) {
			totalCount += monthArray[i];
		}

		totalCount += day;
		return totalCount;
	}
}