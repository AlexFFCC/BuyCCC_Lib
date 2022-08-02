package uuu.bccc.service;

import uuu.bccc.entity.Color;
import uuu.bccc.entity.Customer;
import uuu.bccc.entity.Order;
import uuu.bccc.entity.OrderItem;
import uuu.bccc.entity.OrderStatusLog;
import uuu.bccc.entity.PaymentType;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.Review;
import uuu.bccc.entity.ShippingType;
import uuu.bccc.exception.BCCCException;
import uuu.bccc.exception.StockShrotageException;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
class OrdersDAO {
	private static final String UPDATE_RPODUCT_STOCK=" UPDATE products SET stock = stock - ? WHERE  stock>=? AND id = ? ";
	private static final String UPDATE_RPODUCT_COLOR_STOCK="UPDATE product_colors SET stock = stock - ? WHERE stock>=? AND product_id = ? AND color_name =?";

	private static final String INSERT_ORDERS="INSERT INTO orders "
			+ "(id, customer_id, order_date, order_time"
			+ ", payment_type, payment_fee, payment_note"
			+ ", shipping_type, shipping_fee, shipping_note"
			+ ", recipient_name, recipient_email, recipient_phone, shipping_address, status)"
			+ "VALUES(?,?,?,?, ?,?,'',?,?,'', ?,?,?,?,0)";
	private static final String INSERT_ORDER_ITEMS="INSERT INTO order_items "
			+ "(order_id, porduct_id, color_name, size, price, quantity) VALUES(?,?,?,?,?,?)";
//	private static final String INSERT_REVIEW_INIT="INSERT INTO reviews (id,order_id)"
//			+ "	VALUES(0,?)";
	 void insert(Order order) throws BCCCException{//因為新增不用回傳
		try(
				Connection connection = RDBConnection.getConnection();
				
				PreparedStatement pstmtU1 = connection.prepareStatement(UPDATE_RPODUCT_STOCK);
				PreparedStatement pstmtU2 = connection.prepareStatement(UPDATE_RPODUCT_COLOR_STOCK);
				
																							//回傳自動給號key
				PreparedStatement pstmt1 = connection.prepareStatement(INSERT_ORDERS,Statement.RETURN_GENERATED_KEYS);//準備指令1
				PreparedStatement pstmt2 = connection.prepareStatement(INSERT_ORDER_ITEMS);//準備指令2
//				PreparedStatement pstmt3 = connection.prepareStatement(INSERT_REVIEW_INIT);//準備指令
			) {
			try {
			//交易控制開始 begin
				connection.setAutoCommit(false);//true預設值各自成功各自失敗，將底層connection自動cmmit機制關掉，要由程式自動commit/rollback
				
			
			//依據明細修改庫存
			for(OrderItem item:order.getOrderItemSet()) {
				Product p = item.getProduct();
				Color color = item.getColor();
				int quantity =item.getQuantity();
				
				PreparedStatement pstmt0;
				if(item.getColor()==null) {
					pstmt0 = pstmtU1;
					
				}else {
					pstmt0 = pstmtU2;
					pstmt0.setString(4, color.getName());
				}
				
				pstmt0.setInt(1, quantity);
				pstmt0.setInt(2, quantity);
				pstmt0.setInt(3, p.getId());
				
				int rows = pstmt0.executeUpdate();//讀出
				if(rows==0) throw new StockShrotageException(p);//拋出就不會往下繼續跑下訂單程式
			}
			
			
			
			//3.1傳入指令pstmt1的?的值
			pstmt1.setInt(1, order.getId());
			pstmt1.setString(2,order.getMember().getId());
			pstmt1.setString(3, order.getOrderDate().toString());
			pstmt1.setString(4, order.getOrderTime().toString());
			pstmt1.setString(5,order.getPaymentType().name());
			pstmt1.setDouble(6, order.getPaymentType().getFee());
			pstmt1.setString(7,order.getShippingType().name());
			pstmt1.setDouble(8,order.getShippingType().getFee());
			pstmt1.setString(9,order.getRecipientName());
			pstmt1.setString(10,order.getRecipientEmail());
			pstmt1.setString(11,order.getRecipientPhone());
			pstmt1.setString(12,order.getShippingAddress());
			//執行pstmt1指令
			pstmt1.executeUpdate();
			//取得自動給號的值
			try(ResultSet rs = pstmt1.getGeneratedKeys()){
				if(rs!=null) {
					while(rs.next()) {
						int genKey = rs.getInt(1);
						order.setId(genKey);
					}
				}
			}
			

			for(OrderItem item:order.getOrderItemSet()) {
				pstmt2.setInt(1,order.getId());
				pstmt2.setInt(2, item.getProduct().getId());
				pstmt2.setString(3, item.getColor()!=null?item.getColor().getName():"");
				pstmt2.setString(4, item.getSize());
				pstmt2.setDouble(5, item.getPrice());
				pstmt2.setInt(6, item.getQuantity());
				
				pstmt2.executeUpdate();
			}
				
			//交易控制 commit
				connection.commit();
				MailService.sendOrder(order);
			}catch(Exception e) {//任何的錯誤
				//rollback還原
				connection.rollback();
				throw e;//讓exception e回歸到原來的錯誤處理程式
			}finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new BCCCException("建立訂單失敗",e);
		}
		
	}
	private static final String SELECT_ORDERS_HISTORY_BY_CUSTOMER_ID="SELECT id, order_date, order_time"
			+ ", status, payment_type"
			+ ", shipping_type, shipping_fee "
			+ ",sum(price*quantity) as total_amount FROM orders JOIN order_items ON orders.id = order_items.order_id "
			+ " WHERE customer_id= ?"
			+ " GROUP BY id ORDER BY order_date DESC, order_time DESC ";
	List<Order> selectOrdersHistoryByCustomerId(String customerId) throws BCCCException {
		List<Order>list =new ArrayList<Order>();
		
		
		try(Connection connection = RDBConnection.getConnection();
			PreparedStatement pstmt =connection.prepareStatement(SELECT_ORDERS_HISTORY_BY_CUSTOMER_ID);) {
			
			pstmt.setString(1, customerId);
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
					order.setOrderDate(LocalDate.parse(rs.getString("order_date")));
					order.setOrderTime(LocalTime.parse(rs.getString("order_time")));
					
//					Customer c = new Customer();
//					c.setId(rs.getString("customer_id"));
//					order.setMember(c);
					String pTypeName = rs.getString("payment_type");
					if(pTypeName!=null) {
						PaymentType pType = PaymentType.valueOf(pTypeName);
						order.setPaymentType(pType);
					}
					
					String sTypeName =rs.getString("shipping_type");
					if(sTypeName!=null) {
						ShippingType sType = ShippingType.valueOf(sTypeName);
						order.setShippingType(sType);
					}
					order.setShippingFee(rs.getDouble("shipping_fee"));
				
					
					order.setTotalAmount(rs.getDouble("total_amount"));
					list.add(order);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	private static final String SELECT_ORDER_BY_ID_AND_CUSTOMERID ="SELECT orders.id, customer_id,  products.name,photo_url,photo_url1 AS color_photo "
			+ ", porduct_id, order_items.color_name "
			+ ", size, price*quantity as price, quantity, unit_price*(100-discount)/100 as unit_price, discount,order_date, order_time, payment_type, payment_fee, payment_note "
			+ ", shipping_type, shipping_fee, shipping_note, recipient_name, recipient_email, recipient_phone "
			+ ", shipping_address, status "
			+ " FROM orders "
			+ " JOIN order_items ON order_id = orders.id "
			+ " JOIN products ON order_items.porduct_id = products.id "
			+ " LEFT JOIN product_colors ON order_items.porduct_id = product_colors.product_id "
			+ " AND order_items.color_name = product_colors.color_name "
			+ "  WHERE orders.id= ? AND customer_id=?";
	 Order selectOrderByIdAndCustomerId(String customerId, String orderId) throws BCCCException {
		Order order = null;
		
		try(Connection connection =RDBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDER_BY_ID_AND_CUSTOMERID);	
				) {
			//傳入?值
			pstmt.setString(1, orderId);
			pstmt.setString(2, customerId);
			
			//執行指令
			try( ResultSet rs = pstmt.executeQuery()
				){
				//處理指令
				while(rs.next()) {
					if(order==null) {
						order=new Order();
						order.setId(rs.getInt("orders.id"));
						order.setStatus(rs.getInt("status"));
						
						Customer c =new Customer();
						c.setId(rs.getString("customer_id"));
						order.setMember(c);
						
						order.setOrderDate(LocalDate.parse(rs.getString("order_date")));
						order.setOrderTime(LocalTime.parse(rs.getString("order_time")));
						
						String pType = rs.getString("payment_type");
						try {
							order.setPaymentType(PaymentType.valueOf(pType));
						}catch(RuntimeException ex){
							System.err.println("不正確的paymentType"+ pType);
							
						}
						order.setPaymentfee(rs.getDouble("payment_fee"));
						order.setPaymentNote(rs.getString("payment_note"));
						
						String shType = rs.getString("shipping_type");
						try {
							order.setShippingType(ShippingType.valueOf(shType));
						}catch(RuntimeException ex){
							System.err.println("不正確的shipping_type"+ shType);
							
						}
						order.setShippingFee(rs.getDouble("shipping_fee"));
						//order.setShippingNote(rs.getString("shipping_note"));
						
						order.setRecipientName(rs.getString("recipient_name"));
						order.setRecipientEmail(rs.getString("recipient_email"));
						order.setRecipientPhone(rs.getString("recipient_phone"));
						order.setShippingAddress(rs.getString("shipping_address"));
						
						
					}
					
					//讀取明細
					OrderItem item = new OrderItem();
					Product  p = new Product();
					p.setId(rs.getInt("porduct_id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					item.setProduct(p);
					order.add(item);
					
					String colorName = rs.getString("color_name");
					if(colorName!=null && colorName.length()>0) {
						Color color =new Color();
						color.setName(colorName);
						color.setPhotoUrl("color_photo");
						item.setColor(color);
						
					}
					item.setSize(rs.getNString("size"));
					item.setPrice(rs.getDouble("price"));
				
					item.setQuantity(rs.getInt("quantity"));
					
					order.add(item);//加到訂單
					
					
					
					
				}
			}
		} catch (SQLException e) {
			throw new BCCCException("查詢訂單失敗",e);
		}
		
		return order;
	}
	
	 private static final String UPDATE_STATUS_TO_TRANSFERED = "UPDATE orders SET status=1" //狀態設定為已轉帳
	            + ", payment_note=? WHERE customer_id=? AND id=? "
	            + " AND status=0" + " AND payment_type='" + PaymentType.ATM.name() + "'";
	void updateStatusToTransfered(String memberId, String ordrId, String paymentNote) throws BCCCException {
		try (Connection connection = RDBConnection.getConnection(); //2. 建立連線
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_STATUS_TO_TRANSFERED) //3. 準備指令
                ) {
            //3.1 傳入?的值
            pstmt.setString(1, paymentNote);
            pstmt.setString(2, memberId);
            pstmt.setString(3, ordrId);

            //4. 執行指令
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw new BCCCException("通知已轉帳失敗!", ex);
        }		
	}
	private static final String SELECT_ORDER_STATUS_LOG="SELECT order_id, update_time, old_status, new_status "
    		+ "	FROM order_status_log WHERE order_id=?  ORDER BY update_time desc limit 1";
	 List<OrderStatusLog> selectOrderStatusLog(String orderId) throws BCCCException {
		List<OrderStatusLog> list = new ArrayList<OrderStatusLog>();
		
		
		try(Connection connection = RDBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDER_STATUS_LOG);
				) {
			pstmt.setString(1, orderId);
			
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					OrderStatusLog log = new OrderStatusLog();
					log.setOrderId(rs.getInt("order_id"));
					log.setNewStatus(rs.getInt("new_status"));
					log.setOrderId(rs.getInt("old_status"));
					log.setUndateTime(LocalDateTime.parse(rs.getString("update_time").replace(' ' , 'T')));
					list.add(log);
				}
			}
			return list;
			
			
		} catch (SQLException e) {
			throw new BCCCException("查詢訂單狀態失敗",e);
		}

	}
	 
	 OrderStatusLog selectOrderStatusLogInt(int orderId) throws BCCCException {
			OrderStatusLog log = new OrderStatusLog();
			
			
			try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ORDER_STATUS_LOG);
					) {
				pstmt.setInt(1, orderId);
				
				try(ResultSet rs = pstmt.executeQuery();){
					while(rs.next()) {
						
						log.setOrderId(rs.getInt("order_id"));
						log.setNewStatus(rs.getInt("new_status"));
						log.setOrderId(rs.getInt("old_status"));
						log.setUndateTime(LocalDateTime.parse(rs.getString("update_time").replace(' ' , 'T')));
						
					}
				}
				return log;
				
				
			} catch (SQLException e) {
				throw new BCCCException("查詢訂單狀態失敗",e);
			}

		}
	 
	 
	 private static final String UPDATE_STATUS_TO_ENTERED = "UPDATE orders SET status=2" //狀態設定為已付款
	            + ", payment_note=? WHERE id=? AND customer_id=?"
	            + " AND status=0" + " AND payment_type='" + PaymentType.CARD.name() + "'";

	 

	    public void updateStatusToPAID(int orderId, String customerId, String paymentNote) throws BCCCException {

	        try (Connection connection = RDBConnection.getConnection(); //2. 建立連線

	                PreparedStatement pstmt = connection.prepareStatement(UPDATE_STATUS_TO_ENTERED) //3. 準備指令

	                ) {

	            //3.1 傳入?的值

	            pstmt.setString(1, paymentNote);

	            pstmt.setInt(2, orderId);

	            pstmt.setString(3, customerId);

	 

	            //4. 執行指令

	            pstmt.executeUpdate();

	        } catch (SQLException ex) {

	            System.out.println("修改信用卡付款入帳狀態失敗-" + ex);

	            throw new BCCCException("修改信用卡付款入帳狀態失敗!", ex);

	        }

	    }
	 
	 
		
}
