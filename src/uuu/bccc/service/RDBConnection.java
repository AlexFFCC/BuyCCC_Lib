package uuu.bccc.service;
import java.sql.*;

import uuu.bccc.exception.BCCCException;
class RDBConnection {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bccc";
	private static final String user = "root";
	private static final String pwd = "1234";

	static Connection getConnection() throws BCCCException{
		try {//載入driver
			Class.forName(driver);
			//建立連線
			try {
				Connection connection = DriverManager.getConnection(url,user,pwd);
				return connection;
			} catch (SQLException e) {
				
				throw new BCCCException("建立連線失敗",e);
			}
		} catch (ClassNotFoundException e) {
			//  checkException 
			throw new BCCCException("無法載入driver:"+driver,e);
		}
	}
}
