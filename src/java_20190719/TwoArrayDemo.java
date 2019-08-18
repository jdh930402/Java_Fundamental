package java_20190719;

public class TwoArrayDemo {

	public static void main(String[] args) {
		int[][] a = new int[3][2];
		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;

		int[][] b = { { 10 }, { 20, 30 }, { 40, 50, 60 } };

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}

		int[] c = { 10, 20, 30 };

		// enhanced for loop
		for (int temp : c) { // 배열의 끝까지 자동으로 출력
			System.out.println(temp);
		}

	}
}
