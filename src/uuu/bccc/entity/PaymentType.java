package uuu.bccc.entity;

public enum PaymentType {
	SHOP("門市付款",new ShippingType[] {ShippingType.SHOP}),
	ATM("ATM轉帳",ShippingType.STORE,ShippingType.HOME),
	STORE("超商付款",ShippingType.STORE),
	CARD("信用卡",ShippingType.STORE,ShippingType.HOME),
	HOME("貨到付款",ShippingType.HOME);
	private final String descrption;
	private final double fee;
	private final ShippingType[] shippingTypeArray;//紀錄付款對應的貨運方式
	
	/**
	 * @return the shippingTypeArray
	 */
	public ShippingType[] getShippingTypeArray() {
		return shippingTypeArray.clone();//陣列的副本
	}
	
	/**
	 * @return 給前端畫面付款對應的的貨運方式
	 */
	public String getShippingTypeArrayString() {
		String str="";
		if(shippingTypeArray!=null && shippingTypeArray.length>0) {
			for(ShippingType sType:shippingTypeArray) {
				if(str.length()>0) str+=",";
				str+=sType.name();
			}
		}
		return str;
	}
	
	
	private PaymentType(String descrption,ShippingType... shippingType) {//參數才可以設定...可變動參數只能用在一維陣列
		this(descrption,0,shippingType);
	}
	
	private PaymentType(String descrption, double fee,ShippingType[] shippingTypeArray) {
		this.descrption = descrption;
		this.fee = fee;
		this.shippingTypeArray = shippingTypeArray;
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
