package com.eason.goods.product;

import com.cartisan.dtos.PageResult;
import com.eason.goods.product.request.ProductParam;
import com.eason.goods.product.request.ProductQuery;
import com.eason.goods.product.response.ProductDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.cartisan.responses.ResponseUtil.success;

/**
 * @author colin
 */
@Api(tags = "产品")
@RestController
@RequestMapping("/products")
@Validated
@Slf4j
public class ProductController {
    private final ProductAppService service;

    public ProductController(ProductAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索产品")
    @GetMapping("/search")
    public ResponseEntity<PageResult<ProductDto>> searchUsers(
            @ApiParam(value = "查询参数") ProductQuery productQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchProducts(productQuery, pageable));
    }

    @ApiOperation(value = "获取所有产品")
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return success(service.getAllProducts());
    }

    @ApiOperation(value = "添加产品")
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(
            @ApiParam(value = "产品信息", required = true) @Validated @RequestBody ProductParam productParam) {
        return success(service.addProduct(productParam));
    }

    @ApiOperation(value = "编辑产品")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> editProduct(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id,
            @ApiParam(value = "产品信息", required = true) @Validated @RequestBody ProductParam productParam) {
        return success(service.editProduct(id, productParam));
    }

    @ApiOperation(value = "删除产品")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(
            @ApiParam(value = "产品Id", required = true) @PathVariable long id) {
        service.removeProduct(id);
        return success();
    }
}
