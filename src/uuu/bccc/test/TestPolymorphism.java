package uuu.bccc.test;

import uuu.bccc.entity.Customer;
import uuu.bccc.entity.Outlet;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.VIP;

public class TestPolymorphism {

	public static void main(String[] args) {
		Object o = new Customer("A123456789","王奇葩",
				"qwe123456"); //多型宣告，建構式
		Object o1 = "Hello";
		
		VIP vip = new VIP();  //因為只有這個new 就只有一個物件
		vip.setId("A223456781");
		vip.setName("吳林美");
		vip.setPassword("qwer12345678");
		vip.setDiscount(25);
		
		Customer c = vip;
		System.out.println(c.getId());
		System.out.println(vip.getName());
		System.out.println(vip.getPassword());
		System.out.println(vip.getDiscount());
		
		if(c instanceof VIP) {
			System.out.println(((VIP)c).getDiscount());//轉型
		}
		
//		System.out.println(c.getDiscount());
		
		//Product p = new Outlet();
		

	}

}
