package com.eason.goods.category;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryConverter extends Converter<Category, CategoryDto> {
    CategoryConverter CONVERTER = Mappers.getMapper(CategoryConverter.class);
}
