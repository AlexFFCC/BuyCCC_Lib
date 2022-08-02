package uuu.bccc.entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Product {
	public static final NumberFormat priceFormat = new DecimalFormat("#.0#");
	
	private int id; //required PKey
	private String name; //required
	private double unitPrice; //required售價
	private int stock; //required >=0
	private String description = ""; //optional
	private String photoUrl; //optional
	private String smallPic1;
	private String smallPic2;
	private String descriptionPhoto1;
	private String descriptionPhoto2;
	private Map<String,Color> colorsMap = new HashMap<>();
	          //顏色名  顏色類別，裡面有顏色類別的屬性
	public Product() {
		
	}

	
	public Product(int id,String name,double price) { //在測試時使用可以快速傳直
		this.id=id;
		this.name=name;
		this.unitPrice=price;
	}
	

	public Map<String, Color> getColorsMap() {
		return new HashMap(colorsMap);//回傳副本，不給修改
		// return colorsMap 這是回傳正本 就可以修改 例如clear就清掉Map
	}
	public void add(Color color) { //集合型態不行使用set
		if(color==null) throw new IllegalArgumentException("產品顏色不得為null");
		colorsMap.put(color.getName(), color);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() { //查售價
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) { //設定售價(即定價)
		this.unitPrice = unitPrice;
	}
	public int getStock() {
		if(this.colorsMap.size()>0) {
			int totalStock=0;
			for(Color color:colorsMap.values()) {
				totalStock = totalStock+color.getStock();
			}
			return totalStock; //產品明細裡的總庫存
		}
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getSmallPic1() {
		return smallPic1;
	}


	public void setSmallPic1(String smallPic1) {
		this.smallPic1 = smallPic1;
	}


	public String getSmallPic2() {
		return smallPic2;
	}


	public void setSmallPic2(String smallPic2) {
		this.smallPic2 = smallPic2;
	}


	/**
	 * @return the descriptionPhoto1
	 */
	public String getDescriptionPhoto1() {
		return descriptionPhoto1;
	}


	/**
	 * @param descriptionPhoto1 the descriptionPhoto1 to set
	 */
	public void setDescriptionPhoto1(String descriptionPhoto1) {
		this.descriptionPhoto1 = descriptionPhoto1;
	}


	/**
	 * @return the descriptionPhoto2
	 */
	public String getDescriptionPhoto2() {
		return descriptionPhoto2;
	}


	/**
	 * @param descriptionPhoto2 the descriptionPhoto2 to set
	 */
	public void setDescriptionPhoto2(String descriptionPhoto2) {
		this.descriptionPhoto2 = descriptionPhoto2;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+ "[產品編號=" + id + ", \n 產品名=" + name + ", \n 單價=" + unitPrice + ", \n 庫存=" + getStock()
				+ ",\n 產品敘述=" + description + ",\n 照片=" + photoUrl +"\n"+colorsMap+"]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
