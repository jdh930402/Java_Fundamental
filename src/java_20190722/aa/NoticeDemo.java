package java_20190722.aa;

public class NoticeDemo {
	public static void main(String[] args) {

		Notice n1 = new Notice();

		n1.number = 1; // public => 서로 다른 패키지에서도 접근 가능

		n1.title = "공지사항입니다."; // protected => 서로 다른 패키지에서 상속받은 경우에는 접근 가능

		n1.hit = 0; // default => 같은 패키지 안에서 사용 가능

		// n1.regdate ="2019"; //private => 같은 클래스 안에서만 사용 가능
	}

}
