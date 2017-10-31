/*
SQLyog - Free MySQL GUI v5.02
Host - 5.0.19-nt : Database - milkplant
*********************************************************************
Server version : 5.0.19-nt
*/


create database if not exists `milkplant`;

USE `milkplant`;

/*Table structure for table `ordertab` */

DROP TABLE IF EXISTS `ordertab`;

CREATE TABLE `ordertab` (
  `OrderId` int(20) NOT NULL auto_increment,
  `ProductName` varchar(50) default NULL,
  `UserId` int(10) default NULL,
  `NumberOfProduct` int(10) default NULL,
  `TotalPrice` int(10) default NULL,
  PRIMARY KEY  (`OrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ordertab` */

insert into `ordertab` values 
(300,'1 litre milk',200,10,100),
(301,'1 litre milk',200,10,540),
(302,'1 litre milk',200,2,108),
(303,'1 litre milk',200,2,108),
(304,'1 litre milk',200,0,0),
(305,'1 litre milk',200,-2,-108),
(306,'1 litre milk',200,0,0),
(307,'1 litre milk',200,1,54),
(308,'1 litre milk',200,2,108),
(309,'1 litre milk',200,3,0);

/*Table structure for table `plant` */

DROP TABLE IF EXISTS `plant`;

CREATE TABLE `plant` (
  `PlantId` int(20) NOT NULL auto_increment,
  `PlantName` varchar(50) default NULL,
  `PlantLocation` varchar(50) default NULL,
  `PlantCity` varchar(50) default NULL,
  PRIMARY KEY  (`PlantId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `plant` */

insert into `plant` values 
(1,'Gagan milk plant','kharadi','pune'),
(2,'Shibu milk plant','viman nagar','pune'),
(3,'abc shop','kharadi','pune'),
(4,'Munni shop','Kharadi','pune'),
(5,'Munni shop','Kharadi','pune'),
(6,'Munni shop','Kharadi','pune'),
(7,'Munni shop','Kharadi','pune'),
(8,'shivam shop','viman nagar','pune'),
(9,'shivam shop','viman nagar','pune'),
(10,'shivam shop','viman nagar','pune');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `ProductName` varchar(30) NOT NULL,
  `ProductPrice` int(10) default NULL,
  `ProductCategory` varchar(30) default NULL,
  `plantName` varchar(30) default NULL,
  PRIMARY KEY  (`ProductName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert into `product` values 
('1 kg of cheese',400,'cheese','pune'),
('1 kg peda',100,'peda','pune'),
('1 litre milk',30,'milk','pune'),
('10gm cheese',45,'chesse','pune'),
('500 gms milk',20,'milk','pune'),
('500 gmsof curd',200,'curd','pune');

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `StockId` int(10) NOT NULL auto_increment,
  `ProductName` varchar(30) default NULL,
  `StockTotalNumber` int(20) default NULL,
  PRIMARY KEY  (`StockId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stock` */

insert into `stock` values 
(100,'1 litre milk',5),
(101,'1 kg peda',10),
(102,'500 gms milk',30),
(103,'500 gms peda',35),
(104,'10gm cheese',10),
(105,'500 gmsof curd',20);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserId` int(11) NOT NULL auto_increment,
  `UserName` varchar(20) default NULL,
  `UserPassword` varchar(10) default NULL,
  `UserType` varchar(20) default NULL,
  `UserAddress` varchar(30) default NULL,
  `UserMobile` int(20) default NULL,
  PRIMARY KEY  (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert into `user` values 
(200,'krishna','krishna','admin','kharadi,pune',997335312),
(202,'govind','govind','clerk','vimanNagar,pune',5678994),
(203,'gagan','gagan','clerk','kalyani nagar',89766543),
(204,'priya','priya','clerk','gtaskjk',87634),
(205,'supriya','supriya','clerk','jannat',87254225),
(206,'rahul','rahun','clerk','khradi',9866777),
(207,'papau','papau','clerk','krishna chauk',88888888),
(208,'rahul','','clerk','pune',966568549),
(209,'fdgg','fdgg','clerk','fdfds',545),
(210,'you','you','clerk','pune',98767),
(211,'sunita','sunita','customer','bangalore',8764984),
(212,'sunita','sunita','customer','bangalore',8764984);
