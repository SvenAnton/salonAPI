-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: booking_initial
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'EE','Tallinn','Uus','13'),(2,'EE','Tartu','Raekoja','22'),(3,'EE','Tallinn','Viru','8'),(4,'EE','Tallinn','Viru','22'),(5,'LV','Riga','Iela','111'),(6,'EE','Tallinn','Nisu','20');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'juuksur',1,1,'2020-06-10 10:00:00','2020-06-10 17:00:00'),(7,'juuksur',2,2,'2020-06-10 09:00:00','2020-06-10 17:00:00'),(13,'juuksur',1,1,'2020-06-11 11:00:00','2020-06-11 18:00:00'),(21,'juuksur',2,2,'2020-06-11 09:00:00','2020-06-11 17:00:00'),(22,'juuksur',2,1,'2020-06-20 09:00:00','2020-06-20 17:00:00');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `schedule_type`
--

LOCK TABLES `schedule_type` WRITE;
/*!40000 ALTER TABLE `schedule_type` DISABLE KEYS */;
INSERT INTO `schedule_type` VALUES ('juuksur','juuksuri töögraafik'),('salong','salongi graafiks');
/*!40000 ALTER TABLE `schedule_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'naiste lõikus','naiste juukselõikus pikk'),(2,'naiste lõikus','naiste juukselõikus lühike'),(3,'mehed','meeste juukselõikus'),(4,'soeng','peo soeng'),(5,'värv','triibutamine');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service_booking`
--

LOCK TABLES `service_booking` WRITE;
/*!40000 ALTER TABLE `service_booking` DISABLE KEYS */;
INSERT INTO `service_booking` VALUES (5,1,7,NULL,'2020-06-10 12:00:00','2020-06-10 12:45:00',0,3),(6,2,7,'l6ikan','2020-06-10 14:00:00','2020-06-10 14:45:00',0,3),(7,2,22,'normal','2020-06-20 14:00:00','2020-06-20 14:45:00',0,3),(9,5,13,NULL,'2020-06-11 12:00:00','2020-06-11 13:15:00',0,1),(10,5,13,NULL,'2020-06-11 12:00:00','2020-06-11 13:15:00',0,1),(11,5,13,NULL,'2020-06-11 12:00:00','2020-06-11 13:15:00',0,1),(12,10,13,NULL,'2020-06-11 12:00:00','2020-06-11 13:15:00',0,1),(26,2,13,NULL,'2020-06-11 11:00:00','2020-06-11 12:00:00',0,2),(27,2,21,NULL,'2020-06-11 09:30:00','2020-06-11 10:40:00',0,6),(28,2,1,NULL,'2020-06-10 12:30:00','2020-06-10 14:30:00',0,4),(29,2,1,NULL,'2020-06-10 10:00:00','2020-06-10 11:15:00',0,1);
/*!40000 ALTER TABLE `service_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES ('mehed','seongute tegemina'),('naiste lõikus','naiste juukselõikused'),('soeng','soengud'),('värv','värvimise teenused');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `services_in_schedule`
--

LOCK TABLES `services_in_schedule` WRITE;
/*!40000 ALTER TABLE `services_in_schedule` DISABLE KEYS */;
INSERT INTO `services_in_schedule` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,7),(7,7,7),(8,8,7),(9,9,7),(10,10,7),(11,1,13),(12,2,13),(13,3,13),(14,4,13),(15,5,13),(16,6,21),(17,7,21),(18,8,21),(19,9,21),(20,10,21);
/*!40000 ALTER TABLE `services_in_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kalle','','','',NULL,'Juuksur','https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80','Kogenud juuksur anno 1950'),(2,'Malle','','','',NULL,'Juuksur','https://www.roteesf.com/wp-content/uploads/2019/11/01-9.jpg','Suurepärase stiilitunnetusega ja auhinnatud soengute sättida'),(3,'Oskar','','','',NULL,'Salong',NULL,NULL),(4,'Tiina','','','',NULL,'Salong',NULL,NULL),(5,'Peep','','','',NULL,'Juuksur',NULL,NULL),(6,'Kalle','Kusta','kurikalle@mail.com','$2a$10$ouHsm16OXUMuyG5dVot3Cu7iGIBi7KVym7eLbL0GQrQBe2dMXZ59G','55667788','juuksur',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_service_list`
--

LOCK TABLES `user_service_list` WRITE;
/*!40000 ALTER TABLE `user_service_list` DISABLE KEYS */;
INSERT INTO `user_service_list` VALUES (1,1,1,15,75),(2,1,2,10,60),(3,1,3,10,60),(4,1,4,40,120),(5,1,5,50,180),(6,2,1,20,70),(7,2,2,10,60),(8,2,3,15,45),(9,2,4,30,120),(10,2,5,40,180),(11,3,1,25,75),(12,3,2,10,60),(13,3,4,50,100),(14,3,5,60,150),(15,4,3,10,45),(16,5,1,20,60),(17,5,2,10,60),(18,5,3,20,60);
/*!40000 ALTER TABLE `user_service_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES ('Juuksur','lõikab juukseid'),('Salong','rendib ruume');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workplace`
--

LOCK TABLES `workplace` WRITE;
/*!40000 ALTER TABLE `workplace` DISABLE KEYS */;
INSERT INTO `workplace` VALUES (1,'Megajuuksur koht 1',1,3),(2,'Megajuuksur koht 2',1,3),(3,'Oskari salong',2,3),(4,'Tiina salong Tallinn',4,4),(5,'Tiina salong Tartu',3,4),(6,'Tiina salong Tallinn',4,4);
/*!40000 ALTER TABLE `workplace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `workplace_booking`
--

LOCK TABLES `workplace_booking` WRITE;
/*!40000 ALTER TABLE `workplace_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `workplace_booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-09 22:30:25
