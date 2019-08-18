package java_20190715;

public class CharLiteralDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char c1 = '\uc9c0';
		char c2 = '\ub3d9';
		char c3 = '\ud601';

		// 유니코드 표현
		System.out.print("유니코드 : ");
		System.out.print(c1);
		System.out.print(c2);
		System.out.println(c3);

		// 아스키코드로 A표현 => 가장 쓸모있음
		char c4 = 65;
		System.out.println("아스키코드 : " + c4);

		// 특수문자 (escape character)
		// char, String형에서 \ ' "는 앞에 \를 반드시 붙여 사용한다.
		char c5 = '\''; // '을 믄자로 인식하기 위해서 앞에 \를 입력
		char c6 = '\\'; // \을 문자로 인식하기 위해서 앞에 \를 입력
		char c7 = '\"'; // "를 문자로 인식하기 위해서 앞에 \를 입력

		// char, String형에서 \ ' "는 앞에 \를 반드시 붙여 사용한다.
		String path = "C:\\dev\\eclipse"; // 경로 사용시 예
	}
}
