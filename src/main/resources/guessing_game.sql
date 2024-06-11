-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 11, 2024 at 10:07 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `guessing_game`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_game`
--

CREATE TABLE `tbl_game` (
  `id` bigint(20) NOT NULL,
  `guesses` varchar(255) DEFAULT NULL,
  `played_at` datetime(6) DEFAULT NULL,
  `status` enum('LOST','PLAYING','SURRENDERED','WON') DEFAULT NULL,
  `tries_left` int(11) NOT NULL,
  `player_id` bigint(20) NOT NULL,
  `word_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_game`
--

INSERT INTO `tbl_game` (`id`, `guesses`, `played_at`, `status`, `tries_left`, `player_id`, `word_id`) VALUES
(1, 'asdfa,asdfd,23241,zxcvz,qweqw', '2024-06-10 16:30:22.627542', 'LOST', 0, 1, 2),
(2, 'asdfa,asdfa,dfdfd,htasd,asdfa', '2024-06-10 16:41:13.081221', 'LOST', 0, 1, 5),
(3, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 08:35:00.432691', 'LOST', 0, 1, 4),
(4, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 08:58:18.321825', 'LOST', 0, 1, 6),
(5, 'asdfa,zxcfz,asdfa,asdfa,asdfa', '2024-06-11 09:03:50.429911', 'LOST', 0, 1, 5),
(6, 'asdfa,asdfa,asdfa,fdfdf,dfdfa', '2024-06-11 09:05:54.449689', 'LOST', 0, 1, 3),
(7, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 09:07:28.619530', 'LOST', 0, 1, 5),
(8, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 09:07:59.817304', 'LOST', 0, 1, 5),
(9, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 09:11:39.961935', 'LOST', 0, 1, 7),
(10, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 09:13:45.436766', 'LOST', 0, 1, 4),
(11, 'asdfa,asdfa,xcvzx,asdfa,gfyhd', '2024-06-11 09:14:02.542176', 'LOST', 0, 1, 4),
(12, 'asdfa,vxcvd,asdrf,asdfa,ghhhj', '2024-06-11 09:17:23.543096', 'LOST', 0, 1, 3),
(13, 'asdfa,asdfa,asdfa,qwera,asdfe', '2024-06-11 09:20:31.699971', 'LOST', 0, 1, 2),
(14, 'asdfa,sdfgs,apple', '2024-06-11 09:35:12.551001', 'WON', 3, 1, 2),
(15, 'asdfl,guava,melon', '2024-06-11 09:50:17.230632', 'WON', 3, 2, 4),
(16, NULL, '2024-06-11 11:45:57.382538', 'SURRENDERED', 5, 1, 2),
(17, 'grape', '2024-06-11 11:49:02.040042', 'WON', 5, 1, 3),
(18, 'asdfa,asdfa,asdfa,asdfa,asdfa', '2024-06-11 11:50:47.363948', 'LOST', 0, 1, 3),
(19, 'asdfa', '2024-06-11 11:51:01.945568', 'SURRENDERED', 4, 1, 5),
(20, NULL, '2024-06-11 11:51:20.069718', 'SURRENDERED', 5, 1, 8),
(21, NULL, '2024-06-11 12:10:06.197126', 'SURRENDERED', 5, 1, 2),
(22, 'asdfa,tests', '2024-06-11 12:10:30.032852', 'SURRENDERED', 3, 1, 3),
(23, 'grape', '2024-06-11 15:24:34.760072', 'WON', 5, 1, 3),
(24, 'apple', '2024-06-11 15:30:16.279397', 'WON', 5, 1, 2),
(25, NULL, '2024-06-11 15:30:50.739018', 'SURRENDERED', 5, 1, 5),
(26, 'grape', '2024-06-11 15:31:15.011319', 'WON', 5, 1, 3),
(27, 'melon', '2024-06-11 16:04:26.526712', 'WON', 5, 1, 4),
(28, 'asdf,asdf,asdf,asdf,', '2024-06-11 16:05:10.630028', 'LOST', 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_player`
--

CREATE TABLE `tbl_player` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_player`
--

INSERT INTO `tbl_player` (`id`, `email`, `password`, `username`) VALUES
(1, 'test@test.com', 'testtest', 'tddninja'),
(2, 'jchips12@gmail.com', 'asdfasdf', 'jchips12');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_word`
--

CREATE TABLE `tbl_word` (
  `id` bigint(20) NOT NULL,
  `hint` varchar(255) DEFAULT NULL,
  `level` enum('EASY','HARD','MEDIUM') DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_word`
--

INSERT INTO `tbl_word` (`id`, `hint`, `level`, `value`) VALUES
(1, 'Sweet when ripe but sour when unripe.', 'EASY', 'mango'),
(2, 'A fruit that is red or green.', 'EASY', 'apple'),
(3, 'A small, round, purple or pale green fruit that you can eat or make into wine.', 'EASY', 'grape'),
(4, 'A large, round fruit with hard, green or yellow skin, sweet flesh, and a lot of seeds.', 'MEDIUM', 'melon'),
(5, 'A round fruit with sweet yellow flesh that has a lot of juice, a slightly furry red and yellow skin, and a large, hard seed in the middle.', 'MEDIUM', 'peach'),
(6, 'A yellow fruit with a lot of juice that is sour.', 'HARD', 'lemon'),
(7, 'A tropical fruit with pink flesh and a strong sweet smell.', 'HARD', 'guava'),
(8, 'A small, soft fruit with a lot of small seeds on the outside.', 'HARD', 'berry');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_game`
--
ALTER TABLE `tbl_game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjij9n5ufahlekjp6skehu909m` (`player_id`),
  ADD KEY `FKr0w4ffqogvu9yku2qnbwdj80u` (`word_id`);

--
-- Indexes for table `tbl_player`
--
ALTER TABLE `tbl_player`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_word`
--
ALTER TABLE `tbl_word`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_game`
--
ALTER TABLE `tbl_game`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `tbl_player`
--
ALTER TABLE `tbl_player`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_word`
--
ALTER TABLE `tbl_word`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_game`
--
ALTER TABLE `tbl_game`
  ADD CONSTRAINT `FKjij9n5ufahlekjp6skehu909m` FOREIGN KEY (`player_id`) REFERENCES `tbl_player` (`id`),
  ADD CONSTRAINT `FKr0w4ffqogvu9yku2qnbwdj80u` FOREIGN KEY (`word_id`) REFERENCES `tbl_word` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
