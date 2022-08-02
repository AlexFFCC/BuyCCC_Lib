USE bccc;

INSERT INTO customers (id, name, email, password, birthday, gender, subscribed)
 VALUES ('A12456789', '王奇葩', 'test01@uuu.com.tw', 'qwrr12345', '2010-02-11', 'M', '0');
 
 INSERT INTO customers (id, name, email, password, birthday, gender, address, phone, subscribed)
	VALUES('A223456718','林美麗','test02@gmail.com','qwrt1235456','1965-01-07','F','台北市','0987654321',false);
 
 INSERT INTO customers (id, name, email, password, birthday, gender, address, phone, subscribed)
	VALUES('A223456775','王例紅','test02@gmail.com','qwrt12456','1955-02-07','F','新北xxx','0987554321',false);
    
INSERT INTO bccc.customers (id, name, email, password, birthday, gender, address, phone, subscribed) 
	VALUES ('A125467892', '陳水', 'test04@gmail.com', '456qwr', '1960-09-09', 'M', '桃園', '09567542313', '1');
INSERT INTO bccc.customers (id, name, email, password, birthday, gender, address, phone, subscribed) 
	VALUES ('A125467845', '陳水', 'test05@gmail.com', '456qwr', '1960-09-09', 'M', '桃園', '09567542313', '1');
SELECT id, name, email, password, birthday, gender, address, phone, subscribed FROM customers;

SELECT id, name, email, password, birthday, gender, address, phone, subscribed FROM customers
	WHERE id = 'A123456789' AND password='qwrr12345';
