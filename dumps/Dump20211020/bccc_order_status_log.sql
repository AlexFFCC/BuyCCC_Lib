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
-- Table structure for table `order_status_log`
--

DROP TABLE IF EXISTS `order_status_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int unsigned NOT NULL,
  `old_status` int unsigned NOT NULL,
  `new_status` int unsigned NOT NULL,
  `old_payment_note` varchar(100) DEFAULT NULL,
  `new_payment_note` varchar(100) DEFAULT NULL,
  `old_shipping_note` varchar(100) DEFAULT NULL,
  `new_shipping_note` varchar(100) DEFAULT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status_log`
--

LOCK TABLES `order_status_log` WRITE;
/*!40000 ALTER TABLE `order_status_log` DISABLE KEYS */;
INSERT INTO `order_status_log` VALUES (1,1,0,1,'','','','','2021-10-19 14:46:44'),(2,2,0,1,'','','','','2021-10-19 16:50:21'),(3,3,0,1,'','美國運通','','','2021-10-19 17:03:13'),(4,5,0,1,'','銀行:阿里山銀行, 後5碼:12345, 金額:16000.0轉帳日期:2021-10-18T20:30','','','2021-10-19 18:18:43'),(5,9,0,1,'','銀行:美國運通, 後5碼:55555, 金額:16000.0轉帳日期:2021-10-18T02:30','','','2021-10-19 18:24:06'),(6,1,1,3,'','','','','2021-10-20 10:23:16'),(7,2,1,2,'','','','','2021-10-20 10:23:16'),(8,13,0,1,'','銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','','','2021-10-20 10:40:31'),(9,1,3,4,'','','','','2021-10-20 10:58:53'),(10,2,2,3,'','','','','2021-10-20 10:58:53'),(11,14,0,1,'','銀行:阿里山銀行, 後5碼:12345, 金額:68518.0轉帳日期:2021-10-20T04:30','','','2021-10-20 12:00:22'),(12,11,0,1,'','','','','2021-10-20 12:06:45'),(13,11,1,2,'','','','','2021-10-20 12:06:52'),(14,11,2,3,'','','','','2021-10-20 12:07:03'),(15,11,3,4,'','','','','2021-10-20 12:07:20'),(16,28,0,1,'','','','','2021-10-20 15:19:16'),(17,28,1,2,'','','','','2021-10-20 15:19:22'),(18,28,2,3,'','','','','2021-10-20 15:19:27'),(19,28,3,4,'','','','','2021-10-20 15:19:32'),(20,19,0,1,'','','','','2021-10-20 15:31:25'),(21,19,1,2,'','','','','2021-10-20 15:31:29'),(22,19,2,3,'','','','','2021-10-20 15:31:35'),(23,19,3,4,'','','','','2021-10-20 15:31:39'),(24,13,1,2,'銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','','','2021-10-20 16:42:56'),(25,13,2,3,'銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','','','2021-10-20 16:43:01'),(26,13,3,4,'銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','銀行:美國運通, 後5碼:12345, 金額:440000.0轉帳日期:2021-10-20T05:30','','','2021-10-20 16:43:06');
/*!40000 ALTER TABLE `order_status_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-20 20:54:46
