package java_20190715;

public class LiteralDemo {
	public static void main(String[] args) {

		// byte a1 = (byte)128; //byte의 범위를 넘어가면 컴파일 에러 발생

		int a1 = 128; // 10진수 표기법
		int a2 = 076; // 8진수 표기법
		int a3 = 0x123; // 16진수 표기법

		long a4 = 2200000000l; // long 리터럴은 숫자 뒤에 l, L을 표기 => 표기 안한경우 자동으로 범위 안의 자료형으로 오토캐스팅 됨
		long a5 = 2100000000; // l, L을 표기 안해도 int로 오토캐스팅 되어 사용 가능

		float f1 = 1234.43f; // float 리터럴은 소수점 뒤에 f, F를 표기
		double d1 = 123455.56; // double 리터럴은 소수점 뒤에 d, D를 표기 또는 생략 가능

		boolean isExisted = false;// boolean 리터럴은 ture, false

		a1 = 10;
		d1 = 10.0d;

		int b1 = 10;
		int b2 = b1;
		b2 = 20;

		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2);
		System.out.println("a3 = " + a3 + "\n");

		System.out.println("a4 = " + a4);
		System.out.println("a5 = " + a5 + "\n");

		System.out.println("f1 = " + f1);
		System.out.println("d1 = " + d1 + "\n");

		System.out.print("a1==d1 = ");
		System.out.println(a1 == d1); // primitive data type의 ==연산자는 값만 비교함.
		System.out.println();

		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);

	}
}
