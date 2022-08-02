package uuu.bccc.test;

import uuu.bccc.entity.Customer;

public class TestEqualTo {

	public static void main(String[] args) {
		Customer c1= new Customer("A123456789","Zora","asdf12345");//new就建立一個記憶體
		Customer c2= new Customer("A123456789","Zora","asdf12345");//記憶體不同只有內容一樣
		
		System.out.println(c1==c2);
		c1.setPassword("78qsf6");
		System.out.println(c2.getPassword());
		
		c2=c1;
		System.out.println(c1==c2);
		c1.setPassword("123456");
		System.out.println(c2.getPassword());
		
		//System.out.println('1'>Integer.parseInt("4"));
		//System.out.println("333".compareTo("234"));// String比較是從第1碼開始比
		
	}

}
