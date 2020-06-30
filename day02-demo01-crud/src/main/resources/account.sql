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

 Date: 28/06/2020 15:44:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'lxh', '1980-02-01', '男', '东莞南城');
INSERT INTO `account` VALUES (2, '张三', '1982-03-21', '女', '广州增城');
INSERT INTO `account` VALUES (3, '李四', '1984-09-11', '男', '东莞厚街');
INSERT INTO `account` VALUES (4, '王五', '1989-04-17', '女', '江西上饶');

SET FOREIGN_KEY_CHECKS = 1;
