package com.eason.goods.productCategory;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductCategoryConverter extends Converter<ProductCategory, ProductCategoryDto> {
    ProductCategoryConverter CONVERTER = Mappers.getMapper(ProductCategoryConverter.class);
}
