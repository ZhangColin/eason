package com.eason.merchant.merchant.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author colin
 */
@Data
public class MerchantDto {
    @ApiModelProperty(value = "商户Id")
    private String id;

    @ApiModelProperty(value = "商户名称")
    private String name;
    @ApiModelProperty(value = "店铺名称")
    private String shopName;
    @ApiModelProperty(value = "账户")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "经营范围")
    private String scope;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
