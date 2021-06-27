package com.eason.payment.gateway.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    @ApiModelProperty(value = "订单Id")
    private Long id;

    @ApiModelProperty(value = "用户Id")
    private Long userId;

    @ApiModelProperty(value = "支付金额")
    private Integer payAmount;

    @ApiModelProperty(value = "交易流水号")
    private String tradeNumber;

    @ApiModelProperty(value = "订单状态，1 正常 0 取消")
    private Integer orderStatus;

    @ApiModelProperty(value = "支付状态，1未支付 2已支付 3已退款")
    private Integer payStatus;

}
