package com.eason.goods.product;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import com.eason.goods.product.request.ProductParam;
import com.eason.goods.product.request.ProductQuery;
import com.eason.goods.product.response.ProductConverter;
import com.eason.goods.product.response.ProductDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;

/**
 * @author colin
 */
@Service
public class ProductAppService {
    public static final String ERR_NAME_EXISTS = "资源名称已存在。";
    private final ProductConverter converter = ProductConverter.CONVERTER;

    private final ProductRepository repository;

    public ProductAppService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDto> getAllResources() {
        return converter.convert(repository.findAll(Sort.by(Sort.Direction.ASC, "categoryId")
                .and(Sort.by(Sort.Direction.ASC, "sort"))));
    }

    public PageResult<ProductDto> searchResources(@NonNull ProductQuery resourceQuery, @NonNull Pageable pageable) {
        final Page<Product> searchResult = repository.findAll(querySpecification(resourceQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "categoryId")
                                .and(Sort.by(Sort.Direction.ASC, "sort"))));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto addResource(ProductParam resourceParam) {
        if (repository.existsByName(resourceParam.getName())) {
            throw new CartisanException(CodeMessage.VALIDATE_ERROR.fillArgs(ERR_NAME_EXISTS));
        }

        final Product product = new Product(resourceParam.getName(), resourceParam.getCode(),
                resourceParam.getUrl(), resourceParam.getCategoryId());

        product.describe(resourceParam.getName(), resourceParam.getCategoryId(),
                resourceParam.getDescription(), resourceParam.getSort());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto editResource(Long id, ProductParam resourceParam) {
        if (repository.existsByNameAndIdNot(resourceParam.getName(), id)) {
            throw new CartisanException(CodeMessage.VALIDATE_ERROR.fillArgs(ERR_NAME_EXISTS));
        }

        final Product product = requirePresent(repository.findById(id));

        product.describe(resourceParam.getName(), resourceParam.getCategoryId(),
                resourceParam.getDescription(), resourceParam.getSort());

        product.configPermission(resourceParam.getCode(), resourceParam.getUrl());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeResource(long id) {
        repository.deleteById(id);
    }

}
