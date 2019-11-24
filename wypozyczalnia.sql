-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2019 at 08:22 PM
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
  `Nazwisko` varchar(255) NOT NULL,
  `pytanie_pomoc` varchar(255) NOT NULL,
  `pytanie_pomoc_tresc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Login`, `Haslo`, `Email`, `Telefon`, `Imie`, `Nazwisko`, `pytanie_pomoc`, `pytanie_pomoc_tresc`) VALUES
('', 'd', '', '', '', '', '', ''),
('aa', 'asddd', '', '', '', '', '', ''),
('asdd', 'asd', 'asd', 'asd', 'asd', 'asd', 'ddd', ''),
('cc', 'asddd', '', '', '', '', '', ''),
('lol', 'asddd', 'asd', 'asd', 'sdf', 'asd', 'Radar', 'Jak miał na imię Twój pierwszy pies?'),
('loll', 'asddd', '', '', '', '', '', ''),
('sss', '', '', '', '', '', '', ''),
('vcb', 'vcb', 'xdd', 'xddd', 'xd', 'xdq', 'bvc', '');

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

--
-- Dumping data for table `utwory`
--

INSERT INTO `utwory` (`Tytul`, `Wykonawca`, `Album`, `Data_publikacji`) VALUES
('asd', 'asd', 'asd', 'asd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `uniq` (`Login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
