package com.eason.merchant.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MerchantParam {
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
}
