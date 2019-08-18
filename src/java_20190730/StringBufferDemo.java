package java_20190730;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		StringBuffer s2 = new StringBuffer("test");
		System.out.println(s1 == s2);
		// equals()메소드가 오버라이딩 안됨 => String클래스에서는 equals()가 자동으로 오버라이딩 되어있지만 다른 클래스에서는
		// 오버라이딩이 안되어있다.
		System.out.println(s1.equals(s2));

		// StringBuffer는 문자열을 연결하기 위한 타입으로 toString()메서드를 이용하여 String타입으로 변경 후 비교할 것.
		// StringBuffer => String으로 변경
		String s3 = s1.toString();
		String s4 = s2.toString();
		System.out.println(s3.equals(s4));

		StringBuffer sql = new StringBuffer("select name, age");
		sql.append("from member ");
		sql.append("where name = '성영한' ");
		sql.append("order by name desc");
		System.out.println(sql);

		// sql의 길이를 0으로 만듬(초기화)
		sql.setLength(0);

		sql.append("select no, writer from board");
		System.out.println(sql);
	}
}
