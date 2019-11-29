-- 添加属性分类数据
INSERT INTO `goods_product_attribute_categories`(id, name, specification_count, param_count) VALUES
('1', '服装-T恤', '2', '14'),
('2', '服装-裤装', '1', '5'),
('3', '手机数码-手机通讯', '0', '6'),
('4', '配件', '0', '0'),
('5', '居家', '0', '0'),
('6', '洗护', '0', '0');

-- 添加产品属性数据
INSERT INTO `goods_product_attributes`(id, category_id, name, select_type, input_type, input_list, `type`) VALUES
(1, 1, '尺寸', '2', '1', 'M,X,XL,2XL,3XL,4XL', '0'),
(2, 1, '颜色', '2', '1', '黑色,红色,白色,粉色', '0'),
(3, 1, '上市年份', '1', '1', '2013年,2014年,2015年,2016年,2017年', 1),
(4, 1, '上市年份1', '1', '1', '2013年,2014年,2015年,2016年,2017年', 1),
(5, 1, '上市年份2', '1', '1', '2013年,2014年,2015年,2016年,2017年', 1),
(6, 1, '上市年份3', '1', '1', '2013年,2014年,2015年,2016年,2017年', 1),
(7, 1, '上市年份4', '1', '1', '2013年,2014年,2015年,2016年,2017年', 1),
(8, 1, '上市年份5', '1', '1', '2013年,2014年,2015年,2016年,2017年', 1),
(9, 1, '适用对象', '1', '1', '青年女性,中年女性', 1),
(10, 1, '适用对象1', '2', '1', '青年女性,中年女性', 1),
(11, 1, '适用对象3', '2', '1', '青年女性,中年女性', 1),
(12, 1, '商品编号', '1', '0', '', 1),
(13, 1, '适用季节', '1', '1', '春季,夏季,秋季,冬季', 1),
(14, 2, '适用人群', '0', '1', '老年,青年,中年', 1),
(15, 2, '风格', '0', '1', '嘻哈风格,基础大众,商务正装', 1),
(16, 2, '颜色', '0', '0', '', 0),
(17, 1, '适用人群', '1', '1', '儿童,青年,中年,老年', 1),
(18, 1, '上市时间', '1', '1', '2017年秋,2017年冬,2018年春,2018年夏', 1),
(19, 1, '袖长', '1', '1', '短袖,长袖,中袖', 1),
(20, 2, '尺码', '0', '1', '29,30,31,32,33,34', 1),
(21, 2, '适用场景', '0', '1', '居家,运动,正装', 1),
(22, 2, '上市时间', '0', '1', '2018年春,2018年夏', 1),
(23, 3, '颜色', '0', '0', '', 1),
(24, 3, '容量', '0', '1', '16G,32G,64G,128G', 1),
(25, 3, '屏幕尺寸', '0', '0', '', 1),
(26, 3, '网络', '0', '1', '3G,4G', 1),
(27, 3, '系统', '0', '1', 'Android,IOS', 1),
(28, 3, '电池容量', '0', '0', '', 1);

-- 添加品牌数据
INSERT INTO `goods_brands`(id, `name`, first_letter, is_manufacturer, is_show, logo, big_pic, sort) VALUES
(1, '万和', 'W', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(5).jpg', '', 0),
(2, '三星', 'S', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (1).jpg', '', 100),
(3, '格力', 'G', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/dc794e7e74121272bbe3ce9bc41ec8c3_222_222.jpg', '', 30),
(4, '方太', 'F', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (4).jpg', '', 20),
(5, '小米', 'M', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/1e34aef2a409119018a4c6258e39ecfb_222_222.png', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180518/5afd7778Nf7800b75.jpg', 0),
(6, 'OPPO', 'O', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(6).jpg', '', 40),
(7, '七匹狼', 'S', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/18d8bc3eb13533fab466d702a0d3fd1f40345bcd.jpg', '', 200),
(8, '海澜之家', 'H', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/99d3279f1029d32b929343b09d3c72de_222_222.jpg', '', 200),
(9, '苹果', 'A', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', '', 0),
(10, 'NIKE', 'N', 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/timg (51).jpg', '', 0);
