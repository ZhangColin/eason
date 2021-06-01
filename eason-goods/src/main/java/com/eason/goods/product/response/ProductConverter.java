package com.eason.goods.product.response;

import com.cartisan.CartisanContext;
import com.cartisan.dtos.Converter;
import com.eason.goods.category.CategoryAppService;
import com.eason.goods.category.CategoryDto;
import com.eason.goods.product.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static com.cartisan.utils.AssertionUtil.requirePresent;

/**
 * @author colin
 */
@Mapper
public interface ProductConverter extends Converter<Product, ProductDto> {
    ProductConverter CONVERTER = Mappers.getMapper(ProductConverter.class);
    String ERR_CATEGORY_NOT_EXISTS = "产品分类不存在";

    @Override
    @InheritConfiguration
    @Mapping(source="categoryId", target="category")
    ProductDto convert(Product product);

    default CategoryDto categoryId2CategoryDto(Long categoryId){
        final CategoryAppService productCategoryAppService =
                CartisanContext.getBean(CategoryAppService.class);

        return requirePresent(productCategoryAppService.getAllCategories().stream()
                .filter(productCategoryDto -> productCategoryDto.getId().equals(categoryId.toString()))
                .findFirst(), ERR_CATEGORY_NOT_EXISTS);
    }
}
