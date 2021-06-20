package com.eason.goods.product.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductParam {
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

    @ApiModelProperty(value = "产地")
    private String place;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "重量")
    private String weight;

    @ApiModelProperty(value = "规格说明和包装")
    private String specification;

    @ApiModelProperty(value = "产品详情图片地址")
    private String pictureDetailUrl;
}
