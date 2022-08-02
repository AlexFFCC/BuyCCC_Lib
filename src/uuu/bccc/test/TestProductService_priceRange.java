package uuu.bccc.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.ProductService;

public class TestProductService_priceRange {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		try {
			System.out.println(pService.getPriceRange("38000", "45000"));
		} catch (BCCCException e) {
			//Logger logger = Logger.getLogger("ProductsDAO測試");
			//logger.addHandler();
			Logger.getLogger("ProductsDAO測試").log(Level.SEVERE,e.getMessage(),e);
		}
	}
}
