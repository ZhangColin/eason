package com.eason.goods.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author colin
 */
@Data
public class ProductAttributeCategoryInfo {
    private Long attributeCategoryId;
    private String attributeCategoryName;

    private List<ProductAttributeInfo> attributes;

    public ProductAttributeCategoryInfo() {
        this.attributes = new ArrayList<>();
    }
}
