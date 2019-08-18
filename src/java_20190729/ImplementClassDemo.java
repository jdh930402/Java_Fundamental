package java_20190729;

public class ImplementClassDemo {
	public static void main(String[] args) {
		InterA i = new ImplementClass();
		i.mA();
		i.mB();
		i.mC();
		// i.PI = 3.15; => final변수이기 때문에 변경할 수 없다.
		System.out.println(i.PI);
	}
}
