package com.eason.order.orderDetail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.lang.Long;
import java.lang.String;

@Data
public class OrderDetailParam {
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    @ApiModelProperty(value = "产品Id")
    private Long productId;

    @ApiModelProperty(value = "供应商Id")
    private Long merchantId;

    @ApiModelProperty(value = "物流单号")
    private String tradeNumber;

}
