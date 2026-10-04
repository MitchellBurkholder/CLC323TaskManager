-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 04, 2026 at 06:25 PM
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
-- Database: `clc323_task_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `Task`
--

CREATE TABLE `Task` (
  `task_id` bigint(20) NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `description` text NOT NULL,
  `priority` varchar(20) NOT NULL,
  `due_date` date NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `full_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`user_id`, `first_name`, `last_name`, `email`, `password_hash`, `role`, `created_at`) VALUES
(1, 'admin', 'admin', 'admin@site.com', '$2a$10$pjiJlQyO5jOzCmcKFmWNCeKkChAU6i5E1tITor.L8yamVQsXDSkVW', 'PROJECT_MANAGER', '2026-10-04 10:54:43');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Task`
--
ALTER TABLE `Task`
  ADD PRIMARY KEY (`task_id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Task`
--
ALTER TABLE `Task`
  MODIFY `task_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
