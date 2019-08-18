package java_20190725;

public class Parent {
	static int staticParent;
	String name;

	static {
		staticParent = 20;
		System.out.println("parent static 초기화");
	}
	{
		System.out.println("parent instance block");
	}
	
	public Parent() {
		super();
		System.out.println("Parent 생성자");
	}
}
