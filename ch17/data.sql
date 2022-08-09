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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `books`;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`description`,`user_id`,`type`) values 
(1,'test','sdfdsfdsfsdf',1,5),
(2,'lalala','zhe shi yi ben hao shu.',1,5),
(3,'lalala','zhe shi yi ben hao shu.',1,5),
(4,'lalala','zhe shi yi ben hao shu.',1,5),
(5,'lalala','zhe shi yi ben hao shu.',1,5),
(6,'海底两万里','这是一本很好看的科幻小说',1,5),
(7,'八十天环游地球','凡尔纳写的一本科幻小说',2,5),
(8,'八十天环游地球','凡尔纳写的一本科幻小说',2,5),
(9,'八十天环游地球','凡尔纳写的一本科幻小说',2,5),
(10,'八十天环游地球','凡尔纳写的一本科幻小说',2,5),
(11,'lalala','zhe shi yi ben hao shu.',1,5),
(12,'lalala','zhe shi yi ben hao shu.',1,5),
(13,'自由与和平','自由与和平习近平',1,5),
(14,'自由与和平','自由与和平习近平',1,5),
(15,'自由与和平','自由与和平',1,5),
(16,'自由与和平','自由与和平',1,5),
(17,'自由与和平','自由与和平',1,1);

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`) values 
(1,'book');

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values 
(1,'guest'),
(2,'manager');

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`perm_id`) values 
(1,1,1);

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`open_id`) values 
(1,'icexmoon','123',''),
(2,'lalala','123','');

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values 
(1,1,1),
(2,1,2),
(3,2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
