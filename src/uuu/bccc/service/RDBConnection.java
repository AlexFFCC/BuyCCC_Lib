package uuu.bccc.service;
import java.sql.*;

import uuu.bccc.exception.BCCCException;
class RDBConnection {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bccc";
	private static final String user = "root";
	private static final String pwd = "1234";
	       //回傳型別    方法都要回傳，如果不回傳就要void  throws可以拋出甚麼錯
	static Connection getConnection() throws BCCCException{
		try {//載入driver
			Class.forName(driver);//新版不用寫
			//建立連線 建立起給其他dao使用 所以不用放到小( )中關掉
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
