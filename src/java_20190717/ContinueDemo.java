package java_20190717;

public class ContinueDemo {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i == 6) {
				continue;
			}
			sum += i;
		}
		System.out.printf("1부터 10까지 합은 %d입니다. \n", sum);
		// outter는 lable명
		outter: for (int first = 2; first <= 9; first++) {
			for (int second = 1; second <= 9; second++) {
				if (second == 5) {
					continue outter;
				}
				System.out.printf("%d * %d = %d \n", first, second, first * second);
			}
		}
	}
}
