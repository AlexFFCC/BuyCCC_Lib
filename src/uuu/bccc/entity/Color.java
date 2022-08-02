package uuu.bccc.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Color {
	private String name;//Pkey
	private int stock;//REQUIRED
	private String photoUrl;
	private Map<String,Size> sizesMap= new HashMap<>();
	
	public Set<Size> getSizeValues(){
		return new TreeSet(sizesMap.values());
	}
	
	/**
	 * @return
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return sizesMap.isEmpty();
	}

	/**
	 * @return
	 * @see java.util.Map#size()
	 */
	public int length() {
		return sizesMap.size();
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public Size get(String sizeName) {
		return sizesMap.get(sizeName);
	}

	/**
	 * @return
	 * @see java.util.Map#keySet()
	 */
	public Set<String> keySet() {
		return sizesMap.keySet();
	}

	public void add(Size size) {
		sizesMap.put(size.getName(), size);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+
				"\n顏色名:" + name + ", 顏色庫存=" + stock + ",\n  圖片網址=" + photoUrl+"\n sizesMap"+ sizesMap ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Color other = (Color) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
