/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-28 10:20:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `userid` int(5) DEFAULT NULL,
  `pid` int(5) DEFAULT NULL,
  `pnum` int(5) DEFAULT NULL,
  `totalprice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `fk_cart_user` (`userid`),
  KEY `fk_cart_product` (`pid`),
  CONSTRAINT `fk_cart_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `fk_cart_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '1', '1', '10', '499.00');
INSERT INTO `cart` VALUES ('6', '1', '1', '5', '5008.00');
INSERT INTO `cart` VALUES ('10', '1', '1', '8', '4799.92');
INSERT INTO `cart` VALUES ('11', '1', '1', '10', '5999.90');
INSERT INTO `cart` VALUES ('12', '4', '1', '5', '2999.95');
INSERT INTO `cart` VALUES ('13', '4', '2', '6', '41999.94');
INSERT INTO `cart` VALUES ('14', '1', '2', '1', '6999.99');
INSERT INTO `cart` VALUES ('15', '1', '7', '2', '299.98');
INSERT INTO `cart` VALUES ('16', '1', '4', '50', '499.50');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mid` int(5) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'root', 'root');

-- ----------------------------
-- Table structure for order0
-- ----------------------------
DROP TABLE IF EXISTS `order0`;
CREATE TABLE `order0` (
  `oid` int(5) NOT NULL AUTO_INCREMENT,
  `ordernum` varchar(50) DEFAULT NULL,
  `userid` int(5) DEFAULT NULL,
  `orderaddress` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `ordername` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  UNIQUE KEY `ordernum` (`ordernum`),
  KEY `fk_order_user` (`userid`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order0
-- ----------------------------
INSERT INTO `order0` VALUES ('1', '59468521354', '1', '阿拉斯加', '16249852164', '王小明');
INSERT INTO `order0` VALUES ('8', '55654', '1', '111111111111', '111111111', '1111111111');
INSERT INTO `order0` VALUES ('9', '123456789', '1', '马达加斯加', '16849523684', '王胖子');
INSERT INTO `order0` VALUES ('10', '8888888888', '1', '香港铜锣湾', '1508226654', '刘德华');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `odid` int(5) NOT NULL AUTO_INCREMENT,
  `oid` int(5) DEFAULT NULL,
  `pid` int(5) DEFAULT NULL,
  `pnum` int(5) DEFAULT NULL,
  PRIMARY KEY (`odid`),
  KEY `fk_orderdetail_order0` (`oid`),
  KEY `fk_orderdetail_product` (`pid`),
  CONSTRAINT `fk_orderdetail_order0` FOREIGN KEY (`oid`) REFERENCES `order0` (`oid`),
  CONSTRAINT `fk_orderdetail_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('3', '1', '1', '10');
INSERT INTO `orderdetail` VALUES ('8', '8', '2', '1');
INSERT INTO `orderdetail` VALUES ('9', '9', '7', '2');
INSERT INTO `orderdetail` VALUES ('10', '10', '4', '50');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(5) NOT NULL AUTO_INCREMENT,
  `pname` varchar(20) DEFAULT NULL,
  `pdesc` varchar(100) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `stock` int(10) DEFAULT NULL,
  `ptid` int(5) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `fk_product_protype` (`ptid`),
  CONSTRAINT `fk_product_protype` FOREIGN KEY (`ptid`) REFERENCES `protype` (`ptid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'NIKE跑鞋', 'Nike 耐克官方 NIKE TANJUN 男子运动休闲鞋 812654', '599.99', '4999', '1');
INSERT INTO `product` VALUES ('2', '神州笔记本', '开机贼快！流畅运行各种游戏！！！！', '6999.99', '50000', '2');
INSERT INTO `product` VALUES ('3', '泡面', '康师傅老谭酸菜牛肉面！！！', '5.50', '99999', '3');
INSERT INTO `product` VALUES ('4', '杭州小笼包', '好吃！！！！！！！！！！！！！！！！！！！！！！！！！！', '9.99', '99999', '3');
INSERT INTO `product` VALUES ('5', '晨光横格本', '用了晨光文具，妈妈再也不用担心我的学习！', '2.50', '999999', '4');
INSERT INTO `product` VALUES ('6', '索尼相机', '用索尼相机，留下精彩瞬间！！！', '9999.99', '5000', '2');
INSERT INTO `product` VALUES ('7', '天津十八街大麻花', '天津名吃，旅游必买，妈妈们最喜欢！！！', '149.99', '999999', '3');

-- ----------------------------
-- Table structure for protype
-- ----------------------------
DROP TABLE IF EXISTS `protype`;
CREATE TABLE `protype` (
  `ptid` int(5) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ptid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of protype
-- ----------------------------
INSERT INTO `protype` VALUES ('1', '服饰');
INSERT INTO `protype` VALUES ('2', '数码');
INSERT INTO `protype` VALUES ('3', '食品');
INSERT INTO `protype` VALUES ('4', '学习');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `emil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jiaoxingbo', '123', '18233862436', '123');
INSERT INTO `user` VALUES ('2', 'wangxiaoming', '123', '15643289742', '222@w.com');
INSERT INTO `user` VALUES ('3', 'xiaohong', '123', '13485621486', '456@iii.com');
INSERT INTO `user` VALUES ('4', 'zhaotiezhu', '123', '14895623157', '951@oo.com');
