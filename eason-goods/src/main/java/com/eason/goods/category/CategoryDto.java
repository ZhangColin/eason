package com.eason.goods.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDto {
    @ApiModelProperty(value = "分类Id")
    private Long id;

    @ApiModelProperty(value = "上级分类")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
