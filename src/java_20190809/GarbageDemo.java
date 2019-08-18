package java_20190809;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

class A extends Thread { // 스레드를 상속받았으므로 A클래스를 스레드로 사용 가능
	public void run() {
		System.out.println("뿅");
	}
}

class B implements Runnable { // 객체를 생성하여 스레드를 사용 가능
	@Override
	public void run() {
		System.out.println("뿅뿅");
	}
}


public class GarbageDemo {
	
	public static void m(String a) {
		a += "abc";
	}

		
	
	public static void main(String[] args) {
		System.out.println("뿅뿅뿅뿅뿅뿅뿅뿅뿅");
		A a = new A();
		a.start();

		Thread t = new Thread(new B());
		t.start();
		
		int d = Integer.parseInt("10");
		String e = String.valueOf(d);
		
		Random rnd = new Random();
		int number = rnd.nextInt(10)+1;
		System.out.println(number);
		
		String str = "123";

		m(str);
		System.out.println(str +"\n");
		
		String s = "abc$def$fsdfsf%asr.zip";
		String[] split = s.split("\\$");
		for(String temp : split) {
			System.out.print(temp);
		}
		System.out.println();
		// split(Strig regex)=> regex는 regular expression(정규 표현식)
		// 구분자로 사용하지 못하고 "\\"를 앞에 붙여주면 사용 가능하다.
		
		System.out.printf("%50d\n",1000000);
		System.out.printf("%50d\n",100);
		System.out.printf("%50d\n",10000);
		StringBuffer sb = new StringBuffer("dasdas");
		String ss = String.valueOf(sb);
		System.out.println(ss.equals("dasdas"));
		
		
	}

	// Calendar 클래스의 메서드만 사용가능
	// 단, GregorianCalendar 클래스에서 overriding된 메서드는 사용가능
	public static Calendar getInstance() {
		return new GregorianCalendar();
	}
}


