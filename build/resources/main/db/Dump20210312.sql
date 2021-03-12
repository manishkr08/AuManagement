-- MariaDB dump 10.19  Distrib 10.5.9-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: AuManagement
-- ------------------------------------------------------
-- Server version	10.5.9-MariaDB

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
-- Table structure for table `assessment`
--

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment` (
  `assessment_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type_id` int(11) NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  `creator_id` int(11) NOT NULL,
  `max_marks` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `date_modified` datetime NOT NULL,
  PRIMARY KEY (`assessment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
INSERT INTO `assessment` VALUES (1,'Angular',1,'This is angular assessment',1,1,100,1,'2021-03-12 00:00:00'),(2,'React',2,'React assessment description',2,0,50,1,'2021-03-12 00:00:00'),(3,'Java',3,'Java assessment',5,0,150,1,'2021-03-12 00:00:00');
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_latest_version`
--

DROP TABLE IF EXISTS `assessment_latest_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_latest_version` (
  `assessment_id` int(11) NOT NULL,
  `latest_version` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_created` datetime NOT NULL,
  PRIMARY KEY (`assessment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_latest_version`
--

LOCK TABLES `assessment_latest_version` WRITE;
/*!40000 ALTER TABLE `assessment_latest_version` DISABLE KEYS */;
INSERT INTO `assessment_latest_version` VALUES (1,'1','2021-03-12 01:33:41'),(2,'1','2021-03-12 01:35:17'),(3,'1','2021-03-12 01:36:54');
/*!40000 ALTER TABLE `assessment_latest_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_prerequisite_skills`
--

DROP TABLE IF EXISTS `assessment_prerequisite_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_prerequisite_skills` (
  `assessment_id` int(11) NOT NULL,
  `skill_id` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_prerequisite_skills`
--

LOCK TABLES `assessment_prerequisite_skills` WRITE;
/*!40000 ALTER TABLE `assessment_prerequisite_skills` DISABLE KEYS */;
INSERT INTO `assessment_prerequisite_skills` VALUES (1,'6'),(1,'7'),(2,'5'),(2,'7'),(2,'8'),(3,'3');
/*!40000 ALTER TABLE `assessment_prerequisite_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_result`
--

DROP TABLE IF EXISTS `assessment_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_result` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `candidate_id` int(11) NOT NULL,
  `assessment_id` int(11) NOT NULL,
  `marks_obtained` int(11) NOT NULL,
  `feedback` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_result`
--

LOCK TABLES `assessment_result` WRITE;
/*!40000 ALTER TABLE `assessment_result` DISABLE KEYS */;
INSERT INTO `assessment_result` VALUES (1,1,1,11,'it was helpful and made me realized what i am lacking.'),(2,2,1,93,'it was easy.'),(3,3,1,79,'Test was hard.'),(4,4,1,50,'Test was good.'),(5,5,1,95,'Cant understand anything'),(6,6,1,84,'Cant understand anything'),(7,7,1,94,'Cant understand anything'),(8,8,1,75,'it was helpful and made me realized what i am lacking.'),(9,9,1,17,'it was helpful and made me realized what i am lacking.'),(10,10,1,21,'it was helpful and made me realized what i am lacking.'),(11,11,1,21,'it was helpful and made me realized what i am lacking.'),(12,12,1,33,'Test was good.'),(13,13,1,61,'Cant understand anything'),(14,14,1,58,'Test was good.'),(15,15,1,27,'It was super hard.'),(16,16,1,7,'Trainer is really helpful.'),(17,17,1,37,'Cant understand anything'),(18,18,1,57,'Test was good.'),(19,19,1,77,'Test was hard.'),(20,1,2,4,'Trainer is really helpful.'),(21,2,2,18,'Test was hard.'),(22,3,2,16,'It was super hard.'),(23,4,2,45,'Trainer is really helpful.'),(24,5,2,13,'Trainer is really helpful.'),(25,6,2,48,'Trainer is really helpful.'),(26,7,2,40,'Test was good.'),(27,8,2,48,'Test was hard.'),(28,9,2,16,'Test was hard.'),(29,10,2,36,'Test was hard.'),(30,11,2,16,'it was easy.'),(31,12,2,41,'Test was hard.'),(32,13,2,16,'Test was good.'),(33,14,2,43,'it was easy.'),(34,15,2,45,'Trainer is really helpful.'),(35,16,2,41,'it was helpful and made me realized what i am lacking.'),(36,1,3,37,'it was easy.'),(37,2,3,107,'It was super hard.'),(38,3,3,60,'It was super hard.'),(39,4,3,53,'Test was hard.'),(40,5,3,119,'Trainer is really helpful.'),(41,6,3,143,'Cant understand anything'),(42,7,3,20,'Test was good.'),(43,8,3,128,'Cant understand anything'),(44,9,3,38,'It was super hard.'),(45,10,3,115,'Test was hard.'),(46,11,3,120,'It was super hard.'),(47,12,3,81,'Test was hard.'),(48,13,3,16,'it was easy.'),(49,14,3,85,'it was helpful and made me realized what i am lacking.'),(50,15,3,34,'Trainer is really helpful.'),(51,16,3,97,'It was super hard.'),(52,17,3,30,'Test was good.'),(53,18,3,114,'it was easy.'),(54,19,3,15,'it was easy.');
/*!40000 ALTER TABLE `assessment_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_tags`
--

DROP TABLE IF EXISTS `assessment_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_tags` (
  `assessment_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_tags`
--

LOCK TABLES `assessment_tags` WRITE;
/*!40000 ALTER TABLE `assessment_tags` DISABLE KEYS */;
INSERT INTO `assessment_tags` VALUES (1,5),(1,1),(2,6),(2,1),(3,2);
/*!40000 ALTER TABLE `assessment_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_type`
--

DROP TABLE IF EXISTS `assessment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_type`
--

LOCK TABLES `assessment_type` WRITE;
/*!40000 ALTER TABLE `assessment_type` DISABLE KEYS */;
INSERT INTO `assessment_type` VALUES (1,'QUIZ'),(2,'MCQ'),(3,'ASSIGNMENT'),(4,'PROJECT');
/*!40000 ALTER TABLE `assessment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_skills`
--

DROP TABLE IF EXISTS `candidate_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate_skills` (
  `candidate_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_skills`
--

LOCK TABLES `candidate_skills` WRITE;
/*!40000 ALTER TABLE `candidate_skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidate_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `trainer_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Angular',1),(2,'React',3),(3,'Spring Boot',2),(4,'Junit',5),(5,'Java',3),(6,'HTML',4),(7,'CSS',4),(8,'Javascript',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skills` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'Python Basic'),(2,'Python Advance'),(3,'Java Basic'),(4,'Java Advance'),(5,'JavaScript'),(6,'TypeScript'),(7,'HTML'),(8,'CSS');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'Frontend'),(2,'Backend'),(3,'Testing'),(4,'Dev-Ops'),(5,'Angular'),(6,'React'),(7,'JavaScript');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_details`
--

DROP TABLE IF EXISTS `trainer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer_details` (
  `trainer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_details`
--

LOCK TABLES `trainer_details` WRITE;
/*!40000 ALTER TABLE `trainer_details` DISABLE KEYS */;
INSERT INTO `trainer_details` VALUES (1,'Ram','Kapoor'),(2,'Vipul','Kumar'),(3,'Manish','Kumar'),(4,'Vidya','Kumari'),(5,'John','Doe');
/*!40000 ALTER TABLE `trainer_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'Manish','Kumar','manish@gmail.com','pass'),(2,'String','String','string@gmail.com','string'),(3,'Random','User','random@gmail.com','pass'),(4,'Abc','Abc','abc@gmail.com','abcd'),(5,'Rakesh','Unknown','rakesh@gmail.com','pass');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-12 14:34:17
