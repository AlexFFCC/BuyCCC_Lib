SELECT * FROM bccc.reviews;
INSERT INTO reviews (id, product_id, customer_id, order_id, nick_name, content, comment_date)
VALUES(0,10,'A123456789',7,'小陸','效能超好','2021-10-14');
INSERT INTO reviews (id, product_id, customer_id, order_id, nick_name, content, comment_date)
VALUES(0,7,'A123456789',7,'小陸','畫質超好','2021-10-14');
INSERT INTO reviews (id, product_id, customer_id, order_id, nick_name, content, comment_date)
VALUES(0,3,'A123456789',7,'小陸','商務風格的筆電','2021-10-14');

INSERT INTO reviews (id, product_id, customer_id, order_id, nick_name, content, comment_date)
VALUES(0,7,'A123456789',9,'小陸','一手掌握很適合來看股票','2021-10-15');

/*查詢產品評價*/
 SELECT products.id ,order_id,name,nick_name, content, comment_date
 FROM products JOIN reviews ON products.id=reviews.product_id WHERE products.id=7 ;
 
 /*查詢個人評價由自己的SessionID & 前端傳來的orderID*/
 SELECT reviews.id, product_id, order_id, nick_name
, content, comment_date FROM reviews JOIN customers WHERE customers.id = 'A123456789' AND order_id = 10 AND product_id=2; 
/*防止被有心人士亂動orderID和produstID 過濾條件*/
 SELECT reviews.id, product_id, reviews.order_id, nick_name,products.name
, content, comment_date FROM reviews JOIN customers 
JOIN order_items ON order_items.porduct_id = reviews.product_id 
JOIN products ON products.id = reviews.product_id
WHERE customers.id = 'A123456789' AND reviews.order_id =1 AND order_items.order_id = reviews.order_id AND product_id=1;
/*查詢個人評價*/
SELECT order_items.order_id, order_items.porduct_id, customer_id, nick_name, content, comment_date, reviews.product_id FROM order_items 
	JOIN reviews ON reviews.order_id = order_items.order_id 
		AND reviews.product_id=order_items.porduct_id WHERE customer_id = 'A123456789' AND order_items.order_id= 5 AND order_items.porduct_id = 2;