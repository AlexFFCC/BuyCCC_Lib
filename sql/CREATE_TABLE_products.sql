CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `unit_price` double NOT NULL,
  `discount` int unsigned NOT NULL DEFAULT '0',
  `stock` int unsigned NOT NULL DEFAULT '0',
  `photo_url` varchar(250) DEFAULT NULL,
  `description` varchar(200) NOT NULL DEFAULT '',
  `shelf_date` date NOT NULL DEFAULT (curdate()),
  `category` varchar(10) NOT NULL DEFAULT '筆電',
  `brand` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
;
CREATE TABLE `product_colors` (
  `product_id` int NOT NULL,
  `color_name` varchar(15) NOT NULL,
  `photo_url1` varchar(250) DEFAULT NULL,
  `photo_url2` varchar(250) DEFAULT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`product_id`,`color_name`),
  CONSTRAINT `fkey_product_colors_TO_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
