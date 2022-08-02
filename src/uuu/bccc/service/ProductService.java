package uuu.bccc.service;

import java.util.List;

import uuu.bccc.entity.CartItem;
import uuu.bccc.entity.Color;
import uuu.bccc.entity.Product;
import uuu.bccc.exception.BCCCException;

public class ProductService {
	private ProductsDAO dao = new ProductsDAO();
	public List<Product>getAllProducts() throws BCCCException{
		return dao.selectAllProducts();	
	}
	
	public List<Product>getProductsByKeyword(String keyword) throws BCCCException{
		return dao.selectProductsByKeyword(keyword);
	}
	public Product getProductById(String id) throws BCCCException {
		return dao.selectProductById(id);
	}
	
	public List<Product>getNewestProudcts() throws BCCCException{
		return dao.selectNewestProducts();
	}
	public List<Product>getPriceRange(String lowPrice,String heightPrice) throws BCCCException{
		return dao.selectPriceRange(lowPrice,heightPrice);
	}
	
	public int getStock(CartItem item) throws BCCCException {
		int stock = 0;
		Product p = item.getProduct();
		Color color = item.getColor();
		if(color==null) {
			stock = dao.selectStock(String.valueOf(p.getId()));
			
		}else {
			stock = dao.selectStock(String.valueOf(p.getId()), color.getName());
		}
		return stock;
		
	}
}

