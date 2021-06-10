package com.eason.merchant.merchant;

import com.cartisan.repositories.Condition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class MerchantQuery {
    @ApiModelProperty(value = "按商户名、店铺名查询", required = true)
    @Condition(blurry = "name,shopName")
    private String blurry;
}
