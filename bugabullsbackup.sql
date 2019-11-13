-- MySQL dump 10.16  Distrib 10.1.8-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: bugabulls
-- ------------------------------------------------------
-- Server version	10.1.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acudiente`
--

DROP TABLE IF EXISTS `acudiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acudiente` (
  `codigoacudiente` int(11) NOT NULL,
  `dniacudiente` bigint(20) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `parentesco` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`codigoacudiente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acudiente`
--

LOCK TABLES `acudiente` WRITE;
/*!40000 ALTER TABLE `acudiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `acudiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `codigoadministrador` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contraseña` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dniadministrador` bigint(20) DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `estadoeliminar` int(1) DEFAULT '0',
  `estadocontra` int(1) DEFAULT '0',
  PRIMARY KEY (`codigoadministrador`),
  KEY `dniadministrador` (`dniadministrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (90000,'Desarrollador','TSL','45c48cce2e2d7fbdea1afc51c7c6ad26',9,'9',9,0,0);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `codigocategoria` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horario` time DEFAULT NULL,
  `codigoentrenador` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigocategoria`),
  KEY `FK_categoria_entrenador` (`codigoentrenador`),
  CONSTRAINT `FK_categoria_entrenador` FOREIGN KEY (`codigoentrenador`) REFERENCES `entrenador` (`codigoentrenador`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Pre Benjamines','00:00:00',NULL),(2,'Benjamines','00:00:00',NULL),(3,'Minis','00:00:00',NULL),(4,'Infantiles','00:00:00',NULL),(5,'Junior','00:00:00',NULL);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrenador` (
  `codigoentrenador` int(11) NOT NULL,
  `dnientrenador` bigint(20) DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contraseña` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estadoeliminar` int(1) DEFAULT '0',
  `estadocontra` int(1) DEFAULT '0',
  PRIMARY KEY (`codigoentrenador`),
  KEY `dnientrenador` (`dnientrenador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `codigoevento` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudad` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `gastos` double DEFAULT NULL,
  `fechaini` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL,
  `cantidadjugadores` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoevento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugador` (
  `codigojugador` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `eps` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL,
  `contraseña` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dnijugador` bigint(20) DEFAULT NULL,
  `codigocategoria` int(11) DEFAULT NULL,
  `codigoacudiente` int(11) DEFAULT NULL,
  `fechacobro` date DEFAULT NULL,
  `estadoeliminar` int(1) DEFAULT '0',
  `estadocontra` int(1) DEFAULT '0',
  PRIMARY KEY (`codigojugador`),
  KEY `FK_jugador_categoria` (`codigocategoria`),
  KEY `FK_jugador_acudiente` (`codigoacudiente`),
  KEY `dnijugador` (`dnijugador`),
  CONSTRAINT `FK_jugador_acudiente` FOREIGN KEY (`codigoacudiente`) REFERENCES `acudiente` (`codigoacudiente`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `FK_jugador_categoria` FOREIGN KEY (`codigocategoria`) REFERENCES `categoria` (`codigocategoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador_evento`
--

DROP TABLE IF EXISTS `jugador_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugador_evento` (
  `codigojugador` int(11) DEFAULT NULL,
  `codigoevento` int(11) DEFAULT NULL,
  KEY `FK__jugador` (`codigojugador`),
  KEY `FK__evento` (`codigoevento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador_evento`
--

LOCK TABLES `jugador_evento` WRITE;
/*!40000 ALTER TABLE `jugador_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `jugador_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `codigopago` int(11) NOT NULL,
  `fechapago` date DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `codigojugador` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigopago`),
  KEY `FK_pago_jugador` (`codigojugador`),
  CONSTRAINT `FK_pago_jugador` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantilla`
--

DROP TABLE IF EXISTS `plantilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plantilla` (
  `numeroplantilla` int(11) NOT NULL,
  `codigojugador` int(11) DEFAULT NULL,
  `imc` double DEFAULT NULL,
  `posicion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `observacion` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tiemposuicidio` double DEFAULT NULL,
  `porcentajecestas` double DEFAULT NULL,
  `vueltascancha` int(11) DEFAULT NULL,
  PRIMARY KEY (`numeroplantilla`),
  KEY `FK_plantilla_jugador` (`codigojugador`),
  CONSTRAINT `FK_plantilla_jugador` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantilla`
--

LOCK TABLES `plantilla` WRITE;
/*!40000 ALTER TABLE `plantilla` DISABLE KEYS */;
/*!40000 ALTER TABLE `plantilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesion`
--

DROP TABLE IF EXISTS `sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesion` (
  `numerosesion` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `especificacion` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigoentrenador` int(11) DEFAULT NULL,
  PRIMARY KEY (`numerosesion`),
  KEY `FK_sesion_entrenador` (`codigoentrenador`),
  CONSTRAINT `FK_sesion_entrenador` FOREIGN KEY (`codigoentrenador`) REFERENCES `entrenador` (`codigoentrenador`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesion_categoria`
--

DROP TABLE IF EXISTS `sesion_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesion_categoria` (
  `numerosesion` int(11) NOT NULL,
  `codigocategoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`numerosesion`),
  KEY `FK_sesion_categoria_categoria` (`codigocategoria`),
  CONSTRAINT `FK_sesion_categoria_categoria` FOREIGN KEY (`codigocategoria`) REFERENCES `categoria` (`codigocategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_sesion_categoria_sesion` FOREIGN KEY (`numerosesion`) REFERENCES `sesion` (`numerosesion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion_categoria`
--

LOCK TABLES `sesion_categoria` WRITE;
/*!40000 ALTER TABLE `sesion_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesion_categoria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-22  8:43:48
