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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pronostico`
--

LOCK TABLES `Pronostico` WRITE;
/*!40000 ALTER TABLE `Pronostico` DISABLE KEYS */;
INSERT INTO `Pronostico` VALUES (1,1,'Argentina','Ganador',1),(2,2,'Mexico','Ganador',1),(3,3,'Polonia','Ganador',1),(4,4,'Argentina','Ganador',1),(5,5,'Polonia','Ganador',1),(6,6,'Arabia Saudita','Ganador',1),(7,7,'Paises Bajos','Ganador',1),(8,8,'Argentina','Empate',1),(9,9,'Paises Bajos','Empate',1),(10,10,'Croacia','Empate',1),(11,11,'Argentina','Perdedor',1),(12,12,'Francia','Empate',1),(13,13,'Argentina','Empate',1),(14,14,'Croacia','Empate',1),(15,1,'Argentina','Empate',2),(16,2,'Mexico','Empate',2),(17,3,'Polonia','Perdedor',2),(18,4,'Argentina','Empate',2),(19,5,'Polonia','Empate',2),(20,6,'Arabia Saudita','Empate',2),(21,7,'Paises Bajos','Ganador',2),(22,8,'Argentina','Perdedor',2),(23,9,'Paises Bajos','Empate',2),(24,10,'Croacia','Ganador',2),(25,11,'Argentina','Perdedor',2),(26,12,'Francia','Empate',2),(27,13,'Argentina','Ganador',2),(28,14,'Croacia','Empate',2),(29,1,'Argentina','Perdedor',3),(30,2,'Mexico','Perdedor',3),(31,3,'Polonia','Perdedor',3),(32,4,'Argentina','Perdedor',3),(33,5,'Polonia','Ganador',3),(34,6,'Arabia Saudita','Ganador',3),(35,7,'Paises Bajos','Ganador',3),(36,8,'Argentina','Ganador',3),(37,9,'Paises Bajos','Ganador',3),(38,10,'Croacia','Ganador',3),(39,11,'Argentina','Empate',3),(40,12,'Francia','Ganador',3),(41,13,'Argentina','Ganador',3),(42,14,'Croacia','Ganador',3);
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

-- Dump completed on 2023-04-04 18:21:03
