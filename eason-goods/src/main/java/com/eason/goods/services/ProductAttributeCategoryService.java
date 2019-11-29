package com.eason.goods.services;

import com.cartisan.dtos.PageResult;
import com.eason.goods.domains.AttributeType;
import com.eason.goods.domains.ProductAttributeCategory;
import com.eason.goods.dtos.ProductAttributeCategoryDto;
import com.eason.goods.repositories.ProductAttributeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Service
public class ProductAttributeCategoryService {
    private final ProductAttributeCategoryRepository repository;

    @Autowired
    public ProductAttributeCategoryService(ProductAttributeCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductAttributeCategoryDto> getAllProductAttributeCategories() {
        final List<ProductAttributeCategory> categories = repository.findAll();
        return categories.stream().map(ProductAttributeCategoryDto::convertFrom).collect(Collectors.toList());
    }

    public ProductAttributeCategoryDto getProductAttributeCategory(Long id) {
        return ProductAttributeCategoryDto.convertFrom(repository.findById(id).get());
    }

    public PageResult<ProductAttributeCategoryDto> searchProductAttributeCategories(Integer currentPage, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize);

        final Page<ProductAttributeCategory> searchResult = repository.findAll(pageRequest);

        return new PageResult<>(searchResult.getTotalElements(),searchResult.getTotalPages(),
                searchResult.map(ProductAttributeCategoryDto::convertFrom).getContent());
    }

    @Transactional(rollbackOn = Exception.class)
    public void addProductAttributeCategory(String name) {
        final ProductAttributeCategory category = new ProductAttributeCategory(name);

        repository.save(category);
    }

    @Transactional(rollbackOn = Exception.class)
    public void editProductAttributeCategory(Long id, String name) {
        final ProductAttributeCategory category = repository.findById(id).get();

        category.setName(name);

        repository.save(category);
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProductAttributeCategory(long id) {
        repository.deleteById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void attributeIncrement (Long id, AttributeType type) {
        final ProductAttributeCategory category = repository.findById(id).get();

        if (AttributeType.Specification.getCode().equals(type.getCode())) {
            category.specificationCountIncrement();
        } else if (AttributeType.Param.getCode().equals(type.getCode())) {
            category.paramCountIncrement();
        }

        repository.save(category);
    }

    @Transactional(rollbackOn = Exception.class)
    public void attributeDecrement (Long id, AttributeType type) {
        final ProductAttributeCategory category = repository.findById(id).get();

        if (AttributeType.Specification.getCode().equals(type.getCode())) {
            category.specificationCountDecrement();
        } else if (AttributeType.Param.getCode().equals(type.getCode())) {
            category.paramCountDecrement();
        }

        repository.save(category);
    }
}
