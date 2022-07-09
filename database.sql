/*
SQLyog Enterprise - MySQL GUI v6.56
MySQL - 5.0.67-community-nt : Database - trust_based
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`trust_based` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `trust_based`;

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `username` text,
  `task` text,
  `date` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*Table structure for table request */

DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (
  `id` int(11) NOT NULL auto_increment,
  `sendfrom` text,
  `sendfrom_id` text,
  `sendto` text,
  `sendto_id` text,
  `status` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



/*Table structure for table share */

DROP TABLE IF EXISTS `share`;

CREATE TABLE `share` (
  `id` int(11) NOT NULL auto_increment,
  `username` text,
  `uid` text,
  `videoname` text,
  `vid` text,
  `fid` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



/*Table structure for table user */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` text,
  `email` text,
  `mobile` text,
  `address` text,
  `username` text,
  `password` text,
  `status` text,
  `trust` float default 60.0,
  `reject` int default 0,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user` VALUES (null,'test user 1','test1@123','123','home','test1','test1','waiting',0.0),(null,'test user 2','test2@123','123','home','test2','test2','waiting',0.0),(null,'test user 3','test3@123','123','home','test3','test3','waiting',0.0),(null,'test user 4','test4@123','123','home','test4','test4','waiting',0.0);

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `id` int(11) NOT NULL auto_increment,
  `fname` text,
  `dt` text,
  `likes` varchar(45) default NULL,
  `dislikes` varchar(45) default NULL,
  `shares` int(11) default 0,
   `source` text default null,
   `status` varchar(10) default null;
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_input`;

CREATE TABLE `userinput` (
  `id` int(11) NOT NULL auto_increment,
   `username` text,
  `fname` text,
  `likes` int(3),
  `dislikes` int(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
