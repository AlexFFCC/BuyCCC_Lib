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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('A108330622','測試Register1005','test09172@gmail.com','qwe123','1000-10-01','M','台北市新華路3號','0987654321',1),('A123456707','郝郝丸','funny@uuu.com.tw','qwe123','1966-09-05','M','金門縣中山路8號','',0),('A123456770','陳夏覷','sea@uuu.com.tw','qwe123','1966-09-05','M','澎湖縣中山路8號','',0),('A123456789','王大小陸','test00911@gmail.com','qwe123','1955-08-11','M','新北市中山路3號','0987654321',1),('A125467892','陳水水','test04@gmail.com','qwe123','1960-09-09','M','桃園','09567542313',1),('A134640680','JhonShi','test0917@gmail.com','qwe123','1965-09-08','M','台南市光泉路三段55號','0978456123',1),('A178386590','無姓名','test0091703@gmail.com','qwe123','1942-11-18','M','','',1),('A223456718','林美麗','test02@gmail.com','qwe123','1965-01-07','F','台北市','0987654321',0),('A223456775','王例紅','test03@gmail.com','qwe123','1955-02-07','F','新北xxx','0987554321',0),('B173234734','ALEX','test00913@gmail.com','QWE123','1947-10-21','M','','0987654321',0),('B203795822','Dora','dora@uuu.bccc.com','qwe123','1999-12-25','F','','',0),('B261226466','Zora','zora@uuu.bccc.com','qwe123','1997-02-05','F','澎湖縣大同街6號6樓','0987654123',0),('C186755716','測試Register','test0915@gmail.com','qwe123','1964-04-29','M','','0987654321',0),('D222974087','joanna','joanna@uuu.com.tw','qwe123','1996-06-04','F','','',1),('M227880498','王美美','test091302@uuu.com.tw','qwe123','1997-06-17','F','','0988654321',1);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-16 13:10:48
