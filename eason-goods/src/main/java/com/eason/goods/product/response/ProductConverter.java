package com.eason.goods.product.response;

import com.cartisan.CartisanContext;
import com.cartisan.dtos.Converter;
import com.ekin.system.resource.application.ResourceCategoryAppService;
import com.ekin.system.resource.domain.Resource;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author colin
 */
@Mapper
public interface ProductConverter extends Converter<Resource, ProductDto> {
    ProductConverter CONVERTER = Mappers.getMapper(ProductConverter.class);
    String ERR_CATEGORY_NOT_EXISTS = "资源分类不存在";

    @Override
    @InheritConfiguration
    @Mapping(source="categoryId", target="category")
    ProductDto convert(Resource resource);

    default ResourceCategoryDto categoryId2CategoryDto(Long categoryId){
        final ResourceCategoryAppService resourceCategoryAppService =
                CartisanContext.getBean(ResourceCategoryAppService.class);

        return requirePresent(resourceCategoryAppService.getAllResourceCategories().stream()
                .filter(resourceCategoryDto -> resourceCategoryDto.getId().equals(categoryId.toString()))
                .findFirst(), ERR_CATEGORY_NOT_EXISTS);
    }
}
