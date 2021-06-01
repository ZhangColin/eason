package com.eason.membership.user.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author colin
 */
@Data
public class UserParam {
    private String name;
    private Integer age;
    private String account;
    private String password;
    private String address;
    private String telphone;
    private String qq;
    private String weixin;
    private String email;
    private String sex;
}
