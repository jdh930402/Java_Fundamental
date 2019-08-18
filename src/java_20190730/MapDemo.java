package java_20190730;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		// HashMap<제너릭key, 제너릭 value> : key값은 유일해야하고, value값은 중복이 가능하다
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 111111);
		map.put("2", 222222);
		map.put("3", 333333);
		map.put("4", 444444);
		map.put("5", 555555);
		map.put("1", 666666); // key값이 중복이면 value를 덮어쓴다.

		// 출력
		Integer value = map.get("1");
		System.out.println(value);

		// 모두 출력
		Set<String> set = map.keySet();
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			String k = i.next();
			Integer v = map.get(k);
			System.out.printf("key : %s, value : %d\n", k, v);
		}
	}
}
