package uuu.bccc.entity;

import java.time.LocalDateTime;

public class OrderStatusLog {
	private int orderId;
	private int oldStatus;
	private int newStatus;
	private LocalDateTime undateTime;
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the oldStatus
	 */
	public int getOldStatus() {
		return oldStatus;
	}
	/**
	 * @param oldStatus the oldStatus to set
	 */
	public void setOldStatus(int oldStatus) {
		this.oldStatus = oldStatus;
	}
	/**
	 * @return the newStatus
	 */
	public int getNewStatus() {
		return newStatus;
	}
	/**
	 * @param newStatus the newStatus to set
	 */
	public void setNewStatus(int newStatus) {
		this.newStatus = newStatus;
	}
	/**
	 * @return the undateTime
	 */
	public LocalDateTime getUndateTime() {
		return undateTime;
	}
	/**
	 * @param undateTime the undateTime to set
	 */
	public void setUndateTime(LocalDateTime undateTime) {
		this.undateTime = undateTime;
	}
	
	
}
