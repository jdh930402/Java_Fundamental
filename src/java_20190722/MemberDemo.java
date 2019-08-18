package java_20190722;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();

		m.setName("홍길동");
		m.setZipcode("12345");
		m.setAddress1("서울시");
		m.setAddress2("용산구");
		m.setAge(30);
		m.setSsn1("111111");
		m.setSsn2("1111118");
		m.setRegdata("2019-07-22");

		System.out.println(m.getName());
		System.out.println(m.getZipcode());
		System.out.println(m.getAddress1());
		System.out.println(m.getAddress2());
		System.out.println(m.getAge());
		System.out.println(m.getSsn1());
		System.out.println(m.getSsn2());
		System.out.println(m.getRegdata());

	}
}
