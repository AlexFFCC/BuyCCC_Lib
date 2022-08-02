package uuu.bccc.test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnection {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bccc";
	private static final String user = "root";
	private static final String pwd = "1234";
	private static final String SELECT_ALL_CUSTOMERS="SELECT id, name, email, password, birthday, gender, "
			+ "address, phone, subscribed FROM customers";
	public static void main(String[] args) {

		try {
			// 1. 載入JDBC Driver
			Class.forName(driver);

			                       //關掉連線
			try (Connection connection = DriverManager.getConnection(url, user, pwd);// 2.建立連線
				Statement stmt= connection.createStatement(); //3.建立指令
					ResultSet rs = stmt.executeQuery(SELECT_ALL_CUSTOMERS);//4.執行指令
				){
				//System.out.println(connection.getCatalog());// for testing :顯示:DB Name
				while(rs.next()) {//5.處理re內容
					System.out.println(rs.getString("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("email"));
					System.out.println(rs.getString("password"));
					System.out.println(rs.getString("birthday"));
					System.out.println(rs.getString("gender"));
					System.out.println(rs.getString("address"));
					System.out.println(rs.getString("phone"));
					System.out.println(rs.getBoolean("subscribed"));
				}
			} catch (SQLException e) {
				Logger.getLogger("RDB Connection").log(Level.SEVERE, "建立連線失敗:", e);
			}
		} catch (ClassNotFoundException e) {
			Logger.getLogger("RDB Connection").log(Level.SEVERE, "無法載入JDBC Driver:" + driver);
		}

	}

}
