package com.eason.payment.gateway;

import com.eason.payment.gateway.response.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author colin
 */
@FeignClient(value = "eason-order")
public interface OrderClient {
    @GetMapping("/{id}")
    OrderDto getOrder(@PathVariable Long id);

    @PutMapping("/{id}/pay")
    void pay(@PathVariable Long id, @RequestParam Integer payType, @RequestParam Integer status );
}
