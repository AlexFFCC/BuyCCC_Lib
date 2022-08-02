package uuu.bccc.service;

import java.util.List;

import uuu.bccc.entity.Order;
import uuu.bccc.entity.OrderItem;
import uuu.bccc.entity.Review;
import uuu.bccc.exception.BCCCException;

public class ReviewService {
	private ReviewsDAO dao = new ReviewsDAO();
	public void wirteComment(Review review) throws BCCCException{
		dao.insert(review);
	}
	public List<Review> getReviewsOfProductId(String productId) throws BCCCException{
		return dao.selectReviewsOfProductId(productId);
		
	}
	public Review getReviewByOrderIdAndProductId(String memberId, String OrderId,String ProudctId)
	throws BCCCException{
		
		return dao.selectReviewByOrderIdAndProductId(memberId,  OrderId,ProudctId);
		
	}
	public Order getOrderItem(String memberId,String orderId, String productId) throws BCCCException {
		return dao.selectOrderItem(memberId,orderId,productId);
	}

}
