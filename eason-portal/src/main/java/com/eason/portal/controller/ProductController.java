package com.eason.portal.controller;

import com.eason.portal.response.ProductCategoryDto;
import com.eason.portal.response.ProductDto;
import com.eason.portal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author colin
 */
@Controller
@RequestMapping(value = "/product")
@Slf4j
public class ProductController {
    private final ProductService productService;



    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/list")
    public String searchProduct(Model model, @RequestParam String keyword, @RequestParam Long categoryId){
        final List<ProductCategoryDto> productCategories = productService.getAllProductCategories();
        model.addAttribute("productCategories", productCategories);

        if (categoryId == null) {
            categoryId = productCategories.get(0).getId();
        }

        final List<ProductDto> products = productService.searchProducts(keyword, categoryId);
        model.addAttribute("products", products);

        return "list";
    }
}
