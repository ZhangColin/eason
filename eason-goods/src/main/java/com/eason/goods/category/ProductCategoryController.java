package com.eason.goods.category;

import com.cartisan.dtos.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.cartisan.responses.ResponseUtil.success;

@Api(tags = "产品：产品分类")
@RestController
@RequestMapping("/productCategories")
@Validated
@Slf4j
public class ProductCategoryController {
    private final ProductCategoryAppService service;

    public ProductCategoryController(ProductCategoryAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索产品分类")
    @GetMapping("/search")
    public ResponseEntity<PageResult<ProductCategoryDto>> searchProductCategories(
            @ApiParam(value = "查询参数") ProductCategoryQuery productCategoryQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchProductCategories(productCategoryQuery, pageable));
    }

    @ApiOperation(value = "获取产品分类")
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDto> getProductCategory(@ApiParam(value = "产品分类Id", required = true) @PathVariable Long id){
        return success(service.getProductCategory(id));
    }

    @ApiOperation(value = "添加产品分类")
    @PostMapping
    public ResponseEntity<ProductCategoryDto> addProductCategory(
            @ApiParam(value = "产品分类信息", required = true) @Validated @RequestBody ProductCategoryParam productCategoryParam) {
        return success(service.addProductCategory(productCategoryParam));
    }

    @ApiOperation(value = "编辑产品分类")
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryDto> editProductCategory(
            @ApiParam(value = "产品分类Id", required = true) @PathVariable Long id,
            @ApiParam(value = "产品分类信息", required = true) @Validated @RequestBody ProductCategoryParam productCategoryParam) {
        return success(service.editProductCategory(id, productCategoryParam));
    }

    @ApiOperation(value = "删除产品分类")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProductCategory(
            @ApiParam(value = "产品分类Id", required = true) @PathVariable Long id) {
        service.removeProductCategory(id);
        return success();
    }
}
