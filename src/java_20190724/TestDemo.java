package java_20190724;

import java_20190724.aa.*; // Test클래스를 import하기 위해서는 Test클래스의 접근한정자는 public이어야한다. 

public class TestDemo {
	public static void main(String[] args) {
		Test t = new Test(); // 서로 다른패키지일 경우, 생성자가 default일 경우 접근 불가
		// Math m = new Math(); // Math클래스는 생성자는 private이여서 객체 생성은 불가능
		// 만약 static메서드로 만들 경우 클래스.메서드명으로 호출가능
	}
}