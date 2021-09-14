-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: disney
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'src/images/fantasia.jpg','Fantasia'),(2,'src/images/musical.jpg','Musical'),(3,'src/images/accion.jpg','Accion'),(4,'src/images/cienciaficcion.jpg','Ciencia_ficcion'),(5,'src/images/romantica','Romantica'),(6,'src/images/Animada','Animada'),(7,'src/images/Comedia.jpg','Comedia');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero_like`
--

DROP TABLE IF EXISTS `genero_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero_like` (
  `pelicula_serie_id` bigint NOT NULL,
  `genero_id` bigint NOT NULL,
  PRIMARY KEY (`pelicula_serie_id`,`genero_id`),
  KEY `FK8sgyqjyeh5oclh5yt3iiwns6f` (`genero_id`),
  CONSTRAINT `FK8sgyqjyeh5oclh5yt3iiwns6f` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`),
  CONSTRAINT `FKfjapubbgr4n2dx5sxrc0u8f20` FOREIGN KEY (`pelicula_serie_id`) REFERENCES `pelicula_serie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero_like`
--

LOCK TABLES `genero_like` WRITE;
/*!40000 ALTER TABLE `genero_like` DISABLE KEYS */;
INSERT INTO `genero_like` VALUES (84,2),(80,3),(85,3),(80,4),(85,4),(84,5),(81,6),(84,6),(81,7);
/*!40000 ALTER TABLE `genero_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peli_serie_like`
--

DROP TABLE IF EXISTS `peli_serie_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peli_serie_like` (
  `personaje_id` bigint NOT NULL,
  `pelicula_serie_id` bigint NOT NULL,
  PRIMARY KEY (`personaje_id`,`pelicula_serie_id`),
  KEY `FKhi7wtexyulct3dd7ru310pwcg` (`pelicula_serie_id`),
  CONSTRAINT `FKhi7wtexyulct3dd7ru310pwcg` FOREIGN KEY (`pelicula_serie_id`) REFERENCES `pelicula_serie` (`id`),
  CONSTRAINT `FKidcx3ebgrcmekfycutf26kint` FOREIGN KEY (`personaje_id`) REFERENCES `personaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peli_serie_like`
--

LOCK TABLES `peli_serie_like` WRITE;
/*!40000 ALTER TABLE `peli_serie_like` DISABLE KEYS */;
INSERT INTO `peli_serie_like` VALUES (8,80),(9,80),(6,81),(7,81),(3,84),(5,84),(1,85),(2,85);
/*!40000 ALTER TABLE `peli_serie_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_serie`
--

DROP TABLE IF EXISTS `pelicula_serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_serie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_serie`
--

LOCK TABLES `pelicula_serie` WRITE;
/*!40000 ALTER TABLE `pelicula_serie` DISABLE KEYS */;
INSERT INTO `pelicula_serie` VALUES (80,4,'1999-05-19','src/images/starwars.jpg','Star Wars: The Phantom Menace'),(81,4,'1995-11-22','src/images/toystory1.jpg','Toy Story 1'),(84,5,'1992-07-09','src/images/beautyandtheBeast.jpg','Beauty and the Beast'),(85,5,'2019-03-22','src/images/avengersendgame.jpg','Avengers: Endgame');
/*!40000 ALTER TABLE `pelicula_serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `edad` int DEFAULT NULL,
  `historia` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (1,53,'Iron man....','Iron Man',77.4,'src/images/ironman.jpg'),(2,27,'Carol Danvers, also known as Captain Marvel, is a former United States Air Force pilot.','Captain Marvel',57.4,'src/images/captainmarvel.jpg'),(3,22,'Beauty....','Beauty',51.4,'src/images/beauty.jpg'),(5,36,'The Beast....','The Beast',83.2,'src/images/beast.jpg'),(6,18,'Woody....','Woody',0.45,'src/images/woody.jpg'),(7,19,'Buzz Lightyear....','Buzz Lightyear',0.53,'src/images/buz.jpg'),(8,34,'BObi-Wan Kenobi....','Obi-Wan Kenobi',74.3,'src/images/obi.jpg'),(9,421,'Yoda....','Yoda',22.3,'src/images/yoda.jpg');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'erik','123','reinoso','erik.nrs@gmail.com','erik.nrs'),(9,'name','password','last_name','erik.nrs@gmail.com','nuevousuario');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'disney'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-14  1:50:29
