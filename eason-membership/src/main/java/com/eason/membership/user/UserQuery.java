package com.eason.membership.user;

import com.cartisan.repositories.Condition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserQuery {
    @ApiModelProperty(value = "账号", required = true)
    @Length(min = 2, max = 32, message = "账号必须在 2 至 32 之间")
    @Condition(propName = "name", type = Condition.Type.INNER_LIKE)
    private String name;

    @ApiModelProperty(value = "手机")
    @Length(min = 1, max = 13, message = "电话长度需要在13个字以内")
    @Condition(propName = "telphone", type = Condition.Type.EQUAL)
    private String telphone;
}
