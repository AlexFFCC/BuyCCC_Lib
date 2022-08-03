package uuu.bccc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import uuu.bccc.entity.Order;
import uuu.bccc.entity.OrderItem;
import uuu.bccc.entity.OrderStatusLog;
import uuu.bccc.exception.BCCCException;

public class OrderService {
	 private OrdersDAO dao = new OrdersDAO();
	 public void checkOut(Order order) throws BCCCException{
		dao.insert(order);
	}
	 
	 public List<Order> getOrdersHistoryByCustomerId(String customerId) throws BCCCException{
		return dao.selectOrdersHistoryByCustomerId(customerId);
	 }
	 
	 public  Order getOrderByIdAndCustomerId(String customerId, String orderId) throws BCCCException{
		
		 return dao.selectOrderByIdAndCustomerId(customerId,orderId);
	 }

	 public void updateStatusToTransfered(String member, String ordrId, String bank, String cardNumber,
			 							double pay, LocalDateTime dateTime) throws BCCCException{
		 String note = "銀行:" + bank + ", 後5碼:" + cardNumber + ", 金額:" + pay + "轉帳日期:" + dateTime;
		dao.updateStatusToTransfered(member,ordrId,note);
	 }
	 
	 public List<OrderStatusLog> getOrderStatusLog(String orderId) throws BCCCException {
			return dao.selectOrderStatusLog(orderId);
		}
	 
	 public OrderStatusLog getOrderStatusLogInt(int orderId) throws BCCCException {
			return dao.selectOrderStatusLogInt(orderId);
		}
	 
	 public void updateStatusToPAID(int orderId, String customerId, String cardF6, String cardL4,

	            String auth, String paymentDate, String amount) throws BCCCException {

	        StringBuilder paymentNote = new StringBuilder("信用卡號:");

	        paymentNote.append(cardF6==null?"4311-95":cardF6).append("**-****").append(cardL4==null?2222:cardL4);

	        paymentNote.append(",授權碼:").append(auth==null?"777777":auth);

	        paymentNote.append(",交易時間:").append(paymentDate==null?LocalDateTime.now():paymentDate);

	        paymentNote.append(",刷卡金額:").append(amount);

	        System.out.println("orderId = " + orderId);

	        System.out.println("customerId = " + customerId);

	        System.out.println("paymentNote = " + paymentNote);

	        dao.updateStatusToPAID(orderId, customerId, paymentNote.toString());

	    }
}
