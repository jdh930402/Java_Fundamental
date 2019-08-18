package java_20190729;

import java.util.HashSet;

public class EqulasDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println();
		
		Car c1 = new Car("10101010", "black");
		Car c2 = new Car("10101010", "black");
		// c1과 c2가 같은 객체를 참조하면 true, 그렇지 않으면 false
		System.out.println(c1 == c2);
		// equals => c1과 c2가 같은 객체를 참조하면 true, 그렇지 않으면 false
		// equals를 오버라이딩하면 객체가 달라도 값을 비교한다.
		// equals를 오버라이딩하면 hashCode의 값을 같게 해야한다. => hashCode의 값도 오버라이딩해주어야한다.
		// alt + shift + s 누르고 hashCode() and equals()클릭하여 생성
		System.out.println(c1.equals(c2));
		System.out.println();

		// hashCode는 객체가 가지는 유일한 값, 반드시 유일한 값을 가져야함
		int hashCode1 = c1.hashCode();
		int hashCode2 = c2.hashCode();
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		System.out.println();

		Car c3 = new Car("101010", "white");
		Car c4 = c3;
		System.out.println(c3 == c4);
		System.out.println(c3.equals(c4));
		System.out.println();

		// c3.equals(c4)의 결과가 true이면, c3와 c4의 hashCode값은 같고
		// c3.equals(c4)의 결과가 false이면, c3와 c4의 hashCode값은 다르다
		int hashCode3 = c3.hashCode();
		int hashCode4 = c4.hashCode();
		System.out.println(hashCode3);
		System.out.println(hashCode4);
		System.out.println(c4.toString());
		
		HashSet<Car> set = new HashSet<Car>();
		set.add(c1);
		set.add(c2);
		System.out.println(set.size()); 
		//HashSet을 사용할 경우 HashCode를 오버라이딩 하지 않고 equals만 오버라이딩 한 경우 각각 다른 객체로 인삭한다.
		// 한 경우 size()값이 1, 안한경우 2가 나온다.
	}
}

class Car {
	String modelNumber;
	String color;

	public Car(String modelNumber, String color) {
		this.modelNumber = modelNumber;
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((modelNumber == null) ? 0 : modelNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (modelNumber == null) {
			if (other.modelNumber != null)
				return false;
		} else if (!modelNumber.equals(other.modelNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [modelNumber=" + modelNumber + ", color=" + color + "]";
	}
}
