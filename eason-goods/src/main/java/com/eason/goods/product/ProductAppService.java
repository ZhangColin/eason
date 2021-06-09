package com.eason.goods.product;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cartisan.utils.SnowflakeIdWorker;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;
import static java.util.stream.Collectors.toList;

@Service
public class ProductAppService {
    private final ProductRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final ProductConverter converter = ProductConverter.CONVERTER;

    public ProductAppService(ProductRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<ProductDto> searchProducts(@NonNull ProductQuery productQuery, @NonNull Pageable pageable) {
        final Page<Product> searchResult = repository.findAll(querySpecification(productQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public ProductDto getProduct(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto addProduct(ProductParam productParam) {
        final Product product = new Product(idWorker.nextId(),
        productParam.getCategoryId(),
        productParam.getMerchantId(),
        productParam.getTitle(),
        productParam.getPictureUrl(),
        productParam.getPrice(),
        productParam.getStockNumber(),
        productParam.getSellNumber(),
        productParam.getAuditStatus(),
        productParam.getAudited(),
        productParam.getStatus());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto editProduct(Long id, ProductParam productParam) {
        final Product product = requirePresent(repository.findById(id));

        product.describe(productParam.getCategoryId(),
        productParam.getMerchantId(),
        productParam.getTitle(),
        productParam.getPictureUrl(),
        productParam.getPrice(),
        productParam.getStockNumber(),
        productParam.getSellNumber(),
        productParam.getAuditStatus(),
        productParam.getAudited(),
        productParam.getStatus());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProduct(long id) {
        repository.deleteById(id);
    }
}
