package com.eason.goods.product.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductElasticSearch {
    private Long id;
    private String title;
    private String description;
}
