/*
MySQL Backup
Source Server Version: 5.5.33
Source Database: zjkfgj
Date: 2013/10/28 21:15:48
*/


-- ----------------------------
--  Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `areaName` varchar(20) NOT NULL,
  `displayOrder` int(11) NOT NULL DEFAULT '0',
  `descriptin` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `district_report1`
-- ----------------------------
DROP TABLE IF EXISTS `district_report1`;
CREATE TABLE `district_report1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `developerName` varchar(200) DEFAULT NULL COMMENT '开发企业名称\r\n\r\n开发企业名称',
  `licenceNo` varchar(50) DEFAULT NULL COMMENT '预售许可证编号',
  `licenceDate` varchar(20) DEFAULT NULL COMMENT '预售许可证颁发时间',
  `projectName` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `location` varchar(300) DEFAULT NULL COMMENT '房屋坐落地',
  `houseNumber` int(11) DEFAULT NULL COMMENT '住宅套数',
  `houseArea` double(15,2) DEFAULT NULL COMMENT '住宅面积',
  `business` double(15,2) DEFAULT NULL,
  `office` double(15,2) DEFAULT NULL,
  `other` double(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='颁发商品房预售许可证情况表';

-- ----------------------------
--  Table structure for `district_report2_5`
-- ----------------------------
DROP TABLE IF EXISTS `district_report2_5`;
CREATE TABLE `district_report2_5` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `developerName` varchar(200) DEFAULT NULL COMMENT '开发企业名称',
  `projectName` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `startTime` varchar(20) DEFAULT NULL COMMENT '开工时间',
  `completeTime` varchar(20) DEFAULT NULL COMMENT '竣工时间',
  `location` varchar(300) DEFAULT NULL COMMENT '房屋座落地',
  `houseNumber` int(11) DEFAULT NULL COMMENT '套数',
  `area` double(15,2) DEFAULT NULL COMMENT '面积',
  `totalPrice` double(15,2) DEFAULT NULL COMMENT '合同总价（万元）',
  `averagePrice` double(15,2) DEFAULT NULL COMMENT '平均价（元）',
  `category` varchar(10) DEFAULT NULL COMMENT '种类，1商品住宅,2商业营业房,3办公房,4其他房',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='销售备案情况表';

-- ----------------------------
--  Table structure for `district_report6`
-- ----------------------------
DROP TABLE IF EXISTS `district_report6`;
CREATE TABLE `district_report6` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `firstNumber` int(11) DEFAULT NULL COMMENT '1990年之前套数',
  `firstArea` double(15,2) DEFAULT NULL COMMENT '1990年之前面积(万㎡)',
  `secondNumber` int(11) DEFAULT NULL COMMENT '1991年-2000年套数',
  `secondArea` double(15,2) DEFAULT NULL COMMENT '1991年-2000年面积(万㎡)',
  `threeNumber` int(11) DEFAULT NULL COMMENT '2001年-2010年套数',
  `threeArea` double(15,2) DEFAULT NULL COMMENT '2001年-2010年面积(万㎡)',
  `fourNumber` int(11) DEFAULT NULL COMMENT '2011年—本年本月套数',
  `fourArea` double(15,2) DEFAULT NULL COMMENT '2011年—本年本月面积(万㎡)',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `district_report7`
-- ----------------------------
DROP TABLE IF EXISTS `district_report7`;
CREATE TABLE `district_report7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `dealNumber` int(11) DEFAULT NULL COMMENT '套数',
  `dealArea` double(15,2) DEFAULT NULL COMMENT '面积（m2）',
  `totalPrice` double(15,2) DEFAULT NULL COMMENT '总金额（万元）',
  `averagePrice` double(15,2) DEFAULT NULL COMMENT '平均价（元）',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `realestate_develop`
-- ----------------------------
DROP TABLE IF EXISTS `realestate_develop`;
CREATE TABLE `realestate_develop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `areaId` int(11) NOT NULL COMMENT '区县外键',
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `investHouse` double(15,2) DEFAULT '0.00' COMMENT '完成投资（万元）住宅',
  `investBusiness` double(15,2) DEFAULT '0.00' COMMENT '完成投资（万元）商业营业房',
  `investOffice` double(15,2) DEFAULT '0.00' COMMENT '完成投资（万元）办公房',
  `investOther` double(15,2) DEFAULT '0.00' COMMENT '完成投资（万元）其他房',
  `financialSourcingInland` double(15,2) DEFAULT '0.00' COMMENT '资金来源（万元）国内筹款',
  `financialSourcingForeign` double(15,2) DEFAULT '0.00' COMMENT '资金来源（万元）利用外资',
  `financialSourcingSelf` double(15,2) DEFAULT '0.00' COMMENT '资金来源（万元）自筹资金',
  `financialSourcingOther` double(15,2) DEFAULT '0.00' COMMENT '资金来源（万元）其他资金',
  `workingAreaHouse` double(15,2) DEFAULT '0.00' COMMENT '施工面积（㎡）住宅',
  `workingAreaBusiness` double(15,2) DEFAULT '0.00' COMMENT '施工面积（㎡）商业营业房',
  `workingAreaOffice` double(15,2) DEFAULT '0.00' COMMENT '施工面积（㎡）办公房',
  `workingAreaOther` double(15,2) DEFAULT '0.00' COMMENT '施工面积（㎡）其他房',
  `newAreaHouse` double(15,2) DEFAULT '0.00' COMMENT '新开工面积（㎡）住宅',
  `newAreaBusiness` double(15,2) DEFAULT '0.00' COMMENT '新开工面积（㎡）商业营业房',
  `newAreaOffice` double(15,2) DEFAULT '0.00' COMMENT '新开工面积（㎡）办公房',
  `newAreaOther` double(15,2) DEFAULT '0.00' COMMENT '新开工面积（㎡）其他房',
  `completeAreaHouse` double(15,2) DEFAULT '0.00' COMMENT '竣工面积（㎡）住宅',
  `completeAreaBusiness` double(15,2) DEFAULT '0.00' COMMENT '竣工面积（㎡）商业营业房',
  `completeAreaOffice` double(15,2) DEFAULT '0.00' COMMENT '竣工面积（㎡）办公房',
  `completeAreaOther` double(15,2) DEFAULT '0.00' COMMENT '竣工面积（㎡）其他房',
  `saledAreaHouse` double(15,2) DEFAULT '0.00' COMMENT '销售面积（㎡）住宅',
  `saledAreaBusiness` double(15,2) DEFAULT '0.00' COMMENT '销售面积（㎡）商业营业房',
  `saledAreaOffice` double(15,2) DEFAULT '0.00' COMMENT '销售面积（㎡）办公房',
  `saledAreaOther` double(15,2) DEFAULT '0.00' COMMENT '销售面积（㎡）其他房',
  `incomingHouse` double(15,2) DEFAULT '0.00' COMMENT '销售收入（万元）住宅',
  `incomingBusiness` double(15,2) DEFAULT '0.00' COMMENT '销售收入（万元）商业营业房',
  `incomingOffice` double(15,2) DEFAULT '0.00' COMMENT '销售收入（万元）办公房',
  `incomingOther` double(15,2) DEFAULT '0.00' COMMENT '销售收入（万元）其他房',
  `onsaleAreaHouse` double(15,2) DEFAULT '0.00' COMMENT '待售面积（㎡）住宅',
  `onsaleAreaBusiness` double(15,2) DEFAULT '0.00' COMMENT '待售面积（㎡）商业营业房',
  `onsaleAreaOffice` double(15,2) DEFAULT '0.00' COMMENT '待售面积（㎡）办公房',
  `onsaleAreaOther` double(15,2) DEFAULT '0.00' COMMENT '待售面积（㎡）其他房',
  PRIMARY KEY (`id`),
  KEY `realeastate_develop_recordYearMonth` (`recordYearMonth`),
  KEY `realestate_develop_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `qtip` varchar(100) DEFAULT NULL,
  `sort_num` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_role`;
CREATE TABLE `t_menu_role` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_money`
-- ----------------------------
DROP TABLE IF EXISTS `t_money`;
CREATE TABLE `t_money` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `operator` varchar(50) DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_money_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_money_list`;
CREATE TABLE `t_money_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money_id` bigint(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MONEY` (`money_id`),
  CONSTRAINT `FK_MONEY` FOREIGN KEY (`money_id`) REFERENCES `t_money` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `otherName` varchar(200) DEFAULT NULL,
  `userType` int(11) DEFAULT '3' COMMENT '1开发商，2房管局，3其它',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `area` VALUES ('1','桥东区','1','区域'),  ('2','桥西区','2','区域'),  ('3','高新区','3','区域'),  ('4','宣化区','4','区域'),  ('5','下花园区','5','区域'),  ('6','张北县','6','区域'),  ('7','康保县','7','区域'),  ('8','沽源县','8','区域'),  ('9','尚义县','9','区域'),  ('10','崇礼县','10','区域'),  ('11','万全县','11','区域'),  ('12','怀安县','12','区域'),  ('13','阳原县','13','区域'),  ('14','蔚  县','14','区域'),  ('15','赤城县','15','区域'),  ('16','宣化县','16','区域'),  ('17','怀来县','17','区域'),  ('18','涿鹿县','18','区域'),  ('19','察北管理区','19','区域'),  ('20','塞北管理区','20','区域');
INSERT INTO `district_report1` VALUES ('1','6','2013-10-25 21:14:18','2013-10-25 21:15:00','201310','桥东区开发商','201310201310','2013-10-25','小项目1','左卫','11','22.00','33.00','44.00','55.00'),  ('2','6','2013-10-25 21:20:37',NULL,'201310','we','qwe','2013-10-22','22','22','22','22.00','2.00','22.00','34.00'),  ('3','7','2013-10-27 11:02:49',NULL,'201310','q','q','2013-10-28','qq','qq','1','2.00','34.00','5.00','6.00');
INSERT INTO `district_report2_5` VALUES ('11','7','2013-10-27 11:04:16',NULL,'201310','1','1','2013-10-11','2013-10-11','11','1','1.00','1.00','1.00','2');
INSERT INTO `district_report6` VALUES ('3','7','2013-10-27 11:05:15',NULL,'201310','1','2.00','3','4.00','5','6.00','67','88.00');
INSERT INTO `district_report7` VALUES ('2','6','2013-10-25 21:18:34',NULL,'201310','2','2.00','34.00','45.00'),  ('3','7','2013-10-27 11:06:48',NULL,'201310','1','2.00','34.00','5.00');
INSERT INTO `realestate_develop` VALUES ('18','1','1','2013-09-04 20:48:26','2013-09-07 18:17:38','201309','1.00','2.00','1.00','22.00','1.00','2.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00'),  ('19','2','1','2013-09-04 20:48:48','2013-09-04 21:10:07','201309','12313.00','1.00','313.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00'),  ('20','3','1','2013-09-04 20:49:49',NULL,'201309','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00'),  ('21','4','1','2013-09-04 20:50:10',NULL,'201309','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00'),  ('22','5','1','2013-09-04 20:50:30',NULL,'201309','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00'),  ('23','6','1','2013-09-04 20:51:00',NULL,'201309','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00','1.00'),  ('24','7','1','2013-09-04 20:51:31',NULL,'201309','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00','3.00'),  ('25','8','1','2013-09-04 20:51:54',NULL,'201309','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00','5.00'),  ('26','9','1','2013-09-04 20:52:12',NULL,'201309','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00','6.00'),  ('27','10','1','2013-09-04 20:52:35',NULL,'201309','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00','7.00'),  ('28','11','1','2013-09-04 20:53:03',NULL,'201309','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00','8.00'),  ('29','12','1','2013-09-04 20:53:23',NULL,'201309','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00','9.00'),  ('30','13','1','2013-09-04 20:54:07',NULL,'201309','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00'),  ('31','14','1','2013-09-04 20:54:38',NULL,'201309','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00'),  ('32','15','1','2013-09-04 20:55:01',NULL,'201309','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00','11.00'),  ('33','16','1','2013-09-04 20:55:25',NULL,'201309','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00','15.00'),  ('34','17','1','2013-09-04 20:55:58',NULL,'201309','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00'),  ('36','1','3','2013-09-04 21:23:06',NULL,'201309','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00','16.00'),  ('37','2','3','2013-09-04 21:23:30',NULL,'201309','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','16.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00','20.00'),  ('38','1','1','2013-09-05 23:04:10','2013-09-05 23:05:22','201311','1.00','2.00','3.00','4.00','5.00','6.00','7.00','8.00','9.00','10.00','11.00','12.00','13.00','14.00','15.00','16.00','17.00','18.00','19.00','20.00','21.00','22.00','23.00','24.00','25.00','26.00','27.00','28.00','29.00','30.00','31.00','32.00'),  ('40','1','1','2013-09-08 12:07:55',NULL,'201401','1.00','1.00','2.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00','10.00');
INSERT INTO `t_menu` VALUES ('1','系统维护','images/plugin.gif','System','系统维护','1',NULL,'系统维护'),  ('2','用户管理','images/plugin.gif','User','用户管理','1','1','用户管理'),  ('3','角色管理','images/plugin.gif','Role','角色管理','2','1','角色管理'),  ('4','菜单管理','images/plugin.gif','Menu','菜单管理','3','1','菜单管理'),  ('7','开发商管理','images/plugin.gif','Develop','开发商报送','2',NULL,'开发商管理'),  ('8','开发商报送','images/plugin.gif','Develop','开发商报送','1','7','开发商报送'),  ('9','房地产开发企业汇总','images/plugin.gif','Develop','开发商统计','3',NULL,'房地产开发企业汇总'),  ('10','开发情况汇总表','images/plugin.gif','Develop1','开发情况表','1','9','开发情况汇总表'),  ('11','完成投资情况汇总表','images/plugin.gif','Develop2','完成投资情况汇总表','2','9','完成投资情况汇总表'),  ('12','资金来源情况汇总表','images/plugin.gif','Develop3','资金来源情况汇总表','3','9','资金来源情况汇总表'),  ('13','在建工程施工面积情况汇总表','images/plugin.gif','Develop4','在建工程施工面积情况汇总表','4','9','在建工程施工面积情况汇总表'),  ('14','新开工面积情况汇总表','images/plugin.gif','Develop5','新开工面积情况汇总表','5','9','新开工面积情况汇总表'),  ('15','竣工面积情况汇总表','images/plugin.gif','Develop6','竣工面积情况汇总表','6','9','竣工面积情况汇总表'),  ('16','销售面积情况汇总表','images/plugin.gif','Develop7','销售面积情况汇总表','7','9','销售面积情况汇总表'),  ('17','销售收入情况汇总表','images/plugin.gif','Develop8','销售收入情况汇总表','8','9','销售收入情况汇总表'),  ('18','待售面积情况汇总表','images/plugin.gif','Develop9','待售面积情况汇总表','9','9','待售面积情况汇总表'),  ('19','区县房管局报送管理','images/plugin.gif','DistrictReport1','区县单位报送管理','3',NULL,'区县房管局报送管理'),  ('20','颁发商品房预售许可证情况表','images/plugin.gif','DistrictReport1','颁发商品房预售许可证情况表','11','19','颁发商品房预售许可证情况表'),  ('21','商品住宅销售备案情况表','images/plugin.gif','DistrictReport2','商品住宅销售备案情况表','12','19','商品住宅销售备案情况表'),  ('22','商业营业房销售备案情况表','images/plugin.gif','DistrictReport3','商业营业房销售备案情况表','13','19','商业营业房销售备案情况表'),  ('23','办公房销售备案情况表','images/plugin.gif','DistrictReport4','办公房销售备案情况表','14','19','办公房销售备案情况表'),  ('24','其它房销售备案情况表','images/plugin.gif','DistrictReport5','其它房销售备案情况表','15','19','其它房销售备案情况表'),  ('25','在册私有住宅情况表','images/plugin.gif','DistrictReport6','在册私有住宅情况表','16','19','在册私有住宅情况表'),  ('26','二手住宅交易情况表','images/plugin.gif','DistrictReport7','二手住宅交易情况表','17','19','二手住宅交易情况表'),  ('27','区县房管局汇总','images/plugin.gif','DistrictCount','区县房管局汇总','20',NULL,'区县房管局汇总'),  ('28','颁发商品房预售许可证情况汇总表','images/plugin.gif','DistrictCount1','颁发商品房预售许可证情况汇总表','21','27','颁发商品房预售许可证情况汇总表'),  ('29','商品房销售情况汇总表','images/plugin.gif','DistrictCount2','商品房销售情况汇总表','22','27','商品房销售情况汇总表'),  ('30','登记在册私有住宅汇总表','images/plugin.gif','DistrictCount3','登记在册私有住宅汇总表','23','27','登记在册私有住宅汇总表'),  ('31','二手房住宅交易情况汇总表','images/plugin.gif','DistrictCount4','二手房住宅交易情况汇总表','24','27','二手房住宅交易情况汇总表'),  ('32','用户报送情况统计','images/plugin.gif','StatisticsDev','用户报送情况统计','30',NULL,'用户报送情况统计'),  ('33','开发商报送情况','images/plugin.gif','StatisticsDev1','开发商报送情况','31','32','开发商报送情况'),  ('34','颁发商品房预售许可证报送情况','images/plugin.gif','StatisticsDis1','颁发商品房预售许可证报送情况','32','32','颁发商品房预售许可证报送情况'),  ('35','商品住宅销售备案报送情况','images/plugin.gif','StatisticsDis2','商品住宅销售备案报送情况','33','32','商品住宅销售备案报送情况'),  ('36','商业营业房销售备案报送情况','images/plugin.gif','StatisticsDis3','商业营业房销售备案报送情况','34','32','商业营业房销售备案报送情况'),  ('37','办公房销售备案报送情况','images/plugin.gif','StatisticsDis4','办公房销售备案报送情况','35','32','办公房销售备案报送情况'),  ('38','其它房销售备案报送情况','images/plugin.gif','StatisticsDis5','其它房销售备案报送情况','36','32','其它房销售备案报送情况'),  ('39','在册私有住宅报送情况','images/plugin.gif','StatisticsDis6','在册私有住宅报送情况','37','32','在册私有住宅报送情况'),  ('40','二手住宅交易报送情况','images/plugin.gif','StatisticsDis7','二手住宅交易报送情况','38','32','二手住宅交易报送情况');
INSERT INTO `t_menu_role` VALUES ('1','-1'),  ('1','1'),  ('2','-1'),  ('2','1'),  ('3','-1'),  ('4','-1'),  ('7','-1'),  ('7','2'),  ('8','-1'),  ('8','2'),  ('9','-1'),  ('9','3'),  ('10','-1'),  ('10','3'),  ('11','-1'),  ('11','3'),  ('12','-1'),  ('12','3'),  ('13','-1'),  ('13','3'),  ('14','-1'),  ('14','3'),  ('15','-1'),  ('15','3'),  ('16','-1'),  ('16','3'),  ('17','-1'),  ('17','3'),  ('18','-1'),  ('18','3'),  ('19','-1'),  ('19','4'),  ('20','-1'),  ('20','4'),  ('21','-1'),  ('21','4'),  ('22','-1'),  ('22','4'),  ('23','-1'),  ('23','4'),  ('24','-1'),  ('24','4'),  ('25','-1'),  ('25','4'),  ('26','-1'),  ('26','4'),  ('27','-1'),  ('28','-1'),  ('29','-1'),  ('30','-1'),  ('31','-1'),  ('32','-1'),  ('33','-1'),  ('34','-1'),  ('35','-1'),  ('36','-1'),  ('37','-1'),  ('38','-1'),  ('39','-1'),  ('40','-1');
INSERT INTO `t_role` VALUES ('-1','超级管理员','超级管理员'),  ('1','系统管理员','系统管理员'),  ('2','开发商报送','开发商报送'),  ('3','开发商数据阅览','开发商数据阅览'),  ('4','房管局报送','房管局报送');
INSERT INTO `t_user` VALUES ('-1','superadmin','1','2013-08-30 01:06:00','222222222222','3'),  ('1','admin','1','2013-08-30 23:58:11','管理员','1'),  ('3','桥东区开发商','1','2013-08-30 20:37:06','111111','1'),  ('4','开发商阅览','1','2013-09-15 10:08:02','开发商阅览','3'),  ('5','管理员','1','2013-09-23 21:14:20','1','3'),  ('6','qdq','1','2013-10-25 21:10:56','桥东区','2'),  ('7','qxq','1','2013-10-25 21:12:50','桥西区','2'),  ('8','sa','a','2013-10-25 22:18:02','a','2'),  ('9','ss','1','2013-10-25 22:31:40','ss','2'),  ('10','11','1','2013-10-25 22:31:58','11','1'),  ('11','111','1','2013-10-25 22:32:52','1111','1'),  ('12','33','1','2013-10-25 22:37:56','33','1'),  ('13','gxq','1','2013-10-27 10:53:48','高新区','2');
INSERT INTO `t_user_role` VALUES ('-1','-1'),  ('1','1'),  ('3','2'),  ('4','3'),  ('5','1'),  ('6','4'),  ('7','4'),  ('8','4'),  ('9','4'),  ('10','4'),  ('11','4'),  ('12','4'),  ('13','4');
