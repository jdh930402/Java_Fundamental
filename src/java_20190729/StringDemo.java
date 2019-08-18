package java_20190729;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));

		// 문자열을 연결하면 Constant Pool에 계속 쌓임
		// 문자열 연결은 안하는것이 좋다.
		// 문자열을 연결하고 싶다면 StringBuffer클래스를 이용한다.
		String sql = "select id, pwd, email from member";
		sql += "where id = 'syh1011' and email = 'sdf@sf.com'";
		sql += "";

		// 문자열은 연결하지 않는것이 좋다
		String ssn = "111111-1111118";
		char c = ssn.charAt(6);
		System.out.println(c);
		System.out.println(ssn);

		// ★★★ endsWith(String str) => 문자열의 마지막이 str일 경우 true, str이 아닌 경우 false
		String fileName = "abd.abd.doc";
		if (fileName.endsWith("zip")) {
			System.out.println("압축 파일입니다.");
		} else if (fileName.endsWith("doc")) {
			System.out.println("워드 문서입니다.");
		} else {
			System.out.println("파일입니다.");
		}

		// equalsIgnoreCase(String str) : str문자열의 대소문자를 구분하지 않고 비교하여 같은 경우 true, 다를 경우
		// false
		System.out.println(fileName.equalsIgnoreCase("ABD.DOC"));

		// indexOf(String str) : str문자열의 위치를 반환한다
		int index = ssn.indexOf("-");
		System.out.println(index);

		// ★★★ lastIndexOf(String str) : 마지막에 오는 str문자열의 위치를 맨 앞에있는 문자의 인덱스기준으로 반환한다.
		index = fileName.lastIndexOf(".");
		System.out.println(index);

		// ★★★★★ substring(int first, int second) : first이상 second미만까지의 문자열을 추춣하며
		// first만 있을 경우, first이상부터 마지막까지의 문자열을 추출한다.
		String first = fileName.substring(0, fileName.lastIndexOf(".")); // a이상 b미만
		String second = fileName.substring(fileName.lastIndexOf(".") + 1); // a이상 모두
		System.out.println(first);
		System.out.println(second);

		// replaceAll(String old, String new) : 문자열 안에 old문자열을 new문자열로 변환한다.
		String html = "안녕하세요\n저는 성영한입니다.\n잘 부탁드립니다.";
		html = html.replaceAll("\n", "<br>"); // html의 개행은 <br>이다.
		System.out.println(html);

		String url = "http://www.naver.com";
		String path = "/news/sdfsdf.do?id=123&cat=1010";
		if (path.startsWith("/news")) { // startWith(String str) : str문자열로 시작할 경우 true, 아닐 경우 false
			System.out.println("뉴스 페이지입니다.");
		} else if (path.startsWith("/sports")) {
			System.out.println("스포츠 페이지입니다.");
		} else {
			System.out.println("페이지가 존재하지않습니다.");
		}

		String m1 = "Hello";
		String m2 = "Hello ";
		System.out.println(m1.length());// length() : 문자열의 길이를 반환
		System.out.println(m2.length());
		if (m1.equals(m2.trim())) { // trim() : 빈 공백을 제거
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		m1 = m1.toUpperCase(); // toUpperCase() : 대문자로 변환
		System.out.println(m1);

		m1 = m1.toLowerCase(); // toLowerCase() : 소문자로 변환
		System.out.println(m1);

		int a = 10;
		String str = String.valueOf(a); // primitive type을 문자열로 변환

		char[] c1 = { 'a', 'b', 'c' };
		String str1 = String.valueOf(c1, 0, 2);
		System.out.println(str1);

		// split(String delimiter) : 문자열을 구분자(delimiter)로 토큰(token)화 시키는 메서드
		String[] strArray = ssn.split("-");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		
		//
		String str2 = String.format("%,.2f", 1234.12512);
		System.out.println(str2);
		
		str2 = String.format("%,d", 1000000);
		System.out.println(str2);
	}
}
