package uuu.bccc.test;

import uuu.bccc.entity.Product;
import uuu.bccc.entity.ShoppingCart;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.ProductService;

public class TestShoppingCart {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		try {
			Product p2 = pService.getProductById("1");
			Product p3 = pService.getProductById("7");
			
			//加入購物車 先宣告購物車建立起來
			ShoppingCart sCart = new ShoppingCart();
			sCart.add(p2, "金色", null, 1);
			System.out.println(sCart);
			System.out.println("___________________");
			sCart.add(p3, "黑色", null, 2);
			System.out.println(sCart);
			
			System.out.println("___________________");
			
			
		} catch (BCCCException e) {
			// TODO Auto-generated catch block
			System.out.println("購物失敗");
		}

	}

}
