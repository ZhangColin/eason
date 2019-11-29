package com.eason.goods.dtos;

import com.eason.goods.domains.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
public class ProductCategoryDto {
    private Long id;

    private String name;
    private Long parentId;
    private Integer level;
    private Integer productCount;
    private String productUnit;
    private Boolean showNavigation;
    private Boolean isShow;
    private String icon;
    private String keywords;
    private String description;
    private Integer sort;

    public static ProductCategoryDto convertFrom(ProductCategory productCategory) {
        return new ProductCategoryDto(
                productCategory.getId(),
                productCategory.getName(),
                productCategory.getParentId(),
                productCategory.getLevel(),
                productCategory.getProductCount(),
                productCategory.getProductUnit(),
                productCategory.getShowNavigation(),
                productCategory.getIsShow(),
                productCategory.getIcon(),
                productCategory.getKeywords(),
                productCategory.getDescription(),
                productCategory.getSort()
        );
    }
}
