package uuu.bccc.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;
                             //throws Exception 就會不停醒錯誤 因為錯誤又丟上去了
public class TestCustomerServiceLogin  {

	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		try {
			System.out.println(cService.login("A123456791", "qwe123"));
		} catch (BCCCException e) {
			System.out.println(e.getMessage());//for user
			//for admin developer
			Logger.getLogger("...").log(Level.SEVERE,e.getMessage(),e);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
