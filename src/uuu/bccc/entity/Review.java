package uuu.bccc.entity;

import java.time.LocalDate;

public class Review {
	private Product product;
	private Customer member;
	private int id;//pkey自動給號
	private String orderId;
	private String nickName;
	private String comment;
	private LocalDate commentDate = LocalDate.now();
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getMember() {
		return member;
	}
	public void setMember(Customer member) {
		this.member = member;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(LocalDate commentDate) {
		this.commentDate = commentDate;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "Review [產品名稱=" + product + ", 會員=" + member + ", 訂單編號=" + id +
				"\n, 暱稱=" + nickName
				+ ",\n 評論內容=" + comment + ", \n評論時間=" + commentDate + "]";
	}

	
}
