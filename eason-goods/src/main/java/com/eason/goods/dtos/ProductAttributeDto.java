package com.eason.goods.dtos;

import com.eason.goods.domains.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author colin
 */
@Data
@AllArgsConstructor
public class ProductAttributeDto {
    private Long id;

    private Long categoryId;
    private String name;
    private Integer selectType;
    private Integer inputType;
    private String inputList;
    private Integer filterType;
    private Integer searchType;
    private Boolean related;
    private Boolean handAdd;
    private Integer type;
    private Integer sort;

    public static ProductAttributeDto convertFrom(ProductAttribute productAttribute) {
        return new ProductAttributeDto(
                productAttribute.getId(),
                productAttribute.getCategoryId(),
                productAttribute.getName(),
                productAttribute.getSelectType(),
                productAttribute.getInputType(),
                productAttribute.getInputList(),
                productAttribute.getFilterType(),
                productAttribute.getSearchType(),
                productAttribute.getRelated(),
                productAttribute.getHandAdd(),
                productAttribute.getType(),
                productAttribute.getSort()
        );
    }
}
