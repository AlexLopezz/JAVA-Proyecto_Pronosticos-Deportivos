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
-- Table structure for table `Pronostico`
--

DROP TABLE IF EXISTS `Pronostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pronostico` (
  `idPronostico` int NOT NULL AUTO_INCREMENT,
  `partido_FK` int NOT NULL,
  `equipo_FK` varchar(30) NOT NULL,
  `resultado` enum('Ganador','Empate','Perdedor') NOT NULL,
  `persona_FK` int NOT NULL,
  PRIMARY KEY (`idPronostico`),
  KEY `partido_FK` (`partido_FK`),
  KEY `equipo_FK` (`equipo_FK`),
  KEY `persona_FK` (`persona_FK`),
  CONSTRAINT `Pronostico_ibfk_1` FOREIGN KEY (`partido_FK`) REFERENCES `Partido` (`idPartido`),
  CONSTRAINT `Pronostico_ibfk_2` FOREIGN KEY (`equipo_FK`) REFERENCES `Equipo` (`Nombre`),
  CONSTRAINT `Pronostico_ibfk_3` FOREIGN KEY (`persona_FK`) REFERENCES `Persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pronostico`
--

LOCK TABLES `Pronostico` WRITE;
/*!40000 ALTER TABLE `Pronostico` DISABLE KEYS */;
INSERT INTO `Pronostico` VALUES (1,1,'Argentina','Perdedor',1),(2,2,'Mexico','Empate',1),(3,3,'Polonia','Ganador',1),(4,4,'Argentina','Perdedor',1),(5,5,'Polonia','Empate',1),(6,6,'Arabia Saudita','Empate',1),(7,7,'Paises Bajos','Ganador',1),(8,8,'Argentina','Ganador',1),(9,9,'Japon','Ganador',1),(10,10,'Brasil','Ganador',1),(11,11,'Inglaterra','Ganador',1),(12,12,'Francia','Perdedor',1),(13,13,'Marruecos','Ganador',1),(14,14,'Portugal','Perdedor',1),(15,15,'Paises Bajos','Perdedor',1),(16,16,'Croacia','Ganador',1),(17,17,'Inglaterra','Ganador',1),(18,18,'Marruecos','Perdedor',1),(19,19,'Argentina','Ganador',1),(20,20,'Francia','Perdedor',1),(21,21,'Croacia','Ganador',1),(22,22,'Argentina','Ganador',1),(23,1,'Argentina','Empate',2),(24,2,'Mexico','Empate',2),(25,3,'Polonia','Ganador',2),(26,4,'Argentina','Perdedor',2),(27,5,'Polonia','Perdedor',2),(28,6,'Arabia Saudita','Ganador',2),(29,7,'Paises Bajos','Ganador',2),(30,8,'Argentina','Ganador',2),(31,9,'Japon','Perdedor',2),(32,10,'Brasil','Ganador',2),(33,11,'Inglaterra','Ganador',2),(34,12,'Francia','Perdedor',2),(35,13,'Marruecos','Perdedor',2),(36,14,'Portugal','Ganador',2),(37,15,'Paises Bajos','Ganador',2),(38,16,'Croacia','Ganador',2),(39,17,'Inglaterra','Perdedor',2),(40,18,'Marruecos','Ganador',2),(41,19,'Argentina','Perdedor',2),(42,20,'Francia','Perdedor',2),(43,21,'Croacia','Perdedor',2),(44,22,'Argentina','Ganador',2),(45,1,'Argentina','Ganador',3),(46,2,'Mexico','Empate',3),(47,3,'Polonia','Empate',3),(48,4,'Argentina','Perdedor',3),(49,5,'Polonia','Ganador',3),(50,6,'Arabia Saudita','Ganador',3),(51,7,'Paises Bajos','Ganador',3),(52,8,'Argentina','Perdedor',3),(53,9,'Japon','Ganador',3),(54,10,'Brasil','Ganador',3),(55,11,'Inglaterra','Ganador',3),(56,12,'Francia','Ganador',3),(57,13,'Marruecos','Ganador',3),(58,14,'Portugal','Ganador',3),(59,15,'Paises Bajos','Perdedor',3),(60,16,'Croacia','Perdedor',3),(61,17,'Inglaterra','Ganador',3),(62,18,'Marruecos','Perdedor',3),(63,19,'Argentina','Ganador',3),(64,20,'Francia','Ganador',3),(65,21,'Croacia','Ganador',3),(66,22,'Argentina','Ganador',3);
/*!40000 ALTER TABLE `Pronostico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-11  9:38:29
