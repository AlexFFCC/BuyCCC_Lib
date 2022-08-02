USE bccc;
CREATE TABLE `customers` (
  `id` char(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `gender` char(1) NOT NULL,
  `address` varchar(100) NOT NULL DEFAULT '',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `subscribed` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*create  orderitems*/
CREATE TABLE `order_items` (
  `order_id` int NOT NULL,
  `porduct_id` int NOT NULL,
  `color_name` varchar(15) NOT NULL DEFAULT '',
  `size` varchar(10) NOT NULL DEFAULT '',
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_id`,`porduct_id`,`color_name`,`size`),
  KEY `fkey_order_itme_TO_products_idx` (`porduct_id`),
  CONSTRAINT `fkey_order_itme_TO_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `fkey_order_itme_TO_products` FOREIGN KEY (`porduct_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*create orders */
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` char(10) NOT NULL,
  `order_date` date NOT NULL DEFAULT (curdate()),
  `order_time` time NOT NULL DEFAULT (curtime()),
  `payment_type` varchar(10) NOT NULL,
  `payment_fee` double NOT NULL,
  `payment_note` varchar(100) NOT NULL DEFAULT '',
  `shipping_type` varchar(10) NOT NULL,
  `shipping_fee` double NOT NULL,
  `shipping_note` varchar(100) NOT NULL DEFAULT '',
  `recipient_name` varchar(40) NOT NULL,
  `recipient_email` varchar(50) NOT NULL,
  `recipient_phone` varchar(20) NOT NULL,
  `shipping_address` varchar(100) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fkey_orders_TO_customers_idx` (`customer_id`),
  CONSTRAINT `fkey_orders_TO_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*CREATE product_color_size*/
CREATE TABLE `product_color_sizes` (
  `product_id` int NOT NULL,
  `color_name` varchar(15) NOT NULL DEFAULT '',
  `size` varchar(15) NOT NULL,
  `ordinal` int NOT NULL,
  `stock` int NOT NULL,
  `unit_price` double NOT NULL,
  PRIMARY KEY (`product_id`,`color_name`,`size`),
  CONSTRAINT `fkey_product_color_sizes_TO_porducts` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci




