package com.eason.goods.product;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import com.cartisan.utils.SnowflakeIdWorker;
import com.eason.goods.product.request.ProductParam;
import com.eason.goods.product.request.ProductQuery;
import com.eason.goods.product.response.ProductConverter;
import com.eason.goods.product.response.ProductDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final ProductConverter converter = ProductConverter.CONVERTER;

    private final SnowflakeIdWorker idWorker;
    private final ProductRepository repository;

    public ProductAppService(SnowflakeIdWorker idWorker, ProductRepository repository) {
        this.idWorker = idWorker;
        this.repository = repository;
    }

    public List<ProductDto> getAllProducts() {
        return converter.convert(repository.findAll());
    }

    public PageResult<ProductDto> searchProducts(@NonNull ProductQuery productQuery, @NonNull Pageable pageable) {
        final Page<Product> searchResult = repository.findAll(querySpecification(productQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto addProduct(ProductParam productParam) {
        final Product product = new Product(idWorker.nextId(), productParam.getCategoryId(), productParam.getMerchantId(),
                productParam.getTitle(), productParam.getPictureUrl(), productParam.getPrice());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto editProduct(Long id, ProductParam productParam) {

        final Product product = requirePresent(repository.findById(id));

        product.describe(productParam.getCategoryId(), productParam.getMerchantId(),
                productParam.getTitle(), productParam.getPictureUrl(), productParam.getPrice());

        return converter.convert(repository.save(product));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProduct(long id) {
        repository.deleteById(id);
    }

}
