package uuu.bccc.exception;

import uuu.bccc.entity.Product;

public class StockShrotageException extends BCCCException {
	private final Product p;
	/**
	 * @return the p
	 */
	public Product getProduct() {
		return p;
	}

	public StockShrotageException(Product p) {
		this(p,"庫存不足");
		
		
	}

	public StockShrotageException(Product p,String message, Throwable cause) {
		super(message, cause);
		this.p = p;
	}

	public StockShrotageException(Product p,String message) {
		super(message);
		this.p = p;
	
	}

	@Override
	public String toString() {
		return (p!=null?p.getName():"")+ getMessage();
	}

}
