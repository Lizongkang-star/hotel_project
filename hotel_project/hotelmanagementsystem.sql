/*
Navicat MySQL Data Transfer

Source Server         : lzk
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : hotelmanagementsystem

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-12-15 19:50:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `admin_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `admin_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '可用于拓展，比如一个最高级管理员，多个普通管理员',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'admin', 'admin', 'BigFish', '男', '经理');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识符',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录帐号，不可更改且唯一',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户真实姓名',
  `customer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户电话号码',
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户身份证号',
  `customer_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`customer_id`) USING BTREE,
  KEY `Account` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'user', 'user', '李宗康', '12444788532', '11462344478214', 'male');
INSERT INTO `customer` VALUES ('2', 'wym1234', 'hello', '王叶明', '13365412245', '330015201906065412', 'male');
INSERT INTO `customer` VALUES ('3', 'lql1234', 'admin', '林晴岚', '18355921456', '330652199515086610', 'male');
INSERT INTO `customer` VALUES ('4', 'yhf1234', 'admin222', '杨浩峰', '1366355841', '413605200808083654', 'male');
INSERT INTO `customer` VALUES ('6', 'xqh1234', 'dalianmao', '肖启航', '13864522356', '321546198012023365', 'male');
INSERT INTO `customer` VALUES ('7', 'zjh1234', 'sunny', 'zjh', '13824511250', '330015201906065365', 'male');
INSERT INTO `customer` VALUES ('8', 'lzk', '123456', '李宗康', '1234', '45', null);
INSERT INTO `customer` VALUES ('9', 'wym123', '12345678', '王叶明', '13556730677', '440881199722851', 'male');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标志号',
  `employee_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工登录帐号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工姓名',
  `employee_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '员工1', '12345678', 'lzk', '男');
INSERT INTO `employee` VALUES ('2', '员工2', '12345678', 'wym', '男');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `location_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '酒店的地理信息',
  `traffic_Info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '酒店的交通信息',
  `hotel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '酒店名称',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '酒店简介(多家酒店可建立多个数据库进行处理)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('广东省东莞市南城区西湖路', '公交29路可以直达！', 'EZO大酒店', '南城地区最舒适最实惠的酒店之一');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `record_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录生成时间，可以是预定时间或者是入住时间',
  `start_time` datetime DEFAULT NULL COMMENT '入住开始时间',
  `end_time` datetime DEFAULT NULL,
  `customer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单用户',
  `customer_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户身份证号',
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '入住人，可有多个',
  `orders_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单状态（在住、预定等）',
  `orders_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '房间类型，如单人间、双人间等等',
  `orders_cost` double(10,2) DEFAULT NULL COMMENT '消费额',
  PRIMARY KEY (`orders_id`) USING BTREE,
  KEY `index1` (`customer_id`) USING BTREE,
  KEY `index2` (`room_number`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`room_number`) REFERENCES `room` (`room_number`) ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '403', '2019-12-15 19:47:48', '2019-11-28 00:00:00', '2019-12-26 00:00:00', 'lzk', '45', '李宗康', '在住', '双人间', '300.00');
INSERT INTO `orders` VALUES ('2', '403', '2019-12-13 09:57:04', '2019-11-30 00:00:00', '2019-12-01 00:00:00', 'wym123', '440881199722851', '王叶明', '预定', '双人间', '300.00');
INSERT INTO `orders` VALUES ('3', '201', '2019-12-15 19:08:09', '2019-11-29 15:55:00', '2019-12-15 19:08:10', 'yhf1234', '413605200808083654', '曾俊鸿', '已退房', '单人间', null);
INSERT INTO `orders` VALUES ('4', '502', '2019-12-13 09:57:11', '2019-11-28 00:00:00', '2019-11-29 00:00:00', 'lzk', '45', '李宗康', '预定', '双人间', '300.00');
INSERT INTO `orders` VALUES ('9', '302', '2019-12-15 19:48:51', '2019-12-28 00:00:00', '2019-12-29 00:00:00', 'user', '11462344478214', '李宗康', '预定', null, null);
INSERT INTO `orders` VALUES ('10', '502', '2019-12-15 19:49:07', '2019-12-19 00:00:00', '2019-12-24 00:00:00', 'user', '11462344478214', '李宗康', '预定', '双人间', '300.00');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `question_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息内容',
  `sender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发送者帐号',
  `send_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '消息发送时间',
  `question_response` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复者帐号(客户处应该始终显示客服这两个字)',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '房间号',
  `room_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述房间的类型',
  `room_floor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼层，一般以房间号第一位即可',
  `room_direction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '朝向',
  `room_square` double(10,2) DEFAULT NULL COMMENT '房间面积',
  `can_addbed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '能否加床',
  `bed_num` int(11) DEFAULT NULL COMMENT '床位数',
  `room_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其他描述',
  `room_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '房间状态，可以实现自动修改（可用，在住，预定，维修等）',
  PRIMARY KEY (`room_id`) USING BTREE,
  KEY `Number` (`room_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '302', '单人间', '3', '朝南', '30.00', '可加床', '1', '房间宽敞明亮有阳台', '维修中');
INSERT INTO `room` VALUES ('2', '201', '双人间', '2', '朝北', '50.00', '不可加床', '2', '房间宽敞明亮有阳台', '维修中');
INSERT INTO `room` VALUES ('3', '403', '豪华', '2', '全方位', '80.00', '不可加床', '3', '房间宽敞明亮有阳台', '可用');
INSERT INTO `room` VALUES ('4', '502', '总统套房', '5', '全透明', '120.00', '不可加床', '4', '房间宽敞明亮有阳台', '可用');

-- ----------------------------
-- Table structure for roomcategory
-- ----------------------------
DROP TABLE IF EXISTS `roomcategory`;
CREATE TABLE `roomcategory` (
  `roomcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `roomcategory_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roomcategory_price` double(10,2) DEFAULT NULL,
  `total_number` int(11) DEFAULT NULL,
  `roomcategory_score` double(10,2) DEFAULT NULL,
  `locked_number` int(11) DEFAULT NULL,
  `inuse_roomnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`roomcategory_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of roomcategory
-- ----------------------------
INSERT INTO `roomcategory` VALUES ('1', '单人间', '150.00', '5', '9.00', '0', '0');
INSERT INTO `roomcategory` VALUES ('2', '双人间', '300.00', '5', '8.00', '0', '0');
INSERT INTO `roomcategory` VALUES ('3', '三人间', '500.00', '5', '9.80', '2', '0');
INSERT INTO `roomcategory` VALUES ('4', '大床房', '350.00', '5', '9.00', '0', null);
INSERT INTO `roomcategory` VALUES ('5', '豪华套房', '6000.00', '2', '10.00', '0', null);
