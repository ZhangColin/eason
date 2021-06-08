-- 产品分类表
CREATE TABLE `gds_product_categories` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类Id',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '上级分类',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `level` int NOT NULL DEFAULT 0 COMMENT '层级',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_category_parent_id`(`parent_id`),
  INDEX `index_category_sort`(`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品分类';

-- 产品表
CREATE TABLE `gds_products` (
  `id` bigint NOT NULL COMMENT '产品Id',
  `category_id` bigint NOT NULL COMMENT '分类Id',
  `merchant_id` bigint NOT NULL COMMENT '商家Id',
  `title` varchar(32) NOT NULL COMMENT '产品标题',
  `picture_url` varchar(256) NOT NULL COMMENT '产品图片',
  `price` int NOT NULL COMMENT '价格',
  `stock_number` int NOT NULL COMMENT '库存',
  `sell_number` int NOT NULL COMMENT '销量',
  `audit_status` tinyint NOT NULL DEFAULT 1 COMMENT '审核状态',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_product_category_id`(`category_id`),
  INDEX `index_product_merchant_id`(`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品';

-- 产品详情表
CREATE TABLE `gds_product_details` (
  `id` bigint NOT NULL COMMENT '产品Id',
  `place` varchar(256) NOT NULL COMMENT '产品图片',
  `description` varchar(256) NOT NULL COMMENT '产品图片',
  `brand` varchar(256) NOT NULL COMMENT '产品图片',
  `weight` varchar(256) NOT NULL COMMENT '产品图片',
  `specification` varchar(256) NOT NULL COMMENT '产品图片',
  `picture_url` varchar(256) NOT NULL COMMENT '产品图片',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品详情';




