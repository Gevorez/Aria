-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2020 at 10:13 PM
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
CREATE DATABASE IF NOT EXISTS `wypozyczalnia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `wypozyczalnia`;

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
  `Nazwisko` varchar(255) NOT NULL,
  `pytanie_pomoc` varchar(255) NOT NULL,
  `pytanie_pomoc_tresc` varchar(255) NOT NULL,
  `nazwa_studia` varchar(255) NOT NULL,
  `Admin` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Login`, `Haslo`, `Email`, `Telefon`, `Imie`, `Nazwisko`, `pytanie_pomoc`, `pytanie_pomoc_tresc`, `nazwa_studia`, `Admin`) VALUES
('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'admin', 'admin', 'admin', 'admin', 'admin', '', '', 1),
('xd', '7782391677c36f0f0e77363c7ef182e4e75e7669', 'nie', 'admin', 'a', 'to', 'xd', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `utwory`
--

CREATE TABLE `utwory` (
  `Tytul` varchar(255) NOT NULL,
  `Wykonawca` varchar(255) NOT NULL,
  `Album` varchar(255) NOT NULL,
  `Data_publikacji` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utwory`
--

INSERT INTO `utwory` (`Tytul`, `Wykonawca`, `Album`, `Data_publikacji`, `id`) VALUES
('leci', 'asd', 'asd', 'asd', 8),
('asdsad', 'asdas', 'asda', 'asdasd', 10);

-- --------------------------------------------------------

--
-- Table structure for table `wykonawca`
--

CREATE TABLE `wykonawca` (
  `Imie` varchar(255) NOT NULL,
  `Nazwisko` varchar(255) NOT NULL,
  `Pseudonim` varchar(255) NOT NULL,
  `Wykonawca` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `uniq` (`Login`);

--
-- Indexes for table `utwory`
--
ALTER TABLE `utwory`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `utwory`
--
ALTER TABLE `utwory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
