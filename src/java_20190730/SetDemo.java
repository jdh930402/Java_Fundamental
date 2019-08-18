package java_20190730;

import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {

	// Collection은 Primitive type을 인식하지 못함
	public static void main(String[] args) {
		// 자동 import : ctrl + shift + o
		// HashSet은 데이터(객체)의 중복을 허용하지않고, 순서가 없음
		// equals와 hashCode 값을 비교하여 일치하면 제외
		// HashSet set = new HashSet();

		// TreeSet은 데이터(객체)의 중복을 허용하지않고, 오름차순 정렬
		TreeSet<Integer> set = new TreeSet<Integer>();

		while (true) {
			int random = (int) (Math.random() * 45) + 1;

			// add() : 값을 할당
			// Auto-boxing : Primitive type => Wrapper Class로 변환 (int => Integer)
			// 변환됨)
			set.add(random);

			// HashSet의 크기
			if (set.size() == 6)
				break;
		}

		// HashSet의 출력은 Iterator(반복자)로 출력해야한다.
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) { // hasNext() : HashSet에 출력할 객체가 존재하는지 판단하는 메서드
			// Auto-unboxing : Wrapper Class => Primitive type으로 변환 ( Integer => int)
			int temp = i.next(); // next() : 해당 객체를 가져오는 메서드
			System.out.println(temp + "\t");
		}
	}
}
