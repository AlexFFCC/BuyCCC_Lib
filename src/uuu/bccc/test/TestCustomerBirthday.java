package uuu.bccc.test;

import uuu.bccc.entity.Customer;
import uuu.bccc.exception.BCCCDataInvalidException;

public class TestCustomerBirthday {

	public static void main(String[] args) {
		try {
			Customer c1 = new Customer();
			c1.setBirthday("2000-04-12");
			System.out.println(c1.getBirthday());
			
			c1.setBirthday("2000-04-12");
			System.out.println(c1.getBirthday());
			
			c1.setBirthday(2000,2,35);
			System.out.println(c1.getBirthday());
			
		} catch (BCCCDataInvalidException e) {
			System.out.println(e.getMessage());
		}

	}

}
