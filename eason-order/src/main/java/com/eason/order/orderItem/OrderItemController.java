package com.eason.order.orderItem;

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

@Api(tags = "订单：订单项")
@RestController
@RequestMapping("/orderItems")
@Validated
@Slf4j
public class OrderItemController {
    private final OrderItemAppService service;

    public OrderItemController(OrderItemAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索订单项")
    @GetMapping("/search")
    public ResponseEntity<PageResult<OrderItemDto>> searchOrderItems(
            @ApiParam(value = "查询参数") OrderItemQuery orderItemQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchOrderItems(orderItemQuery, pageable));
    }

    @ApiOperation(value = "获取订单项")
    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getOrderItem(@ApiParam(value = "订单项Id", required = true) @PathVariable Long id){
        return success(service.getOrderItem(id));
    }

    @ApiOperation(value = "添加订单项")
    @PostMapping
    public ResponseEntity<OrderItemDto> addOrderItem(
            @ApiParam(value = "订单项信息", required = true) @Validated @RequestBody OrderItemParam orderItemParam) {
        return success(service.addOrderItem(orderItemParam));
    }

    @ApiOperation(value = "编辑订单项")
    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDto> editOrderItem(
            @ApiParam(value = "订单项Id", required = true) @PathVariable Long id,
            @ApiParam(value = "订单项信息", required = true) @Validated @RequestBody OrderItemParam orderItemParam) {
        return success(service.editOrderItem(id, orderItemParam));
    }

    @ApiOperation(value = "删除订单项")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeOrderItem(
            @ApiParam(value = "订单项Id", required = true) @PathVariable Long id) {
        service.removeOrderItem(id);
        return success();
    }
}
