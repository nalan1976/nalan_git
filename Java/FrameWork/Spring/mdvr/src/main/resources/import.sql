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
#注释块不起作用，不知为何，加上就报异常 //nalan???
#初始化菜单项数据：一级菜单id区间为1-100，二级101-1000
INSERT INTO t_menu(menuId, fatherId, menuName, url) VALUES (1, -1, "系统设置", "setup/userGroup");
INSERT INTO t_menu(menuId, fatherId, menuName, url) VALUES (2, -1, "报表", "reporting");
INSERT INTO t_menu(menuId, fatherId, menuName, url) VALUES (101, 1, "用户组管理", "setup/userGroup");
