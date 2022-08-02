/*SELECT ALL*/
SELECT * FROM products;

/*SELECT one product by id*/
SELECT id, name, unit_price, discount, stock, photo_url, description,shelf_date FROM products WHERE id = '3';

/*SELECT TOP3 LASTEST PRODUCT*/
SELECT id, name, unit_price, discount, stock, photo_url, description,shelf_date FROM products
ORDER BY shelf_date DESC LIMIT 3;

SELECT id, name, unit_price, discount, stock, photo_url, description,shelf_date FROM products WHERE name like'%acer%';
/*分類查詢*/
SELECT * FROM products where category= '輕薄筆電';

/*最新上架*/
SELECT id, name, unit_price, discount, stock, photo_url, description, shelf_date, category, brand FROM products ORDER BY shelf_date DESC LIMIT 5;
/*查詢價格區間*/
SELECT id, name, unit_price, discount, stock, photo_url, description, shelf_date, category, brand FROM products WHERE unit_price BETWEEN 20000 AND 34000;