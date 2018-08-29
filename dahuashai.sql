SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coin_translog
-- ----------------------------
-- DROP TABLE IF EXISTS `coin_translog`;
CREATE TABLE `coin_translog`  (
  `coin_translog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易流水ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `account_type` int(11) NOT NULL COMMENT '账户类型.1-金币,2-积分;3-红包',
  `trans_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '交易类型',
  `trans_type_sub` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '交易子类型',
  `trans_flag` int(11) NOT NULL COMMENT '交易方向.1-收入,2-支出',
  `trans_amount` int(11) NULL DEFAULT 0 COMMENT '交易金额. 金币数',
  `balance` int(11) NULL DEFAULT NULL COMMENT '余额',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `award_percent_invitor` int(11) NULL DEFAULT NULL COMMENT '抽佣百分比  20表示20%',
  `award_from_user_id` bigint(20) NULL DEFAULT NULL COMMENT '获得额外佣金的来源用户(好友)',
  `trans_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '交易时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`coin_translog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '金币交易流水' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fix_share
-- ----------------------------
-- DROP TABLE IF EXISTS `fix_share`;
CREATE TABLE `fix_share`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `share_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '分享文本',
  `share_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '分享图片链接',
  `share_type` int(4) NULL DEFAULT 0 COMMENT '分享类型 1-夺冠 2-复活 3-拉新',
  `status` int(4) NULL DEFAULT 0 COMMENT '0-无效  1-有效',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_break_against_records
-- ----------------------------
-- DROP TABLE IF EXISTS `game_break_against_records`;
CREATE TABLE `game_break_against_records`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `game_model_id` bigint(20) NULL DEFAULT NULL COMMENT '游戏模式id',
  `game_model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏模式key',
  `game_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏场次编号',
  `game_round` smallint(6) NULL DEFAULT NULL COMMENT '关卡数',
  `score` int(11) NULL DEFAULT NULL COMMENT '得分',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `is_win` tinyint(1) NULL DEFAULT NULL COMMENT '是否赢',
  `is_game_end` tinyint(1) NULL DEFAULT NULL COMMENT '是否提前结束比赛(一方玩家提前死亡)',
  `against_user_id` bigint(20) NULL DEFAULT NULL COMMENT '对手id',
  `against_nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '对手昵称',
  `against_head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '对手头像',
  `against_score` int(11) NULL DEFAULT NULL COMMENT '对手得分',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3543 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '闯关游戏用户对战记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_break_records
-- ----------------------------
-- DROP TABLE IF EXISTS `game_break_records`;
CREATE TABLE `game_break_records`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `game_model_id` bigint(11) NOT NULL COMMENT '游戏ID',
  `game_model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏key',
  `game_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '比赛场次编号',
  `game_filed_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '赛场名称',
  `total_round` int(11) NOT NULL COMMENT '闯关总关数',
  `contest_num` int(11) NULL DEFAULT 0 COMMENT '参赛人次',
  `pass_through_num` int(11) NULL DEFAULT NULL COMMENT '通关人次',
  `per_award` int(11) NULL DEFAULT 0 COMMENT '单份奖金金额(单位为分)',
  `game_status` smallint(2) NULL DEFAULT 0 COMMENT '比赛状态：0.未开赛 1.比赛中 2.比赛结束',
  `start_time` timestamp(0) NULL DEFAULT NULL COMMENT '本轮次开始时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '本轮次结束时间',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '闯关比赛记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_break_recover_cost
-- ----------------------------
-- DROP TABLE IF EXISTS `game_break_recover_cost`;
CREATE TABLE `game_break_recover_cost`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `game_model_id` bigint(11) NOT NULL COMMENT '游戏id',
  `game_model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏key',
  `game_round` int(4) NULL DEFAULT NULL COMMENT '游戏关卡数',
  `cost_type` smallint(2) NULL DEFAULT NULL COMMENT '复活费用类型：1.金币 2.积分 3.红包',
  `cost_num` int(11) NULL DEFAULT NULL COMMENT '费用',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `create_id` bigint(11) NULL DEFAULT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '闯关游戏复活费用信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_break_recover_records
-- ----------------------------
-- DROP TABLE IF EXISTS `game_break_recover_records`;
CREATE TABLE `game_break_recover_records`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `game_model_id` bigint(11) NULL DEFAULT NULL COMMENT '游戏id',
  `game_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏编码',
  `game_round` int(4) NULL DEFAULT NULL COMMENT '游戏关卡数',
  `cost_type` smallint(2) NULL DEFAULT NULL COMMENT '复活费用类型：1.金币 2.积分 3.红包',
  `cost_num` int(11) NULL DEFAULT NULL COMMENT '费用',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '闯关游戏用户复活记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_break_user_qualify
-- ----------------------------
-- DROP TABLE IF EXISTS `game_break_user_qualify`;
CREATE TABLE `game_break_user_qualify`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `game_model_id` bigint(11) NOT NULL COMMENT '游戏模式id',
  `game_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '游戏场次编号',
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `head_url` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `pass_times` int(5) NULL DEFAULT NULL COMMENT '该场游戏通关次数',
  `is_award` tinyint(1) NULL DEFAULT 0 COMMENT '是否已颁发：0.否 1.是',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '闯关游戏用户领奖资格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_break_user_records
-- ----------------------------
-- DROP TABLE IF EXISTS `game_break_user_records`;
CREATE TABLE `game_break_user_records`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(11) UNSIGNED NOT NULL COMMENT '游戏id',
  `game_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '比赛场次编号',
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `head_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `recovery_times` int(11) NULL DEFAULT NULL COMMENT '复活次数',
  `pass_max_level` smallint(2) NULL DEFAULT 1 COMMENT '达到的最高关数',
  `is_pass` tinyint(1) NULL DEFAULT NULL COMMENT '是否通关',
  `score` int(11) NULL DEFAULT NULL COMMENT '得分',
  `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注说明',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户比赛记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_config
-- ----------------------------
-- DROP TABLE IF EXISTS `game_config`;
CREATE TABLE `game_config`  (
  `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `game_model_id` bigint(11) NOT NULL COMMENT '游戏模式ID',
  `game_model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏模式key',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `alias_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '别名',
  `type_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类型key',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代码',
  `type_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '值',
  `unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '单位',
  `sort` int(5) UNSIGNED NULL DEFAULT NULL COMMENT '排序',
  `status` smallint(2) NULL DEFAULT NULL COMMENT '状态: 1=正常 0=无效',
  `create_id` bigint(11) NULL DEFAULT NULL COMMENT '创建人id',
  `update_id` bigint(11) NULL DEFAULT NULL COMMENT '最后修改人id',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '游戏配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_fight_records
-- ----------------------------
-- DROP TABLE IF EXISTS `game_fight_records`;
CREATE TABLE `game_fight_records`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '场次编号',
  `contest_num` int(11) NULL DEFAULT 0 COMMENT '参赛人数',
  `pk_times` int(11) NULL DEFAULT 0 COMMENT 'pk次数',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_fight_user_record
-- ----------------------------
-- DROP TABLE IF EXISTS `game_fight_user_record`;
CREATE TABLE `game_fight_user_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '游戏场次编号',
  `user_id` bigint(20) NOT NULL COMMENT 'userId',
  `head_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `play_times` int(11) NULL DEFAULT NULL COMMENT '玩的次数',
  `win_times` int(11) NULL DEFAULT NULL COMMENT '赢的次数',
  `invite_times` int(11) NULL DEFAULT NULL COMMENT '邀战次数',
  `success_invite_times` int(11) NULL DEFAULT NULL COMMENT '成功邀战次数',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`, `user_id`, `game_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_model
-- ----------------------------
-- DROP TABLE IF EXISTS `game_model`;
CREATE TABLE `game_model`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `game_model_key` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏模式key',
  `game_model_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '游戏模式名称',
  `icon_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏图标icon',
  `bg_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '背景图片',
  `icon_url_x` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏图标icon_适配iphoneX大图',
  `bg_img_x` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '背景图片_适配iphoneX大图',
  `sort` smallint(4) NULL DEFAULT NULL COMMENT '排序',
  `status` smallint(2) NULL DEFAULT 1 COMMENT '状态：0.无效 1.正常',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除：0.否 1.是',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '游戏备注说明',
  `extentStr1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '扩展预留字段1',
  `extentStr2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '扩展预留字段2',
  `create_id` bigint(11) NULL DEFAULT NULL COMMENT '创建人ID(对应后台系统用户表)',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `updator_id` bigint(11) NULL DEFAULT NULL COMMENT '更新人ID(对应后台系统用户表)',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '游戏模式信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_rank_record
-- ----------------------------
-- DROP TABLE IF EXISTS `game_rank_record`;
CREATE TABLE `game_rank_record`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `game_model_id` bigint(11) NOT NULL COMMENT '游戏模式id',
  `game_model_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '游戏模式key',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `user_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `score` int(11) NULL DEFAULT NULL COMMENT '得分',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '排行游戏模式记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_single_prize
-- ----------------------------
-- DROP TABLE IF EXISTS `game_single_prize`;
CREATE TABLE `game_single_prize`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `min_point` int(11) NOT NULL COMMENT '最低分数',
  `max_point` int(11) NOT NULL COMMENT '最高分数',
  `prize_coin` int(11) NULL DEFAULT NULL COMMENT '奖励金币',
  `deleted` smallint(1) NULL DEFAULT NULL COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '弹球单机模式奖励配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for game_user_win_percent
-- ----------------------------
-- DROP TABLE IF EXISTS `game_user_win_percent`;
CREATE TABLE `game_user_win_percent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `win_percent_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '赢概率的code(对应game_config的code)',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp(),
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_withdraw_order
-- ----------------------------
-- DROP TABLE IF EXISTS `pay_withdraw_order`;
CREATE TABLE `pay_withdraw_order`  (
  `withdraw_order_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '充值金币订单流水号;SeqUUIDUtil产生，唯一',
  `withdraw_order_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '充值金币展示订单号;yyyyMMdd24HHmmss + COIND + 业务订单流水号后三位',
  `order_type` int(11) NULL DEFAULT NULL COMMENT '订单类型;1--一般提现;',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '支付用户ID',
  `openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信openid',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付用户名;支付者趣电玩用户名',
  `withdraw_coin_amount` bigint(11) NULL DEFAULT NULL COMMENT '提现金币数量',
  `withdraw_amount` bigint(11) NULL DEFAULT NULL COMMENT '提现人民币金额',
  `order_amount` bigint(11) NULL DEFAULT NULL COMMENT '订单金额',
  `channel_acquiring_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付流水号;支付平台收单号',
  `channel_pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付完成时间;买家最近一次支付的操作时间。支付成功后，记录支付平台返回时间',
  `channel_pay_errorcode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付平台支付失败时返回的错误代码',
  `channel` int(11) NULL DEFAULT NULL COMMENT '支付平台返回的支付渠道.1--支付宝;2--微信app;3-微信小程序',
  `channel_pay_amount` int(11) NULL DEFAULT NULL COMMENT '支付平台返回的支付金额',
  `order_state` int(11) NULL DEFAULT NULL COMMENT '订单状态;0--待审核 1--待支付;2--支付成功;3--订单取消',
  `order_state_sub` int(11) NULL DEFAULT NULL COMMENT '订单状态为1：11--支付失败取消;为3：31--支付金额与订单金额相等;32—支付金额与订单金额不等',
  `order_flag` int(11) NULL DEFAULT 1 COMMENT '对用户展示的标示0--已删除;1--有效(默认)',
  `order_desc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单描述',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `client_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户IP',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '订单创建时间',
  `valid_time` timestamp(0) NOT NULL COMMENT '订单有效时间',
  `finish_time` timestamp(0) NOT NULL COMMENT '订单完成时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`withdraw_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '支付提现订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for redpack_withdraw_application
-- ----------------------------
-- DROP TABLE IF EXISTS `redpack_withdraw_application`;
CREATE TABLE `redpack_withdraw_application`  (
  `application_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '申请ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `withdraw_amount` int(11) NULL DEFAULT NULL COMMENT '申请提现金额',
  `withdraw_state` smallint(6) NULL DEFAULT NULL COMMENT '提现状态.0-新申请,1-审核通过,2-已经支付',
  `alipay_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付宝账号',
  `alipay_realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付宝认证的实名',
  `operator_id` int(11) NULL DEFAULT NULL COMMENT '操作人Id',
  `operator_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作人名',
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '红包提现申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
-- DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务分组名称',
  `cron_expression` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '触发时间表达式',
  `is_concurrent` tinyint(1) NULL DEFAULT NULL COMMENT '是否并发',
  `is_springBean` tinyint(1) NULL DEFAULT NULL COMMENT '是否是Spring中定义的Bean,如果不是需要设置全类名,对应class_name字段需要配置',
  `target_object` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行任务类名称',
  `target_method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行任务类方法名称',
  `clazz_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '全类名，前置条件，当is_springBean为0时',
  `arguments` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '执行任务方法参数',
  `jobStatus` smallint(2) NULL DEFAULT 0 COMMENT '任务状态：-1.执行失败 0.就绪 1.执行中 2.执行成功',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务描述',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13660 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统任务信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for schedule_job_fail_log
-- ----------------------------
-- DROP TABLE IF EXISTS `schedule_job_fail_log`;
CREATE TABLE `schedule_job_fail_log`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `job_id` bigint(11) NULL DEFAULT NULL COMMENT '任务ID',
  `job_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务组名称',
  `reason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '任务失败原因',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '任务失败日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for share_info
-- ----------------------------
-- DROP TABLE IF EXISTS `share_info`;
CREATE TABLE `share_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `share_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '分享内容',
  `content_type` int(4) NULL DEFAULT 0 COMMENT '内容类型  1-文本 2-图片',
  `share_type` int(4) NULL DEFAULT 0 COMMENT '分享类型 1-夺冠 2-复活 3-拉新',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_classseq
-- ----------------------------
-- DROP TABLE IF EXISTS `system_classseq`;
CREATE TABLE `system_classseq`  (
  `CLASS_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CLASS_SEQ` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`CLASS_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
-- DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项名称',
  `param_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'key唯一标志',
  `param_value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '值',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注说明',
  `status` smallint(2) NULL DEFAULT 0 COMMENT '状态：0.有效 1.无效',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_datadict
-- ----------------------------
-- DROP TABLE IF EXISTS `system_datadict`;
CREATE TABLE `system_datadict`  (
  `DATA_ID` bigint(20) NOT NULL,
  `DATA_CODE_TYPE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `DATA_CODE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `DATA_DESP` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `DATA_REMARK` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `DATA_ORDERS` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`DATA_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_distribution
-- ----------------------------
-- DROP TABLE IF EXISTS `system_distribution`;
CREATE TABLE `system_distribution`  (
  `distr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发布Id',
  `app_type` smallint(6) NULL DEFAULT NULL COMMENT 'app类型.1-ios;2-android;3-小程序;4-h5',
  `version` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '版本',
  `app_store_id` smallint(6) NULL DEFAULT NULL COMMENT '应用商店ID.1-安智;2-搜狗;3-西西软件;4-同步推;5-机锋;6-百度;7-360;8-应用宝.',
  `distr_state` smallint(6) NULL DEFAULT NULL COMMENT '发布状态.1-未发布;2已发布',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`distr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '应用发布状态' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_functions
-- ----------------------------
-- DROP TABLE IF EXISTS `system_functions`;
CREATE TABLE `system_functions`  (
  `FUNC_CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `FUNC_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `FUNC_PARENT_NODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `TREE_CLS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `FUNC_QTIP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `CMD_URI` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `FUNC_ID` bigint(20) NOT NULL,
  `FUNC_PARENT_CODE` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `FUNC_TYPE` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `IS_LEAF_NODE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`FUNC_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_logs
-- ----------------------------
-- DROP TABLE IF EXISTS `system_logs`;
CREATE TABLE `system_logs`  (
  `USR_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `LOG_TYPE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `CRT_DATE` datetime(0) NULL DEFAULT NULL,
  `OPER_TIME` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`USR_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_oper_logs
-- ----------------------------
-- DROP TABLE IF EXISTS `system_oper_logs`;
CREATE TABLE `system_oper_logs`  (
  `OPER_USER` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `OPER_DATE` datetime(0) NOT NULL,
  `OPER_MODEL` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `OPER_REMARK` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `OPER_RESULT` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`OPER_USER`, `OPER_DATE`, `OPER_MODEL`, `OPER_REMARK`, `OPER_RESULT`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
-- DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色描述',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_role_function
-- ----------------------------
-- DROP TABLE IF EXISTS `system_role_function`;
CREATE TABLE `system_role_function`  (
  `ROLE_ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `FUNC_ID` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `OPERATOR` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `CRT_DATE` datetime(0) NULL DEFAULT NULL,
  `OPER_FLAG` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`, `FUNC_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
-- DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `user_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for task
-- ----------------------------
-- DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `task_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `task_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '任务名',
  `task_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '任务描述',
  `task_repet_num` int(11) NULL DEFAULT 1 COMMENT '任务重复次数',
  `task_type_attr` smallint(11) NOT NULL DEFAULT 0 COMMENT '任务类型属性. 0-日常任务;1- 一次性新手任务',
  `task_type_catalog` smallint(11) NOT NULL DEFAULT 1 COMMENT '任务类型目录. 1-普通任务,2-游戏类任务 3- 大话骰任务',
  `task_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '任务类型.当任务类型目录是2或3时, 填写game表中的game_key.任务目录为1,约定几个',
  `task_display` smallint(6) NOT NULL DEFAULT 1 COMMENT '是否显示.0-隐藏,1-显示',
  `successor_task_id` int(11) NOT NULL DEFAULT 0 COMMENT '后续任务ID.新手任务才会有后续任务',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for task_log
-- ----------------------------
-- DROP TABLE IF EXISTS `task_log`;
CREATE TABLE `task_log`  (
  `task_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `task_id` int(11) NOT NULL COMMENT '任务ID',
  `task_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '任务名',
  `task_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '任务描述',
  `task_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '任务类型.当任务类型目录是2时, 填写game表中的game_key.任务目录为1,约定几个',
  `task_display` smallint(6) NULL DEFAULT NULL COMMENT '是否显示.0-隐藏,1-显示',
  `task_repet_num` int(11) NULL DEFAULT NULL COMMENT '任务重复次数',
  `task_type_attr` smallint(11) NOT NULL COMMENT '任务类型属性. 0-日常任务;1- 一次性新手任务',
  `task_type_catalog` smallint(11) NOT NULL DEFAULT 1 COMMENT '任务类型目录. 1-普通任务,2-游戏类任务',
  `task_state` smallint(11) NOT NULL COMMENT '任务状态.1-已经完成未领取奖励;2-已完成已经领取奖励',
  `successor_task_id` int(11) NULL DEFAULT 0 COMMENT '后续任务ID.新手任务才会有后续任务',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`task_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1112374 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '任务日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for task_reward_rule
-- ----------------------------
-- DROP TABLE IF EXISTS `task_reward_rule`;
CREATE TABLE `task_reward_rule`  (
  `reward_rule_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '奖励规则Id',
  `reward_rule_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '奖励规则名,显示名称可以中文',
  `award_type` smallint(11) NULL DEFAULT 0 COMMENT '奖品类型.1-趣币;2-积分;3-红包',
  `award_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '奖品名.奖品类型为1填趣币,如此类推',
  `award_num` int(11) NOT NULL DEFAULT 0 COMMENT '奖励数量',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`reward_rule_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '任务奖励规则' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for task_reward_rule_map
-- ----------------------------
-- DROP TABLE IF EXISTS `task_reward_rule_map`;
CREATE TABLE `task_reward_rule_map`  (
  `task_id` int(11) NOT NULL COMMENT '任务ID',
  `reward_rule_id` int(11) NOT NULL COMMENT '奖励规则Id',
  PRIMARY KEY (`task_id`, `reward_rule_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '身份令牌',
  `openid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信openid',
  `union_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信登录唯一标志ID',
  `pkey` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `token_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '系统分配用户的ID:暂定6位',
  `registe_type` smallint(4) NULL DEFAULT 3 COMMENT '注册方式：1.手机 2.邮箱 3.微信 4.QQ',
  `status` smallint(4) NOT NULL DEFAULT 1 COMMENT '状态：-1冻结 0.无效 1.正常',
  `is_robot` tinyint(1) NULL DEFAULT 0 COMMENT '是否是机器人：0.否 1.是',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`, `uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '平台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
-- DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_random_no` int(11) NULL DEFAULT NULL COMMENT '用户随机编号',
  `head_pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像路径',
  `gender` smallint(4) NULL DEFAULT NULL COMMENT '性别：1.男 2.女',
  `birthday` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出生日期：格式如1992-02-03',
  `province_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '省编码',
  `city_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '市编码',
  `area_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地区编码',
  `invaite_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邀请码',
  `level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '等级',
  `diamond` int(11) NULL DEFAULT 0 COMMENT '钻石',
  `coin` int(11) NOT NULL DEFAULT 0 COMMENT '金币',
  `point` int(11) NOT NULL DEFAULT 0 COMMENT '积分',
  `balance` bigint(11) NOT NULL DEFAULT 0 COMMENT '红包余额:单位为分',
  `balance_withdrawable` bigint(11) NOT NULL DEFAULT 0 COMMENT '可提现红包金额',
  `balance_freezed` bigint(11) NOT NULL DEFAULT 0 COMMENT '冻结的红包金额  提现申请的金额被冻结',
  `alipay_account` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '绑定的支付宝帐号',
  `alipay_realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付宝认证的实名',
  `phone_validated` tinyint(1) NULL DEFAULT 0 COMMENT '手机是否已验证：0.否 1.是',
  `realname_validated` tinyint(1) NULL DEFAULT 0 COMMENT '实名是否已验证：0.否 1.是',
  `alipay_account_validated` tinyint(1) NULL DEFAULT 0 COMMENT '支付宝账户是否已验证：0.否 1.是',
  `last_login_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登录时间',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `INDEX_USER_ID`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_invite
-- ----------------------------
-- DROP TABLE IF EXISTS `user_invite`;
CREATE TABLE `user_invite`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL COMMENT '邀请人id',
  `invitor_user_id` bigint(11) NOT NULL COMMENT '邀请人id',
  `is_new` tinyint(1) NULL DEFAULT NULL COMMENT '被邀请人是否为新人',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户邀请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_share
-- ----------------------------
-- DROP TABLE IF EXISTS `user_share`;
CREATE TABLE `user_share`  (
  `share_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分享流水ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `share_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分享标题',
  `share_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分享描述',
  `share_link` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分享链接',
  `share_img_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分享图标',
  `share_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分享类型,music、video或link，不填默认为link',
  `content_type` smallint(2) NULL DEFAULT NULL COMMENT '分享内容类型 1-比赛结束分享  2-红包分享',
  `content_sub_type` smallint(2) NULL DEFAULT NULL COMMENT '分享内容子类型 1-单人模式 2-对战模式 3-闯关模式 4-奖金模式 5-好友邀请',
  `data_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '如果type是music或video，则要提供数据链接，默认为空',
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`share_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 455 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for welfare
-- ----------------------------
-- DROP TABLE IF EXISTS `welfare`;
CREATE TABLE `welfare`  (
  `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `welfare_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '福利名称',
  `welfare_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '福利描述',
  `welfare_type` int(11) NOT NULL COMMENT '福利类型 1-拆红包',
  `award_type` int(11) NOT NULL COMMENT '奖励类型  1趣币 2积分 3红包',
  `award_num` int(11) NULL DEFAULT 0 COMMENT '奖励数量',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '福利配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for welfare_receive_log
-- ----------------------------
-- DROP TABLE IF EXISTS `welfare_receive_log`;
CREATE TABLE `welfare_receive_log`  (
  `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户ID',
  `welfare_id` bigint(11) NULL DEFAULT NULL COMMENT '福利ID',
  `welfare_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `welfare_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '福利描述',
  `welfare_type` int(11) NULL DEFAULT NULL,
  `award_type` int(11) NULL DEFAULT NULL,
  `award_num` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '领取状态 0未完成  1已完成未领取  2已领取',
  `friend_user_id` bigint(11) NULL DEFAULT NULL COMMENT ' 受邀请的好友ID',
  `create_time` timestamp(0) NULL DEFAULT current_timestamp() ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '福利领取记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
