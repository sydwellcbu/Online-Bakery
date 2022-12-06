-- --------------------------------------------------------
-- Host:                         192.168.115.90
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bakerystore
CREATE DATABASE IF NOT EXISTS `bakerystore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bakerystore`;

-- Dumping structure for table bakerystore.address
CREATE TABLE IF NOT EXISTS `address` (
  `userId` int(10) NOT NULL,
  `homeAddress` varchar(100) DEFAULT NULL,
  `deliveryAddress` varchar(100) DEFAULT NULL,
  KEY `FK_address_user` (`userId`),
  CONSTRAINT `FK_address_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.address: ~1 rows (approximately)
INSERT INTO `address` (`userId`, `homeAddress`, `deliveryAddress`) VALUES
	(1, '113 Penina Park Polokwane', '15 Midarnd Mecer InterEd');

-- Dumping structure for table bakerystore.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `adminId` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(30) DEFAULT NULL,
  `tittle` varchar(30) DEFAULT NULL,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.admin: ~1 rows (approximately)

-- Dumping structure for table bakerystore.card
CREATE TABLE IF NOT EXISTS `card` (
  `bankName` varchar(50) DEFAULT NULL,
  `cvv` int(11) DEFAULT NULL,
  `cardNumber` varchar(50) DEFAULT NULL,
  `expDate` int(11) DEFAULT NULL,
  `payId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.card: ~0 rows (approximately)

-- Dumping structure for table bakerystore.category
CREATE TABLE IF NOT EXISTS `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) DEFAULT '0',
  `categoryPicture` varchar(200) DEFAULT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`categoryId`) USING BTREE,
  UNIQUE KEY `categoryName` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.category: ~5 rows (approximately)
INSERT INTO `category` (`categoryId`, `categoryName`, `categoryPicture`, `active`) VALUES
	(22, 'Breads', 'picture/bread5.jpg', 1),
	(33, 'Pies', 'picture/Pastries2.jpg', 1),
	(34, 'Cookies', 'picture/cookie.jpg', 1),
	(35, 'Kotas', 'picture/kota3.webp', 1),
	(41, 'Cakes', 'picture/cakeCate.jpg', 1);

-- Dumping structure for table bakerystore.delivery
CREATE TABLE IF NOT EXISTS `delivery` (
  `deliveryId` int(10) NOT NULL AUTO_INCREMENT,
  `deliveryStatus` tinyint(4) DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1',
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`deliveryId`),
  KEY `FK_delivery_order` (`orderId`),
  CONSTRAINT `FK_delivery_order` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.delivery: ~0 rows (approximately)

-- Dumping structure for table bakerystore.ingridients
CREATE TABLE IF NOT EXISTS `ingridients` (
  `ingridientsId` int(10) NOT NULL AUTO_INCREMENT,
  `ingrItem` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ingridientsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.ingridients: ~0 rows (approximately)

-- Dumping structure for table bakerystore.ingridient_inventory
CREATE TABLE IF NOT EXISTS `ingridient_inventory` (
  `inventoryId` int(10) NOT NULL AUTO_INCREMENT,
  `availableStock` int(10) NOT NULL DEFAULT '0',
  `maxOrder` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`inventoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.ingridient_inventory: ~0 rows (approximately)

-- Dumping structure for table bakerystore.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoiceId` int(10) NOT NULL AUTO_INCREMENT,
  `orderId` int(10) DEFAULT '0',
  PRIMARY KEY (`invoiceId`),
  KEY `FK__order` (`orderId`),
  CONSTRAINT `FK__order` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.invoice: ~0 rows (approximately)

-- Dumping structure for table bakerystore.order
CREATE TABLE IF NOT EXISTS `order` (
  `orderId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL DEFAULT '0',
  `productId` int(10) NOT NULL DEFAULT '0',
  `quantity` int(10) NOT NULL DEFAULT '0',
  `orderAmount` double NOT NULL DEFAULT '0',
  `orderStatus` varchar(10) NOT NULL,
  `orderDate` date DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`orderId`),
  KEY `FK_order_product` (`productId`),
  KEY `FK_order_customer` (`userId`) USING BTREE,
  CONSTRAINT `FK_order_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.order: ~0 rows (approximately)

-- Dumping structure for table bakerystore.orderproducts
CREATE TABLE IF NOT EXISTS `orderproducts` (
  `productId` int(10) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `orderId` int(10) DEFAULT NULL,
  KEY `FK_orderproducts_product` (`productId`),
  KEY `FK_orderproducts_order` (`orderId`),
  CONSTRAINT `FK_orderproducts_order` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_orderproducts_product` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.orderproducts: ~0 rows (approximately)

-- Dumping structure for table bakerystore.payment
CREATE TABLE IF NOT EXISTS `payment` (
  `payId` int(10) NOT NULL AUTO_INCREMENT,
  `invoiceId` int(10) DEFAULT '0',
  `payMethod` varchar(50) DEFAULT NULL,
  `payStatus` varchar(20) DEFAULT NULL,
  `payDate` date DEFAULT NULL,
  PRIMARY KEY (`payId`),
  KEY `FK__invoice` (`invoiceId`),
  CONSTRAINT `FK__invoice` FOREIGN KEY (`invoiceId`) REFERENCES `invoice` (`invoiceId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.payment: ~0 rows (approximately)

-- Dumping structure for table bakerystore.product
CREATE TABLE IF NOT EXISTS `product` (
  `productId` int(10) NOT NULL AUTO_INCREMENT,
  `productName` varchar(20) DEFAULT NULL,
  `productDesc` varchar(60) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `discount` double NOT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `productPic` varchar(50) DEFAULT NULL,
  `postedDate` date DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`productId`) USING BTREE,
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.product: ~2 rows (approximately)
INSERT INTO `product` (`productId`, `productName`, `productDesc`, `quantity`, `price`, `discount`, `categoryId`, `productPic`, `postedDate`, `active`) VALUES
	(19, 'Crispy Pie', 'Pie with crispy cheee', 5, 12, 50, 33, 'picture/', '2022-11-14', 0),
	(21, 'Big Kota', 'Kota with russian ,polony and crispy chips ', 10, 35, 0, 35, 'picture/kota1_1.webp', '2022-11-16', 1),
	(22, 'Small Kota', 'Chips and polony ', 5, 20, 5, 35, 'picture/kota2.webp', '2022-11-16', 1),
	(23, 'Medium Kota', 'Kota with russian ,polony and cheese', 5, 28.5, 0, 35, 'picture/kota4.webp', '2022-11-16', 1),
	(24, 'Brown Cake', 'Contain more sugar with less cream', 70, 89.99, 0, 41, 'picture/brownCake.jpg', '2022-11-16', 1),
	(26, 'Cream Cake', 'Contain more cream than sugar', 102, 82.32, 5, 41, 'picture/cake2.jpg', '2022-11-16', 1),
	(27, 'Red CAke', 'Red cake with Strawberry', 56, 88.99, 0, 41, 'picture/redCake.jpg', '2022-11-16', 0),
	(28, 'Cream Cake', 'Contain more cream than sugar', 102, 89.99, 0, 41, 'picture/creamyCake.jpg', '2022-11-16', 1),
	(29, 'Brown Bread', 'Contain more Protein', 50, 17, 0, 22, 'picture/bread5.jpg', '2022-11-16', 1),
	(30, 'White Bread', 'Protein', 70, 18, 0, 22, 'picture/brownBread.jpg', '2022-11-16', 1),
	(31, 'Chocolate Cookie', 'Contain more Spice', 70, 22, 0, 34, 'picture/cookie.jpg', '2022-11-16', 1),
	(32, 'Grape Cookie', 'Contain Grapes', 56, 14, 2, 34, 'picture/cookie2.jpg', '2022-11-16', 1),
	(33, 'Doll like Cookie', 'Contain more Protein for kids', 102, 15, 0, 34, 'picture/cookie3.jpg', '2022-11-16', 1),
	(35, 'Kota King', 'Polony, Egg, Rib patty, Double Cheese, Bacon, Russion', 80, 49, 2, 35, 'picture/kota3.webp', '2022-11-16', 1);

-- Dumping structure for table bakerystore.recipe
CREATE TABLE IF NOT EXISTS `recipe` (
  `recipeId` int(10) NOT NULL AUTO_INCREMENT,
  `recipeDesc` varchar(200) NOT NULL DEFAULT '0',
  `recipeInstr` varchar(150) NOT NULL DEFAULT '0',
  `productId` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`recipeId`),
  KEY `FK__product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.recipe: ~0 rows (approximately)

-- Dumping structure for table bakerystore.recipe_ingridients
CREATE TABLE IF NOT EXISTS `recipe_ingridients` (
  `recipeId` int(10) DEFAULT NULL,
  `ingridientsId` int(10) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  KEY `FK__recipe` (`recipeId`),
  KEY `FK__ingridients` (`ingridientsId`),
  CONSTRAINT `FK__ingridients` FOREIGN KEY (`ingridientsId`) REFERENCES `ingridients` (`ingridientsId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__recipe` FOREIGN KEY (`recipeId`) REFERENCES `recipe` (`recipeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.recipe_ingridients: ~0 rows (approximately)

-- Dumping structure for table bakerystore.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tittle` varchar(50) DEFAULT NULL,
  `active` tinyint(4) DEFAULT '1',
  `isAdmin` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table bakerystore.user: ~6 rows (approximately)
INSERT INTO `user` (`userId`, `firstName`, `lastName`, `telephone`, `email`, `password`, `address`, `tittle`, `active`, `isAdmin`) VALUES
	(1, 'Aubrey', 'Mohlala', '0728685375', 'mash@gmail.com', '@1234', '1632 Phumolong Tembisa', NULL, 1, 0),
	(2, 'sydwell', 'ngwenya', '0794322', 'sbu@mecer', '3224', '15th Randgesburg Midrand', NULL, 1, 0),
	(3, 'Makonko', 'khambule', '05423234', 'masala@gmail.com', '112', 'soshanguve', 'Miss', 1, 0),
	(8, 'Bontle', 'Letlaka', '0784563452', 'letlaka@mieemail.com', '123', 'Polokwane 7 street', 'Mrs', 1, 0),
	(9, 'Andrie', 'Ntobeng', '0794589539', 'mahubed9539@gmail', '12345', 'PRETORIA', 'Mr', 1, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
