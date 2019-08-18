package java_20190723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalendarDemo {
	public static String console() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) throws IOException {
		Calendar c = new Calendar();
		while (true) {
			System.out.print("날짜를 입력하세요>");
			String readLine = console();
			if (readLine.equals("exit"))
				break;

			// split메서드는 문자열을 분리시키켜 배열로 반환한다.
			String[] data = readLine.split(" ");
			int dataLength = data.length;
			if (dataLength == 1) {
				// String sYear = data[0];
				int year = Integer.parseInt(data[0]);
				c.print(year);

			} else if (dataLength == 2) {
				// String sYear = data[0];
				// String sMonth = data[1];
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				c.print(year, month);

			} else if (dataLength == 3) {
				// String sYear = data[0];
				// String sMonth = data[1];
				// String sDay = data[2];
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				int day = Integer.parseInt(data[2]);
				c.print(year, month, day);

			} else {

			}
		}
	}
}
