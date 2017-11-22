
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2017 at 05:01 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PrivateCondo`
--

-- --------------------------------------------------------

--
-- Table structure for table `days`
--

CREATE TABLE `days` (
  `dayId` int(11) NOT NULL,
  `dayName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `days`
--

INSERT INTO `days` (`dayId`, `dayName`) VALUES
(1, 'Monday'),
(2, 'Tuesday'),
(3, 'Wednesday'),
(4, 'Thursday'),
(5, 'Friday'),
(6, 'Saturday'),
(7, 'Sunday');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `new_id` int(11) NOT NULL,
  `new_topic` varchar(100) NOT NULL,
  `new_description` varchar(300) NOT NULL,
  `announceDate` date NOT NULL,
  `announcer_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`new_id`, `new_topic`, `new_description`, `announceDate`, `announcer_Id`) VALUES
(1, 'ทำบุญประจำปี 2560', 'ขอเชิญผู้พักอยู่อาศัยทุกท่าน มาร่วมทำบุญประจำปี บริเวณชั้น 1 ณ วันที่ 15/11/60 เวลา 10:00 น. เป็นต้นไป', '2017-11-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `problemhandler`
--

CREATE TABLE `problemhandler` (
  `handlerid` int(11) NOT NULL,
  `problem_id` int(11) NOT NULL,
  `problemstatus_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `handleDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `problemhandler`
--

INSERT INTO `problemhandler` (`handlerid`, `problem_id`, `problemstatus_id`, `admin_id`, `handleDate`) VALUES
(1, 1, 1, 1, '2017-11-20 13:26:00');

-- --------------------------------------------------------

--
-- Table structure for table `problems`
--

CREATE TABLE `problems` (
  `problem_id` int(11) NOT NULL,
  `topic` varchar(70) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `reportDate` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `problems`
--

INSERT INTO `problems` (`problem_id`, `topic`, `description`, `reportDate`, `user_id`, `room_id`) VALUES
(1, 'น้ำรั่ว', 'มีน้ำรั่วออกมาจากฝักบัวค่ะ', '2017-11-23', 2, 13);

-- --------------------------------------------------------

--
-- Table structure for table `problemstatus`
--

CREATE TABLE `problemstatus` (
  `problemStatus_id` int(11) NOT NULL,
  `problemStatus_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `problemstatus`
--

INSERT INTO `problemstatus` (`problemStatus_id`, `problemStatus_name`) VALUES
(1, 'In Progress'),
(2, 'Done');

-- --------------------------------------------------------

--
-- Table structure for table `relationtype`
--

CREATE TABLE `relationtype` (
  `relationTypeId` int(11) NOT NULL,
  `relationTypeName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `relationtype`
--

INSERT INTO `relationtype` (`relationTypeId`, `relationTypeName`) VALUES
(1, 'Owner'),
(2, 'Resident');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `roomId` int(11) NOT NULL,
  `roomNum` varchar(20) NOT NULL,
  `floor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`roomId`, `roomNum`, `floor`) VALUES
(1, '101', 1),
(2, '102', 1),
(3, '103', 1),
(4, '104', 1),
(5, '201', 2),
(6, '202', 2),
(7, '203', 2),
(8, '204', 2),
(9, '301', 3),
(10, '302', 3),
(11, '303', 3),
(12, '304', 3),
(13, '401', 4),
(14, '402', 4),
(15, '403', 4),
(16, '404', 4),
(17, '501', 5),
(18, '502', 5),
(19, '503', 5),
(504, '5', 0);

-- --------------------------------------------------------

--
-- Table structure for table `roomservicestaffs`
--

CREATE TABLE `roomservicestaffs` (
  `staffId` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `staffImagePath` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roomservicestaffs`
--

INSERT INTO `roomservicestaffs` (`staffId`, `fname`, `lname`, `staffImagePath`) VALUES
(1, 'นันทวัน', 'หอมประเสริฐสุข', 'https://scontent.fbkk12-2.fna.fbcdn.net/v/t1.0-9/19554051_1452986468102411_6585311614308058377_n.jpg?oh=50ca40ac665a8431f2c94f86f1e39925&oe=5A8AC82C');

-- --------------------------------------------------------

--
-- Table structure for table `servicereservation`
--

CREATE TABLE `servicereservation` (
  `reserveId` int(11) NOT NULL,
  `serviceDate` date NOT NULL,
  `rooms_roomId` int(11) NOT NULL,
  `worktime_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `servicereservation`
--

INSERT INTO `servicereservation` (`reserveId`, `serviceDate`, `rooms_roomId`, `worktime_id`) VALUES
(1, '2017-11-25', 13, 2);

-- --------------------------------------------------------

--
-- Table structure for table `userroomrelation`
--

CREATE TABLE `userroomrelation` (
  `relation_id` int(11) NOT NULL,
  `user_userId` int(11) NOT NULL,
  `rooms_roomId` int(11) NOT NULL,
  `relationtype_typeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userroomrelation`
--

INSERT INTO `userroomrelation` (`relation_id`, `user_userId`, `rooms_roomId`, `relationtype_typeid`) VALUES
(1, 2, 13, 1),
(2, 2, 13, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `gender` varchar(2) NOT NULL,
  `telNo` varchar(15) DEFAULT NULL,
  `line` varchar(30) DEFAULT NULL,
  `userType_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `username`, `password`, `fname`, `lname`, `gender`, `telNo`, `line`, `userType_Id`) VALUES
(1, 'poom029', '029', 'กฤตพันธ์', 'พราหมณะนันทน์', 'M', '0830723684', 'poom029', 0),
(2, 'jillion', '1234', 'จิราภา', 'ทรงโฉม', 'F', '0866168318', 'jillIsSoBeauty', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usertypes`
--

CREATE TABLE `usertypes` (
  `userType_Id` int(11) NOT NULL,
  `userType_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usertypes`
--

INSERT INTO `usertypes` (`userType_Id`, `userType_name`) VALUES
(0, 'Admin'),
(1, 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `worktimes`
--

CREATE TABLE `worktimes` (
  `worktimeid` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `worktime_staffId` int(11) NOT NULL,
  `worktime_dayid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `worktimes`
--

INSERT INTO `worktimes` (`worktimeid`, `startTime`, `endTime`, `worktime_staffId`, `worktime_dayid`) VALUES
(1, '09:00:00', '11:00:00', 1, 6),
(2, '14:00:00', '16:00:00', 1, 6),
(3, '09:00:00', '11:00:00', 1, 7),
(4, '14:00:00', '16:00:00', 1, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `days`
--
ALTER TABLE `days`
  ADD PRIMARY KEY (`dayId`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`new_id`),
  ADD KEY `news_user_id` (`announcer_Id`);

--
-- Indexes for table `problemhandler`
--
ALTER TABLE `problemhandler`
  ADD PRIMARY KEY (`handlerid`),
  ADD KEY `handler_problem_id_fk` (`problem_id`),
  ADD KEY `handler_user_id_fk` (`admin_id`),
  ADD KEY `handler_problemstatus_id_fk` (`problemstatus_id`);

--
-- Indexes for table `problems`
--
ALTER TABLE `problems`
  ADD PRIMARY KEY (`problem_id`),
  ADD KEY `problem_user_id_fk` (`user_id`),
  ADD KEY `problem_room_id_fk` (`room_id`);

--
-- Indexes for table `problemstatus`
--
ALTER TABLE `problemstatus`
  ADD PRIMARY KEY (`problemStatus_id`);

--
-- Indexes for table `relationtype`
--
ALTER TABLE `relationtype`
  ADD PRIMARY KEY (`relationTypeId`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`roomId`);

--
-- Indexes for table `roomservicestaffs`
--
ALTER TABLE `roomservicestaffs`
  ADD PRIMARY KEY (`staffId`);

--
-- Indexes for table `servicereservation`
--
ALTER TABLE `servicereservation`
  ADD PRIMARY KEY (`reserveId`),
  ADD KEY `reserve_worktimeid_fk` (`worktime_id`),
  ADD KEY `reserve_roomId_fk` (`rooms_roomId`);

--
-- Indexes for table `userroomrelation`
--
ALTER TABLE `userroomrelation`
  ADD PRIMARY KEY (`relation_id`),
  ADD KEY `relation_userId_fk` (`user_userId`),
  ADD KEY `relation_relationtype_fk` (`relationtype_typeid`),
  ADD KEY `relation_roomId_fk` (`rooms_roomId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `user_usertype_fk` (`userType_Id`);

--
-- Indexes for table `usertypes`
--
ALTER TABLE `usertypes`
  ADD PRIMARY KEY (`userType_Id`);

--
-- Indexes for table `worktimes`
--
ALTER TABLE `worktimes`
  ADD PRIMARY KEY (`worktimeid`),
  ADD KEY `worktime_roomserstaff_id` (`worktime_staffId`),
  ADD KEY `worktime_day_id` (`worktime_dayid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `new_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `problemhandler`
--
ALTER TABLE `problemhandler`
  MODIFY `handlerid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `problems`
--
ALTER TABLE `problems`
  MODIFY `problem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `roomId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=505;

--
-- AUTO_INCREMENT for table `roomservicestaffs`
--
ALTER TABLE `roomservicestaffs`
  MODIFY `staffId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `servicereservation`
--
ALTER TABLE `servicereservation`
  MODIFY `reserveId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `userroomrelation`
--
ALTER TABLE `userroomrelation`
  MODIFY `relation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `worktimes`
--
ALTER TABLE `worktimes`
  MODIFY `worktimeid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `news_user_id` FOREIGN KEY (`announcer_Id`) REFERENCES `users` (`userId`) ON DELETE NO ACTION;

--
-- Constraints for table `problemhandler`
--
ALTER TABLE `problemhandler`
  ADD CONSTRAINT `handler_problem_id_fk` FOREIGN KEY (`problem_id`) REFERENCES `problems` (`problem_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `handler_problemstatus_id_fk` FOREIGN KEY (`problemstatus_id`) REFERENCES `problemstatus` (`problemStatus_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `handler_user_id_fk` FOREIGN KEY (`admin_id`) REFERENCES `users` (`userId`) ON DELETE NO ACTION;

--
-- Constraints for table `problems`
--
ALTER TABLE `problems`
  ADD CONSTRAINT `problem_room_id_fk` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`roomId`) ON DELETE NO ACTION,
  ADD CONSTRAINT `problem_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`userId`) ON DELETE NO ACTION;

--
-- Constraints for table `servicereservation`
--
ALTER TABLE `servicereservation`
  ADD CONSTRAINT `reserve_roomId_fk` FOREIGN KEY (`rooms_roomId`) REFERENCES `rooms` (`roomId`) ON DELETE NO ACTION,
  ADD CONSTRAINT `reserve_worktimeid_fk` FOREIGN KEY (`worktime_id`) REFERENCES `worktimes` (`worktimeid`) ON DELETE NO ACTION;

--
-- Constraints for table `userroomrelation`
--
ALTER TABLE `userroomrelation`
  ADD CONSTRAINT `relation_relationtype_fk` FOREIGN KEY (`relationtype_typeid`) REFERENCES `relationtype` (`relationTypeId`) ON DELETE NO ACTION,
  ADD CONSTRAINT `relation_roomId_fk` FOREIGN KEY (`rooms_roomId`) REFERENCES `rooms` (`roomId`) ON DELETE NO ACTION,
  ADD CONSTRAINT `relation_userId_fk` FOREIGN KEY (`user_userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `user_usertype_fk` FOREIGN KEY (`userType_Id`) REFERENCES `usertypes` (`userType_Id`) ON DELETE NO ACTION;

--
-- Constraints for table `worktimes`
--
ALTER TABLE `worktimes`
  ADD CONSTRAINT `worktime_day_id` FOREIGN KEY (`worktime_dayid`) REFERENCES `days` (`dayId`) ON DELETE NO ACTION,
  ADD CONSTRAINT `worktime_roomserstaff_id` FOREIGN KEY (`worktime_staffId`) REFERENCES `roomservicestaffs` (`staffId`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
