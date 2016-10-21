/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/10/19 14:15:03                          */
/*==============================================================*/


DROP TABLE IF EXISTS sys_data_group;

DROP TABLE IF EXISTS sys_data_item;

DROP TABLE IF EXISTS sys_log;

DROP TABLE IF EXISTS sys_login_status;

DROP TABLE IF EXISTS sys_organization;

DROP TABLE IF EXISTS sys_permission;

DROP TABLE IF EXISTS sys_permission_group;

DROP TABLE IF EXISTS sys_role;

DROP TABLE IF EXISTS sys_role_organization;

DROP TABLE IF EXISTS sys_role_permission;

DROP TABLE IF EXISTS sys_user;

DROP TABLE IF EXISTS sys_user_permission;

DROP TABLE IF EXISTS sys_user_role_organization;

/*==============================================================*/
/* Table: sys_data_group                                        */
/*==============================================================*/
CREATE TABLE sys_data_group
(
  id          BIGINT NOT NULL AUTO_INCREMENT,
  description VARCHAR(256) COMMENT '描述',
  parent_id   BIGINT COMMENT '父级id',
  name        VARCHAR(256) COMMENT '名称',
  is_final    INT             DEFAULT 1
  COMMENT '是否可删除',
  rank        BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by   BIGINT          DEFAULT 0
  COMMENT '创建人',
  update_by   BIGINT          DEFAULT 0
  COMMENT '更热人',
  status      TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_data_item                                         */
/*==============================================================*/
CREATE TABLE sys_data_item
(
  id                BIGINT NOT NULL AUTO_INCREMENT,
  sys_data_group_id BIGINT COMMENT '组id',
  key_value         VARCHAR(256) COMMENT '值',
  key_name          VARCHAR(256) COMMENT '名称',
  is_final          INT             DEFAULT 1
  COMMENT '是否可删除',
  rank              BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time       DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time       DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by         BIGINT          DEFAULT 0
  COMMENT '创建人',
  update_by         BIGINT          DEFAULT 0
  COMMENT '更热人',
  status            TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除,3:禁用账号',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
CREATE TABLE sys_log
(
  id          BIGINT NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  rank        BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by   BIGINT          DEFAULT 0
  COMMENT '创建人',
  update_by   BIGINT          DEFAULT 0
  COMMENT '更热人',
  status      TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  ip          VARCHAR(256) COMMENT '请求ip',
  user_id     VARCHAR(256) COMMENT '操作用户id',
  method      VARCHAR(2048) COMMENT '请求方法',
  param       TEXT COMMENT '请求参数',
  result      TEXT COMMENT '请求结果',
  duration    BIGINT COMMENT '持续时间',
  url         VARCHAR(512) COMMENT '请求url',
  user_agent  VARCHAR(512) COMMENT '请求ua标识',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_login_status                                      */
/*==============================================================*/
CREATE TABLE sys_login_status
(
  id                  BIGINT NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  sys_user_id         BIGINT COMMENT '用户id',
  session_id          VARCHAR(256) COMMENT 'session id',
  session_expires     DATETIME COMMENT 'session过期时间',
  sys_user_login_name VARCHAR(256) COMMENT '登录名',
  sys_user_zh_name    VARCHAR(256) COMMENT '中文名',
  last_login_time     DATETIME COMMENT '上一次登录时间',
  platform            TINYINT COMMENT '登录平台 1:web 2:android 3:ios',
  rank                BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time         DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time         DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by           BIGINT          DEFAULT 0
  COMMENT '创建人',
  update_by           BIGINT          DEFAULT 0
  COMMENT '更热人',
  status              TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_organization                                      */
/*==============================================================*/
CREATE TABLE sys_organization
(
  id          BIGINT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(256) COMMENT '名称',
  description VARCHAR(1024) COMMENT '描述',
  is_final    INT             DEFAULT 1
  COMMENT '是否可删除',
  parent_id   BIGINT          DEFAULT 0,
  rank        BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by   BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by   BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status      TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  full_name   VARCHAR(256) COMMENT '全称',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
CREATE TABLE sys_permission
(
  id                      BIGINT NOT NULL AUTO_INCREMENT,
  name                    VARCHAR(256) COMMENT '名称',
  description             VARCHAR(256) COMMENT '描述',
  code                    VARCHAR(256) COMMENT '编码',
  sys_permission_group_id BIGINT COMMENT '分组id',
  is_final                INT             DEFAULT 1
  COMMENT '是否可删除',
  rank                    BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time             DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time             DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by               BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by               BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status                  TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_permission_group                                  */
/*==============================================================*/
CREATE TABLE sys_permission_group
(
  id          BIGINT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(256) COMMENT '名称',
  description VARCHAR(256) COMMENT '描述',
  parent_id   BIGINT          DEFAULT 0
  COMMENT '父级id',
  is_final    INT             DEFAULT 1
  COMMENT '是否可删除',
  rank        BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by   BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by   BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status      TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
CREATE TABLE sys_role
(
  id          BIGINT NOT NULL AUTO_INCREMENT,
  description VARCHAR(1024),
  name        VARCHAR(256),
  rank        BIGINT          DEFAULT 0
  COMMENT '排序',
  is_final    INT             DEFAULT 1
  COMMENT '是否可删除',
  create_time DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by   BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by   BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status      TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_role_organization                                 */
/*==============================================================*/
CREATE TABLE sys_role_organization
(
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  sys_organization_id BIGINT COMMENT '组织id',
  sys_role_id         BIGINT COMMENT '角色id',
  parent_id           BIGINT COMMENT '父级id',
  name                VARCHAR(256),
  full_name           VARCHAR(256),
  description         VARCHAR(256),
  rank                BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time         DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time         DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by           BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by           BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status              TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  is_final            TINYINT COMMENT '是否能修改',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
CREATE TABLE sys_role_permission
(
  id                BIGINT NOT NULL AUTO_INCREMENT,
  sys_permission_id BIGINT COMMENT '权限id',
  sys_role_id       BIGINT COMMENT '角色id',
  rank              BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time       DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time       DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by         BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by         BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status            TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
CREATE TABLE sys_user
(
  id            BIGINT NOT NULL AUTO_INCREMENT,
  login_name    VARCHAR(256) COMMENT '登陆名',
  zh_name       VARCHAR(256) COMMENT '中文名',
  en_name       VARCHAR(256) COMMENT '英文名',
  sex           INT             DEFAULT 0
  COMMENT '性别',
  birth         VARCHAR(256) COMMENT '生日',
  email         VARCHAR(256) COMMENT '邮箱',
  phone         VARCHAR(256) COMMENT '电话',
  address       VARCHAR(1024) COMMENT '地址',
  password      VARCHAR(256) COMMENT '密码',
  password_salt VARCHAR(256) COMMENT '密码盐',
  rank          BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time   DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time   DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by     BIGINT          DEFAULT 0
  COMMENT '创建人',
  update_by     BIGINT          DEFAULT 0
  COMMENT '更热人',
  status        TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除,3:禁用账号',
  is_final      TINYINT COMMENT '是否能修改',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_user_permission                                   */
/*==============================================================*/
CREATE TABLE sys_user_permission
(
  id                BIGINT NOT NULL AUTO_INCREMENT,
  sys_user_id       BIGINT,
  sys_permission_id BIGINT,
  is_final          INT             DEFAULT 1,
  rank              BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time       DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time       DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by         BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by         BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status            TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: sys_user_role_organization                            */
/*==============================================================*/
CREATE TABLE sys_user_role_organization
(
  id                       BIGINT NOT NULL AUTO_INCREMENT,
  sys_user_id              BIGINT,
  sys_role_organization_id BIGINT,
  rank                     BIGINT          DEFAULT 0
  COMMENT '排序',
  create_time              DATETIME        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time              DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  create_by                BIGINT          DEFAULT 0
  COMMENT '创建人id',
  update_by                BIGINT          DEFAULT 0
  COMMENT '更新人id',
  status                   TINYINT         DEFAULT 1
  COMMENT '数据状态,1:正常,2:删除',
  is_final                 TINYINT COMMENT '是否能修改',
  PRIMARY KEY (id)
);

