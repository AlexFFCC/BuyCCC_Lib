package uuu.bccc.test;

import java.time.LocalDate;

import uuu.bccc.entity.Customer;

public class TestCustomerCheckId {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(new String("A123456789")); //String 會new String
		customer.setName("王奇葩");
		customer.setEmail("test01@uuu.com.tw");
		customer.setPassword("qwert123");
		customer.setBirthday(LocalDate.parse("2001-09-02"));
		customer.setGender('M');

		
		System.out.println(customer.getId()); 
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getPassword());
		System.out.println(customer.getBirthday());
		System.out.println(customer.getBirthday().getDayOfWeek());//原來的沒有＝指派，所以是讀取get
		System.out.println(customer.getGender());
		System.out.println(customer.getAddress());
		System.out.println(customer.getPhone());
		System.out.println(customer.isSubscribed());
		
	}

}
