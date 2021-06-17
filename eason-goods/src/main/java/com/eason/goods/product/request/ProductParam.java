package com.eason.goods.product.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

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

}
