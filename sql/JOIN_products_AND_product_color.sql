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
SELECT id, name, color_name,unit_price, discount, photo_url1 AS color_photo ,product_colors.stock AS color_stock, SUM(product_colors.stock) ,products.stock, photo_url, description, shelf_date, category
, brand FROM products 
LEFT JOIN product_colors ON products.id = product_colors.product_id WHERE id = 2;
/*產品顏色加總*/
SELECT id, name, color_name,unit_price, discount,IFNULL(SUM(product_colors.stock),products.stock) AS stock, photo_url1 AS color_photo , photo_url, description, shelf_date, category, brand 
FROM products 
LEFT JOIN product_colors 
ON products.id = product_colors.product_id GROUP BY products.id;
/*產品有顏色有尺寸有不同價格*/
SELECT * FROM products;
SELECT * FROM product_colors;
SELECT * FROM product_color_sizes ORDER BY product_id, color_name ,ordinal;
SELECT id, name, products.unit_price, product_color_sizes.unit_price as size_unit_price,discount
, product_colors.color_name,product_color_sizes.color_name, size
, products.stock as products_stock, product_colors.stock as color_stock, product_color_sizes.stock as size_stock,photo_url, description, shelf_date, category
, brand, products.photo_url2, products.photo_url3, products.photo_url4
, description_photo1, description_photo2
, product_colors.photo_url1, product_colors.photo_url2 
, ordinal
 FROM products 
LEFT JOIN product_colors  ON products.id = product_colors.product_id 
	LEFT JOIN product_color_sizes ON products.id= product_color_sizes.product_id 
		AND (product_colors.color_name = product_color_sizes.color_name 
        OR product_color_sizes.color_name =''
        )WHERE id ='7' ORDER BY ordinal;
        
SELECT id, name, product_colors.color_name, product_color_sizes.color_name AS size_color_name, size, ordinal, product_color_sizes.stock AS size_stock, product_color_sizes.unit_price AS size_unit_price ,products.unit_price, discount, photo_url1 AS color_photo ,product_colors.stock AS color_stock, products.stock
, photo_url, products.photo_url2, products.photo_url3, description,description_photo1, description_photo2 , shelf_date, category, brand
 FROM products
	LEFT JOIN product_colors ON products.id = product_colors.product_id
   LEFT JOIN product_color_sizes ON product_color_sizes.product_id = products.id AND 
   (product_color_sizes.color_name = product_colors.color_name
   OR product_color_sizes.color_name=''
   ) 
    WHERE id = '7'






