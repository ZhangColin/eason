package com.eason.portal.gateway;

import com.eason.portal.response.ProductCategoryDto;
import com.eason.portal.response.ProductDetailDto;
import com.eason.portal.response.ProductDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author colin
 */
@Service
public class ProductClientHystrix {
    private final ProductClient productClient;

    public ProductClientHystrix(ProductClient productClient) {
        this.productClient = productClient;
    }

    @HystrixCommand(fallbackMethod = "getAllProductCategoriesFallback")
    public List<ProductCategoryDto> getAllProductCategories(){
        return productClient.getAllProductCategories();
    }

    public List<ProductCategoryDto> getAllProductCategoriesFallback() {
        final ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(1L);
        productCategoryDto.setParentId(0L);
        productCategoryDto.setDescription("吃的");
        productCategoryDto.setName("食品");
        productCategoryDto.setLevel(1);

        return asList(productCategoryDto);
    }
}
