-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2017 at 08:04 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project1`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerId` int(50) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT 'null',
  `number` int(11) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT 'null',
  `item` varchar(50) NOT NULL DEFAULT 'null',
  `price` float NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT 'Ordinary',
  `address` text NOT NULL,
  `silver` int(11) DEFAULT '30000',
  `platinum` int(11) DEFAULT '45000',
  `gold` int(11) DEFAULT '65000'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerId`, `name`, `number`, `email`, `item`, `price`, `status`, `address`, `silver`, `platinum`, `gold`) VALUES
(2, 'Taohidur Imran', 1926651990, 'taohidurimran95@gmail.com', 'Burger', 40090, 'Platinum', 'Vola Road , Korno Kathi ,Barisal', 30000, 45000, 65000),
(3, 'Aminul Islam', 1521466521, 'aminul420@gmail.com', 'nuduls,Burger', 35160.2, 'Platinum', 'bazar-road , Jhalokathi', 30000, 45000, 65000),
(4, 'Jaydev Ghosh', 1758998547, 'joydeb420@gmail.com', 'null', 0, 'Ordinary', 'SOLEMAIn pur , ghosh para , jhenidah', 30000, 45000, 65000),
(5, 'Ripon das', 1681611691, 'ripon420@gmail.com', 'null', 2000, 'Ordinary', 'Barisal University', 30000, 45000, 65000),
(6, 'Monir', 1762035728, 'monir420@gmail.com', 'null', 0, 'Ordinary', 'cipa goli , barisal', 30000, 45000, 65000),
(7, 'Md. Mosaddek hossain', 1744977541, 'mdmosaddek420@gmail.com', 'burger , red wine , chicken fried rice', 22000, 'Ordinary', 'Rangpur', 30000, 45000, 65000),
(8, 'Mousum', 1819870719, '', 'null', 0, 'Ordinary', 'Kurigram ,Rangpur', 30000, 45000, 65000),
(9, 'Mousum', 1234567895, 'mousum420@gmail.com', 'null', 70000, 'Gold', 'Kurigram', 30000, 45000, 65000),
(10, 'sohan', 1677629716, 'sohan420@gmail.com', 'nuduls', 62000, 'Gold', '', 30000, 45000, 65000),
(11, 'suvo', 1775533373, '', 'sangxnsg', 80000, 'Gold', '', 30000, 45000, 65000),
(12, 'aman', 1521451006, '', 'sdsff', 61300, 'Gold', 'zdfxdgxg', 30000, 45000, 65000),
(13, 'Ashif Rahman', 1845041010, 'arshifty@gmail.com', 'null', 54200, 'Gold', 'kurigram', 30000, 45000, 65000),
(14, ' tuhin vai', 1236547890, '', 'cake', 44000, 'Platinum', 'rangpur', 30000, 45000, 65000),
(18, 'Tarikul', 1923779030, 'asa', 'null', 76500, 'Gold', '', 30000, 45000, 65000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerId`),
  ADD UNIQUE KEY `number` (`number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
