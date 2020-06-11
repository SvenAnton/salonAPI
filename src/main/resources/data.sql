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
INSERT INTO `schedule` VALUES (94,'juuksur',9,1,'2020-06-12 08:00:00','2020-06-12 14:00:00'),(95,'juuksur',9,1,'2020-06-13 08:00:00','2020-06-13 16:00:00'),(96,'juuksur',9,1,'2020-06-14 07:00:00','2020-06-14 15:00:00');
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
INSERT INTO `service` VALUES (1,'Naiste juukselõikus','Naiste juukselõikus pikk'),(2,'Naiste juukselõikus','Naiste juukselõikus lühike'),(3,'Meeste juukselõikus','Meeste juustelõikus'),(4,'Soengud','Pidulik soeng'),(5,'Juuste värvimine','Juurte värvimine');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service_booking`
--

LOCK TABLES `service_booking` WRITE;
/*!40000 ALTER TABLE `service_booking` DISABLE KEYS */;
INSERT INTO `service_booking` VALUES (70,10,94,NULL,'2020-06-12 08:00:00','2020-06-12 14:00:00',0,59),(71,2,95,NULL,'2020-06-13 10:00:00','2020-06-13 10:20:00',1,60),(72,2,95,NULL,'2020-06-13 10:00:00','2020-06-13 10:40:00',1,63),(73,2,95,NULL,'2020-06-13 08:05:00','2020-06-13 08:45:00',0,63),(74,2,95,NULL,'2020-06-13 13:10:00','2020-06-13 13:50:00',0,63);
/*!40000 ALTER TABLE `service_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES ('Juuste värvimine','värvimise teenused'),('Meeste juukselõikus','seongute tegemina'),('Naiste juukselõikus','naiste juukselõikused'),('Soengud','soengud');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `services_in_schedule`
--

LOCK TABLES `services_in_schedule` WRITE;
/*!40000 ALTER TABLE `services_in_schedule` DISABLE KEYS */;
INSERT INTO `services_in_schedule` VALUES (59,46,94),(60,45,95),(61,45,96),(62,46,96),(63,47,96);
/*!40000 ALTER TABLE `services_in_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kalle','','','',NULL,'Juuksur','https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80','Kogenud juuksur anno 1950'),(2,'Malle','','','',NULL,'Juuksur','https://www.roteesf.com/wp-content/uploads/2019/11/01-9.jpg','Suurepärase stiilitunnetusega ja auhinnatud soengute sättida'),(3,'Oskar','','','',NULL,'Salong','https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80',NULL),(4,'Tiina','','','',NULL,'Salong','https://www.roteesf.com/wp-content/uploads/2019/11/01-9.jpg',NULL),(5,'Peep','','','',NULL,'Juuksur','https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80',NULL),(6,'Kalle','Kusta','kurikalle@mail.com','$2a$10$ouHsm16OXUMuyG5dVot3Cu7iGIBi7KVym7eLbL0GQrQBe2dMXZ59G','55667788','juuksur','https://www.roteesf.com/wp-content/uploads/2019/11/01-9.jpg',NULL),(7,'Peeter','Paan','paan@gmail.com','$2a$10$c5eOAWLfhMsrBHNcn5gB8eKRRid3jcemLs3jwolgBCeWVQoukJr/u','556677','juuksur','https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80',NULL),(8,'Kuri','Malle','malle@gmail.com','$2a$10$P2wWRdSro9OgAM1TGVCnreyNX/HMtKTADF..w1w6y63nkw0dLMzaC','55667778','juuksur','https://www.roteesf.com/wp-content/uploads/2019/11/01-9.jpg',NULL),(9,'juta','jube','juta@jube.ee','$2a$10$L3F55MUw8Oq8jlVuqYx6puw1mpOjRvCPrx70CHM35A/LnNKnALY0C','321321','juuksur','https://images.unsplash.com/photo-1521590832167-7bcbfaa6381f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_service_list`
--

LOCK TABLES `user_service_list` WRITE;
/*!40000 ALTER TABLE `user_service_list` DISABLE KEYS */;
INSERT INTO `user_service_list` VALUES (45,9,2,10,20),(46,9,4,50,60),(47,9,1,30,40);
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

-- Dump completed on 2020-06-11 20:16:24
