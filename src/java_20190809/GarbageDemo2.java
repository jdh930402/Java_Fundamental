package java_20190809;

import java.util.ArrayList;
import java.util.Arrays;


public class GarbageDemo2 {
	public static void main(String[] args) {
		CustomerDao c = new CustomerDao();
		
		for (Customer customer : c.getCustomer()) {
			System.out.println(customer.getName());
		}
		
		for( Customer customer : c.getCustomers()) {
			System.out.println(customer.getName());
		}
		
	}
}

class Customer{
	String name;
	Customer(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class CustomerDao{
	
	Customer[] cs;
	public Customer[] getCustomer() {
		Customer[] cs = new Customer[10];
		cs[0] = new Customer("성영한1");
		cs[1] = new Customer("성영한2");
		cs[2] = new Customer("성영한3");
		cs[3] = new Customer("성영한4");
		cs[4] = new Customer("성영한5");
		cs[5] = new Customer("성영한6");
		cs[6] = new Customer("성영한7");
		cs[7] = new Customer("성영한8");
		cs[8] = new Customer("성영한9");
		cs[9]= new Customer("성영한10");

		return cs;
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("성영한1"));
		list.add(new Customer("성영한2"));
		list.add(new Customer("성영한3"));
		list.add(new Customer("성영한4"));
		list.add(new Customer("성영한5"));
		list.add(new Customer("성영한6"));
		list.add(new Customer("성영한7"));
		list.add(new Customer("성영한8"));
		list.add(new Customer("성영한9"));
		list.add(new Customer("성영한10"));		
		return list;
	}
}

