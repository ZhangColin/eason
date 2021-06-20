package com.eason.membership.account.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;

/**
 * @author colin
 */
@Data
public class CreateAccountCommand {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @Email
    private String email;
}
