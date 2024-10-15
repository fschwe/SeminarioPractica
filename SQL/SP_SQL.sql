DROP DATABASE IF EXISTS `sp_relev`;
CREATE DATABASE  IF NOT EXISTS `sp_relev` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `sp_relev`;

--
-- Estructura `articles`
--

DROP TABLE IF EXISTS `articles`;

CREATE TABLE `articles` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `articles_sku_unique` (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `brands`
--

DROP TABLE IF EXISTS `brands`;

CREATE TABLE `brands` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `brand_has_articles`
--

DROP TABLE IF EXISTS `brand_has_articles`;

CREATE TABLE `brand_has_articles` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `brands_id` bigint(20) unsigned NOT NULL,
  `articles_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `brand_has_articles_brands_id_foreign` (`brands_id`),
  KEY `brand_has_articles_articles_id_foreign` (`articles_id`),
  CONSTRAINT `brand_has_articles_articles_id_foreign` FOREIGN KEY (`articles_id`) REFERENCES `articles` (`id`),
  CONSTRAINT `brand_has_articles_brands_id_foreign` FOREIGN KEY (`brands_id`) REFERENCES `brands` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `sites`
--

DROP TABLE IF EXISTS `sites`;

CREATE TABLE `sites` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sites_number_unique` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '1',
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_username_unique` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `competitors`
--

DROP TABLE IF EXISTS `competitors`;

CREATE TABLE `competitors` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sites_id` bigint(20) unsigned NOT NULL,
  `brands_id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `latitude` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `longitude` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `competitors_sites_id_foreign` (`sites_id`),
  KEY `competitors_brands_id_foreign` (`brands_id`),
  CONSTRAINT `competitors_brands_id_foreign` FOREIGN KEY (`brands_id`) REFERENCES `brands` (`id`),
  CONSTRAINT `competitors_sites_id_foreign` FOREIGN KEY (`sites_id`) REFERENCES `sites` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `surveys`
--

DROP TABLE IF EXISTS `surveys`;

CREATE TABLE `surveys` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `competitors_id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `surveys_competitors_id_foreign` (`competitors_id`),
  KEY `surveys_user_id_foreign` (`user_id`),
  CONSTRAINT `surveys_competitors_id_foreign` FOREIGN KEY (`competitors_id`) REFERENCES `competitors` (`id`),
  CONSTRAINT `surveys_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Estructura `prices`
--

DROP TABLE IF EXISTS `prices`;

CREATE TABLE `prices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `articles_id` bigint(20) unsigned NOT NULL,
  `surveys_id` bigint(20) unsigned NOT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prices_articles_id_foreign` (`articles_id`),
  KEY `prices_surveys_id_foreign` (`surveys_id`),
  CONSTRAINT `prices_articles_id_foreign` FOREIGN KEY (`articles_id`) REFERENCES `articles` (`id`),
  CONSTRAINT `prices_surveys_id_foreign` FOREIGN KEY (`surveys_id`) REFERENCES `surveys` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


--
-- Datos para`articles`
--

INSERT INTO `articles` VALUES 
	(1,'1821','COCA-COLA PET X 500CC'),
    (2,'1079','VILLAVICENCIO AGUA SIN GAS PET X 500CC.'),
    (3,'23601','MEDIALUNA DE MANTECA X UN'),
    (4,'3159','TRIPLE MIGA BLANCO J.COCIDO Y QUESO X 3 UN'),
    (5,'28171','HAMBURGUESA SIMPLE SWIFT'),
    (6,'27385',' EMPANADA DE CARNE X UN'),
    (7,'27174','CAFÉ CON LECHE TAZA');

--
-- Datos para`brands`
--

INSERT INTO `brands` VALUES 
	(1,'YPF','PETROLERA'),
    (2,'MC CAFÉ','CAFETERÍA'),
    (3,'OPEN 25','KIOSCO'),
    (4,'AXION','PETROLERA'),
    (5,'TOSTADO','RESTAURANT'),
    (6,'CAFÉ MARTINEZ','CAFETERÍA'),
    (7,'HAVANNA','CAFETERÍA'),
    (8,'KENTUCKY','RESTAURANT');

--
-- Datos para`brand_has_articles`
--

INSERT INTO `brand_has_articles` VALUES 
	(1,1,1),
    (2,1,2),
    (3,1,3),
    (4,1,4),
    (5,1,5),
    (6,1,6),
    (7,1,7),
    (8,2,1),
    (9,2,2),
    (10,2,3),
    (11,2,4),
    (12,2,7),
    (13,3,1),
    (14,3,2),
    (15,3,4),
    (16,5,1),
    (17,5,2),
    (18,5,4),
    (19,5,5),
    (20,5,6),
    (21,5,7),
    (22,4,1),
    (23,4,2),
    (24,4,3),
    (25,4,4),
    (26,4,5),
    (27,4,6),
    (28,4,7),
    (29,6,1),
    (30,6,2),
    (31,6,3),
    (32,6,4),
    (33,6,7),
    (34,7,1),
	(35,7,2),
    (36,7,3),
    (37,7,4),
    (38,7,7),
    (39,8,1),
    (40,8,2),
    (41,8,4),
    (42,8,5),
    (43,8,6),
    (44,8,7),
    (45,3,1),
    (46,3,2),
    (47,3,3),
    (48,3,7),
    (49,3,4),
    (50,3,5),
    (51,3,6);

--
-- Datos para`sites`
--

INSERT INTO `sites` VALUES 
	(1,'3','RIVER'),
    (2,'29','CABILDO'),
    (3,'31','CENTENARIO'),
    (4,'36','LINCOLN Y NUEVA YORK'),
    (5,'56','OLIVOS'),
    (6,'65','LA PLATA'),
    (7,'66','LA PLATA'),
    (8,'289','LIMA'),
    (9,'584','LOMAS DE ZAMORA'),
    (10,'599','VIRREY DEL PINO'),
    (11,'631','REMEDIOS DE ESCALADA'),
    (12,'1066','SALGUERO'),
    (13,'1068','GIUFRA'),
    (14,'1132','JORGE NEWBERY'),
    (15,'1230','CERRITO'),
    (16,'1291','PILAR NORTE'),
    (17,'1344','LA PLATA'),
    (18,'1389','CHASCOMUS'),
    (19,'1401','SARANDI'),
    (20,'1425','ITUZAINGO'),
    (21,'1426','CIUDADELA'),
    (22,'1428','URQUIZA'),
    (23,'1438','ACCESO NORTE RAMAL TIGRE -A TIGRE'),
    (24,'1439','ACCESO NORTE RAMAL TIGRE -DE TIGRE'),
    (25,'1450','INTERMEDANOS'),
    (26,'1469','ILLIA'),
    (27,'1478','LELOIR'),
    (28,'1482','MAZA'),
    (29,'1506','GRAL PAZ - NORTE'),
    (30,'1507','GRAL PAZ - SUR'),
    (31,'1539','24 DE NOVIEMBRE'),
    (32,'1553','CDRO RIVADAVIA'),
    (33,'1584','ARROYO SARANDI'),
    (34,'1682','LAS ARMAS'),
    (35,'1695','DIAZ VELEZ'),
    (36,'1716','AUT EZEIZA-CAÑUELAS - MANO CAÑUELAS'),
    (37,'1717','AUT EZEIZA-CAÑUELAS - MANO EZEIZA'),
    (38,'1735','AUT BSAS-LA PLATA - A LA PLATA'),
    (39,'1736','AUT BSAS-LA PLATA - A BS AS'),
    (40,'1775','PLAZA ESPAÑA'),
    (41,'1956','DELLEPIANE NORTE');

--
-- Datos para`users`
--

INSERT INTO `users` VALUES 
	(1,'User','Survey','otheruser@gmail.com','99999997','1','password'),
    (2,'User2','Survey','otheruser@gmail.com','99999996','1','password'),
    (3,'User3','Survey','otheruser@gmail.com','99999995','1','password'),
    (4,'John','Doe','johndeo@gmail.com','98764528','1','admin');

--
-- Datos para`competitors`
--

INSERT INTO `competitors` VALUES 
	(1,1,1,'YPF','TBD',NULL,NULL),
    (2,1,2,'MC CAFÉ','TBD',NULL,NULL),
    (3,2,3,'OPEN 25','TBD',NULL,NULL),
    (4,2,1,'YPF','TBD',NULL,NULL),
    (5,3,1,'YPF','TBD',NULL,NULL),
    (6,3,4,'AXION','TBD',NULL,NULL),
    (7,3,3,'OPEN 25','TBD',NULL,NULL),
    (8,5,4,'AXION','TBD',NULL,NULL),
    (9,5,1,'YPF','TBD',NULL,NULL),
    (10,5,5,'TOSTADO','TBD',NULL,NULL),
    (11,8,6,'CAFÉ MARTINEZ','TBD',NULL,NULL),
    (12,8,7,'HAVANNA','TBD',NULL,NULL),
    (13,8,3,'OPEN 25','TBD',NULL,NULL),
    (14,10,6,'CAFÉ MARTINEZ','TBD',NULL,NULL),
    (15,10,8,'KENTUCKY','TBD',NULL,NULL),
    (16,10,7,'HAVANNA','TBD',NULL,NULL),
    (17,13,8,'KENTUCKY','TBD',NULL,NULL),
    (18,13,7,'HAVANNA','TBD',NULL,NULL),
    (19,15,7,'HAVANNA','TBD',NULL,NULL),
    (20,15,3,'OPEN 25','TBD',NULL,NULL),
    (21,17,1,'YPF','TBD',NULL,NULL),
    (22,25,4,'AXION','TBD',NULL,NULL),
    (23,25,7,'HAVANNA','TBD',NULL,NULL),
    (24,25,1,'YPF','TBD',NULL,NULL),
    (25,27,4,'AXION','TBD',NULL,NULL),
    (26,27,6,'CAFÉ MARTINEZ','TBD',NULL,NULL),
    (27,32,5,'TOSTADO','TBD',NULL,NULL);

--
-- Datos para`surveys`
--

INSERT INTO `surveys` VALUES 
	(1,1,1,'2024-08-01 00:00:00'),
    (2,1,1,'2024-08-04 00:00:00'),
    (3,2,2,'2024-08-07 00:00:00'),
    (4,3,3,'2024-08-03 00:00:00'),
    (5,2,2,'2024-08-08 00:00:00'),
    (6,4,3,'2024-08-11 00:00:00'),
    (7,5,2,'2024-08-14 00:00:00');

--
-- Datos para`prices`
--

INSERT INTO `prices` VALUES 
	(1,2,1,30.00),
    (2,3,1,40.00),
    (3,4,1,534.00),
    (4,5,1,490.00),
    (5,1,1,447.00),
    (6,2,1,905.00),
    (7,3,1,489.00),
    (8,6,1,929.00),
    (9,5,1,399.00),
    (10,4,1,682.00),
	(11,2,2,888.00),
    (12,3,2,911.00),
    (13,6,2,708.00),
    (14,1,2,317.00),
    (15,7,2,903.00),
    (16,2,2,840.00),
    (17,3,2,70.00),
    (18,4,2,244.00),
    (19,2,2,182.00),
    (20,5,2,2.00),
    (21,2,3,234.00),
    (22,1,3,987.00),
    (23,6,3,530.00),
    (24,7,3,573.00),
	(25,3,4,495.00),
    (26,6,4,851.00),
    (27,3,4,752.00),
    (28,5,5,144.00),
    (29,3,5,735.00),
    (30,5,5,176.00),
    (31,3,5,689.00),
    (32,5,6,674.00),
    (33,4,6,323.00),
    (34,7,7,219.00),
    (35,3,7,986.00);

  
