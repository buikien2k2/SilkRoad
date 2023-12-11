-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2023 at 09:22 PM
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
-- Database: `silkroaddb`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `commentImg` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `text`, `timestamp`, `post_id`, `commentImg`) VALUES
(2, 'hello', '2023-11-17 22:27:52.000000', 1, ''),
(3, 'how are you', '2023-11-17 22:28:01.000000', 1, ''),
(4, 'kiên đẹp trai quá', '2023-11-17 22:29:30.000000', 6, '');

-- --------------------------------------------------------

--
-- Table structure for table `friendship`
--

CREATE TABLE `friendship` (
  `id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `request_time` datetime DEFAULT NULL,
  `subscriber_id` int(11) DEFAULT NULL,
  `accept_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `friendship`
--

INSERT INTO `friendship` (`id`, `status`, `request_time`, `subscriber_id`, `accept_id`) VALUES
(4, 1, '2023-12-12 03:06:22', 16, 17);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `text` varchar(2048) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `postImg` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `tag`, `text`, `user_id`, `file_name`, `postImg`) VALUES
(1, 'Weather', 'Today is a good weather', 1, NULL, ''),
(2, 'Weather', 'Its sunny outside', 1, NULL, ''),
(3, 'Java', 'On the Server end, we recieve the data and reply back to the client. In Spring we can create a customized handler by using either TextWebSocketHandler or BinaryWebSocketHandler', 2, NULL, ''),
(4, 'Java', 'BinaryWebSocketHandler is used to handle more enriched type of data like images. In our case since we need to handle only text so we will use TextWebSocketHandler.', 2, NULL, ''),
(5, 'Sport', 'Manchester City vs Barcelona in 21:40', 4, NULL, ''),
(6, 'hahahahah', 'hahahha', 10, NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `post_dislike`
--

CREATE TABLE `post_dislike` (
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `post_like`
--

CREATE TABLE `post_like` (
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `post_like`
--

INSERT INTO `post_like` (`user_id`, `message_id`) VALUES
(10, 6);

-- --------------------------------------------------------

--
-- Table structure for table `private_message`
--

CREATE TABLE `private_message` (
  `id` int(11) NOT NULL,
  `text` varchar(1024) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `receiver` int(11) DEFAULT NULL,
  `sender` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `secure_token`
--

CREATE TABLE `secure_token` (
  `id` bigint(20) NOT NULL,
  `time_stamp` datetime NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `secure_token`
--

INSERT INTO `secure_token` (`id`, `time_stamp`, `token`, `user_id`) VALUES
(8, '2023-11-15 21:15:41', 'fad7cb01-03a4-4f44-a04e-94405a8d2fd5', 9),
(9, '2023-11-17 22:24:05', '05bd3aa1-1886-435b-abae-b8b14bd89b17', 10);

-- --------------------------------------------------------

--
-- Table structure for table `userdetail`
--

CREATE TABLE `userdetail` (
  `id` int(11) NOT NULL,
  `live_at` varchar(255) DEFAULT NULL,
  `relation` int(11) NOT NULL,
  `school` varchar(255) DEFAULT NULL,
  `work_at` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userdetail`
--

INSERT INTO `userdetail` (`id`, `live_at`, `relation`, `school`, `work_at`) VALUES
(16, 'No data 0', 1, 'No data', 'No data'),
(17, 'No data', 0, 'No data', 'No data');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_enabled` bit(1) NOT NULL,
  `avatar_name` varchar(255) DEFAULT NULL,
  `coverImg` varchar(255) DEFAULT NULL,
  `Phone` int(10) DEFAULT NULL,
  `Bio` text DEFAULT NULL,
  `Birth` date NOT NULL,
  `Gender` int(1) NOT NULL,
  `account_non_expired` bit(1) DEFAULT NULL,
  `account_non_locked` bit(1) DEFAULT NULL,
  `cover_img` varchar(255) DEFAULT NULL,
  `credentials_non_expired` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `is_enabled`, `avatar_name`, `coverImg`, `Phone`, `Bio`, `Birth`, `Gender`, `account_non_expired`, `account_non_locked`, `cover_img`, `credentials_non_expired`) VALUES
(1, 'admin@admin.com', 'HKien', '$2a$06$8tOeV93mfGYXRAsDvkfc5eMEIdKelAXY3DCM.dp8apSwSjSxxDoDC', b'1', NULL, '0', 0, '0', '0000-00-00', 0, b'1', b'1', NULL, b'1'),
(2, 'user@user.com', 'User', '$2a$06$yl6YmzQZBkhJOw0.Zfsq7ek9T9Dru.wUI.9kwWqlfW.FD208D1lDy', b'1', NULL, '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(3, 'anton@anton.com', 'Anton', '$2a$06$5SQMCyk8A0YqNfHvi29.5eBKjl8k/GkFbl9dhHyVyJEdD6JHU7r8G', b'1', NULL, '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(4, 'olga@olga.com', 'Olga', '$2a$06$YB6cY41qxnUOiwL0xRIYQOJFCM5j94zl9hDINru.YL4apHbHQ5Fsq', b'1', NULL, '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(7, 'huynhkien27894869@gmail.com', 'Kien', '1', b'1', NULL, '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(8, 'mizuk1s4n@gmail.com', 'Kie', '$2a$06$DGzCevYntjm4FMwTBWbbBedLXWw/S1QrJopPyAq49bcklLDMJcDze', b'1', NULL, '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(9, 'kienai2k2@gmail.com', 'kienai', '$2a$06$QIELBzyoTGW169TyB.jH1OKdmRsB/sT1K7k0HGVk155MXsdXiR48G', b'1', NULL, '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(10, 'nhakhoahoctrungkien@gmail.com', 'kienai1', '$2a$06$NAVsl2fhqEWYhy0Y5k.dn.hNjp9GaUPuyIZBtGtDde4msqex4.RHS', b'1', 'nhakhoahoctrungkien@gmail.com_51532.jpg', '0', 0, '0', '0000-00-00', 0, NULL, NULL, NULL, NULL),
(16, 'kienphan6969@gmail.com', 'kien', '$2a$10$2GhrtfUoWnBTF7coxeq1t.66.6jbMHt9HR5whinjyfextIIeyIhrK', b'1', '/img/avatar/1702265409731.jpg', NULL, NULL, '', '2020-02-26', 0, b'1', b'1', '/img/profileCover/1702267493717.jpg', b'1'),
(17, 'kienphan696969@gmail.com', 'kien2', '$2a$10$Z628hS4W1PgJW2lBN79sVOBZ7bt..rSMSVOINj6nFom9STpR9.UPe', b'1', '/img/avatar/1702325313349.gif', NULL, NULL, '', '2020-02-26', 0, b'1', b'1', '/img/profileCover/1702325509758.jpg', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(16, 1),
(17, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `comment_fk` (`post_id`) USING BTREE;

--
-- Indexes for table `friendship`
--
ALTER TABLE `friendship`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqycn6th9tfax40x5yr8gygrry` (`subscriber_id`),
  ADD KEY `FKbalhrbv93q1rngwfrdrl4ghaf` (`accept_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `message_user_fk` (`user_id`) USING BTREE;

--
-- Indexes for table `post_dislike`
--
ALTER TABLE `post_dislike`
  ADD PRIMARY KEY (`user_id`,`message_id`) USING BTREE,
  ADD KEY `user_dislike_fk` (`message_id`) USING BTREE;

--
-- Indexes for table `post_like`
--
ALTER TABLE `post_like`
  ADD PRIMARY KEY (`user_id`,`message_id`) USING BTREE,
  ADD KEY `message_like_fk` (`message_id`) USING BTREE;

--
-- Indexes for table `private_message`
--
ALTER TABLE `private_message`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `FKi2eyv59xxrrr031w4mul4vems` (`receiver`) USING BTREE,
  ADD KEY `FKhqd52u8ugesglpc1v8l63e2bp` (`sender`) USING BTREE;

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `secure_token`
--
ALTER TABLE `secure_token`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD KEY `secure_user_fk` (`user_id`) USING BTREE;

--
-- Indexes for table `userdetail`
--
ALTER TABLE `userdetail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `friendship`
--
ALTER TABLE `friendship`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `private_message`
--
ALTER TABLE `private_message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `secure_token`
--
ALTER TABLE `secure_token`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_fk` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Constraints for table `friendship`
--
ALTER TABLE `friendship`
  ADD CONSTRAINT `FKbalhrbv93q1rngwfrdrl4ghaf` FOREIGN KEY (`accept_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKqycn6th9tfax40x5yr8gygrry` FOREIGN KEY (`subscriber_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `message_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `post_dislike`
--
ALTER TABLE `post_dislike`
  ADD CONSTRAINT `message_dislike_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `user_dislike_fk` FOREIGN KEY (`message_id`) REFERENCES `post` (`id`);

--
-- Constraints for table `post_like`
--
ALTER TABLE `post_like`
  ADD CONSTRAINT `message_like_fk` FOREIGN KEY (`message_id`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `user_like_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `private_message`
--
ALTER TABLE `private_message`
  ADD CONSTRAINT `FKhqd52u8ugesglpc1v8l63e2bp` FOREIGN KEY (`sender`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKi2eyv59xxrrr031w4mul4vems` FOREIGN KEY (`receiver`) REFERENCES `users` (`id`);

--
-- Constraints for table `secure_token`
--
ALTER TABLE `secure_token`
  ADD CONSTRAINT `secure_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `userdetail`
--
ALTER TABLE `userdetail`
  ADD CONSTRAINT `FKrx76da2tv1lfprh950pgtgplm` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
