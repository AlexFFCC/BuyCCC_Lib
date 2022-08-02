-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: bccc
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'A123456789','2021-10-07','16:06:18','ATM',0,'','HOME',100,'','王大陸','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(2,'A123456789','2021-10-07','16:08:49','ATM',0,'','HOME',100,'','王大陸','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(3,'A123456789','2021-10-14','09:30:10','ATM',0,'','SHOP',0,'','王大路','test00911@gmail.com','0987654321','台中門市','0'),(4,'A123456789','2021-10-14','11:08:34','CARD',0,'','SHOP',0,'','王大路','test00911@gmail.com','0987654321','台北門市','0'),(5,'A123456789','2021-10-14','11:19:29','ATM',0,'','STORE',60,'','王大路','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(6,'A123456789','2021-10-14','11:27:54','SHOP',0,'','SHOP',0,'','王大路','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(7,'A123456789','2021-10-14','11:45:24','STORE',0,'','SHOP',0,'','王大路','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(8,'A123456789','2021-10-14','15:16:31','STORE',0,'','STORE',60,'','王大路','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(9,'A123456789','2021-10-14','16:03:35','ATM',0,'','SHOP',0,'','王大路','test00911@gmail.com','0987654321','台南市光泉路三段44號','0'),(10,'A123456789','2021-10-16','15:54:21','SHOP',0,'','SHOP',0,'','testtest','test00911@gmail.com','0987654321','台北門市','0');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-16 23:04:12
