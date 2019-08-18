package java_20190729;

public class ImplementClass implements InterA {

	@Override
	public void mB() {
		// TODO Auto-generated method stub
		System.out.println("mB()메서드");

	}

	@Override
	public void mC() {
		// TODO Auto-generated method stub
		System.out.println("mC()메서드");
	}

	@Override // @Override를 지우면 자체적인 메서드로 인식됨
	public void mA() {
		// TODO Auto-generated method stub
		System.out.println("mA()메서드");
	}

}
