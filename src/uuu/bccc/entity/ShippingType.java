package uuu.bccc.entity;

public enum ShippingType {
	SHOP("B3C實體門市取貨",0),
	STORE("超商取貨",60),
	HOME("宅配到府",100);
	
	
	private final String descrption;
	private final double fee;

	private ShippingType(String descrption, double fee) {
		this.descrption = descrption;
		this.fee = fee;
	}
	/**
	 * @return the descrption
	 */
	public String getDescrption() {
		return descrption;
	}
	/**
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}
	
	@Override
	public String toString() {
		String feeString="";
		if(fee>0) feeString=","+fee+"元";
		return this.descrption + feeString;
	}
	
}
