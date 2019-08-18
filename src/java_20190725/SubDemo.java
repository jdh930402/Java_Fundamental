package java_20190725;

public class SubDemo {
	public static void main(String[] args) {
		Sub s1 = new Sub();
		s1.makeMoney();// 부모클래스의 메소드
		s1.gotoSchool();
		s1.play("starcraft");
		System.out.println();
		s1.money = 1000000;
		s1.chicken = "교촌치킨 2마리";

		// 부모의 멤버변수, 메서드 접근가능
		// 자식의 멤버변수 접근불가, 메서드 접근가능
		// 자식의 메서드 중에서 오버라이딩 된 메서드 접근 가능
		Super s2 = new Sub();
		s2.makeMoney();
		// s2.gotoSchool(); => Super타입이기 때문에 자식클래스의 gotoSchool메소드는 호출 불가
		s2.play("omok"); // play()메서드는 오버라이딩 되었기때문에 동적바인딩 되어서 Sub의 play()가 호출됨
		System.out.println();
	}
}
