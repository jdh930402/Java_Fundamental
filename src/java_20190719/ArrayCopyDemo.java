package java_20190719;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		String[] fruits = { "apple", "banana", "watermelon", "blueberry" };
		String[] temp = new String[6];
		System.arraycopy(fruits, 0, temp, 0, 4);
		// src : 원본배열, srcPos : 복사할 원본배열의 위치, dest : 복사받을 배열, destPos : 복사받을 배열 위치,
		// length : 복사할 길이

		temp[4] = "peach";
		temp[5] = "rasberry";

		for (String str : temp) {
			System.out.println(str);
		}
	}
}
