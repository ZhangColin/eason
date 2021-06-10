package com.eason.order.order.response;

import com.eason.order.order.response.OrderItemDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDto {
    @ApiModelProperty(value = "订单Id")
    private Long id;

    @ApiModelProperty(value = "用户Id")
    private Long userId;

    @ApiModelProperty(value = "支付金额")
    private Integer payAmount;

    @ApiModelProperty(value = "收件人地址")
    private String consigneeAddress;

    @ApiModelProperty(value = "收件人电话")
    private String consigneePhone;

    @ApiModelProperty(value = "收件人姓名")
    private String consigneeName;

    @ApiModelProperty(value = "交易流水号")
    private String tradeNumber;

    @ApiModelProperty(value = "订单状态，1 正常 0 取消")
    private Integer orderStatus;

    @ApiModelProperty(value = "支付状态，1未支付 2已支付 3已退款")
    private Integer payStatus;

    private List<OrderItemDto> items;
}
