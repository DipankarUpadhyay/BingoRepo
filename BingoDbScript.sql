-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.11-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4132
-- Date/time:                    2016-04-12 23:02:07
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for bingo
CREATE DATABASE IF NOT EXISTS `bingo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bingo`;


-- Dumping structure for table bingo.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(40) NOT NULL,
  KEY `FK_user_userdetail` (`id`),
  CONSTRAINT `FK_user_userdetail` FOREIGN KEY (`id`) REFERENCES `userdetail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table bingo.userdetail
CREATE TABLE IF NOT EXISTS `userdetail` (
  `username` varchar(50) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `sex` char(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `telephone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
