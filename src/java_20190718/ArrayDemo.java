package java_20190718;

/*
 * String의 길이는 변수.length(); => 메소드
 * Array의 길이는 변수.length; => 속성값
 */

public class ArrayDemo {

	public static void main(String[] args) {

		// int 배열 선언
		int[] a = new int[4];

		// 배열 할당
		a[0] = 100;
		a[1] = 200;
		a[2] = 300;
		a[3] = 400;

		// 배열 출력
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			System.out.println(a[i]);
		}

		System.out.printf("배열의 총합은 %d입니다.\n", sum);

		// 배열 생성과 할당을 동시에 함
		int[] b = new int[] { 1000, 2000, 3000, 4000 };

		// 배열 값을 변경(할당)
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		b[3] = 4;

		// 배열의 출력
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}