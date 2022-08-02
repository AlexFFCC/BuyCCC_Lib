package uuu.bccc.test;

import uuu.bccc.entity.Customer;
import uuu.bccc.exception.BCCCDataInvalidException;

public class TestCustomer {

	public static void main(String[] args) {
		try {Customer customer = new Customer();
		customer.setId("A123456789"); //String 會new String
		customer.setName("王奇葩");
		customer.setEmail("test01@uuu.com.tw");
		customer.setPassword("qwert123");
		customer.setBirthday(1965,2,27);
		//customer.birthday = LocalDate.of(2008,2,23);
		customer.setGender('S');
	
		
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
	}catch(BCCCDataInvalidException e) {
		System.out.println(e.getMessage());
	}
	}
}
