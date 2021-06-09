package com.eason.goods.productDetail;

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

@Api(tags = "商品：产品详情")
@RestController
@RequestMapping("/productDetails")
@Validated
@Slf4j
public class ProductDetailController {
    private final ProductDetailAppService service;

    public ProductDetailController(ProductDetailAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索产品详情")
    @GetMapping("/search")
    public ResponseEntity<PageResult<ProductDetailDto>> searchProductDetails(
            @ApiParam(value = "查询参数") ProductDetailQuery productDetailQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchProductDetails(productDetailQuery, pageable));
    }

    @ApiOperation(value = "获取产品详情")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDto> getProductDetail(@ApiParam(value = "产品详情Id", required = true) @PathVariable Long id){
        return success(service.getProductDetail(id));
    }

    @ApiOperation(value = "添加产品详情")
    @PostMapping
    public ResponseEntity<ProductDetailDto> addProductDetail(
            @ApiParam(value = "产品详情信息", required = true) @Validated @RequestBody ProductDetailParam productDetailParam) {
        return success(service.addProductDetail(productDetailParam));
    }

    @ApiOperation(value = "编辑产品详情")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailDto> editProductDetail(
            @ApiParam(value = "产品详情Id", required = true) @PathVariable Long id,
            @ApiParam(value = "产品详情信息", required = true) @Validated @RequestBody ProductDetailParam productDetailParam) {
        return success(service.editProductDetail(id, productDetailParam));
    }

    @ApiOperation(value = "删除产品详情")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProductDetail(
            @ApiParam(value = "产品详情Id", required = true) @PathVariable Long id) {
        service.removeProductDetail(id);
        return success();
    }
}
