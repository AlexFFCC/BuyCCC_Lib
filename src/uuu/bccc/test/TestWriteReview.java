package uuu.bccc.test;

import java.time.LocalDate;

import uuu.bccc.entity.Customer;
import uuu.bccc.entity.Order;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.Review;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.service.CustomerService;
import uuu.bccc.service.OrderService;
import uuu.bccc.service.ProductService;
import uuu.bccc.service.ReviewService;

public class TestWriteReview {

	public static void main(String[] args) throws BCCCException {
		ReviewService rService = new ReviewService();
		Review review = new Review();
		
		try {
			CustomerService cService = new CustomerService();
			Customer member = cService.login("A123456789", "qwe123");//登入
			review.setId(0);//資料庫會自動給號，先給0
			review.setMember(member);//取得會員，dao那會去getId()
			review.setNickName("聰明盧");
			review.setComment("好聰明");
			review.setCommentDate(LocalDate.now());
//			OrderService oService = new OrderService();
//			Order o = oService.getOrderByIdAndCustomerId("A123456789", "1");//得到此會員的這個訂單號碼
			review.setOrderId("1");//取得訂單號碼，dao那會去getOrdr的Id
			ProductService pService = new ProductService();
			Product p = pService.getProductById("1");//前端傳來的productId
			review.setProduct(p);//得到此編號產品 dao那會取getId
			
			rService.wirteComment(review);//call service執行
			System.out.println(review);
		} catch (BCCCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
