-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: livestockmanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `livestock`
--

DROP TABLE IF EXISTS `livestock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livestock` (
  `LivestockName` varchar(20) NOT NULL,
  `UnitPrice` decimal(9,2) NOT NULL,
  `LivestockID` char(4) NOT NULL,
  `Feeds` varchar(20) NOT NULL,
  `MaturityDate` date NOT NULL,
  `ScheduledHarvestDate` date NOT NULL,
  `BatchNo` char(4) NOT NULL,
  `HarvestNo` char(5) NOT NULL,
  PRIMARY KEY (`LivestockID`),
  KEY `BatchNo` (`BatchNo`),
  KEY `HarvestNo` (`HarvestNo`),
  CONSTRAINT `livestock_ibfk_1` FOREIGN KEY (`BatchNo`) REFERENCES `schedule` (`BatchNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `livestock_ibfk_2` FOREIGN KEY (`HarvestNo`) REFERENCES `harvest` (`HarvestNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livestock`
--

LOCK TABLES `livestock` WRITE;
/*!40000 ALTER TABLE `livestock` DISABLE KEYS */;
INSERT INTO `livestock` VALUES ('Dairy',11.25,'DAF1','Vitamins & Feeds','2019-04-21','2019-04-22','AA01','HRV11'),('Poultry',8.50,'POF1','Vitamins & Grains','2019-04-28','2019-04-29','BA01','HRV01'),('Poultry',10.00,'POF2','Vitamins & Grains','2019-06-11','2019-06-12','BA02','HRV02'),('Poultry ',10.00,'POF3','Vitamins & Feeds','2019-11-10','2019-11-12','CA01','HRV31'),('Wool',13.50,'SHF1','Vitamins & Feeds','2019-04-27','2019-04-28','AA02','HRV21'),('Wool',13.50,'SHF2','Vitamins & Feeds','2019-11-14','2019-11-15','CA02','HRV32');
/*!40000 ALTER TABLE `livestock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-15 13:29:32
