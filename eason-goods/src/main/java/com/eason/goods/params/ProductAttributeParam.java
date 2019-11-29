package com.eason.goods.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author colin
 */
@Data
public class ProductAttributeParam {
    @ApiModelProperty("属性分类ID")
    @NotEmpty(message = "属性分类不能为空")
    private Long categoryId;
    @ApiModelProperty("属性名称")
    @NotEmpty(message = "属性名称不能为空")
    private String name;
    @ApiModelProperty("属性选择类型：0->唯一；1->单选；2->多选")
//    @FlagValidator({"0","1","2"})
    private Integer selectType;
    @ApiModelProperty("属性录入方式：0->手工录入；1->从列表中选取")
//    @FlagValidator({"0","1"})
    private Integer inputType;
    @ApiModelProperty("可选值列表，以逗号隔开")
    private String inputList;
    @ApiModelProperty("分类筛选样式：0->普通；1->颜色")
//    @FlagValidator({"0","1"})
    private Integer filterType;
    @ApiModelProperty("检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
//    @FlagValidator({"0","1","2"})
    private Integer searchType;
    @ApiModelProperty("相同属性产品是否关联；0->不关联；1->关联")
    private Boolean related;
    @ApiModelProperty("是否支持手动新增；0->不支持；1->支持")
    private Boolean handAdd;
    @ApiModelProperty("属性的类型；0->规格；1->参数")
//    @FlagValidator({"0","1"})
    private Integer type;
    @ApiModelProperty(value = "排序字段")
    @Min(value = 0, message = "排序最小为0")
    private Integer sort;
}
