package com.eason.membership.user.response;

import lombok.Data;

/**
 * @author colin
 */
@Data
public class UserDto {
    private Long id;
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
