-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2022 at 05:23 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbouas`
--

-- --------------------------------------------------------

--
-- Table structure for table `categoryuser`
--

CREATE TABLE `categoryuser` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categoryuser`
--

INSERT INTO `categoryuser` (`id`, `name`) VALUES
(1, 'Private Account'),
(2, 'Creator Account'),
(3, 'Business Account');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `idCategory` int(11) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `idCategory`, `photo`) VALUES
(11, 'felicia', 'felicia@gmail.com', 'felicia', 0, 'C:\\Users\\Felicia\\OneDrive\\Documents\\HAI ;)\\penting\\Kartu Mhs.jpg'),
(26, 'a', 'a@gmail.com', 'a', 1, 'C:\\Users\\Felicia\\OneDrive\\Pictures\\logo ithb png.png'),
(43, 'b', 'b@gmail.com', 'b', 2, 'C:\\Users\\Felicia\\OneDrive\\Documents\\ITHB\\HIMA\\Logo iec.png'),
(59, 'c', 'c@gmail.com', 'c', 1, 'C:\\Users\\Felicia\\OneDrive\\Pictures\\Screenshots\\Screenshot (126).png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
