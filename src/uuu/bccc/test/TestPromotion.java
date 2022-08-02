package uuu.bccc.test;

public class TestPromotion {

	public static void main(String[] args) {
		String id = "A123456789";
		char firstChar = id.charAt(0);
		
		int firstNumber = firstChar;  //promotion
		System.out.println(firstNumber); //65
		System.out.println(firstChar);  //A
		
		//轉型 強迫轉型
		int theNumber = 1;
		char theChar = (char) theNumber;
		System.out.println(theChar); //印出。13會是換行 unicode -> char ，49才會是1
		System.out.println(theNumber); // 13
		theChar = (char)(theNumber+'0');//1+48=49
		//'0'字元是48，計算0-9之間的數字(ex:idNumber)，所以要減掉0字元。使用for loop寫ID檢查
		//基本型別Performance最好
		System.out.println(theChar);
		
		char anotherChar = '1';
		int anotherNumber = anotherChar - '0';
		System.out.println(anotherChar);//字元'1'
		System.out.println(anotherNumber); //整數1
		
		//casting
		double price = 90.5;
		int intPrice = (int)price; //90
		System.out.println(intPrice);

	}
}
