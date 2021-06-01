package com.eason.membership.user.request;

import com.cartisan.repositories.Condition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author colin
 */
@Data
public class UserQuery {
    @ApiModelProperty(value = "名称", required = true)
    @Length(min = 2, max = 32, message = "商户名称必须在 2 至 32 之间")
    @Condition(propName = "name", type = Condition.Type.INNER_LIKE)
    private String name;
}
