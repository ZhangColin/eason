package com.eason.order.order;

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

@Api(tags = "订单：订单")
@RestController
@RequestMapping("/orders")
@Validated
@Slf4j
public class OrderController {
    private final OrderAppService service;

    public OrderController(OrderAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索订单")
    @GetMapping("/search")
    public ResponseEntity<PageResult<OrderDto>> searchOrders(
            @ApiParam(value = "查询参数") OrderQuery orderQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchOrders(orderQuery, pageable));
    }

    @ApiOperation(value = "获取订单")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@ApiParam(value = "订单Id", required = true) @PathVariable Long id){
        return success(service.getOrder(id));
    }

    @ApiOperation(value = "添加订单")
    @PostMapping
    public ResponseEntity<OrderDto> addOrder(
            @ApiParam(value = "订单信息", required = true) @Validated @RequestBody OrderParam orderParam) {
        return success(service.addOrder(orderParam));
    }

    @ApiOperation(value = "编辑订单")
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> editOrder(
            @ApiParam(value = "订单Id", required = true) @PathVariable Long id,
            @ApiParam(value = "订单信息", required = true) @Validated @RequestBody OrderParam orderParam) {
        return success(service.editOrder(id, orderParam));
    }

    @ApiOperation(value = "删除订单")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeOrder(
            @ApiParam(value = "订单Id", required = true) @PathVariable Long id) {
        service.removeOrder(id);
        return success();
    }
}
