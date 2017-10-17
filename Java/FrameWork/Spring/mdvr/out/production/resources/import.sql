# 初始化admin用户
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', 'admin', '1');
#增加用户和用户组测试数据
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '1', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '2', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '3', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '4', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '5', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '6', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '7', '0');
INSERT INTO `mdvr`.`t_user` (`createDatetime`, `password`, `userName`, `userType`) VALUES ('2017-10-03 21:46:44', '123456', '8', '0');

INSERT INTO `mdvr`.`t_user_group` (`userGroupName`) values ('1');
INSERT INTO `mdvr`.`t_user_group` (`userGroupName`) values ('2');
INSERT INTO `mdvr`.`t_user_group` (`userGroupName`) values ('3');
INSERT INTO `mdvr`.`t_user_group` (`userGroupName`) values ('4');

INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (2, 7);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (2, 2);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (2, 5);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (3, 3);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (3, 4);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (3, 6);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (4, 5);
INSERT INTO `t_user_join_usergroup` (`userGroupId`, `userId`) values (4, 6);
/*
测试结果：
CascadeType.ALL：
1）删除无关联的用户，只删除当前用户，但将所有双向关联的表都select一遍（t_user_group反而没有）
2）删除有关联的任一用户或用户组，所有有关联用户、用户组都删除，中间表被清空
CascadeType.MERGE：
添加时会级联保存，删除不会，能满足需求，但select语句好像还是多了一些
*/




