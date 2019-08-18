package java_20190717;

public class SwitchDemo {
	public static void main(String[] args) { // String[] args의 매개변수는 [Run Configurations] - [Arguments] - Program

		int month = Integer.parseInt(args[0]);
		String season = null;

		switch (month) {

		// case문에 break기 없을 경우 아래 문장을 수행한다.
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;

		case 3:
		case 4:
		case 5:
			season = "봄";
			break;

		case 6:
		case 7:
		case 8:
			season = "여름";
			break;

		case 9:
		case 10:
		case 11:
			season = "가을";
			break;

		default:
			season = "없는 계절";
		}

		System.out.printf("%d월은 %s입니다.", month, season);
	}
}
