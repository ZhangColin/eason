package com.eason.goods.product;

import com.cartisan.dtos.PageResult;
import com.cartisan.utils.SnowflakeIdWorker;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;

@Service
@CacheConfig(cacheNames = "ProductCache")
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

    @Cacheable
    public ProductDto getProduct(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
//    @Cacheable(key = "#id")
    public ProductDto addProduct(ProductParam productParam) {
        final Product product = new Product(idWorker.nextId(),
        productParam.getCategoryId(),
        productParam.getMerchantId(),
        productParam.getTitle(),
        productParam.getPictureUrl(),
        productParam.getPrice(),
        productParam.getStockNumber(),
        productParam.getSellNumber(),
        productParam.getAuditStatus());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    @CachePut(key = "#id")
    public ProductDto editProduct(Long id, ProductParam productParam) {
        final Product product = requirePresent(repository.findById(id));

        product.describe(productParam.getCategoryId(),
        productParam.getMerchantId(),
        productParam.getTitle(),
        productParam.getPictureUrl(),
        productParam.getPrice(),
        productParam.getStockNumber(),
        productParam.getSellNumber(),
        productParam.getAuditStatus());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    @CacheEvict
    public void removeProduct(long id) {
        repository.deleteById(id);
    }
}
