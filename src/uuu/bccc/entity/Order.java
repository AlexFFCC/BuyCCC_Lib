package uuu.bccc.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private int id;//Pkey auto-Increment
	private LocalDate orderDate=LocalDate.now(); //資料庫 Date yyyy-mm-dd
	private LocalTime orderTime=LocalTime.now();  //time hh:mm:ss.sss
	
	private Customer member;
	private PaymentType paymentType;
	private double paymentfee;//交易手續費
	private String paymentNote="";
	
	private ShippingType shippingType;
	private double shippingFee;
	private String shippingtNote="";
	
	private double totalAmount;
	//收件人
	private String recipientName;
	private String recipientEmail;
	private String recipientPhone;
	private String shippingAddress;
	
	private Set<OrderItem> orderItemSet = new HashSet<>();//產品
	
	private int status;//0代表新訂單,1已轉帳,2已入帳,3已出貨

	
	
	public double getTotalAmount() {
		if(orderItemSet!=null && orderItemSet.size()>0) {
			double sum = 0;
			for(OrderItem item:orderItemSet) {
				sum = sum + item.getPrice()*item.getQuantity();
			}
			return Math.round(sum);
		}
		return Math.round(totalAmount);
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
//	public double getTotalAmountWithFee() {
//		return getTotalAmount()  + getShippingFee();
//	}
	 public double getTotalAmountWithFee() {

	       double sum = getTotalAmount();

	       sum += +shippingFee;

	       return Math.round(sum);

	   }
	//orderItemSet的setter add(),add()
	//把cartItem -> orderItem加入orderItemSet
	public void add(ShoppingCart cart) {
		if(cart==null || cart.size()==0) throw new IllegalArgumentException("建立訂單失敗,cart不得為空的");
									//購買明細CartItem的集合
		for(CartItem cartItem:cart.getCartItemsSet()) {//讀出一個一個的購物明細變成訂單明細，變成訂單明細，getCartItemsSet()的型態是CartItem
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setColor(cartItem.getColor());
			orderItem.setSize(cartItem.getSize());
			orderItem.setPrice(cartItem.getProduct().getUnitPrice());
			orderItem.setQuantity(cart.getQuantity(cartItem));
			
			orderItemSet.add(orderItem);
		}
	}
	//一筆一筆讀出。item是DAO從資料庫讀出一筆一筆訂單明細時，就建立一個order物件，並由此方法加入order物件中
	public void add(OrderItem item) {
		if(item==null) throw new IllegalArgumentException("加入訂單明細時orderItem物件不得為null");
		
		orderItemSet.add(item);
	}
	
	/**
	 * @return the orderItemSet
	 */
	public Set<OrderItem> getOrderItemSet() {//只回傳副本
		return new HashSet<>(orderItemSet);
	}
	
	
	
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderTime
	 */
	public LocalTime getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * @return the member
	 */
	public Customer getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Customer member) {
		this.member = member;
	}

	/**
	 * @return the paymentType
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the paymentfee
	 */
	public double getPaymentfee() {
		return paymentfee;
	}

	/**
	 * @param paymentfee the paymentfee to set
	 */
	public void setPaymentfee(double paymentfee) {
		this.paymentfee = paymentfee;
	}

	/**
	 * @return the paymentNote
	 */
	public String getPaymentNote() {
		return paymentNote;
	}

	/**
	 * @param paymentNote the paymentNote to set
	 */
	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}

	/**
	 * @return the shippingType
	 */
	public ShippingType getShippingType() {
		return shippingType;
	}

	/**
	 * @param shippingType the shippingType to set
	 */
	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	/**
	 * @return the shippingFee
	 */
	public double getShippingFee() {
		return shippingFee;
	}

	/**
	 * @param shippingFee the shippingFee to set
	 */
	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	/**
	 * @return the shippingtNote
	 */
	public String getShippingtNote() {
		return shippingtNote;
	}

	/**
	 * @param shippingtNote the shippingtNote to set
	 */
	public void setShippingtNote(String shippingtNote) {
		this.shippingtNote = shippingtNote;
	}

	/**
	 * @return the recipientName
	 */
	public String getRecipientName() {
		return recipientName;
	}

	/**
	 * @param recipientName the recipientName to set
	 */
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	/**
	 * @return the recipientEmail
	 */
	public String getRecipientEmail() {
		return recipientEmail;
	}

	/**
	 * @param recipientEmail the recipientEmail to set
	 */
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	/**
	 * @return the recipientPhone
	 */
	public String getRecipientPhone() {
		return recipientPhone;
	}

	/**
	 * @param recipientPhone the recipientPhone to set
	 */
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	
	public String getStatusString() {
		if(status<0 || status>= Status.values().length) {
			return String.valueOf(status);
		}
		return status +('-'+Status.values()[status].getDescription());
	}
	
	public String getStatusString(int status) {
		if(status<0 || status>=Status.values().length) {
			return String.valueOf(status);
		}
		return status +('-'+ Status.values()[status].getDescription());
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	
	public enum Status{
		NEW("新訂單"), TRANSFERED("已轉帳"), PAID("已付款"), SHIPPED("已出貨"),
		ARRIVED("已到貨"),CHECKED("已簽收"),COMPLETED("完成");
		
		
		
		private Status(String description) {
			this.description = description;
		}

		private final String description;

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
		
		
	}
	
	@Override
	public String toString() {
		return "\n Order [id=" + id + ", orderDate=" + orderDate + ", \n orderTime=" + orderTime + ", member=" + member
				+ ", paymentType=" + paymentType + ",\n paymentfee=" + paymentfee + ", paymentNote=" + paymentNote
				+ ", shippingType=" + shippingType + ",\n shippingFee=" + shippingFee + ", shippingtNote=" + shippingtNote
				+ ", recipientName=" + recipientName + ",\n recipientEmail=" + recipientEmail + ", recipientPhone="
				+ recipientPhone + ", shippingAddress=" + shippingAddress + ", orderItemSet=" + orderItemSet
				+ ", status=" + status + "]";
	}



	
	
	
	

}
