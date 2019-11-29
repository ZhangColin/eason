package com.eason.goods.services;

import com.cartisan.dtos.PageResult;
import com.eason.goods.domains.AttributeType;
import com.eason.goods.domains.ProductAttribute;
import com.eason.goods.dtos.ProductAttributeDto;
import com.eason.goods.params.ProductAttributeParam;
import com.eason.goods.repositories.ProductAttributeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author colin
 */
@Service
public class ProductAttributeService {
    private final ProductAttributeRepository repository;
    private final ProductAttributeCategoryService categoryService;

    @Autowired
    public ProductAttributeService(ProductAttributeRepository repository, ProductAttributeCategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public ProductAttributeDto getProductAttribute(Long id) {
        return ProductAttributeDto.convertFrom(repository.findById(id).get());
    }

    public PageResult<ProductAttributeDto> searchProductAttributes(Long categoryId, Integer type, Integer currentPage, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize,
                new Sort(Sort.Direction.DESC, "sort"));

        final Page<ProductAttribute> searchResult = repository.findAll((Specification<ProductAttribute>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            predicateList.add(criteriaBuilder.equal(root.get("categoryId"), categoryId));
            predicateList.add(criteriaBuilder.equal(root.get("type"), type));

            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        }, pageRequest);

        return new PageResult<>(searchResult.getTotalElements(),searchResult.getTotalPages(),
                searchResult.map(ProductAttributeDto::convertFrom).getContent());
    }

    @Transactional(rollbackOn = Exception.class)
    public void addProductAttribute(ProductAttributeParam productAttributeParam) {
        final ProductAttribute productAttribute = new ProductAttribute();
        BeanUtils.copyProperties(productAttributeParam, productAttribute);

        repository.save(productAttribute);

        categoryService.attributeIncrement(productAttribute.getCategoryId(),
                AttributeType.valueOf(productAttribute.getType()));

    }

    @Transactional(rollbackOn = Exception.class)
    public void editProductAttribute(Long id, ProductAttributeParam productAttributeParam) {
        final ProductAttribute productAttribute = repository.findById(id).get();
        BeanUtils.copyProperties(productAttributeParam, productAttribute);
        productAttribute.setId(id);

        repository.save(productAttribute);
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProductAttribute(long id) {
        final ProductAttribute productAttribute = repository.getOne(id);
        repository.delete(productAttribute);

        categoryService.attributeDecrement(productAttribute.getCategoryId(), AttributeType.valueOf(productAttribute.getType()));
    }


}
