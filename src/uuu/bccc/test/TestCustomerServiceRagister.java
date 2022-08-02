package uuu.bccc.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.bccc.entity.Customer;
import uuu.bccc.exception.BCCCDataInvalidException;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;

public class TestCustomerServiceRagister {
	
	public static void main(String[] args) {
		try {
			Customer c1 = new Customer();
			c1.setId("A123456752");
			c1.setName("郝郝丸");
			c1.setEmail("funny@uuu.com.tw");
			c1.setPassword("qw");
			c1.setBirthday("1966-09-05");
			c1.setGender('M');
			c1.setAddress("金門縣中山路8號");
			
			CustomerService cService = new CustomerService();
			
			try {
				cService.register(c1);
			} catch (BCCCException e) {
				System.out.println(e.getMessage());
				Logger.getLogger("...").log(Level.SEVERE,e.getMessage(),e);
			}//註冊
		}catch(BCCCDataInvalidException e) {
			System.out.println(e.getMessage());
		}
		
		
//		Customer c2;
//		try {//登入
//			c2 = cService.login("A123456707", "qwe123");
//			System.out.println(c2);
//		} catch (BCCCException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
	}

}
