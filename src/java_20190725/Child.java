package java_20190725;

public class Child extends Parent {
	static int staticChild;
	String phone;

	static {
		staticChild = 200;
		System.out.println("Child static 초기화");
	}
	{
		System.out.println("Child instance block");
	}

	public Child() {
		super();
		System.out.println("Child 생성자");
	}
}
