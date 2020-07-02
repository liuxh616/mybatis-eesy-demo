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

 Date: 02/07/2020 11:46:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role`  (
  `accountid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`roleid`, `accountid`) USING BTREE,
  INDEX `fk_ref_account`(`accountid`) USING BTREE,
  CONSTRAINT `fk_ref_account` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ref_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES (1, 1);
INSERT INTO `account_role` VALUES (1, 3);
INSERT INTO `account_role` VALUES (2, 3);
INSERT INTO `account_role` VALUES (6, 2);
INSERT INTO `account_role` VALUES (8, 2);

SET FOREIGN_KEY_CHECKS = 1;
