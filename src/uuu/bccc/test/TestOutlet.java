package uuu.bccc.test;

import uuu.bccc.entity.Outlet;

public class TestOutlet {

	public static void main(String[] args) {
		Outlet outlet = new Outlet();
		
		outlet.setId(1);
		outlet.setName("索尼SONY 藍牙揚聲器 SRS-XB12/G(綠)");
		outlet.setUnitPrice(700); //設定定價
		outlet.setStock(5);
		outlet.setPhotoUrl("https://www.cdn-tkec.tw/image/product/201905/805067_M.jpg?t=20210730102033");
		outlet.setDescription("EXTRA BASS 強力重低音\r\n"
				+ "揚聲器硬體強化\r\n"
				+ "IP67完美防水防塵\r\n"
				+ "防鏽蝕\r\n"
				+ "防震更耐用\r\n"
				+ "16小時長效電池續航力");
		outlet.setDiscount(10);
		System.out.println(outlet);
//		System.out.println(outlet.getId());
//		System.out.println(outlet.getName());
//		System.out.println(outlet.getListPrice());
//		System.out.println(outlet.getStock());
//		System.out.println(outlet.getPhotoUrl());
//		System.out.println(outlet.getDescription());
//		System.out.println(outlet.getDiscount());
//		System.out.println(outlet.getDiscountString());
//		System.out.println(outlet.getUnitPrice());
		System.out.println(outlet.getClass().getName());
		System.out.println(outlet.getClass().getSimpleName());
	}

}
