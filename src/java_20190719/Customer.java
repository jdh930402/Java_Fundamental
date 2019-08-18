package java_20190719;

public class Customer {
	// 개체 참조 변수
	public String name;
	public String email;
	public String phone;

	// 개체 속성 변수
	public int age;
	public double balance;
	public boolean isReleased;
	public static double interestRate; // static변수. static 변수는 객체가 생설될 때 존재하지않고 따로 존재한다.
										// 모든 객체들이 공유하는 변수

	public static final String BANKNAME = "신한은행"; // final 변수는 불변하는 값이기 때문에 주로 static함수로 사용한다
													// 만약 인스턴스 변수로 생성할 경우 메모리 낭비

}
