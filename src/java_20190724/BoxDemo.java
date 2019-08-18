package java_20190724;

public class BoxDemo{
	int a;
	static int b;
	
	public static void main(String[] args) {
		BoxDemo b = new BoxDemo();
		b.a = 10; // static메서드에서 instance멤버변수에 접근하는 방법
		BoxDemo.b = 10; // static멤버변수는 static메서드에 바로 접근 가능하나 클래스명.변수명으로 접근하는 것이 관례이다

		Box b1 = new Box();
		b1.width = 10;
		b1.height = 20;
		b1.depth = 30;

		Box b2 = new Box();
		b2.width = 10;
		b2.height = 20;
		b2.depth = 30;

		System.out.println(b1.equals(b2));// true => 오버라이딩을 해야한다.
		// b1 == b2 => reference비교 일때는 b1과 b2가 같은 오브젝트를 참조하면 true, 그렇지 않으면 false
		System.out.println(b1 == b2); // false
		Box b3 = b2;
		System.out.println(b3 == b2); // true

		// Box b2 = b1; => *같이 바라보게 할때는 이런식으로 하지 않고 메서드로 사용함

		System.out.printf("width : %d height : %d depth : %d\n", b1.width, b1.height, b1.depth);
		b1.change(b1); // call by reference => b1의 값과 Box클래스의 change(Box b)메서드가 가리키는 위치가 같아짐
		System.out.printf("width : %d height : %d depth : %d", b1.width, b1.height, b1.depth);
	}
}
