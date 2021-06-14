package com.eason.portal.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author colin
 */
@Data
public class UserDto {
    @ApiModelProperty(value = "账户Id")
    private Long id;

    @ApiModelProperty(value = "登录账号")
    private String name;

    @ApiModelProperty(value = "状态(1：正常  2：冻结 ）")
    private Integer age;

    @ApiModelProperty(value = "用户名")
    private String account;

    @ApiModelProperty(value = "密码")
    private String passwordEncrypt;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String telphone;

    @ApiModelProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "微信")
    private String weixin;

    @ApiModelProperty(value = "性别")
    private String sex;
}
