/*查詢歷史訂單*/
SELECT id, order_date, order_time, status, payment_type
, shipping_type, shipping_fee 
,sum(price*quantity) as total_amount FROM orders JOIN order_items ON orders.id = order_items.order_id
WHERE customer_id= 'A123456789'
GROUP BY id;