-- 产品分类
DROP TABLE IF EXISTS `goods_product_categories`;
CREATE TABLE `goods_product_categories` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '上级分类',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `level` int(1) NOT NULL DEFAULT 0 COMMENT '分类级别',
  `product_count` int(11) NOT NULL DEFAULT 0 COMMENT '产品数量',
  `product_unit` varchar(64) NOT NULL DEFAULT '' COMMENT '产品单位',
  `show_navigation` tinyint NOT NULL DEFAULT 0 COMMENT '是否显示在导航栏：0->显示；1->不显示',
  `is_show` tinyint NOT NULL DEFAULT 0 COMMENT '是否显示：0->显示；1->不显示',
  `icon` varchar(255) NOT NULL DEFAULT '' COMMENT '图标',
  `keywords` varchar(255) NOT NULL DEFAULT '' COMMENT '关键字',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品分类';


-- 产品属性分类（产品类型）
DROP TABLE IF EXISTS `goods_product_attribute_categories`;
CREATE TABLE `goods_product_attribute_categories` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `specification_count` int(11) NOT NULL DEFAULT 0 COMMENT '规格数量',
  `param_count` int(11) NOT NULL DEFAULT 0 COMMENT '参数数量',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品属性分类（产品类型）';

-- 产品属性
DROP TABLE IF EXISTS `goods_product_attributes`;
CREATE TABLE `goods_product_attributes` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint NOT NULL COMMENT '产品属性分类',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `select_type` tinyint NOT NULL DEFAULT 0 COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
  `input_type` tinyint NOT NULL DEFAULT 0 COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `input_list` varchar(255) NOT NULL DEFAULT '' COMMENT '可选值列表',
  `filter_type` tinyint NOT NULL DEFAULT 0 COMMENT '分类筛选样式：0->普通；1->颜色',
  `search_type` tinyint NOT NULL DEFAULT 0 COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
  `related` tinyint NOT NULL DEFAULT 0 COMMENT '相同属性产品是否关联；0->不关联；1->关联',
  `hand_add` tinyint NOT NULL DEFAULT 0 COMMENT '是否支持手动新增；0->不支持；1->支持',
  `type` tinyint NOT NULL DEFAULT 0 COMMENT '属性的类型；0->规格；1->参数',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序字段：最高的可以单独上传图片',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX (`category_id`, `type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品属性';


-- 产品的分类和属性的关系表
DROP TABLE IF EXISTS `goods_product_category_attribute_relations`;
CREATE TABLE `goods_product_category_attribute_relations` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint NOT NULL COMMENT '产品分类',
  `attribute_id` bigint NOT NULL COMMENT '产品属性',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）';

-- 品牌
DROP TABLE IF EXISTS `goods_brands`;
CREATE TABLE `goods_brands` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '品牌名',
  `first_letter` varchar(1) NOT NULL COMMENT '首字母',
  `is_manufacturer` tinyint NOT NULL DEFAULT 0 COMMENT '是否为品牌制造商：0->不是；1->是',
  `is_show` tinyint NOT NULL DEFAULT 0 COMMENT '是否显示：0->显示；1->不显示',
  `logo` varchar(255) NOT NULL DEFAULT '' COMMENT 'logo',
  `big_pic` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌大图',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌';

-- 品牌故事
DROP TABLE IF EXISTS `goods_brand_stories`;
CREATE TABLE `goods_brand_stories` (
  `brand_id` bigint NOT NULL COMMENT '品牌Id',
  `brand_story` text COMMENT '品牌故事',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌故事';
