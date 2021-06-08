package com.eason.order.orderDetail;

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

@Api(tags = "订单：订单详情")
@RestController
@RequestMapping("/orderDetails")
@Validated
@Slf4j
public class OrderDetailController {
    private final OrderDetailAppService service;

    public OrderDetailController(OrderDetailAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索订单详情")
    @GetMapping("/search")
    public ResponseEntity<PageResult<OrderDetailDto>> searchOrderDetails(
            @ApiParam(value = "查询参数") OrderDetailQuery orderDetailQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchOrderDetails(orderDetailQuery, pageable));
    }

    @ApiOperation(value = "获取订单详情")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDto> getOrderDetail(@ApiParam(value = "订单详情Id", required = true) @PathVariable Long id){
        return success(service.getOrderDetail(id));
    }

    @ApiOperation(value = "添加订单详情")
    @PostMapping
    public ResponseEntity<OrderDetailDto> addOrderDetail(
            @ApiParam(value = "订单详情信息", required = true) @Validated @RequestBody OrderDetailParam orderDetailParam) {
        return success(service.addOrderDetail(orderDetailParam));
    }

    @ApiOperation(value = "编辑订单详情")
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailDto> editOrderDetail(
            @ApiParam(value = "订单详情Id", required = true) @PathVariable Long id,
            @ApiParam(value = "订单详情信息", required = true) @Validated @RequestBody OrderDetailParam orderDetailParam) {
        return success(service.editOrderDetail(id, orderDetailParam));
    }

    @ApiOperation(value = "删除订单详情")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeOrderDetail(
            @ApiParam(value = "订单详情Id", required = true) @PathVariable Long id) {
        service.removeOrderDetail(id);
        return success();
    }
}
