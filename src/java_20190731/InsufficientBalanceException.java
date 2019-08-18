package java_20190731;

//사용자 정의 예외 클래스
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String msg) {
		// Exception클래스의 매개변수 String인 생성자를 호츨
		// msg는 에러 메세지를 출력할 목적으로 사용된다
		super(msg);
	}
}
