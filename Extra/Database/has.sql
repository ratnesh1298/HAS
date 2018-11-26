-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE `has` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `has`;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_id` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `admin` (`id`, `admin_id`, `password`) VALUES
(1,	'arshad',	'arshad'),
(2,	'ratnesh',	'ratnesh');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `roll_number` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roll_number` (`roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (`id`, `name`, `roll_number`, `password`) VALUES
(12,	'Mohammed Arshad',	'16CSE33026',	'arshad'),
(13,	'Ratnesh',	'16CSE330230',	'ratnesh'),
(14,	'Alpha',	'123ABC',	'alpha'),
(15,	'beta',	'9012A',	'beta'),
(16,	'sdkfj',	'1029',	'ddjskl'),
(17,	'jdsklfd',	'12890',	'fdsjklk'),
(18,	'ddsj',	'812093sjdk',	'qdskfjl'),
(19,	'skjf',	'120',	'dskjf'),
(25,	'asdhj',	'1283',	'ssdfjjk');

DROP TABLE IF EXISTS `user_data`;
CREATE TABLE `user_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch` varchar(30) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `contact_number` varchar(11) DEFAULT NULL,
  `category` varchar(4) DEFAULT NULL,
  `total_marks` int(11) DEFAULT NULL,
  `marks_obtained` int(11) DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `contact_person_name` varchar(200) DEFAULT NULL,
  `contact_person_number` varchar(11) DEFAULT NULL,
  `contact_person_relation` varchar(30) DEFAULT NULL,
  `is_hostler_last_year` bit(1) DEFAULT NULL,
  `roll_number_fk` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roll_number_fk` (`roll_number_fk`),
  CONSTRAINT `user_data_ibfk_1` FOREIGN KEY (`roll_number_fk`) REFERENCES `user` (`roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user_data` (`id`, `branch`, `year`, `dob`, `contact_number`, `category`, `total_marks`, `marks_obtained`, `percentage`, `contact_person_name`, `contact_person_number`, `contact_person_relation`, `is_hostler_last_year`, `roll_number_fk`) VALUES
(7,	'Computer Science',	4,	'1997-03-01',	'8441975563',	'GEN',	1000,	756,	75.6,	'Mohammed Arshad',	'8441975563',	'self',	CONV('1', 2, 10) + 0,	'16CSE33026'),
(8,	'Computer Science',	4,	'1992-03-02',	'0000000000',	'GEN',	1200,	878,	NULL,	'abs',	'0000000000',	'abs',	CONV('0', 2, 10) + 0,	'16CSE330230'),
(9,	'Chemical',	3,	'1996-03-02',	'1230012200',	'OBC',	120,	100,	83.3333,	'pilia',	'0909090909',	'ppl',	CONV('1', 2, 10) + 0,	'123ABC'),
(10,	'BCT',	4,	'1991-02-04',	'0000000000',	'GEN',	100,	92,	92,	'sjkl',	'9090909090',	'klsdjf',	CONV('0', 2, 10) + 0,	'9012A'),
(11,	'Chemical',	4,	'1995-05-02',	'9020903409',	'SBC',	1202,	129,	10.7321,	'masodhds',	'0923090923',	'sndfkj',	CONV('0', 2, 10) + 0,	'1029'),
(12,	'Civil',	3,	'1992-04-04',	'9999999999',	'OBC',	120,	93,	77.5,	'dsfnj',	'9012900912',	'sdjfk',	CONV('0', 2, 10) + 0,	'12890'),
(13,	'BCT',	2,	'1992-03-03',	'0923874587',	'OBC',	1200,	129,	10.75,	'jfw',	'0912090023',	'sdfjk',	CONV('1', 2, 10) + 0,	'812093sjdk'),
(14,	'Civil',	3,	'1995-04-03',	'0923090909',	'ST',	1209,	999,	82.6303,	'ksdjfl',	'0923090909',	'dsjgk',	CONV('0', 2, 10) + 0,	'120'),
(15,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	'1283');

-- 2018-10-23 19:29:41
