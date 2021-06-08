package com.eason.goods.productDetail;

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
    @ApiModelProperty(value = "产品图片")
    private String place;

    @ApiModelProperty(value = "产品图片")
    private String description;

    @ApiModelProperty(value = "产品图片")
    private String brand;

    @ApiModelProperty(value = "产品图片")
    private String weight;

    @ApiModelProperty(value = "产品图片")
    private String specification;

    @ApiModelProperty(value = "产品图片")
    private String pictureUrl;

}
