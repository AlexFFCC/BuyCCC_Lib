package uuu.bccc.entity;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

import uuu.bccc.exception.BCCCDataInvalidException;

public class Customer {
	public static final char MALE = 'M';
	public static final char FEMALE = 'F';
	public static final char OTHERS = 'O';

	private String id; // 必要欄位，符合id(10格字元) PKey 主見值
	private String name; // 必要欄位(2~20個字)
	private String email; // 必要欄位(符合email格式)
	private String password; // 必要欄位,6~20格字元

	private LocalDate birthday = null; // 必要欄位，年滿12歲
	private char gender; // 必要欄位，'M'-男,'F'-女','O'不提供
	private String address = new String(""); // 非必要欄位
	private String phone = ""; // 非必要欄位
	private boolean subscribed; // 非必要欄位

	public Customer() {

	}

	public Customer(String id, String name, String password) {
		// super();
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
	}

	private static final String ID_PATTERN = "[A-Z][1289][0-9]{8}";

	public static boolean checkId(String id) {// 提供ROC OD的檢查
		if (id != null && id.matches(ID_PATTERN)) {// regular expression 第一步先處理擋掉錯誤再下去
			char firstChar = id.charAt(0);
			int firstNumber = 0;
			if (firstChar >= 'A' && firstChar < 'I') {
				firstNumber = firstChar - 'A' + 10;
			} else if (firstChar >= 'J' && firstChar < 'O') {
				firstNumber = firstChar - 'J' + 18;
			} else if (firstChar >= 'P' && firstChar < 'W') {
				firstNumber = firstChar - 'P' + 23;
			} else {
				switch (firstChar) {
				case 'X':
					firstNumber = 30;
					break;
				case 'Y':
					firstNumber = 31;
					break;
				case 'W':
					firstNumber = 32;
					break;
				case 'Z':
					firstNumber = 33;
					break;
				case 'I':
					firstNumber = 34;
					break;
				case 'O':
					firstNumber = 35;
					break;
				}
			}
			int n1 = firstNumber / 10;
			int n2 = firstNumber % 10;
			int sum = 0;
			int n1n2 = n1 * 1 + n2 * 9;
			sum += n1n2;

			for (int i = 1; i < 9; i++) { // 跑8次，少第9為
				int n = id.charAt(i) - '0';
				sum = sum + n * (9 - i);
			}

			sum = sum + id.charAt(9) - '0';
			// System.out.println(sum);
//			if (sum % 10 == 0) {
//				System.out.println("correct id");
//			} else {
//				System.out.println("worng id number");
//			}
			return (sum % 10 == 0);
		} else {
			return false;
		}
	}

	/**
	 * 計算並回傳客戶物件的年齡
	 * 
	 * @return int的年齡
	 */
	// 宣告getAge()方法完成方法內容
	public int getAge() {
		int thisYear = LocalDate.now().getYear();

		if (this.birthday != null) {
			int birthYear = this.birthday.getYear();
			int age = thisYear - birthYear;
			return age;

		} else {
			return -1; // TODO:ch13要改成throw exception

		}

	}

	// 方法名稱 參數
	public void setBirthday(String dateStr) { // 符合iso 8601
		try {
			LocalDate date = LocalDate.parse(dateStr);// 讀取dateStr
			this.setBirthday(date);
		} catch (DateTimeParseException e) {
			//System.out.println("客戶生日日期資料不正確"+ dateStr);
			throw new BCCCDataInvalidException("客戶生日日期資料不正確"+ dateStr);
		}
	}

	// 可在同一個類別中設定相同的方法但是參數個數需不同
	// 寫入set開頭
	public void setBirthday(int year, int month, int day) { // for 舊版 沒有小月曆
		
		try {
		LocalDate date = LocalDate.of(year, month, day);
		this.setBirthday(date);
		}catch(DateTimeException e) {
			//System.out.println("客戶生日日期資料不正確"+ e.getMessage());//前端收不到，伺服器管理者看的到，，不適用管理者，開發人員測試用
			throw new BCCCDataInvalidException("客戶生日資料不正確"+ e.getMessage());
		}
	}
		
	public static final int MIN_AGE =12;
	public void setBirthday(LocalDate birthday) {
		if (Period.between(birthday, LocalDate.now()).getYears() >= 12) {
			this.birthday = birthday; // 屬性的指派

		} else {
			//System.out.println("客戶年齡未滿12歲");
			throw new BCCCDataInvalidException("客戶年齡未滿"+MIN_AGE+"歲:"+ birthday);
			
		}
	}

	// 這裡要寫方法是因為前面改成private在test那邊無法讀取
	// 取得客戶生日get之後讀取，所以需要回傳 get翻成讀取
	// 封裝
	public LocalDate getBirthday() { // getXxx()方法通常沒有參數
		return this.birthday;

	}

	public String getId() { // 存取
		return id;
	}

	public void setId(String id) {
		if (checkId(id)) {
			this.id = id; // 等號右邊是前端傳回來的
		} else {
			throw new BCCCDataInvalidException("客戶身分證號不正確");
		}
	}

	public String getName() {
		return name;
	}
	
	public static final int MIN_NAME_LENGTH =2;
	public static final int MAX_NAME_LENGTH =20;
	public void setName(String name) {
		if (name != null && (name = name.trim()).length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH) {
			this.name = name;
		} else {
			throw new BCCCDataInvalidException("客戶姓名必須"+MIN_NAME_LENGTH+"~"+MAX_NAME_LENGTH+"個字");
			//System.out.println("客戶名稱不正確");
		}

	}

	public String getEmail() {
		return email;
	}
	public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	public void setEmail(String email) {
		if (email != null && email.matches(EMAIL_PATTERN)) {
			this.email = email;
		} else {
			throw new BCCCDataInvalidException("Email格式不正確");
			//System.out.println("Email格式不正確");
		}
	}

	public String getPassword() {
		return password;
	}
	public static final int MIN_PWD_LENGTH = 6;
	public static final int MAX_PWD_LENGTH = 20;
	public void setPassword(String password) {
		if (password != null && (password = password.trim()).length() >=  MIN_PWD_LENGTH && password.length() <= MAX_PWD_LENGTH) {
			this.password = password;
		} else {
			throw new BCCCDataInvalidException("密碼格式不正確，長度必需"+MIN_PWD_LENGTH+"~"+MAX_PWD_LENGTH+"個字");
			//System.out.println("密碼格式不正確，長度必需6~20個字");
		}
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender == MALE || gender == FEMALE || gender == OTHERS) {
			this.gender = gender;
		} else {
			throw new BCCCDataInvalidException("性別選擇錯誤");
			//System.out.println("性別選擇錯誤");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address!=null) {
			this.address = address.trim();
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(phone !=null)
		this.phone = phone.trim();
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[id=" + id + ", name=" + name + ", \n" + "email=" + email
				+ ", password=" + password + ",\n" + "birthday=" + birthday + ", gender=" + gender + ", \n" + "address="
				+ address + ", phone=" + phone + ",\n" + "subscribed=" + subscribed + ", getAge()=" + getAge() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(this==obj)return true;
//		if(obj instanceof Customer) {
//			Customer otherCustomer = (Customer)obj;
//			return this.id!=null && this.id.equals(otherCustomer.id);
//		}
//		return false;
//	}

}
