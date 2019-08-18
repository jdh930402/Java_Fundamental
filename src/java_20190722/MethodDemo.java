package java_20190722;

public class MethodDemo {
	// boolean은 메서드의 반환값
	// instance 메서드
	// int year => 매개변수(parameter)
	public boolean isLeafYear(int year) {
		// 메서드의 반환값이 boolean이기 때문에 return의 value값도 boolean이어야한다.
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public char charofString(String msg, int index) {
		// 해당 문자열을 인덱스 값에 따라 반환
		return msg.charAt(index);
	}

	public long plus(int first, int second) {
		return (long) first + (long) second;
	}

	public double divide(int first, int second) {
		return (double) first / (double) second;
	}

	public void ascending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		MethodDemo m1 = new MethodDemo();
		// 인스턴스 메서드의 사용방법
		// 객체를 생성한후 reference(m1)을 이용해 호출하면 됨
		// 2019 => 전달인자(argument)
		boolean isLeafYear = m1.isLeafYear(234);
		System.out.println(isLeafYear);
		System.out.println(new MethodDemo().isLeafYear(2019));// 만약 한번만 호출하고 말 경우 이와같이 호출하면 됨
		// "Hello",0 => 전달인자(argument)
		char c = m1.charofString("Hello", 0);
		System.out.println(c);
		long sum = m1.plus(2100000000, 2100000000);
		System.out.println(sum);

		double div = m1.divide(6, 4);
		System.out.println(div);

		int[] temp = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int a : temp) {
			System.out.print(a + " ");
		}
		System.out.println();

		m1.ascending(temp); // call by reference에서는 temp와 ascending()에서 받는 파라미터가 같은 값을 가리키기때문에
							// reference 타입은 return받을 필요가 없다.
							// primitive 타입은 값을 새로 생성하기 때문에 return을 받아야한다.
							// Ex) int a = 10, int b = a일떼 a와 b의 값이 따로 생성됨
							// int[] a, int[] b이고 a = b일때 a = b = 같은 배열을 가리킴
		for (int a : temp) {
			System.out.print(a + " ");
		}
	}
}
