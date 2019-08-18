package java_20190729;

public class MethDemo {
	public static void main(String[] args) {
		double d1 = Math.ceil(4.1); // 올림
		System.out.println(d1);

		d1 = Math.floor(4.9); // 내림
		System.out.println(d1);

		double d2 = 42.789;
		System.out.printf("%.2f\n", d2); // 42.79

		d2 = Math.round(d2 * 100); // 반올림
		d2 = d2 / 100;
		System.out.println(d2); //42.79

		double d3 = Math.abs(-4.2); // 절대값
		System.out.println(d3);

		double d4 = Math.sqrt(4); // 제곱근
		System.out.println(d4);
		
		double d5 = Math.pow(2,50); // 제곱
		System.out.println(d5);

		double d6 = Math.random(); // 랜덤값
		System.out.println(d6);
	}
}
