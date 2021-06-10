package com.eason.order.order.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.Long;
import java.lang.String;

@Data
public class OrderItemDto {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "产品Id")
    private Long productId;

    @ApiModelProperty(value = "供应商Id")
    private Long merchantId;

    @ApiModelProperty(value = "交易流水号")
    private String tradeNumber;

}
