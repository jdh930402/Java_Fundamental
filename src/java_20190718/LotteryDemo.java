package java_20190718;

public class LotteryDemo {

	public static void main(String[] args) {

		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {

			double random = Math.random(); // Math.random() => 0보다 크거나 같고 1보다 작은 수를 랜덤으로 double값으로 반환
			int rnd = (int) (random * 45) + 1; // 1 ~ 45 까지의 숫자를 rnd에 반환

			if (i == 0) { // 첫번째 방은 무조건 임의의 값 temp를 저장한다.
				lotto[i] = rnd;
			} else {// isExisted는 임의의 값 temp와 이전 배열의 값을 빅했을때 동일한 값이 있는 경우
				boolean isExisted = false;

				// i==1 아래의 for loop는 1번 반복
				// i==2 아래의 for loop는 2번 반복.....
				for (int j = 0; j < i; j++) {
					if (lotto[j] == rnd) {
						// 새로 생성한 rnd와 이전 배열의 값을 비교
						// 비교값이 같은 값이 존재하면
						isExisted = true;
						break;
					}
				}
				if (!isExisted) {
					lotto[i] = rnd;
				} else {
					i--;
				}
			}
		}

		// 선택정렬
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}

		// 출력
		for (int i = 0; i < lotto.length - 1; i++) {
			System.out.print(lotto[i] + ",");
		}
		System.out.print(lotto[lotto.length - 1]);
	}
}