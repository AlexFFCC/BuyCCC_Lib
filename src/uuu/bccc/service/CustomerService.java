package uuu.bccc.service;

import uuu.bccc.entity.Customer;
import uuu.bccc.exception.BCCCException;

public class CustomerService { //這種商業邏輯類別不直接寫在這 資料庫會不寫在商業邏輯類別
	private CustomersDAO dao = new CustomersDAO();
	
	public Customer login(String id,String pwd) throws BCCCException {
		if(id==null || pwd==null || id.trim().length()==0) throw new IllegalArgumentException("客戶登入必須有id和pwd");
		
		
		Customer customer = dao.selectCustomerById(id);
		if(customer == null ||        //密碼在這檢查equals大小寫需一樣，因為mysql不分大小寫都正確，eqalsIgnoreCase不分大小寫，case sensitive分大小寫
			(customer != null && !pwd.equals(customer.getPassword()))) {
			throw new BCCCException("登入失敗，帳號或密碼不正確");
			
			//return null;
		}

		return customer;
	}
	
	//因為前端所以要public
	public void register(Customer customer) throws BCCCException {
		if(customer == null) throw new IllegalArgumentException("客戶註冊時customer物件不得為null");
		dao.insert(customer);
	}
	
	
	//upadte member info
	
	public void update(Customer customer) throws BCCCException{
		if(customer == null ) throw new IllegalArgumentException("更新customer資料不得為null");
		dao.update(customer);
	}
}
