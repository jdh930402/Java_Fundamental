package java_20190722;

import java_20190719.Customer;

public class CustomerStaticDemo {
	public static void main(String[] args) {
		// static변수는 객체가 동일한 값을 갖는 속성에 한하여 사용한다.
		Customer.interestRate = 3.7;

		Customer c1 = new Customer();
		c1.name = "홍길동";
		c1.age = 40;
		c1.email = "kdhong@test.com";
		c1.phone = "010-8080-0987";
		c1.balance = 190000.43;
		c1.isReleased = false;
		// c1.interestRate = 3.5; => static변수는 모든 객체가 공유하는 변수이기 때문에 클래스명.변수명으로 접근하는것이
		// 좋다. (reference로도 접근 가능하지만 권장하지 않음)
		// Customer.BANKNAME = "국민은행"; => final 함수는 한번 정해지면 값 할당 자체가 불가능

		System.out.println(Customer.interestRate);

		Customer c2 = new Customer();
		c2.name = "아무개";
		c2.age = 50;
		c2.email = "noname@test.com";
		c2.phone = "010-2354-9876";
		c2.balance = 3500000.45;
		c2.isReleased = false;
		System.out.println(Customer.interestRate);

		Customer c3 = new Customer();
		c3.name = "베조스";
		c3.age = 62;
		c3.email = "jaws@amazon.com";
		c3.phone = "010-1111-11111";
		c3.balance = 12000000000.45;
		c3.isReleased = true;
		System.out.println(Customer.interestRate);

	}

}
