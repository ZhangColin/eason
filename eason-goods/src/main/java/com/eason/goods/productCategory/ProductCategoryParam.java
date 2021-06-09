package com.eason.goods.productCategory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

@Data
public class ProductCategoryParam {
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
