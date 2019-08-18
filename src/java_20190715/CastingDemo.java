package java_20190715;

public class CastingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// byte b1 = 250; //overflow 발생하여 컴파일 에러
		byte b1 = (byte) 250; // circuit이 발생, 권장하지 않음
		System.out.println(b1);

		int i1 = (int) 123.45; // cut 발생
		System.out.println(i1);

		double d1 = 123.45f; // 자동 형변환
		System.out.println(d1);

		byte b2 = 10;
		byte b3 = 20;
		byte b4 = (byte) (b2 + b3); // 산술 연산자는 데이터 타입을 int로 변환
									// 그러므로 byte로 형변환해야함
		System.out.println(b4);
	}
}
