SELECT id, stock FROM products ;
/*7*/
SELECT product_id, color_name, stock FROM product_colors WHERE product_id = 7 AND color_name ='星霧金';
/*8*/
SELECT product_id, color_name, size ,stock FROM product_color_sizes
 WHERE product_id = 1 AND color_name = '金色' AND size = '8RAM'; 
 /*6*/
SELECT product_id, color_name, size ,stock FROM product_color_sizes
	WHERE product_id = 5 AND size = '8RAM'; 
    
    
 /*upadte庫存*/

 UPDATE products SET stock = stock - 4 WHERE  stock>=4 AND id = 4 ;
/*7*/

UPDATE product_colors SET stock = stock - 5 WHERE stock>=6 AND product_id = 1 AND color_name ='金色';
/*8*/


SELECT product_id, color_name, size ,stock FROM product_color_sizes
 WHERE product_id = 1 AND color_name = '金色' AND size = '8RAM'; 
 /*6*/
SELECT product_id, color_name, size ,stock FROM product_color_sizes
	WHERE product_id = 5 AND size = '8RAM'; 
 
    
