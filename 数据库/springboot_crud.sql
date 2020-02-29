/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost
 Source Schema         : springboot_crud

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 29/02/2020 18:19:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '技术部');
INSERT INTO `department` VALUES (2, '业务部');
INSERT INTO `department` VALUES (3, '财务部');
INSERT INTO `department` VALUES (4, '人事部');
INSERT INTO `department` VALUES (5, '行政部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
  `user_sex` int(1) NOT NULL DEFAULT 1 COMMENT '用户性别，1男2女',
  `user_age` int(4) NULL DEFAULT NULL COMMENT '用户年龄',
  `user_birthday` datetime(0) NULL DEFAULT NULL COMMENT '用户生日',
  `user_department` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `created_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `created_by` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `update_by` varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  `version` int(11) UNSIGNED ZEROFILL NOT NULL DEFAULT 00000000000 COMMENT '乐观锁',
  `deleted` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '逻辑删除，1已删除0未删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1233316237170290688', 'CloudFly', 1, 23, '1997-06-25 00:00:00', 1, '2020-02-29 10:01:20', NULL, '2020-02-29 10:01:20', NULL, 00000000016, 0);
INSERT INTO `user` VALUES ('1233317041365168128', '赵六', 1, 25, '1995-07-12 00:00:00', 2, '2020-02-29 10:01:23', NULL, '2020-02-29 10:01:23', NULL, 00000000002, 0);
INSERT INTO `user` VALUES ('1233659057965916160', '张三', 2, 21, '1999-02-12 00:00:00', 3, '2020-02-29 10:01:25', NULL, '2020-02-29 10:01:25', NULL, 00000000000, 0);
INSERT INTO `user` VALUES ('1233659388388990976', '李四', 1, 18, '2002-02-28 00:00:00', 4, '2020-02-29 15:44:53', NULL, NULL, NULL, 00000000000, 0);
INSERT INTO `user` VALUES ('1233659691414872064', '王五', 2, 28, '1992-07-16 00:00:00', 5, '2020-02-29 15:46:05', NULL, NULL, NULL, 00000000000, 0);

SET FOREIGN_KEY_CHECKS = 1;
