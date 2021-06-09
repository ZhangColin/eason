package com.eason.goods.productDetail;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.Long;
import java.lang.String;

@Data
public class ProductDetailDto {
    @ApiModelProperty(value = "产品Id")
    private Long id;

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
    private String pictureUrl;

}
