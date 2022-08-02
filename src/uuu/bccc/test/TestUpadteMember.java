package uuu.bccc.test;

import uuu.bccc.entity.Customer;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;

public class TestUpadteMember {

	public static void main(String[] args) {
		//先登入
		
		CustomerService cService = new CustomerService();
		try {
			Customer c1 = cService.login("A123456789", "qwe123");
			System.out.println(c1);
			String id = c1.getId();
			c1.setName("王小路");
			c1.setAddress("ddd");
			cService.update(c1);
			System.out.println(c1);
		} catch (BCCCException e) {
			System.out.println("登入失敗");
		}
		

	}

}
