package com.eason.order.order.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangeConsigneeCommand {
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "收件人地址")
    private String consigneeAddress;

    @ApiModelProperty(value = "收件人电话")
    private String consigneePhone;

    @ApiModelProperty(value = "收件人姓名")
    private String consigneeName;

}
