package java_20190716;

//ctrl + shift + f => 자동 줄 맞춤

public class OperatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10, b = 22;
		int c;
		double d;

		c = a + b;

		System.out.println(c);

		c = a - b;
		System.out.println(c);

		c = a * b;
		System.out.println(c);

		d = (double) b / (double) a;
		System.out.println(d);

		c = b % a;
		System.out.println(c);

		a += b;
		System.out.println(a);

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}

		System.out.println(sum);

		a++;
		++b;

		// 대입 후 a값 증가
		c = a++;
		System.out.println(c);

		// b값 증가 후 대입
		c = ++b;
		System.out.println(c);

		// ---------------------초기화-----------------------------------
		a = 10;
		b = 20;

		boolean isSuccess = false;
		isSuccess = a > b;
		System.out.println(isSuccess);

		isSuccess = a < b;
		System.out.println(isSuccess);

		isSuccess = a >= b;
		System.out.println(isSuccess);

		isSuccess = a <= b;
		System.out.println(isSuccess);

		isSuccess = a == b;
		System.out.println(isSuccess);

		isSuccess = a != b;
		System.out.println(isSuccess);

		// &&에서 앞에가 false일 경우, 뒤에 연산은 하지 않음
		// ||에서 앞에가 true일 경우, 뒤에 연산은 하지않음
		// 이것을 short circuit이라고 함
		isSuccess = a == b && a++ == b++;
		System.out.println(isSuccess);
		System.out.println(!isSuccess);
		// a++ == b++ 연산을 하지 않아 a와 b 값이 증가하지않고 유지됨
		System.out.println(a);
		System.out.println(b);

		// ------------------------------------------------------
		System.out.println(1 + 2 + 3 + "4" + 5 + 6); // 1+2+3을 연산하고 문자열과 만나면 값이 문자열로 바뀜

	}
}