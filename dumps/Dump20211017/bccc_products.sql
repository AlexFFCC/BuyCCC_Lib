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
  `category` varchar(10) NOT NULL DEFAULT '筆電',
  `brand` varchar(10) NOT NULL DEFAULT '',
  `photo_url2` varchar(300) DEFAULT NULL,
  `photo_url3` varchar(300) DEFAULT NULL,
  `photo_url4` varchar(300) DEFAULT NULL,
  `description_photo1` varchar(300) DEFAULT NULL,
  `description_photo2` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'宏碁 ACER Swift 5 筆記型電腦 14',30900,5,10,'https://www.cdn-tkec.tw/image/product/202101/214537_M.jpg?t=20210901172932','Intel Core i5-1135G7(2.40 GHz/4.20 GHz)\n 14 FHD/LED背光/IPS/觸控\n 8GB LPDDR4X(Onboaed)0/8GB)\n 512GB PCIe NVMe SSD(不能擴充)\n Intel Iris Xe Graphics','2021-09-24','筆電','','https://e.ecimg.tw/items/DHABBEA900AZRER/000001_1605514122.jpg','https://d.ecimg.tw/items/DHABBEA900B315B/000001_1610354411.jpg',NULL,'https://b.ecimg.tw/items/DHABBEA900B2082/i010012_1608538259.jpg','https://f.ecimg.tw/items/DHABBEA900B2082/i010015_1608538259.jpg'),(2,'宏碁 ACER Aspire 5 筆記型電腦 15.6',29900,18,10,'https://www.cdn-tkec.tw/image/product/202103/216582_M.jpg?t=20210413092856','CPU:i7-1165G7 clock/Turbo(2.80 GHz/4.70)\n	15.6 FHD/霧面/LED背光/IPS\n	VGA:Nvidia Geforce MX350 2GB GDDR5\n	RAM: 8GB DDR4(Onboard)(1/24GB)','2021-09-27','筆電','',NULL,NULL,NULL,NULL,NULL),(3,'ASUS筆記型電腦 ZenBook 14',36900,10,8,'https://www.cdn-tkec.tw/image/product/202104/217526_M.jpg?t=20210903133648','ASUS ZenBook 14 恆 • 美力\n	14\'FHD (1920 x 1080) IPS-level\n	Intel Core i5-1135G7 Processor 2.4 GHz\n	16GB LPDDR4X on board\n	512GB M.2 NVMe PCIe 3.0 SSD','2021-09-27','筆電','',NULL,NULL,NULL,'https://www.cdn-tkec.tw/image/product/desc/202104/i202105DM130000008_16218471232055210012217.jpg','https://www.cdn-tkec.tw/image/product/desc/202104/i202105DM130000008_16218471232141580071514.jpg'),(4,'宏碁 ACER Swift X 筆記型電腦 14',33900,10,20,'https://www.cdn-tkec.tw/image/product/202106/218731_M.jpg?t=20210818162854','AMD Ryzen 5 5500U(2.1GHz/4.0GHz)\n	14 FHD/霧面/LED背光/IPS\n	16GB LPDDR4 (Onboard)(0/16GB)\n	512GB PCIe NVMe SSD(不能擴充)\n	NVIDIA GeForce GTX 1650-4G\n	1.39 kg 802.11a/b/g/n+ax','2021-09-27','筆電','',NULL,NULL,NULL,NULL,NULL),(5,'樂金LG Gram 16吋 極緻輕薄筆電',43900,0,12,'https://www.cdn-tkec.tw/image/product/202103/216221_M.jpg?t=20210310144801','Intel Core I5-1135G7/搭配Intel Iris Xe\n	2年保固16G DDR4(Onboard)不可擴充\n	512G SSD可擴充SSD PCIe/SATA介面\n	電池容量 80瓦時，最長可達20.5小時續航力\n	通過MIL-STD 810G 軍規7個耐用性測試\n	Thunderbolt 4 (x2) / USB 3.2 Gen2x1 (x2)','2021-09-27','輕薄筆電','',NULL,NULL,NULL,NULL,NULL),(7,'SAMSUNG Galaxy Tab S7 FE WIFI ',16000,0,15,'https://www.cdn-tkec.tw/image/product/202108/220151_M.jpg?t=20210906153343','12.4吋 2560x1600解析度TFT螢幕\n2.2GHz+1.8GHz 八核心處理器\n4GB RAM / 64GB ROM\n主鏡頭8MP+前置鏡頭5MP\n提供 S Pen 手寫筆、專屬收納槽','2021-02-06','筆電','',NULL,NULL,NULL,NULL,NULL),(9,'Microsoft 微軟Surface Laptop 4 13.5吋輕薄觸控筆電',52000,5,6,'https://i4.momoshop.com.tw/1621223239/goodsimg/0008/855/115/8855115_R.webp','第11代Intel處理器\n設計纖薄 輕盈優雅\n一指輕鬆開機','2021-04-25','觸控筆電','','https://i4.momoshop.com.tw/1621222975/goodsimg/0008/855/107/8855107_R1.webp','https://i1.momoshop.com.tw/1621222975/goodsimg/0008/855/107/8855107_R2.webp',NULL,'https://img4.momoshop.com.tw/expertimg/0008/855/107/mobile//B-1000_01.jpg','https://img4.momoshop.com.tw/expertimg/0008/855/107/mobile//B-1000_04.jpg'),(10,'MSI Summit B15 A11MT-693TW 效能商務筆電',32000,0,18,'https://d.ecimg.tw/items/DHAK8RA900BPEKK/000001_1631671345.jpg','處理器：Intel® Core™ i5-1155G7 四核心處理器','2021-10-13','筆電','','https://i2.momoshop.com.tw/1630935039/goodsimg/0009/261/648/9261648_R1.webp','https://i4.momoshop.com.tw/1630935039/goodsimg/0009/261/648/9261648_R3.webp',NULL,NULL,NULL);
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

-- Dump completed on 2021-10-17 12:43:23
