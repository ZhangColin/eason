package com.eason.goods.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

@Data
public class ProductDto {
    @ApiModelProperty(value = "产品Id")
    private Long id;

    @ApiModelProperty(value = "分类Id")
    private Long categoryId;

    @ApiModelProperty(value = "商家Id")
    private Long merchantId;

    @ApiModelProperty(value = "产品标题")
    private String title;

    @ApiModelProperty(value = "产品图片")
    private String pictureUrl;

    @ApiModelProperty(value = "价格")
    private Integer price;

    @ApiModelProperty(value = "库存")
    private Integer stockNumber;

    @ApiModelProperty(value = "销量")
    private Integer sellNumber;

    @ApiModelProperty(value = "审核状态")
    private Integer auditStatus;

}
