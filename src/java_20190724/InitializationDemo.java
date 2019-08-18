package java_20190724;
// i18n => 국제화 

// l10n => 지역화 

public class InitializationDemo {
	int a;
	static int b;
	static final int C = 10; // final변수는 선언한 곳에서 직접 초기화 해야한다

	// static초기화 블럭 (main보다 먼저 호출됨)
	static {
		System.out.println("static area");
		b = 100;
	}

	// instance초기화 블럭
	{
		System.out.println("instance area");
		a = 10;
	}

	// 생성자에서 초기화 할 수 있는 변수는 instance변수만 가능
	public InitializationDemo(int a) {
		// super(); => 모든 생성자에 숨어있음
		System.out.println("생성자");
		this.a = a;
	}

	public static void main(String[] args) {
		System.out.println("main area");
		InitializationDemo i = new InitializationDemo(1000);
		System.out.println(i.a);
		System.out.println(i.b);
	}
}
