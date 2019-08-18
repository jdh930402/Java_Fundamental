package java_20190723;

public class PrimeNumber {

	public void printPrimeNumber(int temp) {
		boolean isPrimeNumber = false;
		int count = 0;

		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;
			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				count++;
				System.out.print(i + "\t");
			}
		}
		System.out.println();
		System.out.print("소수의 개수 : ");
		System.out.println(count);
	}

	public int[] getPrimeNumber(int temp) {
		int[] number = new int[temp];
		boolean isPrimeNumber = false;
		int count = 0;

		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;
			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				number[count] = i;
				count++;
			}
		}
		int[] copyArray = new int[count];
		System.arraycopy(number, 0, copyArray, 0, count);
		return copyArray;
	}
}