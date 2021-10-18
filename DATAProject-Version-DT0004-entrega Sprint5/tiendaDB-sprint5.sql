-- MariaDB dump 10.19  Distrib 10.5.12-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: tiendaDB
-- ------------------------------------------------------
-- Server version	10.5.12-MariaDB-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL,
  `passwordc` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `usuarioc` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `clientes_UN` (`cedula`),
  UNIQUE KEY `clientes_UN_pass` (`passwordc`),
  UNIQUE KEY `clientes_UN_user` (`usuarioc`),
  UNIQUE KEY `clientes_UN_name` (`nombre_completo`),
  UNIQUE KEY `clientes_UN_email` (`correo`),
  UNIQUE KEY `clientes_UN_dir` (`direccion`),
  UNIQUE KEY `clientes_UN_tel` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=200002 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (200001,'51666702','mdsg@homemail.com','cll 24 3-42','Maria del Socorro Garavito','maria1','3337866453','maria1');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `n_cuentadecobro` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidadc` varchar(255) NOT NULL,
  `nit` varchar(255) NOT NULL,
  `producto` varchar(255) NOT NULL,
  `razon_social` varchar(255) NOT NULL,
  `v_total` varchar(255) NOT NULL,
  `v_unitario` varchar(255) NOT NULL,
  `fecha_compra` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  PRIMARY KEY (`n_cuentadecobro`)
) ENGINE=InnoDB AUTO_INCREMENT=43000002 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (43000001,'20','34657876-7','Server 100GB','proveedor1 sas','26.908.460','1.345.423','16-07-2021','Activa');
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` varchar(255) NOT NULL,
  `producto` varchar(255) NOT NULL,
  `v_unitario` varchar(255) NOT NULL,
  `razon_social` varchar(255) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `productos_UN` (`producto`),
  UNIQUE KEY `productos_UN_vu` (`v_unitario`)
) ENGINE=InnoDB AUTO_INCREMENT=63000004 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (63000001,'18','Server 100GB','1.345.423','proveedor1 sas');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `nit` varchar(255) NOT NULL,
  `passwordp` varchar(255) NOT NULL,
  `razon_social` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `usuariop` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `proveedores_UN` (`nit`),
  UNIQUE KEY `proveedores_UN_razs` (`razon_social`),
  UNIQUE KEY `proveedores_UN_pass` (`passwordp`),
  UNIQUE KEY `proveedores_UN_user` (`usuariop`),
  UNIQUE KEY `proveedores_UN_email` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=300002 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (300001,'proveedor1@homemail.com','Av. 34 12-03','34657876-7','prov1','proveedor1 sas','3330987654','prov1');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuarios_UN` (`cedula`),
  UNIQUE KEY `usuarios_UN_pass` (`password`),
  UNIQUE KEY `usuarios_UN_user` (`usuario`),
  UNIQUE KEY `usuarios_UN_email` (`correo`),
  UNIQUE KEY `UKc16i7hw3mbewshkla4x9gib6m` (`cedula`,`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (10001,'80794760','lycaon.gaurhoth@gmail.com','Andrés Mauricio Moreno Garavito','admin','admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `n_factura` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidadv` varchar(255) NOT NULL,
  `cedula` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `estadov` varchar(255) NOT NULL,
  `fecha_venta` varchar(255) NOT NULL,
  `impuesto` varchar(255) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL,
  `producto` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `v_totalv` varchar(255) NOT NULL,
  `v_unitario` varchar(255) NOT NULL,
  PRIMARY KEY (`n_factura`)
) ENGINE=InnoDB AUTO_INCREMENT=5200002 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (5200001,'2','51666702','mdsg@homemail.com','cll 24 3-42','Activa','10-10-2021','16%','Maria del Socorro Garavito','Server 100GB','3337866453','3.121.381,36','1.345.423');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tiendaDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-17 19:57:27
