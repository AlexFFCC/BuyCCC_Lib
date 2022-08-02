package uuu.bccc.test;

public class TestBitwiseOperators {
	public static void main(String[] args) {
		// ~ & | ^
		System.out.println(6 & 5);  //  110
									//  101  &可以檢查衝堂
									//-------
									//  100 -> 4
		
		System.out.println(6 | 5);  //  110
									//  101    |可以選課
									//-------
									//  111 -> 7
		
		System.out.println(6 | 5);  //   110
									// ^ 101   
									//-------
									//   011 -> 3
		
		//三元運算子
		int money = 100;
		int price = 99;
		System.out.println(money>=price?"買":"不買");  //在網頁會常常用到，
										//if money >= price.買。else不買。
		String answer = money>=price?"買":"不買"; //存在變數可以放到資料庫裡
		System.out.println(answer); //買
	}
}
