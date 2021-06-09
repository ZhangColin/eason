package com.eason.merchant.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

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

    @ApiModelProperty(value = "状态(0：禁用  2：启用 ）")
    private Integer status;

    @ApiModelProperty(value = "审核状态，1 提交成功 2 审核通过 3 审核不通过")
    private Integer auditStatus;

}
