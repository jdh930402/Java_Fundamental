package java_20190729;

import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); // object만 담을 수 있다.
		// 자바 1.4이전 버전에서는 primitive type을 Collection에 저장 할 수 없었기 때문에 primitive type을 객체화
		// 할 수 있는 Wrapper으로 변환하여 저장해야한다.
		// 아래와 같이 1을 add할 수 없다.
		list.add(1);
		list.add(new Integer(1)); // Wrapper class를 사용한다(primitive type 한정)

		// 1.primitive type => Wrapper class(생성자를 이용 => new Integer(10))
		// Collection에 담기 위해서 사용
		Integer i2 = new Integer(10);
		Integer i3 = new Integer(20);

		// 	2.String => Wrapper class(Integer.valueOf("10"))
		String s1 = "10";
		String s2 = "20";
		Integer i1 = Integer.valueOf(s1);

		// 3.Wrapper class => primitive type(intValue())
		int temp = i2.intValue() + i3.intValue();

		// ★★★★★ 4.String => primitive type(Integer.parseInt())
		System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2));
		// ★5. primitive type => String
		int a1 = 10;
		String s3 = String.valueOf(a1);

		// auto-boxing : primitive type을 자동으로 Wrapper class로 변환
		Integer i4 = 10;

		// auto-unboxing : Wrapper class를 자동으로 primitive type으로 변환
		int a2 = i2 + i3;
	}
}
