package java_20190717;

public class WhileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		int i = 0;
		while (i < 10) {
			i++;
			sum += i;
		}
		System.out.printf("1부터 10까지 짝수의 합은 %d입니다. \n", sum);

		int first = 2;
		while (first <= 9) {
			int second = 1;
			while (second <= 9) {
				System.out.printf("%d * %d = %d \n", first, second, first * second);
				second++;
			}

			first++;
		}

	}
}
