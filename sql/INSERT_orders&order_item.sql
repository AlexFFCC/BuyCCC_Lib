INSERT INTO orders
(id, customer_id, order_date, order_time
, payment_type, payment_fee, payment_note
, shipping_type, shipping_fee, shipping_note
, recipient_name, recipient_email, recipient_phone, shipping_address, status)
VALUES(?,?,?,?,?,?,'',?,?,'',?,?,?,?,0);

INSERT INTO order_items
(order_id, porduct_id, color_name, size, price, quantity) VALUES(?,?,?,?,?,?);