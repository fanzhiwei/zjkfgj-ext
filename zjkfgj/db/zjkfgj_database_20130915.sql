# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : kika


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `zjkfgj`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `zjkfgj`;

#
# Structure for the `area` table : 
#

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `areaName` varchar(20) NOT NULL,
  `displayOrder` int(11) NOT NULL DEFAULT '0',
  `descriptin` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `district_report1` table : 
#

CREATE TABLE `district_report1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `developerName` varchar(200) DEFAULT NULL COMMENT '开发企业名称\r\n\r\n开发企业名称',
  `licenceNo` varchar(50) DEFAULT NULL COMMENT '预售许可证编号',
  `licenceDate` datetime DEFAULT NULL COMMENT '预售许可证颁发时间',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `district_report2_5` table : 
#

CREATE TABLE `district_report2_5` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  `developerName` varchar(200) DEFAULT NULL COMMENT '开发企业名称',
  `projectName` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `startTime` datetime DEFAULT NULL COMMENT '开工时间',
  `completeTime` datetime DEFAULT NULL COMMENT '竣工时间',
  `location` varchar(300) DEFAULT NULL COMMENT '房屋座落地',
  `houseNumber` int(11) DEFAULT NULL COMMENT '套数',
  `area` double(15,2) DEFAULT NULL COMMENT '面积',
  `totalPrice` double(15,2) DEFAULT NULL COMMENT '合同总价（万元）',
  `averagePrice` double(15,2) DEFAULT NULL COMMENT '平均价（元）',
  `category` varchar(50) DEFAULT NULL COMMENT '种类，区分商品房、住宅等类别',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `district_report6` table : 
#

CREATE TABLE `district_report6` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `district_report7` table : 
#

CREATE TABLE `district_report7` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户表外键',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `recordYearMonth` int(11) NOT NULL COMMENT '记录的年月',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `recordYearMonth` (`recordYearMonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `realestate_develop` table : 
#

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
  KEY `realestate_develop_areaId` (`areaId`),
  KEY `realestate_develop_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

#
# Structure for the `t_menu` table : 
#

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Structure for the `t_menu_role` table : 
#

CREATE TABLE `t_menu_role` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `t_money` table : 
#

CREATE TABLE `t_money` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `operator` varchar(50) DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for the `t_money_list` table : 
#

CREATE TABLE `t_money_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money_id` bigint(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MONEY` (`money_id`),
  CONSTRAINT `FK_MONEY` FOREIGN KEY (`money_id`) REFERENCES `t_money` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `t_role` table : 
#

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for the `t_user` table : 
#

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Structure for the `t_user_role` table : 
#

CREATE TABLE `t_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `area` table  (LIMIT 0,500)
#

INSERT INTO `area` (`id`, `areaName`, `displayOrder`, `descriptin`) VALUES 
  (1,'桥东区',1,'区域'),
  (2,'桥西区',2,'区域'),
  (3,'高新区',3,'区域'),
  (4,'宣化区',4,'区域'),
  (5,'下花园区',5,'区域'),
  (6,'张北县',6,'区域'),
  (7,'康保县',7,'区域'),
  (8,'沽源县',8,'区域'),
  (9,'尚义县',9,'区域'),
  (10,'崇礼县',10,'区域'),
  (11,'万全县',11,'区域'),
  (12,'怀安县',12,'区域'),
  (13,'阳原县',13,'区域'),
  (14,'蔚  县',14,'区域'),
  (15,'赤城县',15,'区域'),
  (16,'宣化县',16,'区域'),
  (17,'怀来县',17,'区域'),
  (18,'涿鹿县',18,'区域'),
  (19,'察北管理区',19,'区域'),
  (20,'塞北管理区',20,'区域');
COMMIT;

#
# Data for the `realestate_develop` table  (LIMIT 0,500)
#

INSERT INTO `realestate_develop` (`id`, `areaId`, `userId`, `createTime`, `modifyTime`, `recordYearMonth`, `investHouse`, `investBusiness`, `investOffice`, `investOther`, `financialSourcingInland`, `financialSourcingForeign`, `financialSourcingSelf`, `financialSourcingOther`, `workingAreaHouse`, `workingAreaBusiness`, `workingAreaOffice`, `workingAreaOther`, `newAreaHouse`, `newAreaBusiness`, `newAreaOffice`, `newAreaOther`, `completeAreaHouse`, `completeAreaBusiness`, `completeAreaOffice`, `completeAreaOther`, `saledAreaHouse`, `saledAreaBusiness`, `saledAreaOffice`, `saledAreaOther`, `incomingHouse`, `incomingBusiness`, `incomingOffice`, `incomingOther`, `onsaleAreaHouse`, `onsaleAreaBusiness`, `onsaleAreaOffice`, `onsaleAreaOther`) VALUES 
  (18,1,1,'2013-09-04 20:48:26','2013-09-07 18:17:38',201309,1.00,2.00,1.00,22.00,1.00,2.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00),
  (19,2,1,'2013-09-04 20:48:48','2013-09-04 21:10:07',201309,12313.00,1.00,313.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00),
  (20,3,1,'2013-09-04 20:49:49',NULL,201309,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00),
  (21,4,1,'2013-09-04 20:50:10',NULL,201309,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00),
  (22,5,1,'2013-09-04 20:50:30',NULL,201309,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00),
  (23,6,1,'2013-09-04 20:51:00',NULL,201309,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00),
  (24,7,1,'2013-09-04 20:51:31',NULL,201309,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00),
  (25,8,1,'2013-09-04 20:51:54',NULL,201309,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00),
  (26,9,1,'2013-09-04 20:52:12',NULL,201309,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00),
  (27,10,1,'2013-09-04 20:52:35',NULL,201309,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00,7.00),
  (28,11,1,'2013-09-04 20:53:03',NULL,201309,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00,8.00),
  (29,12,1,'2013-09-04 20:53:23',NULL,201309,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00),
  (30,13,1,'2013-09-04 20:54:07',NULL,201309,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00),
  (31,14,1,'2013-09-04 20:54:38',NULL,201309,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00),
  (32,15,1,'2013-09-04 20:55:01',NULL,201309,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00,11.00),
  (33,16,1,'2013-09-04 20:55:25',NULL,201309,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00,15.00),
  (34,17,1,'2013-09-04 20:55:58',NULL,201309,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00),
  (36,1,3,'2013-09-04 21:23:06',NULL,201309,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00,16.00),
  (37,2,3,'2013-09-04 21:23:30',NULL,201309,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,16.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00,20.00),
  (38,1,1,'2013-09-05 23:04:10','2013-09-05 23:05:22',201311,1.00,2.00,3.00,4.00,5.00,6.00,7.00,8.00,9.00,10.00,11.00,12.00,13.00,14.00,15.00,16.00,17.00,18.00,19.00,20.00,21.00,22.00,23.00,24.00,25.00,26.00,27.00,28.00,29.00,30.00,31.00,32.00),
  (40,1,1,'2013-09-08 12:07:55',NULL,201401,1.00,1.00,2.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00);
COMMIT;

#
# Data for the `t_menu` table  (LIMIT 0,500)
#

INSERT INTO `t_menu` (`id`, `name`, `image`, `url`, `qtip`, `sort_num`, `parent_id`, `description`) VALUES 
  (1,'系统维护','images/plugin.gif','System','系统维护',1,NULL,'系统维护'),
  (2,'用户管理','images/plugin.gif','User','用户管理',1,1,'用户管理'),
  (3,'角色管理','images/plugin.gif','Role','角色管理',2,1,'角色管理'),
  (4,'菜单管理','images/plugin.gif','Menu','菜单管理',3,1,'菜单管理'),
  (7,'开发商管理','images/plugin.gif','Develop','开发商报送',2,NULL,'开发商管理'),
  (8,'开发商报送','images/plugin.gif','Develop','开发商报送',1,7,'开发商报送'),
  (9,'房地产开发企业汇总','images/plugin.gif','Develop','开发商统计',3,NULL,'房地产开发企业汇总'),
  (10,'开发情况汇总表','images/plugin.gif','Develop1','开发情况表',1,9,'开发情况汇总表'),
  (11,'完成投资情况汇总表','images/plugin.gif','Develop2','完成投资情况汇总表',2,9,'完成投资情况汇总表'),
  (12,'资金来源情况汇总表','images/plugin.gif','Develop3','资金来源情况汇总表',3,9,'资金来源情况汇总表'),
  (13,'在建工程施工面积情况汇总表','images/plugin.gif','Develop4','在建工程施工面积情况汇总表',4,9,'在建工程施工面积情况汇总表'),
  (14,'新开工面积情况汇总表','images/plugin.gif','Develop5','新开工面积情况汇总表',5,9,'新开工面积情况汇总表'),
  (15,'竣工面积情况汇总表','images/plugin.gif','Develop6','竣工面积情况汇总表',6,9,'竣工面积情况汇总表'),
  (16,'销售面积情况汇总表','images/plugin.gif','Develop7','销售面积情况汇总表',7,9,'销售面积情况汇总表'),
  (17,'销售收入情况汇总表','images/plugin.gif','Develop8','销售收入情况汇总表',8,9,'销售收入情况汇总表'),
  (18,'待售面积情况汇总表','images/plugin.gif','Develop9','待售面积情况汇总表',9,9,'待售面积情况汇总表');
COMMIT;

#
# Data for the `t_menu_role` table  (LIMIT 0,500)
#

INSERT INTO `t_menu_role` (`menu_id`, `role_id`) VALUES 
  (1,0),
  (1,1),
  (2,0),
  (2,1),
  (3,0),
  (4,0),
  (7,0),
  (7,2),
  (8,0),
  (8,2),
  (9,0),
  (9,3),
  (10,0),
  (10,3),
  (11,0),
  (11,3),
  (12,0),
  (12,3),
  (13,0),
  (13,3),
  (14,0),
  (14,3),
  (15,0),
  (15,3),
  (16,0),
  (16,3),
  (17,0),
  (17,3),
  (18,0),
  (18,3);
COMMIT;

#
# Data for the `t_role` table  (LIMIT 0,500)
#

INSERT INTO `t_role` (`id`, `name`, `description`) VALUES 
  (0,'超级管理员','超级管理员');
UPDATE `t_role` SET `id`=0 WHERE `id`=LAST_INSERT_ID();
INSERT INTO `t_role` (`id`, `name`, `description`) VALUES 
  (1,'系统管理员','系统管理员'),
  (2,'开发商报送','开发商报送'),
  (3,'开发商数据阅览','开发商数据阅览');
COMMIT;

#
# Data for the `t_user` table  (LIMIT 0,500)
#

INSERT INTO `t_user` (`id`, `name`, `password`, `create_date`) VALUES 
  (0,'superadmin','1','2013-08-30 01:06:00');
UPDATE `t_user` SET `id`=0 WHERE `id`=LAST_INSERT_ID();
INSERT INTO `t_user` (`id`, `name`, `password`, `create_date`) VALUES 
  (1,'admin','1','2013-08-30 23:58:11'),
  (3,'桥东区开发商','1','2013-08-30 20:37:06'),
  (4,'开发商阅览','1','2013-09-15 10:08:02');
COMMIT;

#
# Data for the `t_user_role` table  (LIMIT 0,500)
#

INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES 
  (0,0),
  (1,1),
  (3,2),
  (4,3);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;