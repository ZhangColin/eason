package com.eason.merchant.merchant;

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

@Api(tags = "供应商：商户表")
@RestController
@RequestMapping("/merchants")
@Validated
@Slf4j
public class MerchantController {
    private final MerchantAppService service;

    public MerchantController(MerchantAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索商户表")
    @GetMapping("/search")
    public ResponseEntity<PageResult<MerchantDto>> searchMerchants(
            @ApiParam(value = "查询参数") MerchantQuery merchantQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchMerchants(merchantQuery, pageable));
    }

    @ApiOperation(value = "获取商户表")
    @GetMapping("/{id}")
    public ResponseEntity<MerchantDto> getMerchant(@ApiParam(value = "商户表Id", required = true) @PathVariable Long id){
        return success(service.getMerchant(id));
    }

    @ApiOperation(value = "添加商户表")
    @PostMapping
    public ResponseEntity<MerchantDto> addMerchant(
            @ApiParam(value = "商户表信息", required = true) @Validated @RequestBody MerchantParam merchantParam) {
        return success(service.addMerchant(merchantParam));
    }

    @ApiOperation(value = "编辑商户表")
    @PutMapping("/{id}")
    public ResponseEntity<MerchantDto> editMerchant(
            @ApiParam(value = "商户表Id", required = true) @PathVariable Long id,
            @ApiParam(value = "商户表信息", required = true) @Validated @RequestBody MerchantParam merchantParam) {
        return success(service.editMerchant(id, merchantParam));
    }

    @ApiOperation(value = "删除商户表")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeMerchant(
            @ApiParam(value = "商户表Id", required = true) @PathVariable Long id) {
        service.removeMerchant(id);
        return success();
    }
}
