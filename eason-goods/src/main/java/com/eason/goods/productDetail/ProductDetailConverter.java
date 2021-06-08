package com.eason.goods.productDetail;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDetailConverter extends Converter<ProductDetail, ProductDetailDto> {
    ProductDetailConverter CONVERTER = Mappers.getMapper(ProductDetailConverter.class);
}
