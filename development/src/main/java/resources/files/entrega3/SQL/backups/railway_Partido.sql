-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: containers-us-west-50.railway.app    Database: railway
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
-- Table structure for table `Partido`
--

DROP TABLE IF EXISTS `Partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Partido` (
  `idPartido` int NOT NULL AUTO_INCREMENT,
  `equipo1_FK` varchar(30) NOT NULL,
  `equipo2_FK` varchar(30) NOT NULL,
  `golesEquipo1` int DEFAULT '0',
  `golesEquipo2` int DEFAULT '0',
  `ronda_FK` int NOT NULL,
  PRIMARY KEY (`idPartido`),
  KEY `equipo1_FK` (`equipo1_FK`),
  KEY `equipo2_FK` (`equipo2_FK`),
  KEY `ronda_FK` (`ronda_FK`),
  CONSTRAINT `Partido_ibfk_1` FOREIGN KEY (`equipo1_FK`) REFERENCES `Equipo` (`Nombre`),
  CONSTRAINT `Partido_ibfk_2` FOREIGN KEY (`equipo2_FK`) REFERENCES `Equipo` (`Nombre`),
  CONSTRAINT `Partido_ibfk_3` FOREIGN KEY (`ronda_FK`) REFERENCES `Ronda` (`idRonda`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido`
--

LOCK TABLES `Partido` WRITE;
/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
INSERT INTO `Partido` VALUES (1,'Argentina','Arabia Saudita',1,2,1),(2,'Mexico','Polonia',0,0,1),(3,'Polonia','Arabia Saudita',2,0,2),(4,'Argentina','Mexico',2,0,2),(5,'Polonia','Argentina',0,2,3),(6,'Arabia Saudita','Mexico',1,2,3),(7,'Paises Bajos','Estados Unidos',3,1,4),(8,'Argentina','Australia',2,1,4),(9,'Japon','Croacia',1,3,4),(10,'Brasil','Corea del Sur',4,1,4),(11,'Inglaterra','Senegal',4,1,4),(12,'Francia','Polonia',3,1,4),(13,'Marruecos','España',3,1,4),(14,'Portugal','Suiza',6,1,4),(15,'Paises Bajos','Argentina',3,4,5),(16,'Croacia','Brasil',4,2,5),(17,'Inglaterra','Francia',1,2,5),(18,'Marruecos','Portugal',1,0,5),(19,'Argentina','Croacia',3,0,6),(20,'Francia','Marruecos',2,0,6),(21,'Croacia','Marruecos',2,1,7),(22,'Argentina','Francia',4,2,8);
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-11  9:38:34
