package java_20190724.aa;

//default class는 다른 패키지에서 접근이 불가능하다 => import를 통해서도 접근 불가
public class Test {
	//compiler는 클래스내에 생성자가 없으면 자동으로 디폴트 생성자를 만들어 준다.
	//이때 생성자의 접근 한정자는 클래스의 접근한정자와 동일하게 만들어 준다.
	//public Test() {}
}

//Test1, Test2클래스는 Test.java파일 안에서 선언은 가능하나 서로 다른 패키지에서 사용할 수 없다.

class Test1{
	
}
class Test2{
	
}