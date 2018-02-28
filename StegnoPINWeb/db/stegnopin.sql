/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.0.15-nt : Database - stegnopin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stegnopin` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `stegnopin`;

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `accountid` bigint(20) NOT NULL auto_increment,
  `userid` bigint(20) default NULL,
  `accountname` varchar(256) default NULL,
  `accountnumber` varchar(256) default NULL,
  `balance` double default NULL,
  PRIMARY KEY  (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `accounts` */

insert  into `accounts`(`accountid`,`userid`,`accountname`,`accountnumber`,`balance`) values (1,1,'Santhosh_Santhosh','SB123456789',3800),(2,2,'Chandramouliswaran_Chandramouliswaran','SB987654321',3300),(3,3,'Remya_Remya','SB2143658790',1700),(4,4,'Ashli_Ashli','SB1324567598',1300);

/*Table structure for table `sessionkeys` */

DROP TABLE IF EXISTS `sessionkeys`;

CREATE TABLE `sessionkeys` (
  `sessionkeyid` bigint(20) NOT NULL auto_increment,
  `userid` bigint(20) default NULL,
  `sessionkeys` varchar(1024) default NULL,
  PRIMARY KEY  (`sessionkeyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sessionkeys` */

/*Table structure for table `stegnopins` */

DROP TABLE IF EXISTS `stegnopins`;

CREATE TABLE `stegnopins` (
  `pinid` bigint(20) NOT NULL auto_increment,
  `userid` bigint(20) default NULL,
  `pin` varchar(256) default NULL,
  `otp` varchar(256) default NULL,
  PRIMARY KEY  (`pinid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stegnopins` */

insert  into `stegnopins`(`pinid`,`userid`,`pin`,`otp`) values (1,1,'2570','7128'),(2,2,'2570','7128'),(3,3,'2570','7128'),(4,4,'2470','7928');

/*Table structure for table `transactions` */

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
  `transactionid` bigint(20) NOT NULL auto_increment,
  `accountid` bigint(20) default NULL,
  `amount` double default NULL,
  `balance` double default NULL,
  `transactiontype` varchar(256) default NULL,
  `typeid` bigint(20) default NULL,
  `dateoftransaction` varchar(1024) default NULL,
  PRIMARY KEY  (`transactionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transactions` */

insert  into `transactions`(`transactionid`,`accountid`,`amount`,`balance`,`transactiontype`,`typeid`,`dateoftransaction`) values (7,1,1000,1000,'credit',1,'1518686923871'),(8,1,2000,3000,'credit',1,'1518686931949'),(9,1,500,2500,'debit',1,'1518686937335'),(10,2,1000,1000,'credit',2,'1518686982984'),(11,2,500,1500,'credit',2,'1518686989419'),(12,2,200,1300,'debit',2,'1518686996471'),(13,1,1000,1500,'debit',2,'1518687037481'),(14,2,1000,2300,'credit',1,'1518687037527'),(15,3,1000,1000,'credit',3,'1518690534737'),(16,3,2000,3000,'credit',3,'1518690540374'),(17,3,500,2500,'debit',3,'1518690546684'),(18,3,1000,1500,'debit',2,'1518690582066'),(19,2,1000,3300,'credit',3,'1518690582115'),(20,1,2000,3500,'credit',1,'1519451032467'),(21,1,500,3000,'debit',1,'1519451038408'),(22,1,200,2800,'debit',3,'1519451062829'),(23,3,200,1700,'credit',1,'1519451062879'),(24,4,2000,2000,'credit',4,'1519451398433'),(25,4,500,2500,'credit',4,'1519451408702'),(26,4,200,2300,'debit',4,'1519451415362'),(27,4,1000,1300,'debit',1,'1519451430883'),(28,1,1000,3800,'credit',4,'1519451430922');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userinfoid` bigint(20) NOT NULL auto_increment,
  `userid` bigint(20) default NULL,
  `name` varchar(256) default NULL,
  `primarynumber` varchar(256) default NULL,
  `secondarynumber` varchar(256) default NULL,
  PRIMARY KEY  (`userinfoid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userinfoid`,`userid`,`name`,`primarynumber`,`secondarynumber`) values (1,1,'Chandramouliswaran','8547582085','8281978227'),(2,3,'Remya k','8547582083','8281978227'),(3,4,'Ashli','8547582083','8281978227');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` bigint(20) NOT NULL auto_increment,
  `username` varchar(256) default NULL,
  `password` varchar(256) default NULL,
  `emailid` varchar(256) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`userid`,`username`,`password`,`emailid`) values (1,'Santhosh','redhat123','santhosh1982.r@gmail.com'),(2,'Chandramouliswaran','redhat123','santhosh1982.r@gmail.com'),(3,'Remya','redhat123','remykr228@gmail.com'),(4,'Ashli','redhat123','ashli@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
