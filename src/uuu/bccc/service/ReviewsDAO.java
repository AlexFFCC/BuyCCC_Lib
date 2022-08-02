package uuu.bccc.service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uuu.bccc.entity.Order;
import uuu.bccc.entity.OrderItem;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.Review;
import uuu.bccc.exception.BCCCException;

public class ReviewsDAO {
	private static final String INSERT_REVIEW="INSERT INTO reviews (id, order_id ,product_id, customer_id, nick_name, content, comment_date) "
			+ " VALUES(?,?,?,?,?,?,?)";
	 void insert(Review review) throws BCCCException {
		
		
		 try( Connection connection = RDBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(INSERT_REVIEW);
				 ) {
			 
			 pstmt.setInt(1, review.getId());
			 pstmt.setString(2, review.getOrderId());
			 pstmt.setInt(3, review.getProduct().getId());
			 pstmt.setString(4,review.getMember().getId());
			 pstmt.setString(5, review.getNickName());
			 pstmt.setString(6,review.getComment());
			 pstmt.setString(7, review.getCommentDate().toString());
			 
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			throw new BCCCException("寫評價失敗",e);
		}
		
	}
	 
	 private static final String SELECT_REVIEWS_OF_PRODUCT_ID = " SELECT products.id, name,nick_name, order_id ,content, comment_date "
	 		+ " FROM products JOIN reviews ON products.id=reviews.product_id WHERE products.id=?";
	 List<Review> selectReviewsOfProductId(String productId) throws BCCCException {
		List<Review> list = new ArrayList<Review>();
		
		
		try(
				Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_REVIEWS_OF_PRODUCT_ID);
				) {
			pstmt.setString(1, productId);//傳入?值
			
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					Review r = new Review();
					r.setNickName(rs.getString("nick_name"));
					r.setComment(rs.getString("content"));
					r.setCommentDate(LocalDate.parse(rs.getString("comment_date")));
					r.setOrderId(rs.getString("order_id"));;
					
					list.add(r);
				}
				
			}
			
		} catch (SQLException e) {
			throw new BCCCException("查詢產品評價失敗",e);
		}
		return list;
	}
	 
	 private static final String SELECT_REVIEW_BY_3ID=" SELECT reviews.id, order_items.order_id, order_items.porduct_id, customer_id, nick_name, content, comment_date"
	 		+ ", reviews.product_id FROM order_items "
	 		+ "	JOIN reviews ON reviews.order_id = order_items.order_id "
	 		+ "		AND reviews.product_id=order_items.porduct_id WHERE customer_id = ? AND order_items.order_id= ? AND order_items.porduct_id = ? ";
	
	 private static final String SELECT_REVIEW_BY_3ID2="SELECT orders.id, orders.customer_id,  products.name,photo_url,photo_url1 AS color_photo  "
	 		+ "			  , porduct_id, order_items.color_name , reviews.id, reviews.product_id, reviews.customer_id, reviews.order_id, nick_name, content, comment_date "
	 		+ "			   FROM orders  "
	 		+ "			   JOIN order_items ON order_items.order_id = orders.id  "
	 		+ "               JOIN reviews ON orders.id = reviews.order_id AND  order_items.porduct_id =  reviews.product_id "
	 		+ "			   JOIN products ON order_items.porduct_id = products.id  "
	 		+ "			  LEFT JOIN product_colors ON order_items.porduct_id = product_colors.product_id  "
	 		+ "			   AND order_items.color_name = product_colors.color_name  "
	 		+ "			   WHERE orders.id= ? AND orders.customer_id=? AND reviews.product_id = ?";
	 Review selectReviewByOrderIdAndProductId(String memberId, String orderId, String proudctId ) throws BCCCException {
		 
		 Review r = null ;
			try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_REVIEW_BY_3ID);
					) {
				pstmt.setString(1, memberId);
				pstmt.setString(2, orderId);
				pstmt.setString(3, proudctId);
				
				
				try(ResultSet rs = pstmt.executeQuery();){
					while(rs.next()) {
						 r= new Review();
						r.setNickName(rs.getString("nick_name"));
						r.setComment(rs.getString("content"));
						r.setCommentDate(LocalDate.parse(rs.getString("comment_date")));
						r.setOrderId(rs.getString("order_items.order_id"));
						r.setId(rs.getInt("reviews.id"));
						
					}
					
				}
			} catch (SQLException e) {
				throw new BCCCException("查詢個人評價失敗",e);
			}
		 
		 
		return r;
	}
	 private static final String SELECT_ORDERITEM="SELECT order_id, porduct_id ,customer_id FROM bccc.order_items "
	 		+ "JOIN orders on order_id = orders.id WHERE customer_id = ? AND  porduct_id=? AND order_id = ?";
	 Order selectOrderItem(String memberId, String orderId, String productId) throws BCCCException {
		Order order = new Order();
		
		
		try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDERITEM);	
				) {
			pstmt.setString(1, memberId);
			pstmt.setString(2,productId);
			pstmt.setString(3,orderId);
			
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
				order.setId(rs.getInt("order_id"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
		
				
	}
	

}
