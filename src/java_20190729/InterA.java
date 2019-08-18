package java_20190729;

public interface InterA extends InterB, InterC {
	// 인터페이스의 변수(public static final이 생략되어져 있다)
	public static final double PI = 3.14;

	// 인터페이스의 메서드(접근한정자를 붙이지 않아도 public이 생략되어 있다)
	// abstract가 생략 가능
	public abstract void mA();
}
