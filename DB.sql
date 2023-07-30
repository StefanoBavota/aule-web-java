-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aule-web
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `asset_room`
--

DROP TABLE IF EXISTS `asset_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asset_room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asset_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkmg1kq8el0ahji526sycw8w7h` (`asset_id`),
  KEY `FKhn8l22ogx65goha4aimsue1kv` (`room_id`),
  CONSTRAINT `FKhn8l22ogx65goha4aimsue1kv` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `FKkmg1kq8el0ahji526sycw8w7h` FOREIGN KEY (`asset_id`) REFERENCES `assets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_room`
--

LOCK TABLES `asset_room` WRITE;
/*!40000 ALTER TABLE `asset_room` DISABLE KEYS */;
INSERT INTO `asset_room` VALUES (1,1,11);
/*!40000 ALTER TABLE `asset_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets`
--

DROP TABLE IF EXISTS `assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets`
--

LOCK TABLES `assets` WRITE;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
INSERT INTO `assets` VALUES (1,'proiettore'),(2,'schermo motorizzato'),(3,'schermo manuale'),(4,'imp.audio'),(5,'pc fisso'),(6,'mic.a filo'),(7,'mic. senza filo'),(8,'lavagna luminosa'),(9,'visual presenter'),(10,'imp. elettrico'),(11,'allestimento'),(12,'lavagna');
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_event`
--

DROP TABLE IF EXISTS `course_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeabnkbeptwp45dtvg0y2x4nd3` (`course_id`),
  KEY `FK1bbb1j8w9ulpsohs1my0jdjbj` (`event_id`),
  CONSTRAINT `FK1bbb1j8w9ulpsohs1my0jdjbj` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  CONSTRAINT `FKeabnkbeptwp45dtvg0y2x4nd3` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_event`
--

LOCK TABLES `course_event` WRITE;
/*!40000 ALTER TABLE `course_event` DISABLE KEYS */;
INSERT INTO `course_event` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10);
/*!40000 ALTER TABLE `course_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Advanced database system (basi di dati II)'),(2,'Advanced probability'),(3,'Web engineering'),(4,'Sviluppo web avanzato'),(5,'Analisi 1'),(6,'Ricerca Operativa'),(7,'Fisica'),(8,'Basi di dati laboratorio'),(9,'Fondamenti di programmazione'),(10,'CPU'),(11,'Seminario CyberSecurity'),(12,'Seminario Ingegneria del software'),(13,'Seminario sensibilizzazione igiene personale'),(14,'Matematica Discreta 1 e 2'),(15,'Teoria della calcolabilità e della complessità'),(16,'Web engineering'),(17,'Inglese B2'),(18,'Ottimizzazione combinatoria'),(19,'Laboratorio di algoritmica avanzata');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_time` time(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` time(6) DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  `supervisor_id` bigint DEFAULT NULL,
  `typology_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi4qc07gqilyboc4ueat9mtkn1` (`room_id`),
  KEY `FK9y6cg48fwu0b5gqsnis471k7a` (`supervisor_id`),
  KEY `FKr72b39xqidikc9ikmw9jfvbfl` (`typology_id`),
  CONSTRAINT `FK55v6kmb6lp5eeymlbtufcre7h` FOREIGN KEY (`typology_id`) REFERENCES `typologies` (`id`),
  CONSTRAINT `FK9y6cg48fwu0b5gqsnis471k7a` FOREIGN KEY (`supervisor_id`) REFERENCES `supervisors` (`id`),
  CONSTRAINT `FKi4qc07gqilyboc4ueat9mtkn1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'2023-07-04','Esame Basi di dati laboratorio','16:30:00.000000','E001','14:30:00.000000',5,3,2),(2,'2023-07-05','Esame Basi di dati laboratorio','16:30:00.000000','E002','14:30:00.000000',5,3,2),(3,'2023-07-20','Esame laboratorio di algoritmica avanzata','10:30:00.000000','E004','08:30:00.000000',10,3,2),(4,'2023-07-25','Esame Web engineering','18:30:00.000000','E005','18:00:00.000000',5,2,2),(5,'2023-06-27','Seminario CyberSecurity','13:30:00.000000','S009','10:00:00.000000',8,1,4),(6,'2023-07-31','Seminario sensibilizzazione igiene personale','18:30:00.000000','S014','18:00:00.000000',11,2,3),(7,'2023-08-02','Seminario ingegneria del software','10:30:00.000000','I2I007','09:00:00.000000',4,2,4),(8,'2023-08-02','Esame Parziale Matematica discreta 1 e 2','12:30:00.000000','E013','10:00:00.000000',8,2,4),(9,'2023-08-03','Esame Ottimizzazione combinatoria','13:30:00.000000','E016','10:00:00.000000',16,2,2),(10,'2023-08-04','Lezione Analisi','17:30:00.000000','L010','14:30:00.000000',8,1,3);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `building` varchar(255) DEFAULT NULL,
  `floor` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Alan Touring (Coppito 0)','terra','Coppito'),(2,'Alan Touring (Coppito 0)','primo','Coppito'),(3,'Coppito 1','terra','Coppito'),(4,'Coppito 1','primo','Coppito'),(5,'Coppito 1','secondo','Coppito'),(6,'Coppito 2','terra','Coppito'),(7,'Coppito 2','primo','Coppito'),(8,'Coppito 2','secondo','Coppito'),(9,'11 A','terra','Coppito'),(10,'11 A','primo','Coppito'),(11,'11 A','secondo','Coppito'),(12,'11 A','terzo','Coppito'),(13,'11 B','terra','Coppito'),(14,'11 B','primo','Coppito'),(15,'11 B','secondo','Coppito'),(16,'Blocco Pontieri','terra','Roio'),(17,'Blocco Pontieri','primo','Roio'),(18,'Blocco Pontieri','secondo','Roio'),(19,'Blocco Pontieri','terzo','Roio'),(20,'Rettorato','terra','L\'Aquila Centro'),(21,'Rettorato','primo','L\'Aquila Centro'),(22,'Rettorato','sacondo','L\'Aquila Centro');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_groups`
--

DROP TABLE IF EXISTS `my_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_groups`
--

LOCK TABLES `my_groups` WRITE;
/*!40000 ALTER TABLE `my_groups` DISABLE KEYS */;
INSERT INTO `my_groups` VALUES (1,'Dipartimento di Ingegneria e Scienze dell\'Informazione e Matematica','https://aule.univaq.it/images_structures/diceaa.png','DISIM'),(2,'Aule senza dipartimento','https://aule.univaq.it/images_structures/diceaa.png','ATENEO'),(3,'Centro linguistico di ateneo','https://aule.univaq.it/images_structures/diceaa.png','CLA'),(4,'Polo laboratoriale didattico biologico-chimico','https://aule.univaq.it/images_structures/diceaa.png','COSBE'),(5,'Dipartimento Ingegneria civile edile-architettura-ambiente','https://aule.univaq.it/images_structures/diceaa.png','DICEAA'),(6,'Dipartimento di ingegneria industriale e dell\'informazione e di economia','https://aule.univaq.it/images_structures/diceaa.png','DIIIE aule Roio'),(7,'Dipartimento di ingegneria industriale e dell\'informazione e di economia','https://aule.univaq.it/images_structures/diceaa.png','DIIIE aule Acquasanta'),(8,'Dipartimento scienze chimiche applicate e biotecnologiche','https://aule.univaq.it/images_structures/diceaa.png','DISCAB'),(9,'Dipartimento di scienze fisiche e chimiche','https://aule.univaq.it/images_structures/diceaa.png','DSFC'),(10,'Dipartimento di scienze umane','https://aule.univaq.it/images_structures/diceaa.png','DSU'),(11,'Medicina clinica sanità pubblica scienze della vita e dell\'ambiente','https://aule.univaq.it/images_structures/diceaa.png','MESVA'),(12,'Centro di miscroscopia','https://aule.univaq.it/images_structures/diceaa.png','MICROSCOPIA');
/*!40000 ALTER TABLE `my_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `electrical_outlets` int DEFAULT NULL,
  `ethernet_ports` int DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `group_id` bigint DEFAULT NULL,
  `location_id` bigint DEFAULT NULL,
  `supervisor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK63x2nmd4esdnjrmlnxosq5of9` (`group_id`),
  KEY `FKn44nnd0bt5f0gwkdtw5ub1esg` (`location_id`),
  KEY `FK59197vn8qawqh7yjg8jc3ouyc` (`supervisor_id`),
  CONSTRAINT `FK59197vn8qawqh7yjg8jc3ouyc` FOREIGN KEY (`supervisor_id`) REFERENCES `supervisors` (`id`),
  CONSTRAINT `FK63x2nmd4esdnjrmlnxosq5of9` FOREIGN KEY (`group_id`) REFERENCES `my_groups` (`id`),
  CONSTRAINT `FKn44nnd0bt5f0gwkdtw5ub1esg` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','C1.16',1,6,3),(2,12,'i ragazzi tendono a perdersi',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','0.6',1,3,3),(3,24,'',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','1.1',1,4,3),(4,100,'',4,5,'https://material.angular.io/assets/img/examples/shiba1.jpg','1.7 (Aula biancofiore]',1,4,3),(5,100,'',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','2.5',1,5,3),(6,100,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','Aula Rossa',1,4,3),(7,80,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','C1.9',1,6,3),(8,126,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','C1.10',1,6,3),(9,46,'',4,3,'https://material.angular.io/assets/img/examples/shiba1.jpg','A0.4',1,1,3),(10,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.1',1,2,3),(11,46,'tenda della finestra rotta',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.2',1,2,3),(12,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.3',1,2,3),(13,46,'tenda della finestra rotta',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.4',1,2,3),(14,46,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.5',1,2,3),(15,100,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.6',1,2,3),(16,100,'infestazione di formiche all\'ingresso',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','A1.7',1,2,3),(17,20,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','Digital Class',1,1,3),(18,40,'',4,1,'https://material.angular.io/assets/img/examples/shiba1.jpg','B1.1',3,16,2),(19,25,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','B1.2',3,17,1),(20,100,'',4,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','F1.1',4,18,1),(21,25,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','F1.2',4,19,1),(22,75,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','D1.1',8,20,2),(23,50,'',5,2,'https://material.angular.io/assets/img/examples/shiba1.jpg','D1.2',8,21,3);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisors`
--

DROP TABLE IF EXISTS `supervisors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supervisors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisors`
--

LOCK TABLES `supervisors` WRITE;
/*!40000 ALTER TABLE `supervisors` DISABLE KEYS */;
INSERT INTO `supervisors` VALUES (1,'lorenzo.bosica1@student.univaq.it','Lorenzo'),(2,'stefano.bavota@student.univaq.it','Stefano'),(3,'denis.ciammaricone@student.univaq.it','Denis');
/*!40000 ALTER TABLE `supervisors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typologies`
--

DROP TABLE IF EXISTS `typologies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typologies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typologies`
--

LOCK TABLES `typologies` WRITE;
/*!40000 ALTER TABLE `typologies` DISABLE KEYS */;
INSERT INTO `typologies` VALUES (1,'seminario'),(2,'riunione'),(3,'lauree'),(4,'lezione'),(5,'esame'),(6,'parziale'),(7,'altro');
/*!40000 ALTER TABLE `typologies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `email_verified_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-30 21:40:28
