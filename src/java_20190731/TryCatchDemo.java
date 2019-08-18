package java_20190731;

public class TryCatchDemo {

	private static double getAvg(int korean, int english) {
		int sum = korean + english;
		double avg = (double) sum / (double) 2;
		return avg;
	}

	public static void main(String[] args) {
		try {
			int korean = Integer.parseInt(args[0]);
			int english = Integer.parseInt(args[1]);
			double average = getAvg(korean, english);
			System.out.printf("평균 : %f\n", average);

		} catch (NumberFormatException e) {
			// System.out.println("예외 메세지 : " + e.getMessage());
			// e.printStackTrace();
			System.err.println("문자말고 숫자 너!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("2개 너");
		} finally {
			// 예외가 발생하더라도 무조건 수행
			System.out.println("finally");
		}
	}
}
