-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2019 at 12:08 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wypozyczalnia`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Login` varchar(255) NOT NULL,
  `Haslo` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Telefon` varchar(255) NOT NULL,
  `Imie` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Login`, `Haslo`, `Email`, `Telefon`, `Imie`, `Nazwisko`) VALUES
('login1', 'haslo1', '', '', '', ''),
('login2', 'haslo2', '', '', '', ''),
('asd', 'asd', 'asd', 'asda', 'asd', 'asd'),
('asd', 'asd', 'asd', 'asd', 'asd', 'asd'),
('wojteklogin', 'wojtekhaslo', 'test@gmail.com', '111222333', 'Wojciech', 'Darul'),
('asd', 'haslo', '123@gmail,com', '111222333', 'wojtek', 'darul');

-- --------------------------------------------------------

--
-- Table structure for table `utwory`
--

CREATE TABLE `utwory` (
  `Tytul` varchar(255) NOT NULL,
  `Wykonawca` varchar(255) NOT NULL,
  `Album` varchar(255) NOT NULL,
  `Data_publikacji` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
