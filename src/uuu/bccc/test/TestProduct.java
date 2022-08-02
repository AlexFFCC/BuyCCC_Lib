package uuu.bccc.test;

import uuu.bccc.entity.Product;

public class TestProduct {

	public static void main(String[] args) {
		Product p = new Product();
		p.setId(1);
		p.setName("HP M24f 窄邊美型螢幕(24型/FHD/HDMI/IPS)");
		p.setUnitPrice(4200);
		p.setStock(10);
		p.setDescription("1920 x 1080 FHD解析度\n"
				+ "178度廣視角 IPS面板\n"
				+ "1000:1 靜態\n"
				+ "亮度 300 nits\n"
				+ "支援 VGA/HDMI 介面\n"
				+ "極纖薄機身, 最薄處6.5mm\n"
				+ "Eyesafe認證低藍光\n"
				+ "3邊窄框，99% sRGB\n"
				+ "支架集線設計\n"
				+ "三年保固");
		p.setPhotoUrl("https://d.ecimg.tw/items/DSABA9A900BJI2Q/000001_1628474231.jpg");
		System.out.println(p);//會連到toString
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getUnitPrice());
		System.out.println(p.getStock());
		System.out.println(p.getDescription());
		System.out.println(p.getPhotoUrl());
		System.out.println("------------------------------------------------------");
		Product p2 = new Product(2,"羅技 K780 Multi-Device 跨平台藍牙鍵盤",2490d);
		System.out.println(p2.getId());
		System.out.println(p2.getName());
		System.out.println(p2.getUnitPrice());
		System.out.println(p2.getStock());
		System.out.println(p2.getDescription());
		System.out.println(p2.getPhotoUrl());
		
	}

}
