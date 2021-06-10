package com.eason.order.order.response;

import com.cartisan.dtos.Converter;
import com.eason.order.order.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderConverter extends Converter<Order, OrderDto> {
    OrderConverter CONVERTER = Mappers.getMapper(OrderConverter.class);
}
