package com.eason.goods.product;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
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

@Api(tags = "产品：产品")
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
    public ResponseEntity<PageResult<ProductDto>> searchProducts(
            @ApiParam(value = "查询参数") ProductQuery productQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchProducts(productQuery, pageable));
    }

    @ApiOperation(value = "获取产品")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@ApiParam(value = "产品Id", required = true) @PathVariable Long id){
        return success(service.getProduct(id));
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
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id) {
        service.removeProduct(id);
        return success();
    }
}
