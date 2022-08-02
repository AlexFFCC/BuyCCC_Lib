package uuu.bccc.test;


import java.util.Scanner;

import uuu.bccc.entity.Customer;

public class TestCustimerAge {
	public static void main(String[] args) {
		//建立Customer物件
		Customer c = new Customer(); //這就是建構式 建空的物件
		c.setId("A123456789");
		c.setName("王奇葩");
		c.setEmail("test01@uuu.com.tw");
		c.setPassword("qwert123");
		c.setGender('M');
		//c.birthday = LocalDate.parse("1998-02-23"); //因birthday屬性改成private，無法直接指派，就不會有漏洞
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入客戶年齡(yyyy-mm-dd)");
		String dateString = scanner.next(); //前端送來的會是字串
		c.setBirthday(dateString); //改用setBirthday(...)方法， 參數回進去來指派給屬性
	
//		System.out.println("請輸入出生年");
//		String yStr = scanner.next();
//		System.out.println("請輸入出生月");
//		String mStr = scanner.next();
//		System.out.println("請輸入出生日");
//		String dStr = scanner.next();
//		
//		c.setBirthday(Integer.parseInt(yStr), Integer.parseInt(mStr), Integer.parseInt(dStr));
		//System.out.println(dateString);
		
		//c.birthday = LocalDate.parse(dateString); //字串轉換為LocalDate格式
		
//		String yStr = "1970";
//		String mStr = "12";
//		String dStr = "6";
//		c.birthday = LocalDate.of(Integer.parseInt(yStr))
		
		
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getEmail());
		System.out.println(c.getPassword());
		System.out.println(c.getGender());
		//System.out.println(c.birthday); //因為無法讀取birthday屬性private
		System.out.println(c.getBirthday());  //改用getBirthday()方法來讀取
		
		//計算年齡:今年-客戶出生年
//		int thisYear = LocalDate.now().getYear();
//		int birthYear = c.birthday.getYear();
//		int age = thisYear - birthYear;
		System.out.println(c.getAge()+"歲");	
	}
}
