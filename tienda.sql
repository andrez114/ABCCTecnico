-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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

--
-- Table structure for table `t_clase`
--

DROP TABLE IF EXISTS `t_clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_clase` (
  `id_clase` int NOT NULL,
  `id_departamento` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `clase` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_clase`),
  UNIQUE KEY `id_clase_UNIQUE` (`id_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_clase`
--

LOCK TABLES `t_clase` WRITE;
/*!40000 ALTER TABLE `t_clase` DISABLE KEYS */;
INSERT INTO `t_clase` VALUES (11,'1','COMESTIBLES'),(12,'1','LICUADORAS'),(13,'1','BATIDORAS'),(14,'1','CAFETERAS'),(21,'2','AMPLIFICADORES CAR AUDIO'),(22,'2','AUTO ESTEREOS'),(31,'3','COLCHON'),(32,'3','JUEGO BOX'),(41,'4','SALAS'),(42,'4','COMPLEMENTOS PARA SALA'),(43,'4','SOFAS CAMA');
/*!40000 ALTER TABLE `t_clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_departamento`
--

DROP TABLE IF EXISTS `t_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_departamento` (
  `id_departamento` int NOT NULL,
  `departamento` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_departamento`),
  UNIQUE KEY `id_departamento_UNIQUE` (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_departamento`
--

LOCK TABLES `t_departamento` WRITE;
/*!40000 ALTER TABLE `t_departamento` DISABLE KEYS */;
INSERT INTO `t_departamento` VALUES (1,'DOMESTICOS'),(2,'ELECTRONICA'),(3,'MUEBLE SUELTO'),(4,'SALAS, RECAMARA, COMEDORES');
/*!40000 ALTER TABLE `t_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_familia`
--

DROP TABLE IF EXISTS `t_familia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_familia` (
  `id_familia` int NOT NULL,
  `id_clase` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `familia` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_familia`),
  UNIQUE KEY `id_familia_UNIQUE` (`id_familia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_familia`
--

LOCK TABLES `t_familia` WRITE;
/*!40000 ALTER TABLE `t_familia` DISABLE KEYS */;
INSERT INTO `t_familia` VALUES (110,'11','SIN NOMBRE'),(121,'12','LICUADORAS'),(122,'12','EXCLUSIVO DE COPPEL.COM'),(131,'13','BATIDORA MANUAL'),(132,'13','PROCESADOR'),(133,'13','PICADORA'),(134,'13','BATIDORA PEDESTAL'),(135,'13','BATIDORA FUENTE DE SODAS'),(136,'13','MULTIPRACTICOS'),(137,'13','EXCLUSIVO DE COPPEL.COM'),(141,'14','CAFETERAS'),(142,'14','PERCOLADAS'),(211,'21','AMPLIFICADOR/ RECEPTOR'),(212,'21','KIT DE INSTALACION'),(213,'21','AMPLIFICADORES COPPEL'),(221,'22','AUTOESTEREO CD'),(222,'22','ACCESORIOS CAR AUDIO'),(223,'22','AMPLIFICADOR'),(224,'22','ALARMA AUTO/ CASA /OFICINA'),(225,'22','SIN MECANISMO'),(226,'22','CON CD'),(227,'22','MULTIMEDIA'),(228,'22','PAQUETE SIN MECANISMO'),(229,'22','PAQUETE CD'),(311,'31','PILLOW TOP KS'),(312,'31','PILLOWTOP DOBLE KS'),(313,'31','HULE ESPUMA KS'),(314,'32','ESTANDAR INDIVIDUAL'),(315,'32','PILLOW DOBLE INDIVIDIAL'),(411,'41','ESQUINERAS SUPERIORES'),(412,'41','TIPO L SELECCIONAL'),(421,'42','SILLON OCASIONAL'),(422,'42','PUFF'),(423,'42','BAUL'),(424,'42','TABURETE'),(431,'43','SOFA CAMA TAPIZADO'),(432,'43','SOFA CAMA CLASICO'),(433,'43','ESTUDIO');
/*!40000 ALTER TABLE `t_familia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-26 19:28:28
