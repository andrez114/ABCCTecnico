-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sku` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `articulo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `stock` int NOT NULL,
  `cantidad` int NOT NULL,
  `marca` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modelo` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fechaAlta` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fechaBaja` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `departamento` int NOT NULL,
  `clase` int NOT NULL,
  `familia` int NOT NULL,
  `descontinuado` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (56,'432989','Licuadora',24,20,'Oster','GF898','26-03-2023','1900-01-01',1,2,1,0),(57,'35353','vaso de vidrio',56,32,'oster','JUDS-90','26-03-2023','26-03-2023',1,3,1,1),(58,'34343','Auto Estereo',100,43,'Pionner','MVH-DS','26-03-2023','1900-01-01',2,2,6,0),(59,'768453','Autoestereo',32,30,'Sony','AVH-G2','26-03-2023','1900-01-01',2,2,7,0),(60,'656564','COLCHONMATRIMON',54,4,'Restonic','FDF-656','26-03-2023','26-03-2023',3,1,1,1),(61,'545454','COLCHONINDIVIDU',23,17,'WENDY','DFSF-FDFDF','26-03-2023','26-03-2023',3,2,1,1),(62,'65755','SALA ESQUINERA',12,3,'LOGAN','FDF-54','26-03-2023','1900-01-01',4,1,1,0),(63,'432','SILLON',323,2,'LOGAN','FD-090','26-03-2023','1900-01-01',4,1,2,0);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-26 19:13:45
