package uuu.bccc.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.bccc.entity.Customer;
import uuu.bccc.entity.Order;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;
import uuu.bccc.service.OrderService;

public class TestOrderService_getOrderById {

	public static void main(String[] args) {
		CustomerService cServiec = new CustomerService();
		
		try {
			Customer c = cServiec.login("A123456789", "qwe123");
			OrderService oService = new OrderService();
			Order order = oService.getOrderByIdAndCustomerId(c.getId(),"7");
			System.out.println(order);
		} catch (BCCCException e) {
			Logger.getLogger("查訂單明細").log(Level.SEVERE,e.getMessage(),e);
		}
		

	}

}
