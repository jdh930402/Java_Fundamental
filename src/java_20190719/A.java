package java_20190719;

//한 파일 안에 여러개의 클래스가 존재할 때 public은 파일이름과 동일한 클래스에만 사용 가능
public class A {
	String name;
	int age;

	public void m() {
		System.out.println("m() 메서드");
	}

	public static void main(String[] args) {
		A a = new A();
		a.name = "성영한";
		a.age = 20;

		System.out.println(a.name);
		System.out.println(a.age);
		int[] d = new int[1];
		int[] f = d;
		f[0] = 1;
		System.out.println(f[0]);
		a.m();
	}
}

class B {
	// main 메서드가 실행되기 위해서는 public이 추가된 클래스에서만 작동됨
	// main 메서드가 실행되기 위해서는 파일이름과 동일한 크래스에서 작동
	public static void main(String[] args) {
		System.out.println("Hello2");
	}
}
