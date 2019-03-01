/*
 Navicat Premium Data Transfer

 Source Server         : linux
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 39.108.67.248:3306
 Source Schema         : qrcode

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 02/03/2019 01:08:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `actId` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动主键',
  `actNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动编号',
  `actName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动主题',
  `actJoinNum` int(11) NULL DEFAULT NULL COMMENT '参与活动人数',
  `actState` int(255) NULL DEFAULT NULL COMMENT '活动状态(0,启动;1,进行;2,结束;3,废弃)',
  `actStartTime` datetime(0) NULL DEFAULT NULL COMMENT '活动开始时间',
  `actEndTime` datetime(0) NULL DEFAULT NULL COMMENT '活动结束时间',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`actId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `userNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for useractivity
-- ----------------------------
DROP TABLE IF EXISTS `useractivity`;
CREATE TABLE `useractivity`  (
  `userActId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户主键',
  `actId` int(11) NULL DEFAULT NULL COMMENT '活动主键',
  `userActState` int(11) NULL DEFAULT NULL COMMENT '签到状态(0,邀请;1,签到;2,迟到)',
  `userActTime` datetime(0) NULL DEFAULT NULL COMMENT '签到时间',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userActId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
