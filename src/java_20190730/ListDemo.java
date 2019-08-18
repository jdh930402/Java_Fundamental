package java_20190730;

import java.util.ArrayList;

class Product {
	int number;
	String name;
	double price;

	public Product(int number, String name, double price) {
		this.number = number;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
}

public class ListDemo {
	public static void main(String[] args) {
		
		//ArrayList<제너릭> 변수 = new ArrayList<제너릭>();
		ArrayList<Product> list = new ArrayList<Product>();
		Product p1 = new Product(1, "terra", 2500);
		Product p2 = new Product(2, "신라면", 1000);
		Product p3 = new Product(3, "서울우유", 3000);
		Product p4 = new Product(1, "terra", 2500);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		// 모두 출력
		for (int i = 0; i < list.size(); i++) {
			Product temp = list.get(i);
			System.out.println(temp);
		}
		System.out.println();
		
		// enhanced for loop문으로도 출력이 가능(제너릭으로 선언한 경우)
		/*for (Product product : list) {
			System.out.println(product);
			
		}*/
		
		/* 모두 삭제
		for (int i = 0; i < list.size(); i++) {
			list.remove(i--);
		}
		*/
		for(Product product : list) {
			if(product.number == 3) {
				product.price = 3500;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Product temp = list.get(i);
			System.out.println(temp);
		}
		
	}
}
