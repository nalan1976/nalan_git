DROP DATABASE IF EXISTS mdvr;
CREATE DATABASE mdvr DEFAULT CHARACTER SET utf8;
USE mdvr;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `createDatetime` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8

-- 增加了外键相关代码
CREATE TABLE `t_user_group` (
  `userGroupId` int(11) NOT NULL AUTO_INCREMENT,
  `userGroupName` int(11) DEFAULT NULL,
  PRIMARY KEY (`userGroupId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8

CREATE TABLE `t_user_join_usergroup` (
  `userGroupId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `userGroup_userGroupId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userGroupId`,`userId`),
  KEY `FK5g32v7lnyh8dhqwp2g15dd7x` (`userGroup_userGroupId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8
-- end

CREATE TABLE `t_user_join_usergroup` (
  `userGroupId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `userGroup_userGroupId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userGroupId`,`userId`),
  KEY `FK5g32v7lnyh8dhqwp2g15dd7x` (`userGroup_userGroupId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8
