package com.eason.goods.product;

import com.cartisan.dtos.Converter;
import com.eason.goods.product.domain.ProductDetail;
import com.eason.goods.product.response.ProductDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDetailConverter extends Converter<ProductDetail, ProductDetailDto> {
    ProductDetailConverter CONVERTER = Mappers.getMapper(ProductDetailConverter.class);
}
