package java_20190724;

public class Box {
	// 클래스 안에 있고 메서드 밖에 있는 변수를 멤버변수라한다
	// 멤버변수는 default값으로 자동으로 초기화된다
	int width;
	int height;
	int depth;

	// final 변수는 멤버변수 위치에서 초기화 해야한다.
	// 한번 정해지면 변경 불가
	// final 변수명은 대문자로 하는 것이 관례
	// fianl 변수는 변수의 특성상 인스턴스 변수로 처리하지 않고 static변수로 처리함.
	static final String Name = "BOX";

	public void change(Box b) {
		// 메서드 내에서 매개변수를 포함한 사용자가 정의한 변수를 지역변수라고 한다
		// 지역변수는 자동으로 초기화 되지 않기 때문에 기본값을 저장하고 사용한다
		// 지역변수의 유효범위는 메서드 안에서만 사용 가능
		b.depth = 3000;
	}

	// equals는 반드시 오버라이딩 해야한다. 안할시 ==과 같은 연산을 수행
	public boolean equals(Object b) {
		boolean isEquals = false;
		if (this.width == ((Box) b).width && this.height == ((Box) b).height && this.depth == ((Box) b).depth)
			isEquals = true;
		return isEquals;
	}

}
