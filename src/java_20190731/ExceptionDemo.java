package java_20190731;

import java.util.ArrayList;

public class ExceptionDemo {
	public static void main(String[] args) {

		// NumberFormatException
		try {
			int i = Integer.parseInt("a");
			System.out.println(i);

		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException => 숫자가 아닌 값이 들어왔을 때 발생");
		}

		try {
			int[] a = { 1, 2, 3, 4 };
			System.out.println(a[4]);

		}

		// ArrayIndexOutOfBoundsException
		catch (ArrayIndexOutOfBoundsException b) {
			System.err.println("ArrayIndexOutOfBoundsException => 배열의 인덱스의 범위를 벗어났을 때 발생");
		}

		// IndexOutOfBoundsException
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			System.out.println(list.get(2));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException => 인덱스의 범위를 벗어났을 때 발생");
		}

		// NullPointerException
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.err.println("NullPointerException => null값이 입력되었을 때 발생");
		}

		// ArithmeticException
		try {
			int b = 0;
			int c = 1;
			System.out.println(c / b);
		} catch (ArithmeticException e) {
			System.err.println("ArithmeticException => 분모가 0인 경우 발생");
		}
	}
}
