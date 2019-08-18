package java_20190717;

public class BreakDemo {
	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i == 6) {
				break;
			}
			sum += i;
		}
		System.out.printf("1부터5까지 합은 %d입니다. \n", sum);

		outter: // outter는 lable명. 다중 반복문 일때, break lable을 이용하여 lable의 블록으로 빠져나갈 수 있음.
		for (int first = 2; first <= 9; first++) {
			for (int second = 1; second <= 9; second++) {
				if (first == 4 && second == 8) {
					break outter;
				}
				System.out.printf("%d * %d = %d \n", first, second, first * second);
			}
		}
	}
}
