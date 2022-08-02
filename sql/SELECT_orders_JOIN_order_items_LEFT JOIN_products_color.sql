SELECT orders.id, customer_id,  products.name,photo_url,photo_url1 AS color_photo
, porduct_id, order_items.color_name
, size, price*quantity as price, quantity, unit_price*(100-discount)/100 as unit_price, discount,order_date, order_time, payment_type, payment_fee, payment_note
, shipping_type, shipping_fee, shipping_note, recipient_name, recipient_email, recipient_phone
, shipping_address, status 
 FROM orders 
 JOIN order_items ON order_id = orders.id
 JOIN products ON order_items.porduct_id = products.id
 LEFT JOIN product_colors ON order_items.porduct_id = product_colors.product_id AND order_items.color_name = product_colors.color_name
  WHERE orders.id= '1' AND customer_id="A123456789";
 
