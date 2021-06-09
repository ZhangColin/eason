package com.eason.order.orderItem;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemConverter extends Converter<OrderItem, OrderItemDto> {
    OrderItemConverter CONVERTER = Mappers.getMapper(OrderItemConverter.class);
}
