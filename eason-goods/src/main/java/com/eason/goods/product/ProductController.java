package com.eason.goods.product;

import com.cartisan.dtos.PageResult;
import com.eason.goods.product.request.ProductDetailParam;
import com.eason.goods.product.request.ProductParam;
import com.eason.goods.product.request.ProductQuery;
import com.eason.goods.product.response.ProductDetailDto;
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

import static com.cartisan.responses.ResponseUtil.success;

@Api(tags = "商品：产品")
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
    public ResponseEntity<ProductDetailDto> getProduct(@ApiParam(value = "产品Id", required = true) @PathVariable Long id){
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

    @ApiOperation(value = "审核通过")
    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approve(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id) {
        return success(service.approve(id));
    }

    @ApiOperation(value = "审核未通过")
    @PutMapping("/{id}/reject")
    public ResponseEntity<?> reject(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id) {
        return success(service.reject(id));
    }

    @ApiOperation(value = "上架")
    @PutMapping("/{id}/soldOn")
    public ResponseEntity<?> approve(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id) {
        return success(service.approve(id));
    }

    @ApiOperation(value = "下架")
    @PutMapping("/{id}/soldOut")
    public ResponseEntity<?> reject(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id) {
        return success(service.reject(id));
    }

    @ApiOperation(value = "添加库存")
    @PutMapping("/{id}/addStock")
    public ResponseEntity<?> reject(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id, @RequestParam Integer stock) {
        return success(service.addStock(id));
    }

    @ApiOperation(value = "添加库存")
    @PutMapping("/{id}/editDetail")
    public ResponseEntity<?> reject(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id, @RequestBody ProductDetailParam param) {
        return success(service.addStock(id));
    }

    @ApiOperation(value = "删除产品")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(
            @ApiParam(value = "产品Id", required = true) @PathVariable Long id) {
        service.removeProduct(id);
        return success();
    }
}
