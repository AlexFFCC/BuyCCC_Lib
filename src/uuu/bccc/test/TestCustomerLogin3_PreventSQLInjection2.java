package uuu.bccc.test;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.bccc.entity.Customer;

public class TestCustomerLogin3_PreventSQLInjection2 {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bccc";
	private static final String user = "root";
	private static final String pwd = "1234";// 資料庫連線root的密碼
	private static final String SELECT_CUSTOMERS_BY_ID = "SELECT id, name, email, password, birthday, gender, "
			+ "address, phone, subscribed FROM customers " + "WHERE id = ? AND password=?"; // 需要指令與資料分開解決sql injection

	public static void main(String[] args) {
		String id, password;// 前端登入的帳號密碼
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入帳號:");
		id = scanner.next();

		System.out.println("請輸入密碼:");
		password = scanner.next();
		
		int count = 0;
		Customer customer = null;
		try {
			// 1. 載入JDBC Driver
			Class.forName(driver);

			// 建立關掉連線
			try (Connection connection = DriverManager.getConnection(url, user, pwd); // 2.建立連線
					PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMERS_BY_ID); // 3.指令準備

			) {
				// 4.傳入?的值
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				try (ResultSet rs = pstmt.executeQuery();// 5.執行指令 //關閉RESULTSET
				) {// System.out.println(connection.getCatalog());// for testing :顯示:DB Name
					
					//System.out.println(rs.getRow());// firstxxx看ppt上有，Before First
					
					while (rs.next()) {// 5.處理re內容
						count++;
						customer = new Customer();
						//System.out.println(rs.getString("id"));
						customer.setId(rs.getString("id"));
						
						//System.out.println(rs.getString("name"));
						customer.setName(rs.getString("name"));
						
						//System.out.println(rs.getString("email"));
						customer.setEmail(rs.getString("email"));
						
						//System.out.println(rs.getString("password"));
						customer.setPassword(rs.getString("password"));
						
						//System.out.println(rs.getString("birthday"));
						customer.setBirthday(rs.getString("birthday"));
						
						//System.out.println(rs.getString("gender"));
						customer.setGender(rs.getString("gender").charAt(0));
						
						//System.out.println(rs.getString("address"));
						customer.setAddress(rs.getString("address"));
						
						//System.out.println(rs.getString("phone"));
						customer.setPhone(rs.getString("phone"));
						
						System.out.println(rs.getBoolean("subscribed"));
						customer.setSubscribed(rs.getBoolean("subscribed"));
						
						//System.out.println(rs.getRow());// lastxxx看ppt，After Last
					}
					
				}
			} catch (SQLException e) {
				Logger.getLogger("RDB Connection").log(Level.SEVERE, "建立連線失敗:", e);
			}
		} catch (ClassNotFoundException e) {
			Logger.getLogger("RDB Connection").log(Level.SEVERE, "無法載入JDBC Driver:" + driver);
		}
		if (customer == null) {
			System.out.println("查無資料");
		}else {
			System.out.println(customer);
			
		}
		System.out.println("共"+count+"筆");

	}

}
