CREATE DATABASE  IF NOT EXISTS `quanlynhancong` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlynhancong`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlynhancong
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
-- Table structure for table `dauviec`
--

DROP TABLE IF EXISTS `dauviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dauviec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  `moTa` text,
  `thoiHan` date DEFAULT NULL,
  `maDV` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `maDV` (`maDV`)
) ENGINE=InnoDB AUTO_INCREMENT=253335356 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dauviec`
--

LOCK TABLES `dauviec` WRITE;
/*!40000 ALTER TABLE `dauviec` DISABLE KEYS */;
INSERT INTO `dauviec` VALUES (1,'Phát triển phần mềm nhận diện khuôn mặt','Phát triển phần mềm nhận diện khuôn mặt cho trường PTIT','2024-04-27','DV123'),(2,'Làm đường Giải Phóng','Làm đường Giải Phóng chuẩn bị ngày 30/04 và 01/05','2024-04-29','DV228'),(3,'Phát triển ứng dụng di động','Xây dựng ứng dụng di động cho hệ điều hành Android và iOS.','2024-06-30','DV011'),(4,'Tối ưu hóa cơ sở dữ liệu','Tối ưu hóa cấu trúc cơ sở dữ liệu để tăng hiệu suất và sức chứa.','2024-05-15','DV012'),(5,'Thiết kế giao diện người dùng','Thiết kế giao diện người dùng đẹp mắt và dễ sử dụng cho ứng dụng.','2024-06-25','DV013'),(6,'Phân tích yêu cầu','Phân tích và hiểu rõ yêu cầu của khách hàng để xây dựng sản phẩm phù hợp.','2024-05-10','DV014'),(7,'Triển khai hệ thống','Triển khai và cấu hình hệ thống trên môi trường sản xuất.','2024-07-20','DV015'),(8,'Kiểm thử và sửa lỗi','Kiểm thử ứng dụng và sửa lỗi để đảm bảo tính ổn định và chất lượng.','2024-07-05','DV016'),(9,'Tối ưu hóa hiệu suất','Tối ưu hóa hiệu suất ứng dụng để tăng tốc độ và tối thiểu hóa tài nguyên.','2024-08-15','DV017'),(10,'Phát triển tính năng mới','Phát triển và triển khai các tính năng mới theo yêu cầu của khách hàng.','2024-09-30','DV018'),(11,'Quản lý dự án','Quản lý dự án, phân chia công việc, theo dõi tiến độ và ngân sách.','2024-12-31','DV019'),(12,'Hỗ trợ kỹ thuật','Hỗ trợ kỹ thuật cho người dùng và giải quyết các vấn đề kỹ thuật.','2024-12-31','DV020'),(22,'Đầu việc B','Lắp đặt hệ thống điện cho tòa nhà cao tầng','2024-04-17','DV002'),(23,'Đầu việc C','Thi công hệ thống cấp thoát nước cho khu dân cư','2024-04-18','DV003'),(24,'Đầu việc D','Xây dựng kết cấu thép cho nhà xưởng sản xuất','2024-04-19','DV004'),(25,'Đầu việc E','Thi công lắp đặt hệ thống mạng cho văn phòng PTIT','2024-04-20','DV005'),(26,'Tên đầu việc 6','Mô tả đầu việc 6','2024-04-21','DV006'),(27,'Tên đầu việc 7','Mô tả đầu việc 7','2024-04-22','DV007');
/*!40000 ALTER TABLE `dauviec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhancong`
--

DROP TABLE IF EXISTS `nhancong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhancong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  `ngaySinh` date DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `maNC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `maNC` (`maNC`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhancong`
--

LOCK TABLES `nhancong` WRITE;
/*!40000 ALTER TABLE `nhancong` DISABLE KEYS */;
INSERT INTO `nhancong` VALUES (49,'Nguyễn Văn A','1990-05-15','123 Đường ABC, Quận Ba Đình, Hà Nội','nguyenvana@example.com','NC001'),(50,'Trần Thị B','1995-08-20','456 Đường XYZ, Quận Hoàn Kiếm, Hà Nội','tranthib@example.com','NC002'),(51,'Lê Văn C','1988-12-10','789 Đường KLM, Quận Hai Bà Trưng, Hà Nội','levanc@example.com','NC003'),(52,'Phạm Thị D','1992-04-25','101 Đường UVW, Quận Tây Hồ, Hà Nội','phamthid@example.com','NC004'),(53,'Hoàng Văn E','1985-09-08','234 Đường GHI, Quận Cầu Giấy, Hà Nội','hoangvane@example.com','NC005'),(54,'Nguyễn Thị F','1993-07-18','567 Đường LMN, Quận Đống Đa, Hà Nội','nguyenthif@example.com','NC006'),(55,'Trần Văn G','1989-02-14','890 Đường RST, Quận Thanh Xuân, Hà Nội','tranvang@example.com','NC007'),(56,'Lê Thị H','1998-11-30','112 Đường OPQ, Quận Hoàng Mai, Hà Nội','lethih@example.com','NC008'),(57,'Phan Văn I','1991-03-22','345 Đường DEF, Quận Long Biên, Hà Nội','phanvani@example.com','NC009'),(58,'Hoàng Thị K','1987-06-05','678 Đường STU, Quận Hà Đông, Hà Nội','hoangthik@example.com','NC010'),(59,'Đỗ Văn L','1994-09-28','901 Đường JKL, Quận Bắc Từ Liêm, Hà Nội','dovanl@example.com','NC011');
/*!40000 ALTER TABLE `nhancong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhancongdauviec`
--

DROP TABLE IF EXISTS `nhancongdauviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhancongdauviec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idNhanCong` int DEFAULT NULL,
  `idDauViec` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idNhanCong` (`idNhanCong`),
  KEY `idDauViec` (`idDauViec`),
  CONSTRAINT `nhancongdauviec_ibfk_1` FOREIGN KEY (`idNhanCong`) REFERENCES `nhancong` (`id`),
  CONSTRAINT `nhancongdauviec_ibfk_3` FOREIGN KEY (`idDauViec`) REFERENCES `dauviec` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhancongdauviec`
--

LOCK TABLES `nhancongdauviec` WRITE;
/*!40000 ALTER TABLE `nhancongdauviec` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhancongdauviec` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-23 10:41:46
