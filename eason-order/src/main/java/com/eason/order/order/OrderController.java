package com.eason.order.order;

import com.cartisan.dtos.PageResult;
import com.eason.order.order.request.ChangeConsigneeCommand;
import com.eason.order.order.request.OrderQuery;
import com.eason.order.order.request.PlaceCommand;
import com.eason.order.order.response.OrderDetailDto;
import com.eason.order.order.response.OrderDto;
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
    public ResponseEntity<OrderDetailDto> getOrder(@ApiParam(value = "订单Id", required = true) @PathVariable Long id){
        return success(service.getOrder(id));
    }

    @ApiOperation(value = "下单")
    @PostMapping
    public ResponseEntity<OrderDto> place(
            @ApiParam(value = "订单信息", required = true) @Validated @RequestBody PlaceCommand placeCommand) {
        return success(service.place(placeCommand));
    }

    @ApiOperation(value = "修改收货信息")
    @PostMapping("/changeConsignee")
    public ResponseEntity<OrderDto> changeConsignee(
            @ApiParam(value = "修改收货地址命令", required = true) @Validated @RequestBody ChangeConsigneeCommand command) {
        return success(service.changeConsignee(command));
    }

    @ApiOperation(value = "支付")
    @PutMapping("/{id}/pay")
    public ResponseEntity<?> pay(
            @ApiParam(value = "订单Id", required = true) @PathVariable Long id) {
        service.pay(id);
        return success();
    }


    @ApiOperation(value = "取消")
    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(
            @ApiParam(value = "订单Id", required = true) @PathVariable Long id) {
        service.cancel(id);
        return success();
    }



}
