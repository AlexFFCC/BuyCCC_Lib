package uuu.bccc.test;

import uuu.bccc.entity.Color;
import uuu.bccc.entity.Size;

public class TestColorSize {

	public static void main(String[] args) {
		Color color = new Color();
		color.setName("金色");
		color.setPhotoUrl("https://www.cdn-tkec.tw/image/product/202101/214537_M.jpg?t=20210901");
		color.setStock(7);
		
		Size size1 = new Size();
		size1.setName("8RAM");
		size1.setStock(8);
		size1.setUnitPrice(33900);
		size1.setOrdinal(0);
		color.add(size1);
		
		Size size2 = new Size();
		size2.setName("16RAM");
		size2.setStock(7);
		size2.setUnitPrice(35900);
		size2.setOrdinal(1);
		color.add(size2);
		
		System.out.println(color.getSizeValues());
	}

}
