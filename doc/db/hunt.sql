/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : hunt

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-11-15 19:23:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_data_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_group`;
CREATE TABLE `sys_data_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级id',
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更热人',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_data_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_item`;
CREATE TABLE `sys_data_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_data_group_id` bigint(20) DEFAULT NULL COMMENT '组id',
  `key_value` varchar(256) DEFAULT NULL COMMENT '值',
  `key_name` varchar(256) DEFAULT NULL COMMENT '名称',
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更热人',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除,3:禁用账号',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_ip_forbidden
-- ----------------------------
DROP TABLE IF EXISTS `sys_ip_forbidden`;
CREATE TABLE `sys_ip_forbidden` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更热人',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  `expire_time` datetime DEFAULT NULL COMMENT '到期时间',
  `description` varchar(256) DEFAULT NULL COMMENT '说明',
  `ip` varchar(256) DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更热人',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  `ip` varchar(256) DEFAULT NULL COMMENT '请求ip',
  `user_id` varchar(256) DEFAULT NULL COMMENT '操作用户id',
  `method` varchar(2048) DEFAULT NULL COMMENT '请求方法',
  `param` text COMMENT '请求参数',
  `result` text COMMENT '请求结果',
  `duration` bigint(20) DEFAULT NULL COMMENT '持续时间',
  `url` varchar(512) DEFAULT NULL COMMENT '请求url',
  `user_agent` varchar(512) DEFAULT NULL COMMENT '请求ua',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2722 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_login_status
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_status`;
CREATE TABLE `sys_login_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sys_user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `session_id` varchar(256) DEFAULT NULL COMMENT 'session id',
  `session_expires` datetime DEFAULT NULL COMMENT 'session过期时间',
  `sys_user_login_name` varchar(256) DEFAULT NULL COMMENT '登录名',
  `sys_user_zh_name` varchar(256) DEFAULT NULL COMMENT '中文名',
  `last_login_time` datetime DEFAULT NULL COMMENT '上一次登录时间',
  `platform` tinyint(4) DEFAULT NULL COMMENT '登录平台 1:web 2:android 3:ios',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更热人',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `parent_id` bigint(20) DEFAULT '0',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  `full_name` varchar(256) DEFAULT NULL COMMENT '全称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `code` varchar(256) DEFAULT NULL COMMENT '编码',
  `sys_permission_group_id` bigint(20) DEFAULT NULL COMMENT '分组id',
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_permission_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_group`;
CREATE TABLE `sys_permission_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父级id',
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(1024) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `is_final` int(11) DEFAULT '1' COMMENT '是否可删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_organization`;
CREATE TABLE `sys_role_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_organization_id` bigint(20) DEFAULT NULL COMMENT '组织id',
  `sys_role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级id',
  `name` varchar(256) DEFAULT NULL,
  `full_name` varchar(256) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  `is_final` tinyint(4) DEFAULT NULL COMMENT '是否能修改',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `sys_role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(256) DEFAULT NULL COMMENT '登陆名',
  `zh_name` varchar(256) DEFAULT NULL COMMENT '中文名',
  `en_name` varchar(256) DEFAULT NULL COMMENT '英文名',
  `sex` int(11) DEFAULT '0' COMMENT '性别',
  `birth` varchar(256) DEFAULT NULL COMMENT '生日',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(256) DEFAULT NULL COMMENT '电话',
  `address` varchar(1024) DEFAULT NULL COMMENT '地址',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `password_salt` varchar(256) DEFAULT NULL COMMENT '密码盐',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更热人',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除,3:禁用账号',
  `is_final` tinyint(4) DEFAULT NULL COMMENT '是否能修改',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_permission`;
CREATE TABLE `sys_user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_user_id` bigint(20) DEFAULT NULL,
  `sys_permission_id` bigint(20) DEFAULT NULL,
  `is_final` int(11) DEFAULT '1',
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_organization`;
CREATE TABLE `sys_user_role_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_user_id` bigint(20) DEFAULT NULL,
  `sys_role_organization_id` bigint(20) DEFAULT NULL,
  `rank` bigint(20) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `status` tinyint(4) DEFAULT '1' COMMENT '数据状态,1:正常,2:删除',
  `is_final` tinyint(4) DEFAULT NULL COMMENT '是否能修改',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
