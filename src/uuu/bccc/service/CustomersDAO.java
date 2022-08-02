package uuu.bccc.service;

import uuu.bccc.entity.Customer;
import uuu.bccc.exception.BCCCException;

import java.sql.*;
class CustomersDAO {
	private static final String SELECT_CUSTOMERS_BY_ID = "SELECT id, name, email, password, birthday, gender, "
			+ "address, phone, subscribed FROM customers " + "WHERE id = ? OR email=?";//AND password=?";
	
	Customer selectCustomerById(String id) throws BCCCException {
		Customer customer = null;
		//TODO 資料存取邏輯
	
		
		try(    //因為在DDBC有static，所以在這不用new建立起來
				Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMERS_BY_ID);//準備指令
				){
			//傳入?的值          //前端傳來的id
			pstmt.setString(1, id);
			pstmt.setString(2, id);//同一個id<欄位>
			
			try(
					ResultSet rs = pstmt.executeQuery();//執行指令 需要關掉 這是查詢指令
				){
				while(rs.next()) {
					customer = new Customer();
					customer.setId(rs.getString("id"));
					customer.setName(rs.getString("name"));
					customer.setEmail(rs.getString("email"));
					customer.setPassword(rs.getString("password"));
					customer.setBirthday(rs.getString("birthday"));
					customer.setGender(rs.getString("gender").charAt(0));
					customer.setAddress(rs.getString("address"));
					customer.setPhone(rs.getString("phone"));
					customer.setSubscribed(rs.getBoolean("subscribed"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BCCCException("查詢客戶失敗", e);
		}
		
		return customer;
	}
	private static final String INSERT_CUSTOMER="INSERT INTO customers (id, name, email, password, birthday, gender, address, phone, subscribed)" 
	+"VALUES(?,?,?, ?,?,?, ?,?,?)";
	void insert(Customer customer) throws BCCCException {
		try( //取得連線
			Connection connection = RDBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(INSERT_CUSTOMER);//準備指令
				) {
			//傳入?值
			pstmt.setString(1,customer.getId());
			pstmt.setString(2,customer.getName());
			pstmt.setString(3,customer.getEmail());
			pstmt.setString(4,customer.getPassword());
			pstmt.setString(5,String.valueOf(customer.getBirthday()));
			pstmt.setString(6,String.valueOf(customer.getGender()));
			pstmt.setString(7,customer.getAddress());
			pstmt.setString(8,customer.getPhone());
			pstmt.setBoolean(9,customer.isSubscribed());
			//執行指令
			int rows = pstmt.executeUpdate();
			//System.out.println("新增成功"+rows+"筆");//for test
		}catch(SQLIntegrityConstraintViolationException e) {
			String errMsg = "已重複註冊";
			//Caused by: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry==e.getMessage()
			if(e.getMessage().indexOf("customers.email_UNIQUE")>=0) {
				errMsg = "email"+errMsg;     //coustomers是 table name
			}else if(e.getMessage().indexOf("customers.PRIMARY")>=0) {
				errMsg = "ID"+errMsg;
			}else {
				errMsg=e.getMessage();
			}
			throw new BCCCException("新增客戶失敗:" + errMsg ,e);
		} catch (SQLException e) {
			throw new BCCCException("新增客戶失敗", e);
		}
	}
	
	//updateCustomerInfo
	private static final String UPDATE_MEMBER= "UPDATE customers SET name=?, email=?, password=?, birthday=?"
			+ ", gender=?, address=?, phone=?, subscribed=? WHERE id=?";

	void update(Customer customer) throws BCCCException{
		try( //取得連線
				Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_MEMBER);//準備指令
					) {
				//傳入?值
				pstmt.setString(1,customer.getName());
				pstmt.setString(2,customer.getEmail());
				pstmt.setString(3,customer.getPassword());
				pstmt.setString(4,String.valueOf(customer.getBirthday()));
				pstmt.setString(5,String.valueOf(customer.getGender()));
				pstmt.setString(6,customer.getAddress());
				pstmt.setString(7,customer.getPhone());
				pstmt.setBoolean(8,customer.isSubscribed());
				pstmt.setString(9,customer.getId());
				//執行指令
				pstmt.executeUpdate();
				//System.out.println("新增成功"+rows+"筆");//for test
			}catch(SQLIntegrityConstraintViolationException e) {
				String errMsg = "更新資料錯誤";
				//Caused by: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry==e.getMessage()
				if(e.getMessage().indexOf("customers.email_UNIQUE")>=0) {
					errMsg = "email"+errMsg;     //coustomers是 table name
				}else if(e.getMessage().indexOf("customers.PRIMARY")>=0) {
					errMsg = "ID"+errMsg;
				}else {
					errMsg=e.getMessage();
				}
				throw new BCCCException("更新客戶資料失敗:" + errMsg ,e);
			} catch (SQLException e) {
				throw new BCCCException("更新客戶資料失敗", e);
			}
		
	}
	
	
	
}
