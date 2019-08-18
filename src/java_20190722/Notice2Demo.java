package java_20190722;

import java_20190722.aa.Notice;

public class Notice2Demo extends Notice {
	public static void main(String[] args) {

		Notice n1 = new Notice();

		n1.number = 1; // public => 서로 다른 패키지에서도 접근 가능

		// n1.title = "공지사항입니다."; //protected => 서로 다른 패키지에서 상속받은 경우에는 접근 가능

		// n1.hit = 0; // default => 같은 패키지 안에서 사용 가능

		// n1.regdate ="2019"; //private => 같은 클래스 안에서만 사용 가능

		// 부모 클래스인 Notice에서 접근할 수 있는 접근 한정자는 public, protected
		Notice2Demo n2 = new Notice2Demo();

		n2.number = 1; // public => 서로 다른 패키지에서도 접근 가능

		n2.title = "공지사항입니다."; // protected => 서로 다른 패키지에서 상속받은 경우에는 접근 가능

		// n1.hit = 0; //default => 같은 패키지 안에서 사용 가능

		// n1.regdate ="2019"; //private => 같은 클래스 안에서만 사용 가능

	}

}
