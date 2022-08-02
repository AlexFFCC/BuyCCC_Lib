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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `unit_price` double NOT NULL,
  `discount` int unsigned NOT NULL DEFAULT '0',
  `stock` int unsigned NOT NULL DEFAULT '0',
  `photo_url` varchar(250) DEFAULT NULL,
  `description` varchar(200) NOT NULL DEFAULT '',
  `shelf_date` date NOT NULL DEFAULT (curdate()),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'宏碁 ACER Swift 5 筆記型電腦 14',30900,0,0,NULL,'','2021-09-24'),(2,'宏碁 ACER Aspire 5 筆記型電腦 15.6',29900,18,10,'https://www.cdn-tkec.tw/image/product/202103/216582_M.jpg?t=20210413092856','CPU:i7-1165G7 clock/Turbo(2.80 GHz/4.70)\n	15.6 FHD/霧面/LED背光/IPS\n	VGA:Nvidia Geforce MX350 2GB GDDR5\n	RAM: 8GB DDR4(Onboard)(1/24GB)','2021-09-27'),(3,'宏碁 ACER Swift 5 筆記型電腦 14',30900,0,0,NULL,'','2021-09-24'),(4,'ASUS筆記型電腦 ZenBook 14',36900,10,8,'https://www.cdn-tkec.tw/image/product/202104/217526_M.jpg?t=20210903133648','ASUS ZenBook 14 恆 • 美力\n	14\'FHD (1920 x 1080) IPS-level\n	Intel Core i5-1135G7 Processor 2.4 GHz\n	16GB LPDDR4X on board\n	512GB M.2 NVMe PCIe 3.0 SSD','2021-09-27'),(5,'宏碁 ACER Swift X 筆記型電腦 14',33900,10,20,'https://www.cdn-tkec.tw/image/product/202106/218731_M.jpg?t=20210818162854','AMD Ryzen 5 5500U(2.1GHz/4.0GHz)\n	14 FHD/霧面/LED背光/IPS\n	16GB LPDDR4 (Onboard)(0/16GB)\n	512GB PCIe NVMe SSD(不能擴充)\n	NVIDIA GeForce GTX 1650-4G\n	1.39 kg 802.11a/b/g/n+ax','2021-09-27');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-24 18:03:47
