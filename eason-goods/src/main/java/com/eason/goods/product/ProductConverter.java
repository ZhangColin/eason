package com.eason.goods.product;

import com.cartisan.dtos.Converter;
import com.eason.goods.product.domain.Product;
import com.eason.goods.product.response.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductConverter extends Converter<Product, ProductDto> {
    ProductConverter CONVERTER = Mappers.getMapper(ProductConverter.class);
}
