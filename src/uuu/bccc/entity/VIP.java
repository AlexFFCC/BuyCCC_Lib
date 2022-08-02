package uuu.bccc.entity;

public class VIP extends Customer {
	private int discount;
	
	

	public VIP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VIP(String id, String name, String password) {
		super(id, name, password);
		// TODO Auto-generated constructor stub
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public String getDiscountString() {
		int discount = 100- this.discount;//80
		
		if(discount %10 == 0) {
			discount =  discount/10;
	
		}
		return discount+"折";
	}

	@Override
	public String toString() {
		return super.toString() +"\n[discount=" + discount + ",\ngetDiscountString()=" + getDiscountString();
	}
	
	

}
