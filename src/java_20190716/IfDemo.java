package java_20190716;

public class IfDemo {
	public static void main(String[] args) { // String[] args의 매개변수는 [Run Configurations] - [Arguments] - Program
												// argument에 값을 입력

		int month = Integer.parseInt(args[0]);
		String season = null;

		if (month == 12 || month >= 1 && month <= 2) {
			season = "겨울";
		} else if (month >= 3 && month <= 5) {
			season = "봄";
		} else if (month >= 6 && month <= 8) {
			season = "여름";
		} else if (month >= 9 && month <= 11) {
			season = "가을";
		} else {
			season = "없는 계절";
		}
		System.out.println(month + "월은 " + season + "입니다");
	}
}
