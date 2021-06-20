package com.eason.goods.product;

import com.cartisan.dtos.PageResult;
import com.cartisan.utils.SnowflakeIdWorker;
import com.eason.goods.config.ElasticSearchService;
import com.eason.goods.product.domain.Product;
import com.eason.goods.product.mapper.ProductQueryMapper;
import com.eason.goods.product.request.ProductParam;
import com.eason.goods.product.response.ProductDetailDto;
import com.eason.goods.product.response.ProductDto;
import com.eason.goods.product.response.ProductElasticSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.cartisan.utils.AssertionUtil.requirePresent;

@Service
@Slf4j
public class ProductAppService extends ElasticSearchService {
    private final ProductRepository repository;
    private final ProductQueryMapper productQueryMapper;
    private final SnowflakeIdWorker idWorker;

    private final ProductConverter converter = ProductConverter.CONVERTER;
    private final ProductDetailConverter productDetailConverter = ProductDetailConverter.CONVERTER;

    public ProductAppService(ProductRepository repository, ProductQueryMapper productQueryMapper, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.productQueryMapper = productQueryMapper;
        this.idWorker = idWorker;
    }

    public PageResult<ProductDto> searchProducts(@NonNull String keyword, @NonNull Pageable pageable) {
        final List<String> ids = search("cartisan-goods-product", keyword);

        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        final List<ProductDto> productDtos =
                productQueryMapper.findByIds(ids.stream().map(Long::parseLong).collect(Collectors.toList()));

        PageInfo<ProductDto> pageResult = new PageInfo<>(productDtos);

        return new PageResult<>(pageResult.getTotal(), pageResult.getPages(), pageResult.getList());
    }

    public ProductDetailDto getProduct(Long id) {
        return productDetailConverter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto addProduct(ProductParam productParam) {
        final Product product = new Product(idWorker.nextId(),
                productParam.getCategoryId(), productParam.getMerchantId(), productParam.getTitle(),
                productParam.getPictureUrl(), productParam.getPrice());

        product.setDetail(productParam.getPlace(), productParam.getDescription(), productParam.getBrand(),
                productParam.getWeight(), productParam.getSpecification(), productParam.getPictureDetailUrl());

        repository.save(product);

        createIndexRequest("cartisan-goods-product");
        final ProductElasticSearch productElasticSearch = ProductElasticSearch.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getProductDetail().getDescription()).build();
        insertRequest("cartisan-goods-product", product.getId().toString(),
                productElasticSearch);

        return converter.convert(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public ProductDto editProduct(Long id, ProductParam productParam) {
        final Product product = requirePresent(repository.findById(id));

        product.describe(productParam.getCategoryId(),
                productParam.getMerchantId(),
                productParam.getTitle(),
                productParam.getPictureUrl(),
                productParam.getPrice());

        product.setDetail(productParam.getPlace(), productParam.getDescription(), productParam.getBrand(),
                productParam.getWeight(), productParam.getSpecification(), productParam.getPictureDetailUrl());

        repository.save(product);

        final ProductElasticSearch productElasticSearch = ProductElasticSearch.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getProductDetail().getDescription()).build();
        updateRequest("cartisan-goods-product", product.getId().toString(),
                productElasticSearch);

        return converter.convert(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeProduct(Long id) {
        repository.deleteById(id);
        deleteRequest("cartisan-goods-product", id.toString());
    }

    @Transactional(rollbackOn = Exception.class)
    public void approve(Long id) {
        final Product product = requirePresent(repository.findById(id));

        product.approve();

        repository.save(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public void reject(Long id) {
        final Product product = requirePresent(repository.findById(id));

        product.reject();

        repository.save(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public void putaway(Long id) {
        final Product product = requirePresent(repository.findById(id));

        product.putaway();

        repository.save(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public void soldOut(Long id) {
        final Product product = requirePresent(repository.findById(id));

        product.soldOut();

        repository.save(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public void addStock(Long id, Integer count) {
        final Product product = requirePresent(repository.findById(id));

        product.addStock(count);

        repository.save(product);
    }

    @Transactional(rollbackOn = Exception.class)
    public void sell(Long id, Integer count) {
        final Product product = requirePresent(repository.findById(id));

        product.sell(count);

        repository.save(product);
    }
}
