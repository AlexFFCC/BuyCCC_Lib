package uuu.bccc.test;

import uuu.bccc.entity.Customer;
import uuu.bccc.entity.Order;
import uuu.bccc.entity.PaymentType;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.ShippingType;
import uuu.bccc.entity.ShoppingCart;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;
import uuu.bccc.service.OrderService;
import uuu.bccc.service.ProductService;

public class TestOrderService_checkOut {

	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		
		ProductService pService = new ProductService();
		try {
			Customer member = cService.login("A123456789","qwe123");
			Product p2 = pService.getProductById("1");
			Product p3 = pService.getProductById("7");
			
			//加入購物車 先宣告購物車建立起來
			ShoppingCart sCart = new ShoppingCart();
			sCart.setMember(member);
			
			//System.out.println(sCart);
			System.out.println("___________________");
			sCart.add(p2, "黑色", null, 2);
			//System.out.println(sCart);
			
			System.out.println("___________________");
			Order order = new Order();
			order.setMember(member);
			order.setPaymentType(PaymentType.ATM);
			order.setPaymentfee(PaymentType.ATM.getFee());
			order.setShippingType(ShippingType.HOME);
			order.setShippingFee(ShippingType.HOME.getFee());
	
			order.setRecipientName(member.getName());
			order.setRecipientEmail(member.getEmail());
			order.setRecipientPhone(member.getPhone());
			order.setShippingAddress(member.getAddress());
			order.setStatus(0);
			order.add(sCart);
			
			OrderService oService = new OrderService();
			oService.checkOut(order);
			System.out.println(order);
		} catch (BCCCException e) {
			// TODO Auto-generated catch block
			System.out.println("購物失敗");
		}

	}

}
