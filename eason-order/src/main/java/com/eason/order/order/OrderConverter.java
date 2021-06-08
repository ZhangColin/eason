package com.eason.order.order;

import com.cartisan.dtos.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderConverter extends Converter<Order, OrderDto> {
    OrderConverter CONVERTER = Mappers.getMapper(OrderConverter.class);
}
