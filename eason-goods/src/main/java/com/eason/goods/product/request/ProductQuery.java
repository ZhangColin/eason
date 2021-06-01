package com.eason.goods.product.request;

import com.cartisan.repositories.Condition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author colin
 */
@Data
public class ProductQuery {
    @ApiModelProperty(value = "根据标题模糊查询")
    @Condition(propName = "title", type=Condition.Type.LEFT_LIKE)
    private String blurry;

    @ApiModelProperty(value = "产品分类")
    @Condition(propName = "categoryId", type = Condition.Type.EQUAL)
    private Long categoryId;

    @ApiModelProperty(value = "供应商")
    @Condition(propName = "merchantId", type = Condition.Type.EQUAL)
    private Long merchantId;
}
