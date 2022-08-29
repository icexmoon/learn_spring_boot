/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.29 : Database - books
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `books`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `user_id` int NOT NULL,
  `type` tinyint NOT NULL DEFAULT '5' COMMENT '书籍类型 1艺术 2小说 3科幻 4历史 5其它',
  `extra` text NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`description`,`user_id`,`type`,`extra`,`del_flag`) values 
(1,'test','sdfdsfdsfsdf',1,5,'',0),
(2,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(3,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(4,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(5,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(6,'海底两万里','这是一本很好看的科幻小说',1,5,'',0),
(7,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(8,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(9,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(10,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(11,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(12,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(13,'自由与和平','自由与和平习近平',1,5,'',0),
(14,'自由与和平','自由与和平习近平',1,5,'',0),
(15,'自由与和平','自由与和平',1,5,'',0),
(16,'自由与和平','自由与和平',1,5,'',0),
(17,'自由与和平','自由与和平',1,1,'',0),
(18,'自由与和平','自由与和平',1,1,'{}',0),
(19,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(20,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(21,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(22,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(23,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(24,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(25,'自由与和平','自由与和平',1,1,'{\"iSBN\":\"111-222\",\"publisher\":\"海南出版社\"}',0),
(26,'自由与和平','自由与和平',1,1,'{\"iSBN\":\"111-222\",\"publisher\":\"海南出版社\"}',0);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`,`del_flag`) values 
(1,'book',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`del_flag`) values 
(1,'guest',0),
(2,'manager',0);

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `perm_id` int NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`perm_id`,`del_flag`) values 
(1,1,1,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `open_id` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信openId',
  `real_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名或昵称',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`open_id`,`real_name`,`icon`,`del_flag`) values 
(1,'icexmoon','123','','','',0),
(2,'lalala','123','','','',0),
(3,'dd6524a9b91ce3508e968d18a6be588b','','o05bW5rgwlafHnCJ1zpMBQWqtzww','魔芋红茶?','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIv3gkJ4uclR5rmJS9icoCt2zkFDiaoVkORDrkOiaMv1772IwnXUeicvDNjycOYoM7OeN82z5au2c46lw/132',0);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`,`del_flag`) values 
(1,1,1,0),
(2,1,2,0),
(3,2,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
