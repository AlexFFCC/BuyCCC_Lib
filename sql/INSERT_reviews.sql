/*查詢所有REVIEWS*/
SELECT * FROM bccc.reviews;
/*建立產品評價*/
INSERT INTO reviews (product_id, customer_id, order_id, nick_name, content, comment_date)
VALUES(7,'A123456789',1,'陸陸','出貨速度快，產品很美','2021-10-11');


INSERT INTO reviews (product_id, customer_id, order_id, nick_name, content, comment_date)
VALUES(3,'A123456789',1,'陸陸','效能真好都沒有當機','2021-10-06');
/*JOIN TABLE 產品明細評價*/
SELECT product_id, customer_id, reviews.order_id, nick_name, content, comment_date ,order_items.order_id, color_name, porduct_id FROM reviews 
 JOIN order_items ON order_items.porduct_id= reviews.product_id; 
 
 