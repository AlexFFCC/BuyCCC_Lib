package uuu.bccc.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.bccc.entity.Product;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.ProductService;

public class TestProductService_getAllProudcts {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		try {
			Product p = pService.getProductById("7");
			System.out.println(p.getName());
			System.out.println(p.getColorsMap());
		} catch (BCCCException e) {
			//Logger logger = Logger.getLogger("ProductsDAO測試");
			//logger.addHandler();
			Logger.getLogger("ProductsDAO測試").log(Level.SEVERE,e.getMessage(),e);
		}
	}
}
