package com.eason.goods.product.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.lang.Long;
import java.lang.String;

@Data
public class ProductDetailParam {
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
