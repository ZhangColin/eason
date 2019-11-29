package com.eason.goods.controllers;

import com.cartisan.dtos.PageResult;
import com.cartisan.responses.GenericResponse;
import com.eason.goods.dtos.ProductAttributeInfo;
import com.eason.goods.dtos.ProductCategoryDto;
import com.eason.goods.params.ProductCategoryParam;
import com.eason.goods.queries.ProductAttributeQuery;
import com.eason.goods.services.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cartisan.responses.GenericResponse.success;

/**
 * @author colin
 */
@Api(tags = "ProductCategoryController", description = "产品分类管理")
@RestController
@RequestMapping("/productCategories")
public class ProductCategoryController {
    private final ProductCategoryService service;

    private final ProductAttributeQuery productAttributeQuery;

    public ProductCategoryController(ProductCategoryService service, ProductAttributeQuery productAttributeQuery) {
        this.service = service;
        this.productAttributeQuery = productAttributeQuery;
    }

    @ApiOperation(value = "获取指定级别下所有产品分类")
    @GetMapping
    public GenericResponse<List<ProductCategoryDto>> getProductCategoriesByLevel(
            @ApiParam(value = "级别", required = true) @RequestParam Integer level) {
        return success(service.getProductCategoriesByLevel(level));
    }

    @ApiOperation(value = "获取产品分类")
    @GetMapping("/{id}")
    public GenericResponse<ProductCategoryDto> getProductCategory(
            @ApiParam(value = "产品分类Id", required = true) @PathVariable Long id) {
        return success(service.getProductCategory(id));
    }

    @ApiOperation(value = "搜索产品分类")
    @GetMapping("/search/{parentId}/{currentPage}/{pageSize}")
    public GenericResponse<PageResult<ProductCategoryDto>> searchProductCategories(
            @ApiParam(value = "上级分类Id", required = true) @PathVariable Long parentId,
            @ApiParam(value = "页码", required = true) @PathVariable Integer currentPage,
            @ApiParam(value = "每页记录数", required = true) @PathVariable Integer pageSize) {
        return success(service.searchProductCategories(parentId, currentPage, pageSize));
    }

    @ApiOperation(value = "获取产品分类的所有属性")
    @GetMapping("/{id}/attributes")
    public GenericResponse<List<ProductAttributeInfo>> getProductCategoryAttributes(
            @ApiParam(value = "产品分类Id", required = true) @PathVariable Long id) {
        return success(productAttributeQuery.findByProductCategory(id));
    }

    @ApiOperation(value = "添加产品分类")
    @PostMapping
    public GenericResponse addProductCategory(
            @ApiParam(value = "产品分类信息", required = true) @Validated @RequestBody ProductCategoryParam productCategoryParam) {
        service.addProductCategory(productCategoryParam);

        return success();
    }

    @ApiOperation(value = "更新产品分类")
    @PutMapping("/{id}")
    public GenericResponse editProductCategory(
            @ApiParam(value = "产品分类Id", required = true) @PathVariable Long id,
            @ApiParam(value = "产品分类信息", required = true) @Validated @RequestBody ProductCategoryParam productCategoryParam) {
        service.editProductCategory(id, productCategoryParam);

        return success();
    }

    @ApiOperation(value = "删除产品分类")
    @DeleteMapping("/{id}")
    public GenericResponse removeProductCategory(
            @ApiParam(value = "产品分类Id", required = true) @PathVariable long id) {
        service.removeProductCategory(id);

        return success();
    }
}
