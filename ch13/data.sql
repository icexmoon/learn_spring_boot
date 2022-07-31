/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.21-MariaDB : Database - books
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `books`;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`description`,`user_id`) values (1,'test','sdfdsfdsfsdf',1),(2,'lalala','zhe shi yi ben hao shu.',1),(3,'lalala','zhe shi yi ben hao shu.',1),(4,'lalala','zhe shi yi ben hao shu.',1),(5,'lalala','zhe shi yi ben hao shu.',1);

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`) values (1,'book');

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'guest'),(2,'manager');

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`perm_id`) values (1,1,1);

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`) values (1,'icexmoon','123'),(2,'lalala','123');

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(2,1,2),(3,2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
