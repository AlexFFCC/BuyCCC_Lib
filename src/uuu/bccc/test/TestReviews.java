package uuu.bccc.test;

import java.util.List;

import uuu.bccc.entity.Customer;
import uuu.bccc.entity.Order;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.Review;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;
import uuu.bccc.service.OrderService;
import uuu.bccc.service.ProductService;
import uuu.bccc.service.ReviewService;

public class TestReviews {

	public static void main(String[] args) {

		ReviewService rService = new ReviewService();
		try {
			Review r = rService.getReviewByOrderIdAndProductId("A123456789", "4","3" );
			
				System.out.println(r.getNickName());
				System.out.println(r.getComment());
				System.out.println(r.getCommentDate());
				System.out.println(r.getOrderId());
				System.out.println("---------------------");
			
		} catch (BCCCException e) {
			System.out.println("查詢產品評價失敗");
		}
		

	}

}
