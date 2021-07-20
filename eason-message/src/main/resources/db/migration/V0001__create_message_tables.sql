-- 消息表
CREATE TABLE `msg_messages`
(
    `id`            bigint        NOT NULL COMMENT '消息Id',
    `business_type` varchar(32)   NOT NULL COMMENT '业务类型',
    `business_id`   bigint        NOT NULL COMMENT '业务Id',
    `body`          varchar(1024) NOT NULL DEFAULT '' COMMENT '业务消息实体',
    `status`        tinyint       NOT NULL DEFAULT 1 COMMENT '状态(0：未发送  1：已发送  2：发送失败  3：消费者未接受  4：消费成功  5：消费失败 ）',
    `created`       timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated`       timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX           `index_message_status`(`status`),
    INDEX           `index_message_business_type_business_id`(`business_type`, `business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息';


