package com.eason.merchant.merchant;

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

@Api(tags = "供应商：商户")
@RestController
@RequestMapping("/merchants")
@Validated
@Slf4j
public class MerchantController {
    private final MerchantAppService service;

    public MerchantController(MerchantAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索商户")
    @GetMapping("/search")
    public ResponseEntity<PageResult<MerchantDto>> searchMerchants(
            @ApiParam(value = "查询参数") MerchantQuery merchantQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchMerchants(merchantQuery, pageable));
    }

    @ApiOperation(value = "获取商户")
    @GetMapping("/{id}")
    public ResponseEntity<MerchantDto> getMerchant(@ApiParam(value = "商户Id", required = true) @PathVariable Long id) {
        return success(service.getMerchant(id));
    }

    @ApiOperation(value = "添加商户")
    @PostMapping
    public ResponseEntity<MerchantDto> addMerchant(
            @ApiParam(value = "商户信息", required = true) @Validated @RequestBody MerchantParam merchantParam) {
        return success(service.addMerchant(merchantParam));
    }

    @ApiOperation(value = "编辑商户")
    @PutMapping("/{id}")
    public ResponseEntity<MerchantDto> editMerchant(
            @ApiParam(value = "商户Id", required = true) @PathVariable Long id,
            @ApiParam(value = "商户信息", required = true) @Validated @RequestBody MerchantParam merchantParam) {
        return success(service.editMerchant(id, merchantParam));
    }

    @ApiOperation(value = "审核通过")
    @PutMapping("/{id}/approve")
    public ResponseEntity<MerchantDto> approve(
            @ApiParam(value = "商户Id", required = true) @PathVariable Long id) {
        return success(service.approve(id));
    }

    @ApiOperation(value = "审核未通过")
    @PutMapping("/{id}/reject")
    public ResponseEntity<MerchantDto> reject(
            @ApiParam(value = "商户Id", required = true) @PathVariable Long id) {
        return success(service.reject(id));
    }

    @ApiOperation(value = "启用")
    @PutMapping("/{id}/enable")
    public ResponseEntity<MerchantDto> enable(
            @ApiParam(value = "商户Id", required = true) @PathVariable Long id) {
        return success(service.enable(id));
    }

    @ApiOperation(value = "禁用")
    @PutMapping("/{id}/disable")
    public ResponseEntity<MerchantDto> disable(
            @ApiParam(value = "商户Id", required = true) @PathVariable Long id) {
        return success(service.disable(id));
    }

    @ApiOperation(value = "删除商户")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeMerchant(
            @ApiParam(value = "商户Id", required = true) @PathVariable Long id) {
        service.removeMerchant(id);
        return success();
    }
}
