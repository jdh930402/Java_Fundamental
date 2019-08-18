package java_20190723;
// 자동완성
// 디폴트 생성자 => alt + shift + s 누른 후 c
// 매개변수가 있는 생성자 => alt + shift + s 누른 후 o
// setter/getter => alt + shift + s 누른 후 r 

public class Admin {
	// 항상 default생성자와 모든 변수에 대한

	// 인스턴스 변수는 항상 private로 설정해놔야한다.
	private String id;
	private String pwd;
	private String email;
	private int level;

	// 디폴트 생성자 (default constructor)
	// 다른 생성자가 존재하면 자동으로 만들어주지 않음
	public Admin() {
		super(); // 생성자의 첫 라인에 항상 존재.
	}

	// 생성자 (constructor)
	// 생성자는 반환값이 없고, 이름은 클래스 이름과 동일하게
	// 역할은 인스턴스 변수 초기화 (값을 처음으로 할당)
	public Admin(String id, String pwd, String email, int level) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.level = level;
	}

	public Admin(String id, String pwd, String email) {
		// this.id = id;
		// this.pwd = pwd;
		// this.email = email;
		this(id, pwd, email, 0); // 매개변수가 4개인 생성자를 호출 (나머지 값은 default값을 넣어준다.) => 생성자에서만 사용 가능
		// this 용법 2가지
		// 1. 자기 자신 객체 => this.
		// 2. 다른 생성자 호출 => this(~~) : 생성자에서만 사용 가능
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
