package uuu.bccc.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
	private Customer member;
	private Map<CartItem,Integer> cartMap = new HashMap<>();
	
	//替代集合的setter:add update ,remove
	
	public void add(Product p, String colorName, String size, int quantity) {//想像購物車畫面。加入購物車
		if(p==null) throw new IllegalArgumentException("加入購物車時產品不得為NULL");
		
		Color color = null;
		if(colorName!=null) {
			color = p.getColorsMap().get(colorName);//key顏色名稱
		}
		if(size==null) size="";
		CartItem item = new CartItem();
		item.setProduct(p);
		item.setColor(color);
		item.setSize(size);
		Integer oldQty = cartMap.get(item);//Integer 得到整數值
		if(oldQty!=null) {
			quantity = quantity+oldQty;
		}
		cartMap.put(item, quantity);
	}
	
	public void upadte(CartItem item , int qty) {//將購買數量改為qty值。修改購物車。cartItem購物明細
		cartMap.put(item, qty);//使用put回去注意這是put的用法
	}
	
	public Integer remove(CartItem key) {//將cartItem的item明細與對應值一併移除
		return cartMap.remove(key);
	}

	public int size() {//購物車中有幾項商品
		return cartMap.size();
	}

	public boolean isEmpty() {//購物車是否是空的
		return cartMap.isEmpty();
	}


	public boolean containsKey(Object key) {//檢查購物車是否已購買此明細(同一產品，同一顏色，同一尺寸)
		return cartMap.containsKey(key);
	}


	public Integer getQuantity(CartItem key) {//取得cartItem購買數量
		return cartMap.get(key);
	}

	public Set<CartItem> getCartItemsSet() {//取購買明細CartItem的集合
		return new HashSet<CartItem>(cartMap.keySet());//傳送副本
	}
	public double getAmount(CartItem key) {
		double price = key.getProduct().getUnitPrice();//cartItem裡的key的product裡的getUnitPrice()
		Integer qty = cartMap.get(key);//get values
		double amount = 0;
		if(qty!=null) {
			amount = price*qty;
		}
		return amount;
	}
	public int getTotalQuantity() {
		int sum=0;
		for(Integer qty:cartMap.values()) {
			if(qty!= null) {
				sum = sum+qty;
			}
		}
		return sum;
	}
	
	
	public double getTotalAmount() {
		double sum = 0;
		for(CartItem item :cartMap.keySet()) {
			sum = sum + this.getAmount(item);
		}
		return Math.round(sum);
	}
	
	public Customer getMember() {
		return member;
	}
	
	public void setMember(Customer member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "購物車 [訂購人=" + member + "\n, 購物明細=\n" + cartMap + "]\n"
	+"共"+size()+"項"+getTotalQuantity()+"件"+"\n"
				+"總金額"+getTotalAmount()+"元";
	}

}
