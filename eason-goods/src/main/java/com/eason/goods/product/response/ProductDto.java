package com.eason.goods.product.response;

import com.eason.goods.category.CategoryDto;
import com.eason.goods.product.ProductCategoryVerify;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author colin
 */
@Data
public class ProductDto {
    @ApiModelProperty(value = "产品Id")
    private String id;

    @ApiModelProperty(value = "产品分类")
    private CategoryDto category;

    @ApiModelProperty(value = "供应商")
    private Long merchantId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "图片")
    private String pictureUrl;

    @ApiModelProperty(value = "价格")
    private Integer price;
}
