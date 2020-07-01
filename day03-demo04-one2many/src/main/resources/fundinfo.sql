/*
 Navicat Premium Data Transfer

 Source Server         : .-windows
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.110.46.11:3306
 Source Schema         : eesy_mybatis

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 01/07/2020 15:46:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fundinfo
-- ----------------------------
DROP TABLE IF EXISTS `fundinfo`;
CREATE TABLE `fundinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NULL DEFAULT NULL,
  `avimoney` decimal(18, 2) NULL DEFAULT NULL,
  `rechargemoney` decimal(18, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fundinfo
-- ----------------------------
INSERT INTO `fundinfo` VALUES (1, 1, 10000.00, 0.00);
INSERT INTO `fundinfo` VALUES (2, 1, 20000.00, 500.00);
INSERT INTO `fundinfo` VALUES (3, 1, 50000.00, 100.00);
INSERT INTO `fundinfo` VALUES (4, 8, 100000.00, 0.00);
INSERT INTO `fundinfo` VALUES (5, 12, 1000.00, 0.00);
INSERT INTO `fundinfo` VALUES (6, 3, 50.00, 50.00);
INSERT INTO `fundinfo` VALUES (7, 4, 1000.00, 50.00);
INSERT INTO `fundinfo` VALUES (8, 6, 0.00, 0.00);

SET FOREIGN_KEY_CHECKS = 1;
