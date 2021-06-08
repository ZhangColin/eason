package com.eason.goods.productDetail;

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
public class ProductDetailAppService {
    private final ProductDetailRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final ProductDetailConverter converter = ProductDetailConverter.CONVERTER;

    public ProductDetailAppService(ProductDetailRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<ProductDetailDto> searchProductDetails(@NonNull ProductDetailQuery productDetailQuery, @NonNull Pageable pageable) {
        final Page<ProductDetail> searchResult = repository.findAll(querySpecification(productDetailQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public ProductDetailDto getProductDetail(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDetailDto addProductDetail(ProductDetailParam productDetailParam) {
        final ProductDetail productDetail = new ProductDetail(idWorker.nextId(),
        productDetailParam.getPlace(),
        productDetailParam.getDescription(),
        productDetailParam.getBrand(),
        productDetailParam.getWeight(),
        productDetailParam.getSpecification(),
        productDetailParam.getPictureUrl());

        return converter.convert(repository.save(productDetail));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDetailDto editProductDetail(Long id, ProductDetailParam productDetailParam) {
        final ProductDetail productDetail = requirePresent(repository.findById(id));

        productDetail.describe(productDetailParam.getPlace(),
        productDetailParam.getDescription(),
        productDetailParam.getBrand(),
        productDetailParam.getWeight(),
        productDetailParam.getSpecification(),
        productDetailParam.getPictureUrl());

        return converter.convert(repository.save(productDetail));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProductDetail(long id) {
        repository.deleteById(id);
    }
}
