//특수문자 사용 불가
package java_20190715;

public class IdentifierDemo {

	public static void main(String[] args) {
		// 정상 변수명
		int age = 10;
		String name = "hello";

		/*
		 * 비정상 변수명 String 1fatherName = "John"; // 첫글자로 숫자 사용 불가
		 * 
		 * String mother Name = "Michell"; // 공백 사용 불가
		 * 
		 * String void = "empty"; // 예약어는 변수로 사용 불가
		 */

		// 한글 사용가능하나 영어로만 코딩할 것
		String 이름 = "성영한";
		System.out.println(이름);
	}
}
