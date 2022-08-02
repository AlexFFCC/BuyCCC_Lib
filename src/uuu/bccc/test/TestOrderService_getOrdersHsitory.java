package uuu.bccc.test;

import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.OrderService;

public class TestOrderService_getOrdersHsitory {

	public static void main(String[] args) {
		OrderService oService = new OrderService();
		
		try {
			System.out.println(oService.getOrdersHistoryByCustomerId("A123456789"));
		} catch (BCCCException e) {
			System.out.println("查詢客戶歷史訂單錯誤");
		}

	}

}
