-- 商户表
CREATE TABLE `mch_merchants` (
  `id` bigint NOT NULL COMMENT '账户Id',
  `name` varchar(32) NOT NULL COMMENT '商户名称',
  `shop_name` varchar(32) NOT NULL DEFAULT '' COMMENT '店铺名称',
  `account` varchar(32) NOT NULL DEFAULT '' COMMENT '账户',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `scope` varchar(256) NOT NULL COMMENT '经营范围',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态(0：禁用  2：启用 ）',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_merchant_account`(`account`),
  INDEX `index_merchant_status`(`status`),
  INDEX `index_merchant_soft_deleted`(`active`, `deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户表';


