package uuu.bccc.entity;

public class Outlet extends Product {

	private int discount;
	
	public Outlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Outlet(int id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDiscountString() {
		int discount = 100 - this.discount;// 80

		if (discount % 10 == 0) {
			discount = discount / 10;

		}
		return discount + "折";
	}
	
	@Override
	public double getUnitPrice() {  //查售價
		double price = super.getUnitPrice()*(100-this.discount)/100;
		return price;
	}
	
	public double getListPrice() {  //查原價
		return super.getUnitPrice();
	}

	@Override
	public String toString() {
		return super.toString() + "\n [discount=" + discount 
				+ ",\n 打幾折=" + getDiscountString() 
				+ ",\n 折扣後="+ getUnitPrice() 
				+ ",\n 單價=" + getListPrice() + "]";
	}
	
}
