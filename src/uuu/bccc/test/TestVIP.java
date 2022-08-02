package uuu.bccc.test;

import uuu.bccc.entity.VIP;

public class TestVIP {

	public static void main(String[] args) {
		VIP vip = new VIP();
		vip.setId("A123456788");
//		System.out.println(vip.getId());
		
		vip.setName("王老虎");
		vip.setEmail("eee@gmail.com");
		vip.setBirthday("1995-09-06");
		vip.setGender('F');
		vip.setDiscount(20);
		vip.setPhone("0909090956");//20off
		
		System.out.println("vip的內容:"+vip);
//		System.out.println(vip.getName());
//		System.out.println(vip.getDiscount());
//		System.out.println(vip.getDiscountString());
		

	}

}
