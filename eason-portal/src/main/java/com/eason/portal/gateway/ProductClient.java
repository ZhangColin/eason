package com.eason.portal.gateway;

import com.eason.portal.response.ProductCategoryDto;
import com.eason.portal.response.ProductDetailDto;
import com.eason.portal.response.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author colin
 */
@FeignClient(value = "eason-goods")
public interface ProductClient {
    @GetMapping(value = "/categories")
    List<ProductCategoryDto> getAllProductCategories();

    @GetMapping("/products/search")
    List<ProductDto> searchProducts(@RequestParam(value = "keyword") String keyword,
                                    @RequestParam(value = "categroyId") Long categoryId);

    @GetMapping("/{id}")
    ProductDetailDto getProduct(@PathVariable Long id);
}
