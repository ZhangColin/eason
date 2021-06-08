-- 订单表
CREATE TABLE `ord_orders` (
  `id` bigint NOT NULL COMMENT '订单Id',
  `user_id` bigint NOT NULL COMMENT '订单Id',
  `pay_amount` int NOT NULL COMMENT '支付金额',
  `consignee_address` varchar(128) NOT NULL DEFAULT '' COMMENT '收件人地址',
  `consignee_phone` varchar(16) NOT NULL DEFAULT '' COMMENT '收件人电话',
  `consignee_name` varchar(32) NOT NULL DEFAULT '' COMMENT '收件人姓名',
  `trade_number` varchar(64) NOT NULL DEFAULT '' COMMENT '物流单号',
  `order_status` tinyint NOT NULL DEFAULT 1 COMMENT '订单状态',
  `pay_status` tinyint NOT NULL DEFAULT 1 COMMENT '支付状态',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_order_user_id`(`user_id`),
  INDEX `index_order_order_status`(`order_status`),
  INDEX `index_order_pay_status`(`pay_status`),
  INDEX `index_order_soft_deleted`(`active`, `deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

-- 订单详情表
CREATE TABLE `ord_order_details` (
  `id` bigint NOT NULL COMMENT '订单Id',
  `order_id` bigint NOT NULL COMMENT '订单Id',
  `product_id` bigint NOT NULL COMMENT '产品Id',
  `merchant_id` bigint NOT NULL COMMENT '供应商Id',
  `trade_number` varchar(64) NOT NULL DEFAULT '' COMMENT '物流单号',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情';
