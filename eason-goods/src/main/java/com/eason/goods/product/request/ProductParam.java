package com.eason.goods.product.request;

import com.eason.goods.product.ProductCategoryVerify;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author colin
 */
@Data
public class ProductParam {
    @ApiModelProperty(value = "产品分类", required = true)
    @NotNull(message = "产品分类不能为空")
    @ProductCategoryVerify
    private Long categoryId;

    @ApiModelProperty(value = "供应商", required = true)
//    @NotBlank(message = "供应商不能为空")
    private Long merchantId;

    @ApiModelProperty(value = "标题", required = true)
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "图片")
    private String pictureUrl;

    @ApiModelProperty(value = "价格", required = true)
    private Integer price;
}
