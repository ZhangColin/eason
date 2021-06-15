package com.eason.portal.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author colin
 */
@Data
public class ProductDetailDto {
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

    @ApiModelProperty(value = "审核状态，0 未审核 1 审核通过 2 审核不通过")
    private Integer auditStatus;

    @ApiModelProperty(value = "审核时间")
    private Date audited;

    @ApiModelProperty(value = "产品状态，0 下架 1 h 架")
    private Integer status;
}
