package com.eason.portal.gateway;

import com.cartisan.dtos.PageResult;
import com.eason.portal.request.OrderQuery;
import com.eason.portal.request.PlaceCommand;
import com.eason.portal.response.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author colin
 */
@FeignClient(value = "eason-order")
public interface OrderClient {
    @GetMapping("/search")
    PageResult<OrderDto> searchOrders(OrderQuery orderQuery, @PageableDefault Pageable pageable);

    @PostMapping
    OrderDto place(@RequestBody PlaceCommand placeCommand);
}
