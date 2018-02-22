-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.15-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных library
CREATE DATABASE IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

-- Дамп структуры для таблица library.book
CREATE TABLE IF NOT EXISTS `book` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Publish_Year` int(11) DEFAULT NULL,
  `Author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.book: ~8 rows (приблизительно)
DELETE FROM `book`;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`ID`, `Name`, `Publish_Year`, `Author`) VALUES
	(5, 'Fahrenheit 451', 2000, 'Author4'),
	(6, 'The Outsiders', 1987, 'Author5'),
	(7, 'Animal Farm', 2005, 'Author1'),
	(9, 'Night', 1980, 'Author3'),
	(10, 'The Rain', 2005, 'Author3'),
	(11, 'The Sea', 2012, 'Author10'),
	(12, 'The Sea', 2012, 'Author10'),
	(13, 'The Sea', 2012, 'Author10');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Дамп структуры для таблица library.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Date_of_Birth` date NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.employee: ~4 rows (приблизительно)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`ID`, `Name`, `Date_of_Birth`, `Email`) VALUES
	(1, 'Petrov', '1980-12-25', 'EmailPetrov'),
	(2, 'Ivanov', '1995-07-12', 'EmailIvanov'),
	(3, 'Vasiliev', '1989-03-10', 'EmailVasiliev'),
	(4, 'Aksenov', '1991-05-01', 'EmailAksenov');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Дамп структуры для таблица library.employee_book
CREATE TABLE IF NOT EXISTS `employee_book` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Book` int(11) NOT NULL,
  `Id_Employee` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `employee_book_ibfk_1` (`Id_Book`),
  KEY `employee_book_ibfk_2` (`Id_Employee`),
  CONSTRAINT `employee_book_ibfk_1` FOREIGN KEY (`Id_Book`) REFERENCES `book` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employee_book_ibfk_2` FOREIGN KEY (`Id_Employee`) REFERENCES `employee` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.employee_book: ~0 rows (приблизительно)
DELETE FROM `employee_book`;
/*!40000 ALTER TABLE `employee_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_book` ENABLE KEYS */;

-- Дамп структуры для таблица library.userinf
CREATE TABLE IF NOT EXISTS `userinf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.userinf: ~8 rows (приблизительно)
DELETE FROM `userinf`;
/*!40000 ALTER TABLE `userinf` DISABLE KEYS */;
INSERT INTO `userinf` (`ID`, `login`, `password`, `role`) VALUES
	(1, 'admin', 123, 'admin'),
	(2, 'vasya', 125, 'user'),
	(3, 'petya', 126, 'user'),
	(4, 'kate', 127, 'user'),
	(5, 'maks', 1990, 'user'),
	(6, 'maks', 1990, 'user'),
	(7, 'maks', 1990, 'user'),
	(8, 'maks', 1990, 'user');
/*!40000 ALTER TABLE `userinf` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
