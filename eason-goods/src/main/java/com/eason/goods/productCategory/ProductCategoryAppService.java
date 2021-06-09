package com.eason.goods.productCategory;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;
import static java.util.stream.Collectors.toList;

@Service
public class ProductCategoryAppService {
    private final ProductCategoryRepository repository;

    private final ProductCategoryConverter converter = ProductCategoryConverter.CONVERTER;

    public ProductCategoryAppService(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public PageResult<ProductCategoryDto> searchProductCategories(@NonNull ProductCategoryQuery productCategoryQuery, @NonNull Pageable pageable) {
        final Page<ProductCategory> searchResult = repository.findAll(querySpecification(productCategoryQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public ProductCategoryDto getProductCategory(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductCategoryDto addProductCategory(ProductCategoryParam productCategoryParam) {
        final ProductCategory productCategory = new ProductCategory(productCategoryParam.getParentId(),
        productCategoryParam.getName(),
        productCategoryParam.getDescription(),
        productCategoryParam.getLevel(),
        productCategoryParam.getSort());

        return converter.convert(repository.save(productCategory));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductCategoryDto editProductCategory(Long id, ProductCategoryParam productCategoryParam) {
        final ProductCategory productCategory = requirePresent(repository.findById(id));

        productCategory.describe(productCategoryParam.getParentId(),
        productCategoryParam.getName(),
        productCategoryParam.getDescription(),
        productCategoryParam.getLevel(),
        productCategoryParam.getSort());

        return converter.convert(repository.save(productCategory));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProductCategory(long id) {
        repository.deleteById(id);
    }
}
