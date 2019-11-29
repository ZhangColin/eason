package com.eason.goods.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author colin
 */
@Data
public class ProductCategoryParam {
    @ApiModelProperty(value = "商品分类名称",required = true)
    @NotEmpty(message = "商品分类名称不能为空")
    private String name;
    @ApiModelProperty("父分类的Id")
    private Long parentId;
    @ApiModelProperty("产品数量单位")
    private String productUnit;
    @ApiModelProperty("是否在导航栏显示")
    private Boolean showNavigation;
    @ApiModelProperty("是否进行显示")
    private Boolean isShow;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("关键字")
    private String keywords;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty(value = "排序字段")
    @Min(value = 0, message = "排序最小为0")
    private Integer sort;

    @ApiModelProperty("产品相关筛选属性集合")
    private List<Long> attributeIds;

    public ProductCategoryParam() {
        this.attributeIds = new ArrayList<>();
    }
}
