package com.eason.goods.product.response;

import com.eason.goods.category.CategoryDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author colin
 */
@Data
public class ProductDto {
    @ApiModelProperty(value = "资源Id")
    private String id;

    @ApiModelProperty(value = "资源名称")
    private String name;

    private CategoryDto category;

    @ApiModelProperty(value = "权限编码")
    private String code;

    @ApiModelProperty(value = "Url")
    private String url;

    @ApiModelProperty(value = "资源描述")
    private String description;

    @ApiModelProperty(value = "资源排序")
    private Integer sort;
}
