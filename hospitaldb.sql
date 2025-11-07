-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2025 at 05:50 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL,
  `patientID` int(11) NOT NULL,
  `consultantID` int(11) NOT NULL,
  `bookingDate` date NOT NULL,
  `time` varchar(10) NOT NULL,
  `room` int(11) NOT NULL,
  `paid` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingID`, `patientID`, `consultantID`, `bookingDate`, `time`, `room`, `paid`) VALUES
(1, 1, 1, '2000-10-10', '11.11', 11, '1111'),
(22, 22, 22, '2000-11-11', '11.11', 2, '1111'),
(55, 55, 5, '2000-11-11', '11.11', 33, '13123');

-- --------------------------------------------------------

--
-- Table structure for table `cashieraccountcreate`
--

CREATE TABLE `cashieraccountcreate` (
  `userID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cashieraccountcreate`
--

INSERT INTO `cashieraccountcreate` (`userID`, `name`, `password`, `phoneNumber`, `email`) VALUES
(1, 'Dinuki', 'dinuki', '1234567890', 'dinuki@gmail.com'),
(2, 'Dilki', 'dilki', '1234567890', 'dilki@gmail.com'),
(3, 'sanuka', 'sanuka', '1234567890', 'sanuka@gmail.com'),
(4, 'diluka', 'diluka', '1234513426', 'diluka@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `cashierlogin`
--

CREATE TABLE `cashierlogin` (
  `name` varchar(255) NOT NULL,
  `userID` int(11) NOT NULL,
  `password` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cashierlogin`
--

INSERT INTO `cashierlogin` (`name`, `userID`, `password`) VALUES
('Dinuki', 123, 'Cashier');

-- --------------------------------------------------------

--
-- Table structure for table `consultants`
--

CREATE TABLE `consultants` (
  `cID` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `hospital` varchar(100) NOT NULL,
  `telephone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `consultants`
--

INSERT INTO `consultants` (`cID`, `firstName`, `lastName`, `category`, `hospital`, `telephone`) VALUES
(1, 'nuwan', 'rathnayakaa', 'Eye Surgent ', 'abc', '1234567890'),
(2, 'sarath', 'winula', 'ENT Surgent', 'abc', '0987654321'),
(3, 'suran', 'lakvidu', 'General Physician', 'abc', '1256478392');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userID` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userID`, `password`) VALUES
('admin', '123'),
('staff', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `tel` varchar(15) NOT NULL,
  `category` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `firstName`, `lastName`, `gender`, `dob`, `tel`, `category`) VALUES
(1, 'dinuki', 'wijerathna', 'Female', '2003-08-25', '1234567890', 'abd'),
(109, 'sanula', 'dipanka', 'Female', '2000-11-13', '1234567890', 'acv'),
(111, 'qsd', 'sd', 'Male', '2000-11-13', '1234567890', 'sdzv');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`);

--
-- Indexes for table `cashieraccountcreate`
--
ALTER TABLE `cashieraccountcreate`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `cashierlogin`
--
ALTER TABLE `cashierlogin`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `consultants`
--
ALTER TABLE `consultants`
  ADD PRIMARY KEY (`cID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `cashieraccountcreate`
--
ALTER TABLE `cashieraccountcreate`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `cashierlogin`
--
ALTER TABLE `cashierlogin`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- AUTO_INCREMENT for table `consultants`
--
ALTER TABLE `consultants`
  MODIFY `cID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=214;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
