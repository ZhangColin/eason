-- 账户表
CREATE TABLE `ms_accounts` (
  `id` bigint NOT NULL COMMENT '账户Id',
  `username` varchar(32) NOT NULL COMMENT '登录账号',
  `phone` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态(1：正常  2：冻结 ）',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_account_user_name`(`username`),
  INDEX `index_account_status`(`status`),
  INDEX `index_account_soft_deleted`(`active`, `deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户';


INSERT INTO `ms_accounts` (`id`, `username`, `password`,  `status`)
VALUES (1265586318612762624, 'colin', '$2a$10$1OUc.r.DmlMKTPiXwhhWw.Sr0McOHHLOCNd6/Wgia7oeHgRjCOYeq', 1);

-- 用户表
CREATE TABLE `ms_users` (
   `id` bigint NOT NULL COMMENT '账户Id',
   `name` varchar(32) NOT NULL COMMENT '登录账号',
   `age` tinyint NOT NULL DEFAULT 1 COMMENT '状态(1：正常  2：冻结 ）',
   `account` varchar(32) NOT NULL COMMENT '登录账号',
   `password_encrypt` varchar(64) NOT NULL COMMENT '密码',
   `address` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
   `telphone` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
   `qq` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
   `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
   `weixin` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
   `sex` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
   `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';
