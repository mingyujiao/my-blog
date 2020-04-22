/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.248.128
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 192.168.248.128:3306
 Source Schema         : remango_blog

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 22/04/2020 14:15:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `article_id` bigint(0) NOT NULL COMMENT '文章id',
  `author` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `article_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `type` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别',
  `summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '摘要',
  `categories` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `likes` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `last_article_id` bigint(0) NULL DEFAULT NULL COMMENT '上一篇文章id',
  `next_article_id` bigint(0) NULL DEFAULT NULL COMMENT '写一篇文章id',
  `timeline` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间轴',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `visits` int(0) NULL DEFAULT NULL COMMENT '访问数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 1, '1', '1123123', '123', '123', '123', '123', 123, 123, 123, '123', '2020-04-21 01:03:21', '2020-04-21 13:03:25', 12);
INSERT INTO `article` VALUES (2, 1587482871095, 'root', 'WODEDIYIPIANBOKE', '原创', 'WODE DI YI PIAN BO KE', 'Java,JavaScript,Database', 'WODE DI YI PIAN BO KE', NULL, NULL, NULL, '2020-04-21', '2020-04-21 15:27:51', '2020-04-21 15:27:51', NULL);
INSERT INTO `article` VALUES (3, 1587482917419, 'root', 'WODEDIYIPIANBOKE', '原创', 'WODE DI YI PIAN BO KE', 'Java,JavaScript,Database', 'WODE DI YI PIAN BO KE', NULL, NULL, NULL, '2020-04-21', '2020-04-21 15:28:37', '2020-04-21 15:28:37', NULL);
INSERT INTO `article` VALUES (4, 1587482974729, 'root', 'WODEDIYIPIANBOKE', '原创', 'WODE DI YI PIAN BO KE 加点儿中文乱码不看啊', 'Java,JavaScript,Server', 'WODE DI YI PIAN BO KE 加点儿中文乱码不看啊', NULL, NULL, NULL, '2020-04-21', '2020-04-21 15:29:36', '2020-04-21 15:29:37', NULL);
INSERT INTO `article` VALUES (5, 1587483024409, 'root', 'WODEDIYIPIANBOKE', '原创', 'WODE DI YI PIAN BO KE 加点儿中文乱码不看啊', 'Java,JavaScript,Server', 'WODE DI YI PIAN BO KE 加点儿中文乱码不看啊', NULL, NULL, NULL, '2020-04-21', '2020-04-21 15:30:24', '2020-04-21 15:30:24', NULL);

-- ----------------------------
-- Table structure for article_tags
-- ----------------------------
DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `article_id` bigint(0) NOT NULL COMMENT '文章id',
  `tags_id` bigint(0) NOT NULL COMMENT '标签id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tags
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip地址',
  `operation` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户操作',
  `method` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '处理方法名',
  `params` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求参数',
  `spend_time` int(0) NOT NULL COMMENT '处理时间，单位毫秒',
  `create_time` datetime(0) NOT NULL COMMENT '记录时间',
  `response_args` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返回信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 392954 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `message` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言',
  `create_time` datetime(0) NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '留言' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_board
-- ----------------------------
INSERT INTO `message_board` VALUES (1, '测试', '测试留言001', '2020-04-20 23:35:24');
INSERT INTO `message_board` VALUES (4, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:27');
INSERT INTO `message_board` VALUES (5, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:43');
INSERT INTO `message_board` VALUES (6, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:43');
INSERT INTO `message_board` VALUES (7, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:45');
INSERT INTO `message_board` VALUES (8, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:47');
INSERT INTO `message_board` VALUES (9, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:47');
INSERT INTO `message_board` VALUES (10, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:48');
INSERT INTO `message_board` VALUES (11, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:49');
INSERT INTO `message_board` VALUES (12, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:50');
INSERT INTO `message_board` VALUES (13, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:50');
INSERT INTO `message_board` VALUES (14, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:51');
INSERT INTO `message_board` VALUES (15, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:51');
INSERT INTO `message_board` VALUES (16, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:52');
INSERT INTO `message_board` VALUES (17, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:52');
INSERT INTO `message_board` VALUES (18, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:53');
INSERT INTO `message_board` VALUES (19, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:53');
INSERT INTO `message_board` VALUES (20, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:54');
INSERT INTO `message_board` VALUES (21, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:54');
INSERT INTO `message_board` VALUES (22, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:54');
INSERT INTO `message_board` VALUES (23, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:55');
INSERT INTO `message_board` VALUES (24, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:55');
INSERT INTO `message_board` VALUES (25, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:52:57');
INSERT INTO `message_board` VALUES (26, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:35');
INSERT INTO `message_board` VALUES (27, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:36');
INSERT INTO `message_board` VALUES (28, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:36');
INSERT INTO `message_board` VALUES (29, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:37');
INSERT INTO `message_board` VALUES (30, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:37');
INSERT INTO `message_board` VALUES (31, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:38');
INSERT INTO `message_board` VALUES (32, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:38');
INSERT INTO `message_board` VALUES (33, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:39');
INSERT INTO `message_board` VALUES (34, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试留言001', '2020-04-20 15:53:41');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `role` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'super_admin');
INSERT INTO `role` VALUES (2, 'ordinary_admin');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `tags_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标签',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for timeline
-- ----------------------------
DROP TABLE IF EXISTS `timeline`;
CREATE TABLE `timeline`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `timeline` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间轴',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '时间轴' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of timeline
-- ----------------------------
INSERT INTO `timeline` VALUES (1, '2017-01-12', '2020-04-22 11:14:27');
INSERT INTO `timeline` VALUES (2, '2020-04-21', '2020-04-22 11:14:56');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `avatar_url` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像url',
  `personal_profile` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人简介',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 385930 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (385929, 'root', '290d8939645c64010b99305ce9e52a43c66210fd3bb17a96', '18207131787', 'male', '994857325@qq.com', 'https://remango-blog.oss-cn-shenzhen.aliyuncs.com/public/blogArticles/2019-03-26/1553599138.png', NULL, '2020-04-20 07:02:18', '2020-04-20 07:02:18');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_id` bigint(0) NOT NULL COMMENT '文章id',
  `role_id` bigint(0) NOT NULL COMMENT '标签id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
