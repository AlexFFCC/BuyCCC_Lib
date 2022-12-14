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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'A123456789','2021-10-07','16:06:18','ATM',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','4'),(2,'A123456789','2021-10-07','16:08:49','ATM',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','3'),(3,'A123456789','2021-10-14','09:30:10','ATM',0,'????????????','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','1'),(4,'A123456789','2021-10-14','11:08:34','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(5,'A123456789','2021-10-14','11:19:29','ATM',0,'??????:???????????????, ???5???:12345, ??????:16000.0????????????:2021-10-18T20:30','STORE',60,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','1'),(6,'A123456789','2021-10-14','11:27:54','SHOP',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(7,'A123456789','2021-10-14','11:45:24','STORE',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(8,'A123456789','2021-10-14','15:16:31','STORE',0,'','STORE',60,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(9,'A123456789','2021-10-14','16:03:35','ATM',0,'??????:????????????, ???5???:55555, ??????:16000.0????????????:2021-10-18T02:30','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','1'),(10,'A123456789','2021-10-18','10:19:23','STORE',0,'','STORE',60,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(11,'A123456789','2021-10-18','15:10:12','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','4'),(12,'A123456789','2021-10-18','16:01:11','STORE',0,'','STORE',60,'','?????????','test00911@gmail.com','0987654321','www','0'),(13,'A123456707','2021-10-19','10:03:09','ATM',0,'??????:????????????, ???5???:12345, ??????:440000.0????????????:2021-10-20T05:30','HOME',100,'','?????????','funny@uuu.com.tw','0987654321','??????????????????8???','4'),(14,'A123456707','2021-10-19','15:18:19','ATM',0,'??????:???????????????, ???5???:12345, ??????:68518.0????????????:2021-10-20T04:30','HOME',100,'','?????????','funny@uuu.com.tw','0987654321','??????????????????8???','1'),(15,'A123456789','2021-10-19','15:21:12','SHOP',0,'','STORE',60,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(16,'A123456707','2021-10-20','12:03:33','ATM',0,'??????:UCOM bank, ???5???:12345, ??????:24518.0????????????:2021-10-21T04:00','SHOP',0,'','?????????','funny@uuu.com.tw','0987654321','????????????','1'),(19,'A123456789','2021-10-20','14:53:26','ATM',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','4'),(28,'A123456707','2021-10-20','15:11:24','ATM',0,'','HOME',100,'','?????????','funny@uuu.com.tw','0987564412','??????????????????8???','4'),(29,'A123456707','2021-10-20','15:41:52','ATM',0,'','HOME',100,'','?????????','funny@uuu.com.tw','0987654321','??????????????????8???','0'),(30,'A123456707','2021-10-20','16:45:27','ATM',0,'','SHOP',0,'','?????????','funny@uuu.com.tw','0987654321','????????????','1'),(31,'A123456789','2021-10-21','12:23:46','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(32,'A123456789','2021-10-21','12:25:55','ATM',0,'','STORE',60,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(33,'A123456789','2021-10-21','12:26:52','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','1'),(34,'A123456789','2021-10-21','12:58:56','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(35,'A123456789','2021-10-21','13:26:25','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(36,'A123456789','2021-10-21','13:27:02','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(37,'A123456789','2021-10-21','13:27:37','SHOP',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(38,'A123456789','2021-10-21','13:43:58','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(39,'A123456789','2021-10-21','13:57:39','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(40,'A123456789','2021-10-21','14:00:41','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(41,'A123456789','2021-10-21','15:44:38','ATM',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(42,'A123456789','2021-10-21','15:59:01','ATM',0,'','SHOP',0,'','?????????','uuu5598016@gmail.com','0987654321','????????????','0'),(43,'A123456789','2021-10-21','16:02:58','ATM',0,'??????:???????????????, ???5???:11111, ??????:30510.0????????????:2021-10-21T03:30','SHOP',0,'','?????????','uuu5598016@gmail.com','0987654321','????????????','3'),(44,'A123456789','2021-10-21','16:07:55','SHOP',0,'','SHOP',0,'','?????????','uuu5598016@gmail.com','0987654321','????????????','0'),(45,'A123456789','2021-10-21','18:04:18','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(46,'A123456789','2021-10-21','18:48:15','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(47,'A123456789','2021-10-21','18:54:46','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(48,'A123456789','2021-10-21','18:57:09','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(49,'A123456789','2021-10-21','18:58:04','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(50,'A123456707','2021-10-22','12:05:16','ATM',0,'','HOME',100,'','?????????','funny@uuu.com.tw','0987654321','??????????????????8???','0'),(51,'A123456789','2021-10-22','15:37:08','CARD',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(52,'A123456789','2021-10-22','15:38:24','CARD',0,'','SHOP',0,'','?????????','test00911@gmail.com','0987654321','????????????','0'),(53,'A123456789','2021-10-22','16:18:53','ATM',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(54,'A123456789','2021-10-22','16:20:39','ATM',0,'','HOME',100,'','?????????','test00911@gmail.com','0987654321','????????????????????????44???','0'),(55,'A123456789','2021-10-22','16:21:34','ATM',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(56,'A123456789','2021-10-22','16:25:10','ATM',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(57,'A123456789','2021-10-25','09:37:39','ATM',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(58,'A123456789','2021-10-25','09:41:48','CARD',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(59,'A123456789','2021-10-25','09:46:45','HOME',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(60,'A123456789','2021-10-25','09:54:56','ATM',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(61,'A123456789','2021-10-25','09:57:00','ATM',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(62,'A123456789','2021-10-25','09:57:43','ATM',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(63,'A123456789','2021-10-25','10:19:39','CARD',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(64,'A123456789','2021-10-25','10:34:19','CARD',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(65,'A123456789','2021-10-25','10:34:57','CARD',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(66,'A123456789','2021-10-25','10:52:31','CARD',0,'????????????:4311-95**-****2222,?????????:777367,????????????:2021-10-25 10:52:46,????????????:32000.0','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','2'),(67,'A123456789','2021-10-25','11:37:54','CARD',0,'????????????:4311-95**-****2222,?????????:777617,????????????:2021-10-25 11:37:58,????????????:32000.0','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','2'),(68,'A123456789','2021-10-25','11:56:53','CARD',0,'????????????:4311-95**-****2222,?????????:777642,????????????:2021-10-25 11:56:58,????????????:16110.0','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','2'),(69,'A123456789','2021-10-25','12:00:04','CARD',0,'','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','0'),(70,'A123456789','2021-10-25','12:12:59','CARD',0,'????????????:4311-95**-****2222,?????????:777698,????????????:2021-10-25 12:13:04,????????????:16210.0','HOME',100,'','?????????','uuu5598016@gmail.com','0987654321','????????????????????????44???','2');
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

-- Dump completed on 2021-10-25 12:14:19
