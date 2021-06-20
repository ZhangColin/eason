package com.eason.goods.product.mapper;

import com.eason.goods.product.response.ProductDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author colin
 */
public interface ProductQueryMapper {
    List<ProductDto> findByIds(@Param(value = "productIds") List<Long> productIds);
}
