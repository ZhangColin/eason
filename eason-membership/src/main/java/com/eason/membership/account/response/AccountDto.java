package com.eason.membership.account.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author colin
 */
@Data
public class AccountDto {
    @ApiModelProperty(value = "用户Id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
