package java_20190724;

public class Employee extends Customer {
	String zipcode;
	String address1;
	String address2;
	String id;
	String pwd;
	
	public Customer change(Employee e) {
		Customer c = e;
		return c;
	}
}
