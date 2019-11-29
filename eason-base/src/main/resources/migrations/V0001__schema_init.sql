CREATE TABLE `bas_continents` (
  `id` int(11) NOT NULL,
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `bas_continents` ( `id`, `code`, `name`) values ( '1', 'AS', '亚洲');
insert into `bas_continents` ( `id`, `code`, `name`) values ( '2', 'EU', '欧洲');
insert into `bas_continents` ( `id`, `code`, `name`) values ( '3', 'OA', '大洋洲');
insert into `bas_continents` ( `id`, `code`, `name`) values ( '4', 'NA', '北美洲');
insert into `bas_continents` ( `id`, `code`, `name`) values ( '5', 'SA', '南美洲');
insert into `bas_continents` ( `id`, `code`, `name`) values ( '6', 'AF', '非洲');


CREATE TABLE `bas_countries` (
  `id` int(11) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `english_name` varchar(100) DEFAULT NULL,
  `full_pin_yin` varchar(100) DEFAULT NULL,
  `simple_pin_yin` varchar(50) DEFAULT NULL,
  `continent_id` int(11) NOT NULL DEFAULT '1',
  `continent_name` varchar(45) NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `continent_id_idx` (`continent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '1', 'CN', '中国', 'China', 'zhongguo', 'zg', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '2', 'MY', '马来西亚', 'Malaysia', 'malaixiya', 'mlxy', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '3', 'SG', '新加坡', 'Singapore', 'xinjiapo', 'xjp', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '4', 'TH', '泰国', 'Thailand', 'taiguo', 'tg', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '5', 'AL', '阿尔巴尼亚', 'Albania', 'aerbaniya', 'aebny', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '6', 'DZ', '阿尔及利亚', 'Algeria', 'aerjiliya', 'aejly', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '7', 'AF', '阿富汗', 'Afghanistan', 'afuhan', 'afh', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '8', 'AR', '阿根廷', 'Argentina', 'agenting', 'agt', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '9', 'AE', '阿联酋', 'United Arab Emirates', 'alianqiu', 'alq', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '10', 'EG', '埃及', 'Egypt', 'aiji', 'aj', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '11', 'ET', '埃塞俄比亚', 'Ethiopia', 'aisaiebiya', 'aseby', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '12', 'IE', '爱尔兰', 'Ireland', 'aierlan', 'ael', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '13', 'AO', '安哥拉', 'Angola', 'angela', 'agl', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '14', 'AT', '奥地利', 'Austria', 'aodili', 'adl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '15', 'AU', '澳大利亚', 'Australia', 'aodaliya', 'adly', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '17', 'PK', '巴基斯坦', 'Pakistan', 'bajisitan', 'bjst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '18', 'PA', '巴拿马', 'Panama', 'banama', 'bnm', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '19', 'BR', '巴西', 'Brazil', 'baxi', 'bx', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '20', 'BG', '保加利亚', 'Bulgaria', 'baojialiya', 'bjly', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '21', 'BE', '比利时', 'Belgium', 'bilishi', 'bls', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '22', 'IS', '冰岛', 'Iceland', 'bingdao', 'bd', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '23', 'PL', '波兰', 'Poland', 'bolan', 'bl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '24', 'BO', '玻利维亚', 'Bolivia', 'boliweiya', 'blwy', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '25', 'BI', '布隆迪', 'Burundi', 'bulongdi', 'bld', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '27', 'DK', '丹麦', 'Denmark', 'danmai', 'dm', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '28', 'DE', '德国', 'Germany', 'deguo', 'dg', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '30', 'RU', '俄罗斯', 'Russia', 'eluosi', 'els', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '31', 'FR', '法国', 'France', 'faguo', 'fg', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '32', 'PH', '菲律宾', 'Philippines', 'feilvbin', 'flb', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '33', 'FJ', '斐济', 'Fiji', 'feiji', 'fj', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '34', 'FI', '芬兰', 'Finland', 'fenlan', 'fl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '35', 'GM', '冈比亚', 'Gambia', 'gangbiya', 'gby', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '36', 'CD', '刚果（金）', 'Congo, Democratic republic of', 'gangguo', 'GB', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '37', 'CO', '哥伦比亚', 'Colombia', 'gelunbiya', 'glby', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '38', 'CR', '哥斯达黎加', 'Costa Rica', 'gesidalijia', 'gsdlj', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '39', 'CU', '古巴', 'Cuba', 'guba', 'gb', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '40', 'GY', '圭亚那', 'Guyana', 'guiyana', 'gyn', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '41', 'HT', '海地', 'Haiti', 'haidi', 'hd', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '42', 'kr', '韩国', 'South Korea', 'hanguo', 'hg', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '43', 'NL', '荷兰', 'Netherlands', 'helan', 'hl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '44', 'HN', '洪都拉斯', 'Honduras', 'hongdoulasi', 'hdls', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '45', 'DJ', '吉布提', 'Djibouti', 'jibuti', 'jbt', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '46', 'GN', '几内亚', 'Guinea', 'jineiya', 'jny', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '47', 'CA', '加拿大', 'Canada', 'jianada', 'jnd', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '48', 'GH', '加纳', 'Ghana', 'jiana', 'jn', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '49', 'GA', '加蓬', 'Gabon', 'jiapeng', 'jp', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '50', 'KH', '柬埔寨', 'Cambodia', 'jianpuzhai', 'jpz', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '51', 'ZW', '津巴布韦', 'Zimbabwe', 'jinbabuwei', 'jbbw', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '52', 'CM', '喀麦隆', 'Cameroon', 'kamailong', 'kml', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '53', 'KW', '科威特', 'Kuwait', 'keweite', 'kwt', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '54', 'KE', '肯尼亚', 'Kenya', 'kenniya', 'kny', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '55', 'LA', '老挝', 'Lao', 'laowo', 'lw', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '56', 'LB', '黎巴嫩', 'Lebanon', 'libanen', 'lbn', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '57', 'LT', '立陶宛', 'Lithuania', 'litaowan', 'ltw', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '59', 'LR', '利比里亚', 'Liberia', 'libiliya', 'lbly', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '60', 'LY', '利比亚', 'Libya', 'libiya', 'lby', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '61', 'LU', '卢森堡', 'Luxembourg', 'lusenbao', 'lsb', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '62', 'RW', '卢旺达', 'Rwanda', 'luwangda', 'lwd', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '63', 'RO', '罗马尼亚', 'Romania', 'luomaniya', 'lmny', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '64', 'MU', '毛里求斯', 'Mauritius', 'maoliqiusi', 'mlqs', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '65', 'MR', '毛里塔尼亚', 'Mauritania', 'maolitaniya', 'mltny', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '66', 'US', '美国', 'United States', 'meiguo', 'mg', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '67', 'MN', '蒙古', 'Mongolia', 'menggu', 'mg', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '68', 'BD', '孟加拉国', 'Bangladesh', 'mengjialaguo', 'mjlg', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '69', 'PE', '秘鲁', 'Peru', 'milu', 'ml', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '70', 'MM', '缅甸', 'Berma', 'miandian', 'md', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '71', 'MA', '摩洛哥', 'Morocco', 'moluoge', 'mlg', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '72', 'MX', '墨西哥', 'Mexico', 'moxige', 'mxg', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '73', 'ZA', '南非', 'South Africa', 'nanfei', 'nf', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '74', 'NP', '尼泊尔', 'Nepal', 'niboer', 'nbe', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '75', 'NG', '尼日利亚', 'Nigeria', 'niriliya', 'nrly', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '76', 'NO', '挪威', 'Norway', 'nuowei', 'nw', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '77', 'PT', '葡萄牙', 'Portugal', 'putaoya', 'pty', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '78', 'JP', '日本', 'Japan', 'riben', 'rb', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '79', 'SE', '瑞典', 'Sweden', 'ruidian', 'rd', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '80', 'CH', '瑞士', 'Switzerland', 'ruishi', 'rs', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '81', 'CY', '塞浦路斯', 'Cyprus', 'saipulusi', 'spls', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '82', 'SA', '沙特阿拉伯', 'Saudi Arabia', 'shatealabo', 'stalb', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '83', 'LK', '斯里兰卡', 'Sri Lanka', 'sililanka', 'sllk', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '84', 'SI', '斯洛文尼亚', 'Slovenia', 'siluowenniya', 'slwny', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '85', 'SD', '苏丹', 'Sudan', 'sudan', 'sd', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '87', 'TZ', '坦桑尼亚', 'Tanzania', 'tansangniya', 'tsny', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '88', 'TN', '突尼斯', 'Tunisia', 'tunisi', 'tns', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '89', 'TR', '土耳其', 'Turkey', 'tuerqi', 'teq', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '90', 'GT', '危地马拉', 'Guatemala', 'weidimala', 'wdml', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '91', 'VE', '委内瑞拉', 'Venezuela', 'weineiruila', 'wnrl', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '92', 'BN', '文莱', 'Brunei', 'wenlai', 'wl', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '93', 'UG', '乌干达', 'Uganda', 'wuganda', 'wgd', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '94', 'UY', '乌拉圭', 'Uruguay', 'wulagui', 'wlg', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '95', 'ES', '西班牙', 'Spain', 'xibanya', 'xby', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '96', 'GR', '希腊', 'Greece', 'xila', 'xl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '98', 'NZ', '新西兰', 'New Zealand', 'xinxilan', 'xxl', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '99', 'HU', '匈牙利', 'Hungary', 'xiongyali', 'xyl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '100', 'SY', '叙利亚', 'Syria', 'xuliya', 'xly', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '101', 'JM', '牙买加', 'Jamaica', 'yamaijia', 'ymj', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '102', 'YE', '也门', 'Yemen', 'yemen', 'ym', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '103', 'IQ', '伊拉克', 'Iraq', 'yilake', 'ylk', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '104', 'IR', '伊朗', 'Iran', 'yilang', 'yl', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '105', 'IL', '以色列', 'Israel', 'yiselie', 'ysl', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '106', 'IT', '意大利', 'Italy', 'yidali', 'ydl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '107', 'IN', '印度', 'India', 'yindu', 'yd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '108', 'ID', '印度尼西亚', 'Indonesia', 'yindunixiya', 'ydnxy', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '109', 'GB', '英国', 'United Kingdom', 'yingguo', 'yg', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '110', 'JO', '约旦', 'Jordan', 'yuedan', 'yd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '111', 'VN', '越南', 'Viet Nam', 'yuenan', 'yn', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '112', 'ZM', '赞比亚', 'Zambia', 'zanbiya', 'zby', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '114', 'TD', '乍得', 'Chad', 'zhade', 'zd', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '115', 'CL', '智利', 'Chile', 'zhili', 'zl', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '116', 'YU', '南斯拉夫', 'Yugoslavia', 'nansilafu', 'nslf', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '118', 'BH', '巴林', 'Bahrain', 'balin', 'bl', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '119', 'UA', '乌克兰', 'Ukraine', 'wukelan', 'wkl', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '143', 'KG', '吉尔吉斯斯坦', 'Kyrgizstan', 'jierjisisitan', 'jejsst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '144', 'UZ', '乌兹别克斯坦', 'Uzbekistan', 'wuzibiekesitan', 'wzbkst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '145', 'AZ', '阿塞拜疆', 'Azerbaijan', 'asaibaijiang', 'asbj', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '146', 'MV', '马尔代夫', 'Maldives', 'maerdaifu', 'medf', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '147', 'PY', '巴拉圭', 'Paraguay', 'balagui', 'blg', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '150', 'OM', '阿曼', 'Oman', 'aman', 'am', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '151', 'BY', '白俄罗斯', 'Belarus', 'baieluosi', 'bels', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '152', 'BW', '博茨瓦纳', 'Botswana', 'bociwana', 'bcwn', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '153', 'PG', '巴布亚新几内亚', 'Papua New Guinea', 'babuyaxinjineiya', 'bbyxjny', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '155', 'EC', '厄瓜多尔', 'Ecuador', 'eguaduoer', 'egde', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '156', 'SN', '塞内加尔', 'Senegal', 'saineijiaer', 'snje', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '157', 'MZ', '莫桑比克', 'Mozambique', 'mosangbike', 'msbk', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '158', 'NE', '尼日尔', 'Niger', 'nirier', 'nre', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '159', 'NA', '纳米比亚', 'Namibia', 'namibiya', 'nmby', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '160', 'TO', '汤加', 'Tonga', 'tangjia', 'tj', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '161', 'MT', '马耳他', 'Malta', 'maerta', 'met', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '162', 'CZ', '捷克', 'Czech', 'jieke', 'jk', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '163', 'QA', '卡塔尔', 'Qatar', 'kataer', 'kte', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '164', 'HR', '克罗地亚', 'Croatia', 'keluodiya', 'kldy', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '166', 'EE', '爱沙尼亚', 'Estonia', 'aishaniya', 'asny', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '167', 'VA', '梵蒂冈', 'Vatican', 'fandigang', 'fdg', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '171', 'AW', '阿鲁巴', 'Aruba', 'aluba', 'alb', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '174', 'SC', '塞舌尔', 'Seychelles', 'saisheer', 'sse', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '175', 'AM', '亚美尼亚', 'Armenia', 'yameiniya', 'ymny', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '176', 'KZ', '哈萨克斯坦', 'Kazakhstan', 'hasakesitan', 'hskst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '178', 'BJ', '贝宁', 'Benin', 'beining', 'bn', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '179', 'CI', '科特迪瓦', 'Lvory Coast', 'ketediwa', 'ktdw', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '180', 'GE', '格鲁吉亚', 'Georgia', 'gelujiya', 'gljy', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '181', 'SR', '苏里南', 'Suriname', 'sulinan', 'sln', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '182', 'MD', '摩尔多瓦', 'Moldova', 'moerduowa', 'medw', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '183', 'RS', '塞尔维亚', 'Serbia', 'saierweiya', 'sewy', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '184', 'ER', '厄立特里亚', 'Eritrea', 'eliteliya', 'eltly', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '185', 'BS', '巴哈马', 'Bahamas', 'bahama', 'bhm', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '186', 'MW', '马拉维', 'Malawi', 'malawei', 'mlw', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '187', 'LS', '莱索托', 'Lesotho', 'laisuotuo', 'lst', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '191', 'CK', '库克群岛', 'Cook Islands', 'kukequndao', 'kkqd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '192', 'GU', '关岛', 'Guam', 'guandao', 'gd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '195', 'TM', '土库曼斯坦', 'Turkmenstan', 'tukumansitan', 'tkmst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '196', 'SZ', '斯威士兰', 'Swaziland', 'siweishilan', 'swsl', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '197', 'MK', '马其顿共和国', 'Macedonia', 'maqidungongheguo', 'mqdghg', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '198', 'NI', '尼加拉瓜', 'Nicaragua', 'nijialagua', 'njlg', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '200', 'AD', '安道尔', 'Andorra', 'andaoer', 'ade', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '201', 'AG', '安提瓜和巴布达', 'Antigua and barbuda', 'antiguahebabuda', 'atghbbd', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '202', 'BB', '巴巴多斯', 'Barbados', 'babaduosi', 'bbds', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '205', 'PS', '巴勒斯坦', 'Palestine', 'balesitan', 'blst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '207', 'BM', '百慕大', 'Bermuda', 'baimuda', 'bmd', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '208', 'PR', '波多黎各', 'Puerto Rico', 'boduolige', 'bdlg', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '209', 'BA', '波黑', 'Bosnia and Herzegovina', 'bohei', 'bh', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '210', 'BZ', '伯利兹', 'Belize', 'bolizi', 'blz', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '212', 'BT', '不丹', 'Bhutan', 'budan', 'bd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '213', 'BF', '布基纳法索', 'Burkina Faso', 'bujinafasuo', 'bjnfs', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '214', 'GQ', '赤道几内亚', 'Equatorial Guinea', 'chidaojineiya', 'cdjny', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '215', 'TL', '东帝汶', 'East Timor', 'dongdiwen', 'ddw', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '216', 'TG', '多哥', 'Togo', 'duoge', 'dg', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '217', 'DM', '多米尼克', 'Dominica', 'duominike', 'dmnk', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '219', 'CV', '佛得角', 'Cape Verde', 'fodejiao', 'fdj', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '220', 'GD', '格林纳达', 'Grenada', 'gelinnada', 'glnd', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '221', 'KI', '基里巴斯', 'Kiribati', 'jilibasi', 'jlbs', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '222', 'GW', '几内亚比绍', 'Guinea-bissau', 'jineiyabishao', 'jnybs', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '223', 'KY', '开曼群岛', 'Cayman Islands', 'kaimanqundao', 'kmqd', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '224', 'KM', '科摩罗', 'Comoros', 'kemoluo', 'kml', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '225', 'LV', '拉脱维亚', 'Latvia', 'latuoweiya', 'ltwy', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '227', 'MG', '马达加斯加', 'Madagascar', 'madajiasijia', 'mdjsj', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '228', 'ML', '马里', 'Mali', 'mali', 'ml', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '229', 'MH', '马绍尔群岛', 'Marshall Islands', 'mashaoerqundao', 'mseqd', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '230', 'FM', '密克罗尼西亚', 'Micronesia', 'mikeluonixiya', 'mklnxy', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '231', 'MC', '摩纳哥', 'Monaco', 'monage', 'mng', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '234', 'NR', '瑙鲁', 'Nauru', 'naolu', 'nl', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '236', 'NU', '纽埃（新西兰属）', 'Niue', 'NIUAI', 'NA', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '238', 'SV', '萨尔瓦多', 'El Salvador', 'saerwaduo', 'sewd', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '240', 'SL', '塞拉利昂', 'Sierra Leone', 'sailaliang', 'slla', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '242', 'ST', '圣多美和普林西比', 'Sao Tome and Principe', 'shengduomeihepulinxibi', 'sdmhplxb', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '244', 'LC', '圣卢西亚', 'Saint Lucia', 'shengluxiya', 'slxy', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '245', 'SM', '圣马力诺', 'San Marino', 'shengmalinuo', 'smln', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '246', 'VC', '圣文森特和格林纳丁斯', 'Saint Vincent and the Grenadines', 'shengwensentehegelinnadingsi', 'swsthglnds', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '247', 'SK', '斯洛伐克', 'Slovakia', 'siluofake', 'slfk', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '248', 'SB', '所罗门群岛', 'Solomon Islands', 'suoluomenqundao', 'slmqd', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '249', 'SO', '索马里', 'Somalia', 'suomali', 'sml', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '250', 'TJ', '塔吉克斯坦', 'Tajikistan', 'tajikesitan', 'tjkst', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '252', 'TT', '特立尼达和多巴哥', 'Trinidad and Tobago', 'telinidaheduobage', 'tlndhdbg', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '253', 'TV', '图瓦卢', 'Tuvalu', 'tuwalu', 'twl', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '254', 'VU', '瓦努阿图', 'Vanuatu', 'wanuatu', 'wnat', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '256', 'CF', '中非', 'Central Africa Republic', 'zhongfei', 'zf', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '257', 'ME', '黑山', 'Montenegro', 'heishan', 'hs', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '262', 'MP', '北马里亚纳群岛', 'Northern Mariana Island', 'beimaliyanaqundao', 'bmlynqd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '263', 'NC', '新喀里多尼亚', 'New Caledonia', 'xinkaliduoniya', 'xkldny', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '265', 'TC', '特克斯和凯科斯群岛', 'Turks & Caicos Island', 'tekesihekaikesiqundao', 'tkshkksqd', '1', '亚洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '267', 'PF', '波利尼西亚', 'Polynesia Islands', 'bolinixiya', 'blnxy', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '268', 'GL', '格陵兰', 'Greenland', 'gelinglan', 'gll', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '269', 'RE', '留尼汪（法属）', 'Reunion', 'LIUNIWANG', 'LNW', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '270', 'YT', '马约特', 'Mayotte', 'mayuete', 'myt', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '271', 'CG', '刚果共和国', 'Congo', 'gangguogongheguo', 'ggghg', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '273', 'NE', '圣赫勒拿', 'Saint Helena', 'shenghelena', 'shln', '6', '非洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '274', 'AN', '安的列斯', 'Netherlands Antilles', 'andeliesi', 'adls', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '275', 'AI', '安圭拉', 'Anguilla', 'anguila', 'agl', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '276', 'DO', '多米尼加共和国', 'Dominican Republic', 'duominijiagongheguo', 'dmnjghg', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '277', 'FK', '福克兰群岛', 'Falkland Islands', 'fukelanqundao', 'fklqd', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '278', 'GP', '瓜德罗普', 'Guadeloupe', 'guadeluopu', 'gdlp', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '279', 'MQ', '马提尼克', 'Martinique', 'matinike', 'mtnk', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '280', 'VI', '美属维尔京群岛', 'Virgin Islands U.S.', 'meishuweierjingqundao', 'mswejqd', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '281', 'KN', '圣基茨和尼维斯联邦', 'Saint Kitts and Nevi', 'shengjiciheniweisilianbang', 'sjchnwslb', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '282', 'VG', '英属维尔京群岛', 'British Virgin Islands', 'yingshuweierjingqundao', 'yswejqd', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '283', 'FO', '法罗群岛', 'Faroe Islands', 'faluoqundao', 'flqd', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '285', 'NF', '诺福克岛（澳属）', 'Norfolk Island', 'LUOFUKEDAO', 'LFKD', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '286', 'WF', '瓦利斯和富图纳群岛', 'Wallis And Futuna Is', 'walisihefutunaqundao', 'wlshftnqd', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '287', 'GI', '直布罗陀', 'Gibraltar', 'zhibuluotuo', 'zblt', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '290', 'PF', '大溪地', 'Tahiti', 'daxidi', 'dxd', '2', '欧洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '291', '', '索马里兰', 'Soomaaliland', 'suomalilan', 'smll', '5', '南美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '292', 'MP', '塞班', 'Saipan', 'saiban', 'sb', '4', '北美洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '293', 'PW', '帕劳共和国', 'The Republic of Palau', 'palaogongheguo', 'plghg', '3', '大洋洲');
insert into `bas_countries` ( `id`, `code`, `name`, `english_name`, `full_pin_yin`, `simple_pin_yin`, `continent_id`, `continent_name`) values ( '999', 'OTHER', '其它国家', 'other', 'other', 'qita', '1', '亚洲');


CREATE TABLE `bas_cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `english_name` varchar(100) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  `country_name` varchar(45) NOT NULL,
  `full_pin_yin` varchar(50) DEFAULT NULL,
  `simple_pin_yin` varchar(50) DEFAULT NULL,
  `zone_id` varchar(45) DEFAULT NULL,
  `zone_name` varchar(45) DEFAULT NULL,
  `utc` decimal(10,2) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `country_id_idx` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `bas_airports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `english_name` varchar(100) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  `city_name` varchar(45) NOT NULL,
  `full_pin_yin` varchar(50) DEFAULT NULL,
  `simple_pin_yin` varchar(50) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `city_id_idx` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



CREATE TABLE `bas_vehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `passengers` int(11) NOT NULL,
  `passengers_description` varchar(256) DEFAULT NULL,
  `big_luggage` int(11) NOT NULL,
  `small_luggage` int(11) DEFAULT NULL,
  `picture_url` varchar(256) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `country_name` varchar(45) DEFAULT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `country_id_idx` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '经济型5座', '类似卡罗拉', '4', '0', '2');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '经济型7座', '类似丰田INNOVA', '4', '2', '2');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型5座', '类似丰田凯美瑞', '4', '0', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型7座', '类似别克gl8', '6', '4', '0');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型9座', '类似大众T5', '7', '3', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型10座', '类似丰田van', '9', '3', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '豪华型5座', '类似奔驰E型', '4', '0', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '经济型9座', '类似现代辉翼', '6', '3', '1');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型5座（SUV）', '类似起亚sportage', '4', '0', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '豪华型7座', '类似丰田阿尔法', '6', '4', '0');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '豪华型10座', '类似奔驰斯宾特', '9', '3', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '奢华型5座', '类似奔驰S型', '4', '0', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '商务型7座', '类似奥德赛', '6', '2', '2');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '12座小巴', '类似大T5', '10', '6', '0');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '豪华型9座', '类似奔驰VITO', '8', '5', '0');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型10座（酷炫版）', '丰田海狮', '9', '3', '3');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '豪华型12座', '类似奔驰sprinter', '11', '8', '0');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '14座中巴', '类似丰田海狮', '11', '9', '0');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '15座中巴', '类似丰田海狮', '12', '0', '8');
insert into `bas_vehicles` ( `name`, `description`, `passengers`, `big_luggage`, `small_luggage`) values ( '舒适型14座', '类似丰田海狮', '11', '9', '0');






