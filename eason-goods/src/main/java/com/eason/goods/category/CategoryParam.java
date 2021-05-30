package com.eason.goods.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author colin
 */
@Data
public class CategoryParam {
    @ApiModelProperty(value = "上级商品分类")
    private Long parentId;

    @ApiModelProperty(value = "商品分类名称")
    @NotBlank(message = "商品分类名称不能为空")
    private String name;

    @ApiModelProperty(value = "商品分类排序")
    @Min(value = 0, message = "排序最小为0")
    private Integer sort;
}
