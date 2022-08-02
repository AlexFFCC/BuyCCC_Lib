SELECT * FROM product_colors;/*1產品有2個顏色*/
SELECT * FROM products;
/*INNER JOIN*/
SELECT id, name, color_name, unit_price, discount, products.stock, products.photo_url, description, shelf_date, category, brand FROM products
JOIN product_colors ON products.id = product_colors.product_id;
/*LEFT OUTER JOIN*/
SELECT id, name, color_name, unit_price, discount, products.stock, products.photo_url,product_colors.photo_url2, description, shelf_date, category, brand FROM products
left JOIN product_colors ON products.id = product_colors.product_id;

/*right OUTER JOIN*/
SELECT id, nameproduct_colors, color_name, unit_price, discount, products.stock, products.photo_url,product_colors.photo_url2, description, shelf_date, category, brand FROM products
right JOIN product_colors ON products.id = product_colors.product_id;

/*產品明細*/
SELECT id, name, color_name,unit_price, discount, photo_url1 AS color_photo ,product_colors.stock AS color_stock, SUM(product_colors.stock) ,products.stock, photo_url, description, shelf_date, category, brand FROM products 
LEFT JOIN product_colors ON products.id = product_colors.product_id WHERE id = 7;
/*產品顏色加總*/
SELECT id, name, color_name,unit_price, discount,IFNULL(SUM(product_colors.stock),products.stock) AS stock, photo_url1 AS color_photo , photo_url, description, shelf_date, category, brand 
FROM products 
LEFT JOIN product_colors 
ON products.id = product_colors.product_id GROUP BY products.id;

