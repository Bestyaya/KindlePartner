/*
Navicat MySQL Data Transfer

Source Server         : asdweaf
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : kindledb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-12-18 17:59:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `ASIN` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `imageFile` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9787302291077', '算法竞赛入门经典——训练指南', '01.jpg', '清华大学出版社', '52.8', '1');
INSERT INTO `book` VALUES ('9787302476580', '算法竞赛入门经典——习题与解答', '02.jpg', '清华大学出版社', '55.1', '2');
INSERT INTO `book` VALUES ('9787302356288', ' 算法竞赛入门经典（第2版）', '03.jpg', '清华大学出版社', '35.6', '3');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key1` (`user_id`),
  KEY `key2` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('22', '2', '2', '1', '9');
INSERT INTO `cart` VALUES ('25', '5', '2', '1', '1');
INSERT INTO `cart` VALUES ('26', '5', '1', '1', '1');
INSERT INTO `cart` VALUES ('27', '1', '1', '1', '2');
INSERT INTO `cart` VALUES ('29', '1', '2', '0', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `vip` int(11) DEFAULT NULL,
  `balance` double(255,0) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '123456', '2', '1177', '1', '123@163.com', '1');
INSERT INTO `user` VALUES ('dcr', '123456', '0', '800', '2', '123@163.com', '1');
INSERT INTO `user` VALUES ('321', '123', '0', '800', '5', '123@163.com', '1');
