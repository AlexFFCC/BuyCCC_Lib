SELECT * FROM bccc.products;
/*查詢產品全部及評價*/
SELECT id, name, unit_price, discount, stock, photo_url, description, shelf_date, category, brand
, photo_url2, photo_url3, photo_url4 ,nick_name, content, comment_date
 FROM products JOIN reviews ON products.id=reviews.product_id ;
 
 SELECT id, name, unit_price, discount, stock, photo_url, description, shelf_date, category, brand
, photo_url2, photo_url3, photo_url4 ,nick_name, content, comment_date
 FROM products JOIN reviews ON products.id=reviews.product_id WHERE id=3;