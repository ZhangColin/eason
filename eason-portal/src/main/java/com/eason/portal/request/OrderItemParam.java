package com.eason.portal.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderItemParam {
    @ApiModelProperty(value = "产品Id")
    private Long productId;

    @ApiModelProperty(value = "供应商Id")
    private Long merchantId;

}
