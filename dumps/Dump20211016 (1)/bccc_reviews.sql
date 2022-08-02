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
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `customer_id` char(10) NOT NULL,
  `order_id` int NOT NULL,
  `nick_name` varchar(20) NOT NULL,
  `content` varchar(150) NOT NULL,
  `comment_date` date DEFAULT (curdate()),
  PRIMARY KEY (`id`),
  KEY `fkey_reviews_TO_customers_idx` (`customer_id`),
  KEY `fkey_reivews_TO_prroducts_idx` (`product_id`),
  CONSTRAINT `fkey_reivews_TO_prroducts` FOREIGN KEY (`product_id`) REFERENCES `order_items` (`porduct_id`),
  CONSTRAINT `fkey_reviews_TO_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,10,'A123456789',7,'小陸','效能超好','2021-10-14'),(2,7,'A123456789',7,'小陸','畫質超好','2021-10-14'),(4,3,'A123456789',7,'小陸','商務風格的筆電','2021-10-14'),(5,7,'A123456789',9,'小陸','一手掌握很適合來看股票','2021-10-15'),(10,7,'A123456789',5,'王倪好','超難用','2021-10-16'),(11,7,'A123456789',1,'王倪好','好順目前都沒當機','2021-10-16'),(13,1,'A123456789',2,'王倪好','黑色的有紳士風格','2021-10-16'),(19,7,'A123456789',1,'聰明盧','好聰明','2021-10-16'),(22,3,'A123456789',4,'動物園','好好看','2021-10-16'),(23,3,'A123456789',3,'好好用','好好用','2021-10-16'),(24,2,'A123456789',5,'超級粉','有點太貴了，但很好用','2021-10-16');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
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
