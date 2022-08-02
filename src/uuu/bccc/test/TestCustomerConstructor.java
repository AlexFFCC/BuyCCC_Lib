package uuu.bccc.test;

import uuu.bccc.entity.Customer;

public class TestCustomerConstructor {

	public static void main(String[] args) {
		Customer c =new Customer("A123456789","吳奇葩","QWE123");
		
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getPassword());
		System.out.println(c.getBirthday());//null
		System.out.println(c.getEmail());
		System.out.println(c.getGender());//
		System.out.println(c.getAddress()); //null
		System.out.println(c.getPhone());//
		System.out.println(c.isSubscribed());//false
		

	}

}
